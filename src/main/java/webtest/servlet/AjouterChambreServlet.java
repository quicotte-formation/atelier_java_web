/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtest.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webtest.entity.Chambre;
import webtest.entity.Hotel;
import webtest.service.ChambreService;
import webtest.service.HotelService;

/**
 *
 * @author formation
 */
@WebServlet(name = "AjouterChambreServlet", urlPatterns = {"/ajouter_chambre"})
public class AjouterChambreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        // Ajoute chambre en DB
        Chambre c = new Chambre();
        c.setNom( req.getParameter("nom") );
        c.setPrix( Long.valueOf(req.getParameter("prix")) );
        ChambreService service = new ChambreService();
        long hotelId = Long.valueOf( req.getParameter("hotelId") );
        service.ajouter(c, hotelId);
        
        // Redirection vers liste chambres
        resp.sendRedirect("lister_chambres");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récupère liste hotels et les passe en attribut
        HotelService service = new HotelService();
        List<Hotel> listeHotels = service.lister();
        req.setAttribute("hotels", listeHotels);
        
        // Forward vers JSP
        req.getRequestDispatcher("ajouter_chambre.jsp").forward(req, resp);
    }
}
