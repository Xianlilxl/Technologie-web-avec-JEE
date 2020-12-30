<%-- 
    Document   : response
    Created on : 30 déc. 2020, 11:20:33
    Author     : Xianli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <HEAD><TITLE>Service de reponse du client</TITLE></HEAD>
    <body>
        <H1>requete recu</H1>
        <jsp:useBean id = "TSBean" class = "TechSupport.TechSupportBean" scope = "session"></jsp:useBean>
        <%-- is user exists : <%= TSBean.selectQuery("select email from user" ) %>--%>
        <h3>email : <%=TSBean.getEmail()%></h3>
        <h3>logiciel : <%=TSBean.getLogiciel()%></h3>
        <h3>OS : <%=TSBean.getSystemeExploitation()%></h3>
        <h3>description : <%=TSBean.getDescription()%></h3>
        <h3>prenom : <%=TSBean.getPrenom()%></h3>
        <h3>nom : <%=TSBean.getNom()%></h3>
        <h3>telephone : <%=TSBean.getTelephone()%></h3>
        <p>Merci pour votre requete
        <p>Votre requete a ete enregistre et sera traite dans 3 jours
    </body>
</html>