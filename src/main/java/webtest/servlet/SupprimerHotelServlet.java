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
import webtest.service.HotelService;

/**
 *
 * @author formation
 */
@WebServlet(name = "SupprimerHotelServlet", urlPatterns = {"/supprimer_hotel"})
public class SupprimerHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Suppression en DB
        HotelService service = new HotelService();
        long id = Long.valueOf( req.getParameter("hotelId") );
        service.supprimer(id);
        
        // Redirect vers liste hotels
        resp.sendRedirect("lister_hotels");
    }

    
}
