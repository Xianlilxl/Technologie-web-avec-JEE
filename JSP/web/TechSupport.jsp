<%-- 
    Document   : TechSupport
    Created on : 29 déc. 2020, 15:40:12
    Author     : Xianli
--%>

<%@page import="java.sql.ResultSet"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id = "TSBean" class = "TechSupport.TechSupportBean" scope = "session">
</jsp:useBean>
    <jsp:setProperty name = "TSBean" property = "email" param = "email" />
    <jsp:setProperty name = "TSBean" property = "logiciel" param = "logiciel" />
    <jsp:setProperty name = "TSBean" property = "systemeExploitation" param = "systemeExploitation" />
    <jsp:setProperty name = "TSBean" property = "description" param = "description" />
    <h3>email : <%=TSBean.getEmail()%></h3>
    <h3>logiciel : <%=TSBean.getLogiciel()%></h3>
    <h3>OS : <%=TSBean.getSystemeExploitation()%></h3>
    <h3>description : <%=TSBean.getDescription()%></h3>
    <%--the value of user logiciel is : <jsp:getProperty name = "TSBean" property = "logiciel" />
    <%
        TSBean.setEmail(request.getParameter("email"));
    %>
    the value of user email is : <jsp:getProperty name = "TSBean" property = "email" />--%>
    

<%
    /*String selectQuery = "select email from user";
    boolean result = TSBean.isUserExists(selectQuery);
    
    if(result){
        TSBean.setPrenom("Xianli");
        TSBean.setNom("Li");
        TSBean.setTelephone("659179071");
        response.sendRedirect("response.jsp");
    }else{
        response.sendRedirect("regform.jsp");
    }*/
    
    if(TSBean.getEmail().equals("lixianlilxl@gmail.com")){
        TSBean.setPrenom("Xianli");
        TSBean.setNom("Li");
        TSBean.setTelephone("659179071");
        response.sendRedirect("response.jsp");
    }else{
        response.sendRedirect("regform.jsp");
    }
%>

