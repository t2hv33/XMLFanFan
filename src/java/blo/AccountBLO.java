/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.AccountDAO;
import dao.RegisterDAO;
import dto.AccountDTO;
import generate.jaxb.users.UserType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author duy
 */
public class AccountBLO {

    AccountDAO accountDAO = new AccountDAO();

    public AccountDTO GetAccountByUsernameAndPassword(String username, String password) {
        return accountDAO.GetAccountByUsernameAndPassword(username, password);
    }

    public static List<UserType> getAllUser() {
        try {
            AccountDAO listUser = new AccountDAO();
            return listUser.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(String username, String password, String role, String fullname,
            String email, String address, String phone){
        try {
            RegisterDAO reg = new RegisterDAO();
            return reg.insertUser(username, password, role, fullname, email, address, phone);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
