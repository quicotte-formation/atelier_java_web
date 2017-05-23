/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webtest.entity.Hotel;
import webtest.service.HotelService;

/**
 *
 * @author formation
 */
@WebServlet(name = "AjoutHotelServlet", urlPatterns = {"/ajouter_hotel"})
public class AjouterHotelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Récupère les attributs de forumulaire et les place ds 1 hotel
        Hotel h = new Hotel();
        h.setNom( req.getParameter("nom") );
        h.setAdresse(req.getParameter("adresse") );
        h.setCodePostal( Long.valueOf( req.getParameter("codePostal") ) );
  
        // Ajout en DB
        HotelService service = new HotelService();
        service.ajouter(h);
        
        // Forward vers écran de liste
        resp.sendRedirect("lister_hotels");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("ajouter_hotel.jsp").forward(req, resp);
    }

    
}
