<%-- 
    Document   : ajouter_chambre
    Created on : 23 mai 2017, 11:20:00
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="_menu"></c:import>
        <h1>Nouvelle chambre</h1>
        <form method="post">
            <label>Nom:</label>
            <input type="text" name="nom"/>
            <label>Prix:</label>
            <input type="number" name="prix"/>
            <label>Hotel:</label>
            <select name="hotelId">
                <c:forEach items="${hotels}" var="h">
                    <option value="${h.id}">${h.nom}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Ajouter"/>
        </form>
    </body>
</html>
