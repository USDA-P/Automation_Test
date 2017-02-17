package gov.sba.utils.integration;

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
        String url = "";
        if (TestHelpers.getBaseUrl().toString().contains("elb.maint")) {
            url = "jdbc:postgresql://db.qa.sba-one.net:5432/sbaone_dev";
            // logger_Dbq.info("Passed: SbaoneDev");
        } else {
            if (TestHelpers.getBaseUrl().toString().contains("certify.qa")) {
                url = "jdbc:postgresql://sbaonedev.cypwvkg7qp3n.us-east-1.rds.amazonaws.com:5432/sbaone_qa";
                // logger_Dbq.info("Passed: SbaoneQa");
            } else {
                throw new Exception(new NoSuchFieldException("Connection incorrect - Neither QA/ELB"));
            }
        }

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
        String url = "";
        String url_Check ="";

        String file_path_abs = FixtureUtils.fixturesDir_Duns() + "default.properties";
        Scanner in = new Scanner(new FileReader(file_path_abs));
        while(in.hasNextLine()){
            String nline = in.nextLine();
            if (nline.indexOf("base_url_qa") == 0)
            {
                url_Check= nline.split("base_url_qa=")[1].trim();
                break;
            }
        }

        if (url_Check.contains("elb.maint")) {
            url = "jdbc:postgresql://db.qa.sba-one.net:5432/sbaone_dev";
            logger_Dbq.info(url);
             //logger_Dbq.info("Passed: SbaoneDev");

        } else {
            if (url_Check.contains("certify.qa")) {
                url = "jdbc:postgresql://sbaonedev.cypwvkg7qp3n.us-east-1.rds.amazonaws.com:5432/sbaone_qa";
                logger_Dbq.info(url);
                // logger_Dbq.info("Passed: SbaoneQa");
            } else {
                throw new Exception(new NoSuchFieldException("Connection incorrect - Neither QA/ELB"));
            }
        }

        final Logger logger = LogManager.getLogger(DatabaseQuery.class.getName());
        try {
            Properties props = new Properties();
            props.setProperty("user", "app_etl");
            props.setProperty("password", "etlpassworddev");
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
                    // String max_first_name =
                    // result_Set.getString(column_Names[0]);
                    // String max_last_name =
                    // result_Set.getString(column_Names[1]);
                    sql_Data[i][j - 1] = result_Set.getString(j);
                    // System.out.println(sql_Data[i][j - 1].toString());
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
