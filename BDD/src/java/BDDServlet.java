/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xianli
 */
@WebServlet(urlPatterns = {"/BDDServlet"})
public class BDDServlet extends HttpServlet {
    
    protected final String url = "jdbc:derby://localhost:1527/hotline";
    protected final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    protected final String tableName = "SUPP_REQUESTS";
    protected final String username = "Xianli";
    protected final String password = "lxl19971211";
    
    protected void createTable(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String create_supp_requests = "CREATE TABLE " + tableName + "(id INT  PRIMARY KEY NOT NULL, PRENOM VARCHAR(10), "
                    + "NOM VARCHAR(10), EMAIL VARCHAR(50), TELEPHONE CHAR(10), LOGICIEL VARCHAR(20), OS VARCHAR(20), PROBLEME VARCHAR(10) )";
            ResultSet resultCreate = statement.executeQuery(create_supp_requests);
            String insert_supp_requests = "INSERT INTO " + tableName + "id, PRENOM, NOM, EMAIL, TELEPHONE, LOGICIEL, OS, PROBLEME "
                    + "VALUES ('1', 'xianli', 'Li', 'lixianlilxl@gmail.com', '0611111111', 'google', 'windows', 'blabla')";
            ResultSet resultInsert = statement.executeQuery(insert_supp_requests);
            
        } catch (Exception ex) {
            Logger.getLogger(BDDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void showTable(PrintWriter out) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            printTableTop(connection, resultSet, out);
            printTableBody(resultSet, out);
            connection.close();
        } catch(Exception e) {
            System.err.println("Error: " + e);
        }
    }
    
    protected Connection getConnection() throws Exception {
        Class.forName(driver);
        // Establish network connection to database.
        Properties userInfo = new Properties();
        userInfo.put("user", username);
        userInfo.put("password", password);
        Connection connection =  DriverManager.getConnection(url, userInfo);
        return(connection);
    }
    
    protected void printTableTop(Connection connection, ResultSet resultSet, PrintWriter out) throws SQLException {
        out.println("<TABLE BORDER='1'>");
        // Print headings from explicit heading names
        String[] headingNames = {"id", "PRENOM", "NOM", "EMAIL", "TELEPHONE", "LOGICIEL", "OS", "PROBLEME" };
        out.print("<TR>");
        for (String headingName : headingNames) {
            out.printf("<TH>%s", headingName);
        }
        out.println();
    }
    
    protected void printTableBody(ResultSet resultSet, PrintWriter out) throws SQLException {
        while(resultSet.next()) {
            out.println("<TR ALIGN='RIGHT'>");
            out.printf(" <TD>%d", resultSet.getInt("id"));
            out.printf(" <TD>%s", resultSet.getString("PRENOM"));
            out.printf(" <TD>%s", resultSet.getString("NOM"));
            out.printf(" <TD>%s", resultSet.getString("EMAIL"));
            out.printf(" <TD>$%,d%n", resultSet.getInt("TELEPHONE"));
            out.printf(" <TD>%s", resultSet.getString("LOGICIEL"));
            out.printf(" <TD>%s", resultSet.getString("OS"));
            out.printf(" <TD>$%,d%n", resultSet.getInt("PROBLEME"));
        }
        out.println("</TABLE>");
        }


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BDDServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BDDServlet at " + request.getContextPath() + "</h1>");
            this.createTable();
            this.showTable(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
