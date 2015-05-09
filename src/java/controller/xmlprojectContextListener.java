/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import generate.jaxb.product.Allproduct;
import generate.jaxb.product.ProductType;
import generate.jaxb.users.Allusers;
import generate.jaxb.users.UserType;
import java.util.List;
import javax.servlet.ServletContextEvent;
import util.Marshall;

/**
 *
 * @author ThanhHV
 */
public class xmlprojectContextListener {

    public static void prepareProductXML(String fileName) {
        List<ProductType> Aproduct = blo.ProductBLO.getAllProducts();
        Marshall.marshall(fileName, new Allproduct(Aproduct));
    }

    public static void prepareUser(String fileName) {
        List<UserType> iUser = blo.AccountBLO.getAllUser();
        Marshall.marshall(fileName, new Allusers(iUser));

    }

    public void contextInitialized(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
