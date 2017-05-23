 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : lister_chambres
    Created on : 23 mai 2017, 12:32:27
    Author     : formation
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="_menu"></c:import>
        <h1>Liste des chambres</h1>
        <a href="ajouter_chambre">Nouvelle chambre</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>CHAMBRE</th>
                    <th>HOTEL</th>
                    <th>PRIX</th>
                    <th>ACTION</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listeChambres}" var="ch">
                    <tr>
                        <td>${ch.id}</td>
                        <td>${ch.nom}</td>
                        <td>${ch.hotel.nom}</td>
                        <td>${ch.prix}</td>
                        <td>
                            <a href="supprimer_chambre?idChambre=${ch.id}">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>
