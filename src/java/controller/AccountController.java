/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import blo.AccountBLO;
import dto.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThanhHV
 */
public class AccountController extends HttpServlet {

    private final String homePage = "index.jsp";
    private String fullName;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHH");
        try {

            AccountDTO accountDTO;
            AccountBLO accountBLO = new AccountBLO();
            String action = request.getParameter("action");
            HttpSession session = request.getSession(true);


            if (action.equals("Login")) {

                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");

                accountDTO = accountBLO.GetAccountByUsernameAndPassword(username, password);
                System.out.println("Login roi`");
                if (accountDTO != null) {
                    String role = accountDTO.getRole();
                    session.setAttribute("id", accountDTO);
                    session.setAttribute("account", accountDTO);
                    session.setAttribute("ROLE", role);
                     System.out.println("Login roi`2");
                    String url = homePage;
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);

                } else {
                    System.out.println("log in fail");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("LoginFail");
                }
            } else if (action.equals("Logout")) {
                session.removeAttribute("account");
                session.setAttribute("account", null);
                session.removeAttribute("CART");
//                session.setAttribute("CART", null);
                //session.setAttribute("AddLIST", null);
                String url = homePage;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }//end logout
            else if (action.equals("Register")) {
                // int phone = 0;
                String username = request.getParameter("txtUsername");
                System.out.println(username);
                String password = request.getParameter("txtPassword");
                String role = "Member";
                String fullname = request.getParameter("txtFullName");
                String email = request.getParameter("txtMail");
                String address = request.getParameter("txtAddress");
                String phone = request.getParameter("txtPhone");
                AccountBLO blo = new AccountBLO();
                //Insert into database
                blo.insertUser(username, password, role, fullname, email, address, phone);
                //Get Account again to login
                accountDTO = accountBLO.GetAccountByUsernameAndPassword(username, password);

                if (accountDTO != null) {
                    session.setAttribute("id", accountDTO);
                    session.setAttribute("account", accountDTO);
                    session.setAttribute("ROLE", role);
                    String url = homePage;
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);

                } else {
                    System.out.println("log in reg fail");
                    response.setHeader("Cache-Control", "no-cache");
                    response.getWriter().write("LoginRegFail");
                }
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
