
package com.iesvdc.acceso.simplecrud.controller.service;


import java.util.ArrayList;
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


import com.iesvdc.acceso.simplecrud.dao.InstalacionDao;
import com.iesvdc.acceso.simplecrud.daoimpl.InstalacionDaoImpl;
import com.iesvdc.acceso.simplecrud.model.*;


/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.coms>
 */
@Path("/api")
public class InstalacionResource {

    @GET
    @Path("instalacion")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInstalaciones() {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        List<Instalacion> instalaciones;
        try {
            instalaciones = instalacionDao.findAll();
        } catch (Exception ex) {
            instalaciones = new ArrayList<>();
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(500).entity(instalaciones).build();
        }
        return Response.ok(instalaciones).build();
    }

    @GET
    @Path("instalacion/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInstalacionById(@PathParam("id") String id) {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        Instalacion instalacion;
        try {
            instalacion = instalacionDao.findById(Integer.parseInt(id));
        } catch (Exception ex) {
            instalacion = new Instalacion();
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(400).entity(instalacion).build();
        }
        return Response.ok(instalacion).build();
    }

    
    @GET
    @Path("instalacion/nombre/{nombre}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInstalacionByNombre(@PathParam("nombre") String nombre) {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        List<Instalacion> instalaciones;
        try {
            instalaciones = instalacionDao.findByNombre(nombre);
        } catch (Exception ex) {
            instalaciones = new ArrayList<>();
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(500).build();
        }
        return Response.ok(instalaciones).build();
    }


    @PUT
    @Path("instalacion/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateAlumno(@PathParam("id") Integer id, Instalacion instalacion) {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        try {
            instalacionDao.update(id, instalacion);
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(400).entity(instalacion).build();
        }
        return Response.ok(instalacion).build();
    }

    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("instalacion")
    public Response createInstalacion(Instalacion al) {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        try {
            instalacionDao.create(al);
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(400).entity(al).build();
        }
        return Response.status(200).entity(al).build();
    }
    
    @DELETE
    @Path("instalacion/{id}")
    public Response deleteInstalacion(@PathParam("id") Integer id) {
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        try {
            instalacionDao.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ex.getLocalizedMessage());
            return Response.status(400).build();
        }
        return Response.ok(id).build();
    }
}
