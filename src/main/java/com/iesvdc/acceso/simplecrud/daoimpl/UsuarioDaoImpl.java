package com.iesvdc.acceso.simplecrud.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.simplecrud.dao.UsuarioDao;
import com.iesvdc.acceso.simplecrud.model.Usuario;
import com.iesvdc.acceso.simplecrud.conexion.Conexion;

public class UsuarioDaoImpl implements UsuarioDao {

    
    
    /** 
     * Guarda un objeto de tipo usuario en la base de datos
     * @param usuario
     * @return true si éxito; false si da error.
     */
    @Override
    public boolean create(Usuario usuario) {
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO usuario (id,username,email,password) VALUES (NULL,?,?,?)";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            pstmt.executeUpdate();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            exito = false;
        }
        return exito;
    }

    
    /** 
     * Busca un usuario en la base de datos
     * @param id el identificador del usuario
     * @return El usuario si lo encuentra, usuario vacío si no estaba.
     */
    @Override
    public Usuario findById(Integer id) {
        Usuario usuario;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM usuario WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"), 
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"));
            } else {
                usuario = new Usuario();
            }
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            usuario = new Usuario(); // si error usuario vacío
        }
        return usuario;
    }

    
    /** 
     * Devuelve la lista de usuarios de la base de datos. 
     * Si no hay ninguno o hay algún error de conexión a 
     * la base de datos devuelve una lista vacía.
     * @return La lista de usuarios en la base de datos.
     */
    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM usuario";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"), 
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"));
                usuarios.add(usuario);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return usuarios;
    }

    
    /** 
     * Devuelve una lista de usuarios con ese "username".
     * Debería ser sólo uno, pero por similitud al buscar por email,
     * buscar por... etc. lo hacemos con lista.
     * @param username
     * @return la lista de usuarios con ese username.
     */
    @Override
    public List<Usuario> findByUsername(String username) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM usuario WHERE username=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"), 
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"));
                usuarios.add(usuario);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return usuarios;
    }

    
    /** 
     * Actualiza un usuario con nueva información
     * @param oldUsuario los datos antiguos
     * @param newUsuario los datos nuevos
     * @return true si éxito, false si error
     */
    @Override
    public boolean update(Usuario oldUsuario, Usuario newUsuario) {
        return update(oldUsuario.getId(), newUsuario);
    }

    
    /** 
     * Actualiza un usuario con nueva información
     * @param oldUsuario el ID del usuario a actualizar
     * @param newUsuario los datos nuevos
     * @return true si éxito, false si error
     */
    @Override
    public boolean update(Integer oldUsuario, Usuario newUsuario) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "UPDATE FROM usuario SET id=?, username=?, email=?, password=? WHERE id=?");
            ps.setInt(1, newUsuario.getId());
            ps.setString(2, newUsuario.getUsername());
            ps.setString(3, newUsuario.getEmail());
            ps.setString(4, newUsuario.getPassword());
            ps.setInt(5, oldUsuario);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    
    /** 
     * Borra el usuario de la base de datos si existe en ella.
     * @param usuario
     * @return true si lo borra porque existía, false en otro caso
     */
    @Override
    public boolean delete(Usuario usuario) {
        return delete(usuario.getId());
    }

    
    /** 
     * Borra el usuario de la base de datos si existe
     * @param usuario el ID del usuario.
     * @return true si lo borra porque existía, false en otro caso.
     */
    @Override
    public boolean delete(Integer usuario) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "DELETE FROM usuario WHERE id=?");
            ps.setInt(1, usuario);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

}