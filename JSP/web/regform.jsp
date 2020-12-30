<%-- 
    Document   : regform
    Created on : 30 déc. 2020, 00:05:34
    Author     : Xianli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<HTML>
    <HEAD>
        <TITLE>Enregistrement d'un client</TITLE>
    </HEAD>
    <BODY>
        <CENTER><H1>Enregistrement d'un client</H1></CENTER>
        <HR>
        Engistrez-vous s'il vous plait.
        <FORM ACTION="/JSP/register.jsp" METHOD="POST">
        <TABLE>
        <TR>
            <TD>Prenom:</TD>
            <TD><INPUT TYPE="Text" NAME="prenom" SIZE="30"></TD>
        </TR>
        <TR>
            <TD>Nom:</TD>
            <TD><INPUT TYPE="Text" NAME="nom" SIZE="30"></TD>
        </TR>
        <TR>
            <TD>telephone:</TD>
            <TD><INPUT TYPE="Text" NAME="telephone" SIZE="30"></TD>
        </TR>
        </TABLE>
        <BR><INPUT TYPE="Submit" VALUE="Soumettre la requete">
        </FORM>
    </BODY>
</HTML>