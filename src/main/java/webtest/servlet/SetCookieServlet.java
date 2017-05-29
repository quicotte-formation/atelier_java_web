/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author formation
 */
@WebServlet(name = "SetCookieServlet", urlPatterns = {"/set_cookie"})
public class SetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie c = new Cookie("langue", "fr");
        resp.addCookie(c);
        
        // Récupérer la valeur du cookie langue
        String langue;
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            if( cookie.getName().equals("langue")){
                langue = c.getValue();
            }
        }
        
    }

    
}
