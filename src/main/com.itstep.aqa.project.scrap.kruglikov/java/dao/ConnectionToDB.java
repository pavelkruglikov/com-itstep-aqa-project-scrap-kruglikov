package com.itstep.aqa.project.scrap.kruglikov.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD =  "1234";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/ScrapDB";
    public Connection connection;
    {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
