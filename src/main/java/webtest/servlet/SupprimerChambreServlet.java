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
import webtest.service.ChambreService;

/**
 *
 * @author formation
 */
@WebServlet(name = "SupprimerChambreServlet", urlPatterns = {"/supprimer_chambre"})
public class SupprimerChambreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Supprimer chambre dont id passé en param
        long id = Long.valueOf( req.getParameter("idChambre") );
        new ChambreService().supprimer(id);
        
        // Redirection vers liste des chambres
        resp.sendRedirect("lister_chambres");
    }

}
