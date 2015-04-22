/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import generate.jaxb.product.ProductType;
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
public class ProductDAO {

    DBUtil util;

    public List<ProductType> getAllProduct() throws SQLException, Exception {
        ArrayList<ProductType> allProduct = new ArrayList<ProductType>();

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        util = new DBUtil();
        try {
            conn = util.getDBConection();
            String sql = "select * from Products where Instock > 0 Order by Name";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            allProduct = new ArrayList<ProductType>();
            while (rs.next()) {
                Integer PID = rs.getInt("PID");
                String Name = rs.getString("Name");
                Integer Price = rs.getInt("Price");
                String Description = rs.getString("Description");
                String Category = rs.getString("Category");
                String Image = rs.getString("Image");
                Integer Instock = rs.getInt("Instock");
                Integer Promotion = rs.getInt("Promotion");
                ProductType acc = new ProductType(PID, Name, Price, Description, Category, Image, Instock, Promotion);
                allProduct.add(acc);
            }
            return allProduct;

        } catch (SQLException e) {
            throw e;
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

    public int addproduct(ProductType productType) {
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        util = new DBUtil();

        String insertStoreProc = "call AddProduct(?,?,?,?,?,?,?)";
        System.out.println("Pass");
        try {
            dbConnection = util.getDBConection();
            callableStatement = dbConnection.prepareCall(insertStoreProc);

            callableStatement.setString(1, productType.getName());
            callableStatement.setInt(2, productType.getPrice());
            callableStatement.setString(3, productType.getDescription());
            callableStatement.setString(4, productType.getCategory());
            callableStatement.setString(5, productType.getImage());
            callableStatement.setInt(6, productType.getInstock());
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            System.out.println("toi dung 41");
            callableStatement.executeUpdate();
            System.out.println("toi dung 43");//printout cái callableStatement.getInt(7);

            return productType.getPID();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public void UpdateProduct(ProductType productType) {
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        util = new DBUtil();

        String updateStoreProc = "{call ProductUpdate(?,?,?,?,?,?,?)}";

        try {
            dbConnection = util.getDBConection();
            callableStatement = dbConnection.prepareCall(updateStoreProc);

            callableStatement.setInt(1, productType.getPID());
            callableStatement.setString(2, productType.getName());
            callableStatement.setInt(3, productType.getPrice());
            callableStatement.setString(4, productType.getDescription());
            callableStatement.setString(5, productType.getCategory());
            callableStatement.setString(6, productType.getImage());
            callableStatement.setInt(7, productType.getInstock());

            callableStatement.executeUpdate();
            callableStatement.close();
            dbConnection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}//endClass
