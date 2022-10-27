package com.example.gift.insert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Configure, jdbc.Driver()
 * File -> Project Structure -> Libraries -> classpath -> add mysql-connector
* */
public class Main {

    public static void main(String[] args) throws Exception{
        //Register the Driver
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        //Getting the connection
        //String mysqlUrl = "jdbc:mysql://localhost:3306";
        //Connection con = DriverManager.getConnection(mysqlUrl, "root","password");

        Connection con = getConnection();
        con.setAutoCommit(false);

        System.out.println("Connection established ....");
        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO sys.product VALUES (?,?,?,?,?)");

        InputStream in = new FileInputStream(
                "C:\\Retail-Order-Management\\gift\\gift\\src\\main\\resources\\jpg\\shirt.jpg"
        );
        pstmt.setInt(1,1);
        pstmt.setInt(2,5);
        pstmt.setBlob(3,in);
        pstmt.setString(4,"t-shirt");
        pstmt.setInt(5,1000);
        pstmt.execute();
        System.out.println("Record inserted....");

    }

    private static Connection getConnection() throws Exception{
        //Register the Driver
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String mysqlUrl = "jdbc:mysql://localhost:3306";

        return DriverManager.getConnection(mysqlUrl, "root", "password");
    }
}
