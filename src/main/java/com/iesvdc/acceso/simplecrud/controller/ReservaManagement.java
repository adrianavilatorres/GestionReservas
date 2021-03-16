package com.iesvdc.acceso.simplecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservaManagement extends HttpServlet {
    
    @Override 
    public void init() throws ServletException {
        
    }

    // findOne(id)
    @Override
    protected void doGet(
        HttpServletRequest req, // parámetros de la petición
        HttpServletResponse resp) // respuesta que genero
        throws ServletException, IOException {
            /*
            System.out.println("dentro");

            Cookie loginCookie = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("ges_res.user")) {
                        loginCookie = cookie;

                    }
                    if (cookie.getName().equals("ges_res.userId")) {
                        //loginCookie = cookie;
                        System.out.println("'tenemos cookie2'" + cookie.getValue());

                    }
                }
                if (loginCookie!=null) {
                    System.out.println("'tenemos cookie'" + loginCookie.getClass());
                    System.out.println("'tenemos cookie'" + loginCookie.getValue());
                }
            }*/
            
            
    }

   // CREAR
   @Override
   protected void doPost(
       HttpServletRequest req, // parámetros de la petición
       HttpServletResponse resp) // respuesta que genero
       throws ServletException, IOException {
           
   }

    // BORRAR
    @Override
    protected void doDelete(
        HttpServletRequest req, // parámetros de la petición
        HttpServletResponse resp) // respuesta que genero
        throws ServletException, IOException {
            

    }

    // ACTUALIZAR
    @Override
    protected void doPut(
        HttpServletRequest req, // parámetros de la petición
        HttpServletResponse resp) // respuesta que genero
        throws ServletException, IOException {

        
    }
}