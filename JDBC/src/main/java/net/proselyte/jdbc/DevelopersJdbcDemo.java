package net.proselyte.jdbc;

import java.sql.*;
import java.util.Date;

public class DevelopersJdbcDemo {
    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/second?useUnicode=true&serverTimezone=UTC&useSSL=false";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        for (int i = 0; i < 10; i++) {
            smallExample(10000*i);
        }
        secondExample();
        thirdExample();
    }

    private static void secondExample() throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        java.util.Date start0 = new Date();
        System.out.println("Executing statement...");
        statement = connection.createStatement();

        java.util.Date start2 = new Date();
        String sql = "SELECT * FROM developers WHERE  salary <= 5000";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        java.util.Date end2 = new Date();

        java.util.Date start3 = new Date();
        for (int i = 0; i < 10000; i++) {
            String sql1 = "DELETE FROM second.developers WHERE second.developers.salary >= 5000";
            statement.executeUpdate(sql1);
        }
        java.util.Date end3 = new Date();

        java.util.Date end0 = new Date();
        System.out.println("Retrieving data from database...");
        System.out.println("all time:" + (end0.getTime()-start0.getTime()) + "s");
        System.out.println("select:" + (end2.getTime()-start2.getTime()) + "s");
        System.out.println("delete:" + (end3.getTime()-start3.getTime()) + "s");
        System.out.println("Closing connection and releasing resources...");

        statement.close();
        connection.close();
    }

    private static void thirdExample() throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        java.util.Date start0 = new Date();
        System.out.println("Executing statement...");
        statement = connection.createStatement();

        java.util.Date start2 = new Date();
        String sql = "SELECT * FROM developers WHERE  salary <= 5000 order by salary DESC ";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        java.util.Date end2 = new Date();

        java.util.Date end0 = new Date();
        System.out.println("Retrieving data from database...");
        System.out.println("all time:" + (end0.getTime()-start0.getTime()) + "s");
        System.out.println("select:" + (end2.getTime()-start2.getTime()) + "s");
        System.out.println("Closing connection and releasing resources...");

        statement.close();
        connection.close();
    }

    private static void smallExample(long j) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        java.util.Date start0 = new Date();
        System.out.println("Executing statement...");
        statement = connection.createStatement();

        java.util.Date start1 = new Date();
        for (int i = 0; i < 10000; i++) {
            String sql1 = "INSERT second.developers (name, specialty, salary) VALUES ('ProselyteA', 'Java',"+ i + ");";
            statement.executeUpdate(sql1);
        }
        java.util.Date end1 = new Date();

        java.util.Date start2 = new Date();
        String sql = "SELECT * FROM developers";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        java.util.Date end2 = new Date();

        java.util.Date start3 = new Date();
        for (int i = 0; i < 10000; i++) {
            String sql1 = "DELETE FROM second.developers WHERE second.developers.id =" + i+j + ";";
            statement.executeUpdate(sql1);
        }
        java.util.Date end3 = new Date();

        java.util.Date end0 = new Date();
        System.out.println("Retrieving data from database...");
        System.out.println("all time:" + (end0.getTime()-start0.getTime()) + "s");
        System.out.println("insert:" + (end1.getTime()-start1.getTime()) + "s");
        System.out.println("select:" + (end2.getTime()-start2.getTime()) + "s");
        System.out.println("delete:" + (end3.getTime()-start3.getTime()) + "s");
        System.out.println("Closing connection and releasing resources...");

        statement.close();
        connection.close();
    }
}
