package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by jianshen on 12/17/16.
 *
 * JDBC PreparedStatement can be used for SQL query with paraments, the rest of its usage is same as JDBC Statement.
 * ref - https://www.tutorialspoint.com/jdbc/jdbc-statements.htm
 *
 */
public class JDBCExample_PreParedStatement {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/books";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {

        try {
            insertRecordIntoTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    private static void insertRecordIntoTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO AUTHORS"
                + "(ID, NAME, EMAIL) VALUES"
                + "(?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Shen");
            preparedStatement.setString(3, "jshen0831@gmail.com");

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into Authors table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }


}



