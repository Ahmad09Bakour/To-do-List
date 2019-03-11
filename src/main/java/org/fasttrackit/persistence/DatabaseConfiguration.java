package org.fasttrackit.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfiguration {

    public static Connection getConnection(){
        Properties properties = new Properties();

        // try-with-resources
        try(FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            // this type of try statment
            properties.load(inputStream);

            // laod the Driver Class
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

            return DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));


        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Failed to connect to the db.");
    }
}
