/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

/**
 *
 * @author thanhhvG
 */
public class RegisterDAO {

    DBUtil util;

    public boolean insertUser(String username, String password, String role, String fullname,
            String email, String address, String  phone) throws SQLException, Exception {

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        util = new DBUtil();
        try {
            conn = util.getDBConection();
            String sql = "Insert into Users(Username, Password, Role, FullName, Email, Address, Phone) values (?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, role);
            stm.setString(4, fullname);
            stm.setString(5, email);
            stm.setString(6, address);
            stm.setString(7, phone);
            int row = stm.executeUpdate();
            if (row < 0) {
                return false;
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw (e);
        } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                throw (e);
            }
            try {
                conn.close();//close connection
            } catch (SQLException e) {
                throw (e);
            }
        }
        return true;
    }
}
