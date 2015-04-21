/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ThanhHV
 */
public class DBUtil {

    private Properties prop = new Properties();

    public DBUtil() {
        try {
            InputStream is = DBUtil.class.getResourceAsStream("/util/ConectionInfo.properties");
            prop.load(is);
            is.close();
        } catch (IOException e) {
            return;
        }
    }//end DBUtil

    public String getDriverName() {
        return prop.getProperty("driverName");
    }

    public String getURL() {
        return prop.getProperty("url");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public Connection getDBConection() {
        Connection dbConnection = null;
        try {
            Class.forName(getDriverName());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(getURL(), getUsername(), getPassword());
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;

    }//end Connection

    public static void main(String[] args) {

    }

}
