package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jianshen on 12/17/16.
 */
public class JDBCExample {

    public static void main(String[] args) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        Statement statement = null;

        try {
            //books - mysql database name
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/books","root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        try {
            String createTableSQL = "create table authors2 (id INT, name VARCHAR(20), email varchar(20))";
            statement = connection.createStatement();

            System.out.println(createTableSQL);
            // execute the SQL stetement
            statement.execute(createTableSQL);

            System.out.println("Table \"authors2\" is created!");
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }


    }
}
