<%-- 
    Document   : register
    Created on : 30 déc. 2020, 00:15:54
    Author     : Xianli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="True"%>
<jsp:useBean id = "TSBean" class = "TechSupport.TechSupportBean" scope = "session"></jsp:useBean>
    <jsp:setProperty name = "TSBean" property = "prenom" param = "prenom" />
    <jsp:setProperty name = "TSBean" property = "nom" param = "nom" />
    <jsp:setProperty name = "TSBean" property = "telephone" param = "telephone" />
    <%
        /*String createQuery = "create table if not exists user (prenom VARCHAR(40),nom VARCHAR(40),email VARCHAR(40),telephone VARCHAR(15),logiciel VARCHAR(40),os VARCHAR(40),description VARCHAR(256));";
        String insertQuery = "insert into user PRENOM, NOM, EMAIL, TELEPHONE, LOGICIEL, OS, DESCRIPTION "
                    + "VALUES ('"+ TSBean.getPrenom() + "', '" + TSBean.getNom() + "', '" + TSBean.getEmail() + "', '" + TSBean.getTelephone() + "', '" 
                    + TSBean.getLogiciel()+ "', '" + TSBean.getSystemeExploitation() + "', '" + TSBean.getDescription() + "')";
        TSBean.createTable(createQuery);
        TSBean.insertQuery(insertQuery);*/
        
    %>
    <%response.sendRedirect("response.jsp");%>
    
