package gov.sba.utils.integration;

import static gov.sba.utils.integration.CommonApplicationMethods.return_Db_URL;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseQuery {

    private static final Logger logger_Dbq = LogManager.getLogger(DatabaseQuery.class.getName());

    public static void executeSQLScript(String sql_query) throws Exception {
        // Properties
        String url = return_Db_URL();

        Properties props = new Properties();
        props.setProperty("user", "app_ruby");
        props.setProperty("password", "rubypassword");
        // Connect
        Connection connection_SBA_One_Qa = DriverManager.getConnection(url, props);
        // query execution
        PreparedStatement statement_SQL = connection_SBA_One_Qa.prepareStatement(sql_query);
        statement_SQL.executeUpdate();
        System.out.println("Query Executed");
        statement_SQL.close();
    }

    public static String[][] getDBData(String sql_query, int rows_Needed, int cols_Needed) throws Exception {

        // Connect SBAONE QA DB -to get data from DB
        String url = return_Db_URL();

        final Logger logger = LogManager.getLogger(DatabaseQuery.class.getName());
        try {
            Properties props = new Properties();
            props.setProperty("user", "app_ruby");
            props.setProperty("password", "rubypassword");
            Connection connection_SBA_One_Qa = DriverManager.getConnection(url, props);
            // query execution
            Statement statement_SQL = connection_SBA_One_Qa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result_Set = statement_SQL.executeQuery(sql_query);

            if (!result_Set.first()) {
                logger.info("No data");
                return null;
            }

            String[][] sql_Data = new String[rows_Needed][cols_Needed];
            for (int i = 0; i < rows_Needed; i++) {
                for (int j = 1; j < cols_Needed + 1; j++) {
                    sql_Data[i][j - 1] = result_Set.getString(j);
                }
            }
            result_Set.close();
            connection_SBA_One_Qa.close();
            return sql_Data;
        } catch (Exception e) {
            logger.info(e.toString() + ":- The Cursor retrieval has failed");
            throw e;
        }
    }

}