package com.iesvdc.acceso.simplecrud.controller.service;

import com.iesvdc.acceso.simplecrud.dao.*;
import com.iesvdc.acceso.simplecrud.daoimpl.*;
import com.iesvdc.acceso.simplecrud.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.com>
 */
@Path("/api")
public class ReservasResource {


    @GET
    @Path("reservass")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getReservas() {
        ReservaDao reservaDao = new ReservaDaoImpl();
        List<Reserva> reservas;
        try {
            reservas = reservaDao.findAll();
            return Response.ok(reservas).build();
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("reservass/{id},{date}")
    
    public Response createReserva(@Context HttpServletRequest req ,@PathParam("id") String id,@PathParam("date") String date) {
        
        System.out.println("dentro");
        System.out.println(date);
        

            Cookie loginCookie = null;
            String loginId = "";
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("ges_res.user")) {
                        loginCookie = cookie;

                    }
                    if (cookie.getName().equals("ges_res.userId")) {
                        loginId = cookie.getValue();
                       // System.out.println("'tenemos --- neww cookie2'" + cookie.getValue());

                    }
                }
                if (loginCookie!=null) {
                    //System.out.println("'tenemos cookie'" + loginCookie.getClass());
                    //System.out.println("'tenemos cookie'" + loginCookie.getValue());
                }
            }
        
        ReservaDao reservaDao = new ReservaDaoImpl();
        HorarioDao horarioDao = new HorarioDaoImpl();
        UsuarioDao usuarioDao = new UsuarioDaoImpl();

        Reserva reserva = reservaDao.findOne(Long.parseLong(id));
        Usuario usuario = usuarioDao.findById(Integer.parseInt(loginId));
        Horario horario = horarioDao.findById(Integer.parseInt(id));

        //TODO CAMBIAR ESTA FECHA POR LA FECHA DEL DIA QUE QUEREMOS RESERVAR
        LocalDate fechaActual = LocalDate.parse(date);
        
        try {
            if (!reservaDao.create(usuario,horario,fechaActual)){
                return Response.status(200).entity(reserva).build();
            }else{
                return Response.status(500).entity(reserva).build();

            }
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());

            return Response.status(500).entity(reserva).build();
        }

        //Este return da problemas deberia eliminarse pero al eliminar no funciona el boton
        //return Response.status(404).entity(reserva).build();
        
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("reservass/{id}")

    public Response deleteReserva(@Context HttpServletRequest req ,@PathParam("id") String id) {

        System.out.println("dentro");


            Cookie loginCookie = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("ges_res.user")) {
                        loginCookie = cookie;

                    }

                }
                if (loginCookie!=null) {
                    //System.out.println("'tenemos cookie'" + loginCookie.getClass());
                    //System.out.println("'tenemos cookie'" + loginCookie.getValue());
                }
            }

        ReservaDao reservaDao = new ReservaDaoImpl();


        Reserva reserva = reservaDao.findOne(Long.parseLong(id));


        //TODO CAMBIAR ESTA FECHA POR LA FECHA DEL DIA QUE QUEREMOS RESERVAR

        try {

            if (!reservaDao.delete(Long.parseLong(id))){
                return Response.status(200).entity(reserva).build();
            }else{
                return Response.status(500).entity(reserva).build();

            }
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());

            return Response.status(500).entity(reserva).build();
        }

        //Este return da problemas deberia eliminarse pero al eliminar no funciona el boton
        //return Response.status(404).entity(reserva).build();

    }
    

}