package com.iesvdc.acceso.simplecrud.controller.service;

import com.iesvdc.acceso.simplecrud.dao.*;
import com.iesvdc.acceso.simplecrud.daoimpl.*;
import com.iesvdc.acceso.simplecrud.model.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.com>
 */
@Path("/api")
public class HorarioResource {

    @GET
    @Path("horario")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHorarios() {
        HorarioDao horarioDao = new HorarioDaoImpl();
        List<Horario> horarios;
        try {
            horarios = horarioDao.findAll();
            return Response.ok(horarios).build();
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("horario/instalacion/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHorarioInstalacion(@PathParam("id") String id) {
        HorarioDao horarioDao = new HorarioDaoImpl();
        List<Horario> horarios;
        try {
            horarios = horarioDao.findByInstalacion(Integer.parseInt(id));
            if (horarios!=null) // consulta ok y devuelve lista
                return Response.ok(horarios).build();
            else // no pudo conectar a la BBDD
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        } catch (Exception ex) { // cualquier otro error
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }


    }@GET
    @Path("horario/instalacionSinReservar/{id},{date}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHorarioInstalacionNotReseved(@PathParam("id") String id,@PathParam("date") String date) {
        HorarioDao horarioDao = new HorarioDaoImpl();
        List<Horario> horarios;
        try {
            horarios = horarioDao.findByInstalacionNotReserved(Integer.parseInt(id),date);
            if (horarios!=null) // consulta ok y devuelve lista
                return Response.ok(horarios).build();
            else // no pudo conectar a la BBDD
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        } catch (Exception ex) { // cualquier otro error
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("horario/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHorarioById(@PathParam("id") String id) {
        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario hor;
        try {
            hor = horarioDao.findById(Integer.parseInt(id));
            return Response.ok(hor).build();
        } catch (Exception ex) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("horario/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateHorario(@PathParam("id") Long oldHorarioId, Horario newHorario) {
        HorarioDao horarioDao = new HorarioDaoImpl();
        try {
            if (horarioDao.update(oldHorarioId, newHorario)) {
                return Response.status(200).entity(newHorario).build();
            } 
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(oldHorarioId).build();
        }
        return Response.status(Status.NOT_FOUND).entity(oldHorarioId).build();
    }

    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("horario")
    public Response createHorario(Horario horario) {
        HorarioDao horarioDao = new HorarioDaoImpl();
        try {
            if (horarioDao.create(horario))
                return Response.status(200).entity(horario).build();
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(500).entity(horario).build();
        }
        return Response.status(404).entity(horario).build();
    }
    
    @DELETE
    @Path("horario/{id}")
    public Response deleteHorario(@PathParam("id") Integer id) {
        InstalacionDao horarioDao = new InstalacionDaoImpl();
        try {
            if (horarioDao.delete(id))
                return Response.status(200).entity(id).build();
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(id).build();
        }
        return Response.status(Status.NOT_FOUND).entity(id).build();
    }
}