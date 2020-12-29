<%-- 
    Document   : TechSupport
    Created on : 29 déc. 2020, 15:40:12
    Author     : Xianli
<%= request.getParameter("email") %>
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id = "TSBean" class = "TechSupport.TechSupportBean" scope = "page">
    <jsp:setProperty name = "TSBean" property = "email" param = "email" />
    <jsp:setProperty name = "TSBean" property = "logiciel" param = "logiciel" />
    <jsp:setProperty name = "TSBean" property = "systemeExploitation" param = "systemeExploitation" />
    <jsp:setProperty name = "TSBean" property = "description" param = "description" />
    <h3>email : <%=TSBean.getEmail()%></h3>
    <h3>logiciel : <%=TSBean.getLogiciel()%></h3>
    <h3>OS : <%=TSBean.getSystemeExploitation()%></h3>
    <h3>description : <%=TSBean.getDescription()%></h3>
    
the value of user logiciel is : <jsp:getProperty name = "TSBean" property = "logiciel" />
</jsp:useBean>
