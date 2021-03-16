/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.simplecrud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.iesvdc.acceso.simplecrud.conexion.*;
import com.iesvdc.acceso.simplecrud.model.*;
import com.iesvdc.acceso.simplecrud.dao.*;

/**
 *
 * @author juangu <jgutierrez at iesvirgendelcarmen.com>
 */
public class HorarioDaoImpl implements HorarioDao{
    
    /** 
     * Guarda el objeto en la base de datos
     * @param horario
     * @return boolean
     */
    // CRUD, findAll, finById, count
    public boolean create(Horario horario){
        boolean exito=true;
        try {        
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            String sql = 
                "INSERT INTO horario(id, inicio, fin, instalacion ) VALUES (NULL,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, horario.getId());
            pstmt.setString(2, horario.getInicio().toString());
            pstmt.setString(3, horario.getFin().toString());
            pstmt.setLong(4, horario.getInstalacion().getId());
            pstmt.executeUpdate();  
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR:  "+ex.getMessage());
            exito = false;
        } 
        return exito;
    }
    
    
    
    /** 
     * Busca un horario por su id
     * @param id
     * @return Horario
     */
    public Horario findById(Integer id){
        Horario horario;
        try {
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            InstalacionDao iDao = new InstalacionDaoImpl();
            String sql = 
                "SELECT * FROM horario WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            System.err.println("\nID:: "+id+"\n");
            ResultSet rs  = pstmt.executeQuery();
            rs.next();
            horario = new Horario(
                rs.getLong("id"),
                iDao.findById(rs.getInt("instalacion")),
                rs.getString("inicio"),
                rs.getString("fin"));                    
            conn.close();
        } catch (SQLException ex) {
           horario = null;
        } 
        return horario;
    } 
    

    
    /** 
     * Todos los horarios de la base de datos
     * @return List<Horario>
     */
    public List<Horario> findAll() {
        Horario horario;
        List<Horario> horarios = new ArrayList<Horario>();
        InstalacionDao iDao = new InstalacionDaoImpl();
        try {            
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();

            String sql = "SELECT * FROM horario";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs  = pstmt.executeQuery();
            // recorro el resultset mientras tengo datos
            while (rs.next()){
                horario = new Horario(
                    rs.getLong("id"),
                    iDao.findById(rs.getInt("instalacion")),
                    rs.getString("inicio"),
                    rs.getString("fin")); 
                horarios.add(horario);
            }
            // cerramos la conexión
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR"+ ex.getMessage());
            horarios = null;
        } 
        return horarios;
    }
    
    
    /**
     * Este método busca Horarios en la BBDD por Instalación:
     * @param instalación
     * La instalación de la que queremos sus horarios a buscar
     * @return 
     * Devuelve:
     * null: si hayinstalagún error (no se puede conectar a la BBDD...). <br>
     * ArrayList vacío (length == 0): si no hay horarios para esa instalación. <br>  
     * ArrayList con Horarios: si hay horarios para esa instalación.<br>
     */
    public List<Horario> findByInstalacion(Instalacion instalacion){
        Horario horario;
        List<Horario> horarios = new ArrayList<Horario>();
        try {            
            // conectamos a la BBDD
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            // esta es la cadena SQL de conslulta
            String sql = "SELECT * FROM horario WHERE instalacion=?";
            // usamos este objeto porque es más seguro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instalacion.getId());
            // ejecutar la consulta contra la base de datos y 
            // devuelve el resultado en el ResultSet (parecido a 
            // un Array con iterador
            ResultSet rs  = pstmt.executeQuery();
            // recorro el resultset mientras tengo datos
            while (rs.next()){
                horario = new Horario(
                    rs.getLong("id"),
                    instalacion,
                    rs.getString("inicio"),
                    rs.getString("fin")); 
                horarios.add(horario);
            }
            // cerramos la conexión
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR::"+ ex.getMessage());
            horarios = null;
        } 
        return horarios;
    }
    
    /**
     * Este método busca Horarios en la BBDD por id de Instalación:
     * @param instalación
     * La instalación de la que queremos sus horarios a buscar
     * @return 
     * Devuelve:
     * null: si hayinstalagún error (no se puede conectar a la BBDD...). <br>
     * ArrayList vacío (length == 0): si no hay horarios para esa instalación. <br>  
     * ArrayList con Horarios: si hay horarios para esa instalación.<br>
     */
    public List<Horario> findByInstalacion(Integer id){
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        Instalacion instalacion = instalacionDao.findById(id); 
        return findByInstalacion(instalacion);
    }




    public List<Horario> findByInstalacionNotReserved(Instalacion instalacion,String date){
        Horario horario;
        List<Horario> horarios = new ArrayList<Horario>();
        try {            
            System.out.println(date);
            // conectamos a la BBDD
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            // esta es la cadena SQL de conslulta
            //String sql = "SELECT * FROM horario where id NOT IN (select horario from reserva) and instalacion = ?";
            String sql = "SELECT * FROM  horario where id not IN (select horario from reserva where fecha = '"+ date + "' ) and instalacion = ?";
            // usamos este objeto porque es más seguro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instalacion.getId());
            // ejecutar la consulta contra la base de datos y 
            // devuelve el resultado en el ResultSet (parecido a 
            // un Array con iterador
            ResultSet rs  = pstmt.executeQuery();
            // recorro el resultset mientras tengo datos
            while (rs.next()){
                horario = new Horario(
                    rs.getLong("id"),
                    instalacion,
                    rs.getString("inicio"),
                    rs.getString("fin")); 
                horarios.add(horario);
            }
            // cerramos la conexión
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR::"+ ex.getMessage());
            horarios = null;
        } 
        return horarios;
    }
    
    /**
     * Este método busca Horarios en la BBDD por id de Instalación:
     * @param instalación
     * La instalación de la que queremos sus horarios a buscar
     * @return 
     * Devuelve:
     * null: si hayinstalagún error (no se puede conectar a la BBDD...). <br>
     * ArrayList vacío (length == 0): si no hay horarios para esa instalación. <br>  
     * ArrayList con Horarios: si hay horarios para esa instalación.<br>
     */
    public List<Horario> findByInstalacionNotReserved(Integer id,String date){
        InstalacionDao instalacionDao = new InstalacionDaoImpl();
        Instalacion instalacion = instalacionDao.findById(id); 
        return findByInstalacionNotReserved(instalacion,date);
    }
        
   
    
    /**
     * Este método actualiza una inslación en la BBDD
     * @param old_al
     * El objeto que contiene los datos antiguos  
     * @param newHorario
     * El objeto que contiene los datos nuevos  
     * @return 
     * true si se lleva a cabo correctamente <br>
     * false si no se actualiza nada (error de conexión, no 
     * estaba el objeto en la BBDD...) <br>
     */
    public boolean update(Horario oldHorario, Horario newHorario) {
        
        return update(oldHorario.getId(),newHorario);
    }
    
    /**
     * Este método actualiza un horario en la BBDD.
     * No se actuliza nunca el ID en ninguno de estos DAO 
     * porque en un autoincrement en la BBDD.
     * @param old
     * El id antiguo del objeto 
     * @param newHorario
     * El objeto que contiene la instalación actualizada
     * @return 
     * true si se lleva a cabo correctamente <br>
     * false si no se actualiza nada (error de conexión, no 
     * estaba el objeto en la BBDD...) <br>
     */
    public boolean update(Long old, Horario newHorario) {
        boolean exito=true;
        try {            
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            String sql = 
                "UPDATE horario SET inicio=?, fin=?, instalacion=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(4, old);
            // pstmt.setLong(1, newHorario.getId());
            pstmt.setString(1, newHorario.getInicio().toString());
            pstmt.setString(2, newHorario.getFin().toString());
            pstmt.setInt(3, newHorario.getInstalacion().getId());
            if (pstmt.executeUpdate()==0) {
                exito = false;
            }
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        } 
        return exito;
    }
    
    /**
     * Este método borra de la BBDD el horario cuyo id 
     * coincide con los de el objeto que se le pasa como 
     * parámetro
     * @param id del horario a borrar
     * @return 
     * true si borra el horario <br>
     * false si el horario no existe o no se puede conectar a la BBDD <br>
     */
    public boolean delete(Long id){
        boolean exito=true;
        try {            
            Conexion conexion = new Conexion();    
            Connection conn = conexion.getConnection();
            String sql = "DELETE FROM horario WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            if (pstmt.executeUpdate()==0) {
                exito = false;
            }
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        } 
        return exito;
    }

     /**
     * Este método borra de la BBDD el horario cuyo id 
     * coincide con los de el objeto que se le pasa como 
     * parámetro
     * @param horario el horario  a borrar
     * @return 
     * true si borra el horario <br>
     * false si el horario no existe o no se puede conectar a la BBDD <br>
     */
    public boolean delete(Horario horario){        
        return delete(horario.getId());
    }

    @Override
    public List<Horario> findByInstalacionNotReserved(Instalacion instalacion) {
        // TODO Auto-generated method stub
        return null;
    }
}
