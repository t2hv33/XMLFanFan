/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.AccountDTO;
import generate.jaxb.users.UserType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

/**
 *
 * @author ThanhHV
 */
public class AccountDAO {

    DBUtil util;

    public AccountDTO GetAccountByUsernameAndPassword(String username, String password) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        util = new DBUtil();
        AccountDTO object = null;

        try {
            con = util.getDBConection();
            cs = con.prepareCall("{call spAccountGetByUsernameAndPassword(?,?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            rs = cs.executeQuery();
            if (rs.next()) {
                object = new AccountDTO(rs.getInt("UID"), rs.getString("Username"),
                        rs.getString("Password"), rs.getString("Role"), rs.getString("Fullname"), rs.getString("Email"), rs.getString("Address"),
                        rs.getString("Phone"));

            }
            rs.close();
            cs.close();
            con.close();
            return object;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



public List<UserType> getAllUser() throws SQLException, Exception {
        ArrayList<UserType> allUser = new ArrayList<UserType>();

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        util = new DBUtil();

        try {
            conn = util.getDBConection();
            String sql = "select Username,Email from Users";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            allUser = new ArrayList<UserType>();
            while (rs.next()) {
                String Name = rs.getString("Username");
                String Mail = rs.getString("Email");

                UserType acc = new UserType(Name, Mail);
                //ProductType acc = new ProductType(PID, Name, Price, Description, Category, Image, Brand, Instock, SaleOff);
                allUser.add(acc);
            }
            return allUser;
        } catch (SQLException e) {
            throw  e;
        } catch (Exception e) {
            throw (e);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                throw (e);
            }
            try {
                stm.close();
            } catch (SQLException e) {
                throw (e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw (e);
            }
        }
    }

}
