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

import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.model.Instalacion;
import com.iesvdc.acceso.simplecrud.dao.InstalacionDao;

/**
 *
 * @author juangu
 */
public class InstalacionDaoImpl implements InstalacionDao {
    
    /** 
     * Da de alta en la base  de datos una instalación
     * @param instala la instalación a guardar.
     * @return boolean (true si éxito)
     */
    // CRUD, findAll, finById, count
    public boolean create(Instalacion instala) {
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();
            String sql = "INSERT INTO instalacion VALUES (NULL,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instala.getId());
            pstmt.setString(2, instala.getName());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            exito = false;
        }
        return exito;
    }

    
    /** 
     * Busca una instalación por su identificador
     * @param id
     * @return Instalacion
     */
    public Instalacion findById(Integer id) {
        Instalacion instala;
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();
            String sql = "SELECT * FROM instalacion WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            // System.err.println("\nID:: " + id + "\n");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                instala = new Instalacion(rs.getInt("id"), rs.getString("nombre"));
            } else {
                instala = new Instalacion(); 
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("InstalacionDAO::findById:NOT FOUND:\n  ID:: " + id + "\n");
            instala = null;
        }
        return instala;
    }

    
    /** 
     * Todas las instalaciones de la bae de datos
     * @return List<Instalacion>
     */
    public List<Instalacion> findAll() {
        Instalacion instala;
        List<Instalacion> li_ins = new ArrayList<Instalacion>();
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();

            String sql = "SELECT * FROM instalacion";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            // recorro el resultset mientras tengo datos
            while (rs.next()) {
                instala = new Instalacion(rs.getInt("id"), rs.getString("nombre"));
                li_ins.add(instala);
            }
            // cerramos la conexión
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            li_ins = null;
        }
        return li_ins;
    }

    /**
     * Este método busca Instalaciones en la BBDD por nombre:
     * 
     * @param nombre El nombre a buscar
     * @return Devuelve: null: si hayinstalagún error (no se puede conectar a la
     *         BBDD...). <br>
     *         ArrayList vacío (length == 0): si no hay nadie con ese nombre. <br>
     *         ArrayList con Instalaciones: si hay instalaciones con ese nombre.<br>
     */
    public List<Instalacion> findByNombre(String nombre) {
        Instalacion instala;
        List<Instalacion> li_ins = new ArrayList<Instalacion>();
        try {
            // conectamos a la BBDD
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();
            // esta es la cadena SQL de conslulta
            String sql = "SELECT * FROM instalacion WHERE nombre=?";
            // usamos este objeto porque es más seguro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            // ejecutar la consulta contra la base de datos y
            // devuelve el resultado en el ResultSet (parecido a
            // un Array con iterador
            ResultSet rs = pstmt.executeQuery();
            // recorro el resultset mientras tengo datos
            while (rs.next()) {
                instala = new Instalacion(rs.getInt("id"), rs.getString("nombre"));
                li_ins.add(instala);
            }
            // cerramos la conexión
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            li_ins = null;
        }
        return li_ins;
    }

    /**
     * Este método actualiza una instalación en la BBDD
     * 
     * @param old_al El objeto que contiene los datos antiguos del objeto
     * @param new_al El objeto que contiene los datos nuevos del objeto
     * @return true si se lleva a cabo correctamente <br>
     *         false si no se actualiza nada (error de conexión, no estaba
     *         el objeto en la BBDD...) <br>
     */
    public boolean update(Instalacion old_al, Instalacion new_al) {

        return update(old_al.getId(), new_al);
    }

    /**
     * Este método actualiza una instalación en la BBDD
     * 
     * @param old_id El id antiguo de la instalación
     * @param new_al El objeto que contiene la instalación actualizada
     * @return true si se lleva a cabo correctamente <br>
     *         false si no se actualiza nada (error de conexión, no estaba
     *         en la BBDD...) <br>
     */
    public boolean update(Integer old_id, Instalacion new_al) {
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();
            // No actualizamos el ID porque es un autoincrement y podría dar problemas.
            String sql = "UPDATE instalacion SET nombre=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2, old_id);
            // pstmt.setInt(1, new_al.getId());
            pstmt.setString(1, new_al.getName());
            if (pstmt.executeUpdate() == 0) {
                exito = false;
            }
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }

    /**
     * Este método borra de la BBDD la instalación cuyos datos coinciden con los de el
     * objeto que se le pasa como parámetro
     * 
     * @param instalacion a borrar
     * @return true si borra una instalación. <br>
     *         false si no existe o no se puede conectar a la BBDD
     *         <br>
     */
    public boolean delete(Instalacion instala) {
        return delete(instala.getId());
    }

    public boolean delete(Integer id_al) {
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();
            String sql = "DELETE FROM instalacion WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id_al);
            if (pstmt.executeUpdate() == 0) {
                exito = false;
            }
            conn.close();
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }

}
