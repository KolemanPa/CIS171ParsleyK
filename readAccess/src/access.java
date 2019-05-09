
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kp0885055
 */
public class access {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Class.forName("sun.jdcbc.odbc.JdbcOdbcDriver");
            System.out.println("Loaded");
        } catch (ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or registering MS Access JDBC driver");
        }

        // Access the access database
        try {
            String fileName = "C:\\Users\\kp0885055\\Desktop\\CIS171ParsleyK\\readAccess\\src\\StudentEnrollment.accdb";
            String dbURL = "jdbc:ucanaccess://";
            System.out.println(fileName);

            // Connect to DB
            Connection conn = DriverManager.getConnection(dbURL + fileName);
            System.out.println("Db Connected");

            Statement sqlStatement = conn.createStatement();            // Statement object NEEDS connection
            // Execute SQL statement
            ResultSet resultSet = sqlStatement.executeQuery("select firstName, mi, lastName from Students where lastName = 'Smith'");
            // Iterate through the results and print the student names
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
            conn.close();
        } catch (Exception cnfex) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            System.out.println(cnfex.getMessage());

        }


    }
}
