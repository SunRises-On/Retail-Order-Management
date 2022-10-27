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
        //Driver driver = new com.mysql.jdbc.Driver();
        //Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost:3306";
        Connection con = DriverManager.getConnection(mysqlUrl, "root",
                "password");
        System.out.println("Connection established ....");
        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO sys.product VALUES (?,?)");

        InputStream in = new FileInputStream(
                "C:\\Users\\jewel\\Desktop\\jpg\\shirt.jpg"
        );
        pstmt.setBlob(2,in);
        pstmt.execute();
        System.out.println("Record inserted....");

    }
}
