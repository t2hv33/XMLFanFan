/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.ProductDAO;
import generate.jaxb.product.ProductType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ThanhHV
 */
public class ProductBLO {

    ProductDAO productDAO = new ProductDAO();

    public static List<ProductType> getAllProducts() {
        try {
            ProductDAO listProduct = new ProductDAO();
            return listProduct.getAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int addproduct(ProductType productType){
        return productDAO.addproduct(productType);
    }
    public void UpdateProduct(ProductType productType){
        productDAO.UpdateProduct(productType);
    }
}
