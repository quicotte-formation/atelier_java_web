<%-- 
    Document   : lister_hotels
    Created on : 22 mai 2017, 11:32:39
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
            
            <c:if test="${ cookie['langue'].value=='fr' }">
                Liste hotels
            </c:if>
        
        <a href="ajouter_hotel">Nouveau</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOM</th>
                    <th>ADRESSE</th>
                    <th>ZIP</th>
                    <th>ACTION</th>
                </tr>
            </thead>
            <c:forEach items="${listeHotels}" var="h">
                <tr>
                    <td>${h.id}</td>
                    <td>${h.nom}</td>
                    <td>${h.adresse}</td>
                    <td>${h.codePostal}</td>
                    <td>
                        <a href="supprimer_hotel?hotelId=${h.id}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>
