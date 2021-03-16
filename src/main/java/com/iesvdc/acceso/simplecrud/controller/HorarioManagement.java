package com.iesvdc.acceso.simplecrud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.HorarioDao;
import com.iesvdc.acceso.simplecrud.daoimpl.HorarioDaoImpl;
import com.iesvdc.acceso.simplecrud.model.Horario;


/**
 * TO-DO: falta pasar todo a los DAO
 */
public class HorarioManagement extends HttpServlet {

    @Override
    public void init() {

    }

    // LEER
    @Override
    protected void doGet(HttpServletRequest request, // parámetros de la petición
            HttpServletResponse response) // respuesta que genero
            throws IOException {
        
        String id = request.getRequestURI().substring(request.getContextPath().length());
        id = id.replace("/horario/", "");
        System.err.println("HORARIO-SERVLET::DO-GET:: id="+id);
        HorarioDao horarioDao = new HorarioDaoImpl();
        List<Horario> horarios = horarioDao.findByInstalacion(Integer.parseInt(id));
        
        String horariosJsonString = new Gson().toJson(horarios);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(horariosJsonString);
        out.flush();
    }

    // CREAR
    @Override
    protected void doPost(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {

        Conexion con;
        PreparedStatement ps;

        String instalacion = req.getParameter("instalacion");
        String inicio = req.getParameter("inicio");
        String fin = req.getParameter("fin");
        
        try {
            con = new Conexion();
            String sql = "INSERT INTO `horario` (`instalacion`, `inicio`, `fin`) "+
                " VALUES (?, ?, ?);";
            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(instalacion));
            ps.setString(2, inicio);
            ps.setString(3, fin);
            ps.executeUpdate();
            ps.close();
            con.destroy();
            resp.sendRedirect("privado/horarioRead.jsp");
        } catch (Exception e){
            resp.setStatus(409);
        } finally {
           
        }
    }

    // ACTUALIZAR
    @Override
    protected void doPut(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws  IOException {
        // procesamos la petición
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        Horario horario = gson.fromJson(reader, Horario.class);
        // con el DAO hacemos el cambio en la BBDD
        HorarioDao horarioDao = new HorarioDaoImpl();
        if (horarioDao.update(horario.getId(), horario)) {
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }
    }


    // BORRAR
    @Override
    protected void doDelete(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp)  throws IOException {// respuesta que genero
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonObject = "{}";
        // buscamos en la base de datos el objeto y devolvemos sus datos

        String id = req.getRequestURI().substring(req.getContextPath().length());
        id = id.replace("/horario/", "");
        jsonObject = "{'error': '" + id + "'}";

        // String id = req.getParameter("userid");
        try {
            Conexion conn = new Conexion();
            String sql = "DELETE FROM horario WHERE id=?";
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm = conn.getConnection().prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            if (pstm.executeUpdate() == 0) {
                jsonObject = "{ " + "'id':'" + id + "'}";
            }

            pstm.close();
            conn.destroy();
        } catch (Exception ex) {

        }
        out.print(jsonObject.replaceAll("'", "\""));
        out.flush();

    }

    @Override
    public void destroy() {

    }

    
}
