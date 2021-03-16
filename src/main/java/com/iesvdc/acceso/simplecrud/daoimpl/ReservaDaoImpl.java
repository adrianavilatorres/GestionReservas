package com.iesvdc.acceso.simplecrud.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.HorarioDao;
import com.iesvdc.acceso.simplecrud.dao.ReservaDao;
import com.iesvdc.acceso.simplecrud.dao.UsuarioDao;
import com.iesvdc.acceso.simplecrud.model.Horario;
import com.iesvdc.acceso.simplecrud.model.Instalacion;
import com.iesvdc.acceso.simplecrud.model.Reserva;
import com.iesvdc.acceso.simplecrud.model.Usuario;

public class ReservaDaoImpl implements ReservaDao {

    @Override
    public boolean create(Usuario usuario, Horario horario, LocalDate fecha) {
        return create(usuario.getId(), horario.getId(), fecha);
    }

    @Override
    public boolean create(Integer usuario, Long horario, LocalDate fecha) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            String sql = 
                "INSERT INTO reserva(id, usuario, horario, fecha ) VALUES (NULL,?,?,?)";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, usuario);
            pstmt.setLong(2, horario);
            pstmt.setString(3, fecha.toString());
            if (pstmt.executeUpdate() > 1) 
                resultado = true;
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  "+ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean update(Reserva oldReserva, Reserva newReserva) {
        return update(oldReserva.getId(), newReserva);
    }

    @Override
    public boolean update(Long oldReserva, Reserva newReserva) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            // NO se puede actualizar el ID porque es un autoincrement.
            String sql = 
                "UPDATE FROM reserva SET fecha=?, horario=?, usuario=? WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(2, newReserva.getFecha().toString());
            pstmt.setLong(3, newReserva.getHorario().getId());
            pstmt.setInt(4, newReserva.getUsuario().getId());
            pstmt.setLong(5, oldReserva);
            if (pstmt.executeUpdate() > 1) 
                resultado = true;
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  "+ex.getMessage());
        }
        return resultado;
    }

    @Override
    public Reserva findOne(Long idReserva) {
        Reserva reserva;

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario usuario;

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 

        LocalDate fecha;
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reserva WHERE id=?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setLong(1, idReserva);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
            } else {
                reserva = new Reserva();
            }
            conexion.destroy();
        } catch (SQLException se) {
            reserva = null;
        }
        return reserva;
    }

    @Override
    public List<Reserva> findAll() {
        Reserva reserva;
        List<Reserva> reservas = new ArrayList<Reserva>();

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario usuario;

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 

        LocalDate fecha;
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reserva";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
                reservas.add(reserva);
            } 
            conexion.destroy();
        } catch (SQLException se) {
            reservas = null;
        }
        return reservas;
    }

    @Override
    public List<Reserva> findByInstalacion(Instalacion instalacion) {
        Reserva reserva;
        List<Reserva> reservas = new ArrayList<Reserva>();

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario usuario;

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 

        LocalDate fecha;
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT reserva.* FROM reserva, horario, instalacion "+
                " WHERE horario.instalacion=instalacion.id AND instalacion=?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, instalacion.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
                reservas.add(reserva);
            } 
            conexion.destroy();
        } catch (SQLException se) {
            reservas = null;
        }
        return reservas;
    }

    @Override
    public List<Reserva> findByInstalacionFromNow(Instalacion instalacion) {
        Reserva reserva;
        List<Reserva> reservas = new ArrayList<Reserva>();

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario usuario;

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 

        LocalDate fecha;
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT reserva.* FROM reserva, horario, instalacion "+
                " WHERE horario.instalacion=instalacion.id AND instalacion=? AND "+
                " reserva.fecha >= DATE(NOW())";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, instalacion.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
                reservas.add(reserva);
            } 
            conexion.destroy();
        } catch (SQLException se) {
            reservas = null;
        }
        return reservas;
    }

    @Override
    public List<Reserva> findByDate(LocalDate fecha) {
        Reserva reserva;
        List<Reserva> reservas = new ArrayList<Reserva>();

        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        Usuario usuario;

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reserva WHERE date=?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setString(1, fecha.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
                reservas.add(reserva);
            } 
            conexion.destroy();
        } catch (SQLException se) {
            reservas = null;
        }
        return reservas;
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        Reserva reserva;
        List<Reserva> reservas = new ArrayList<Reserva>();

        HorarioDao horarioDao = new HorarioDaoImpl();
        Horario horario; 

        LocalDate fecha;
        
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reserva WHERE usuario=?";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                horario = horarioDao.findById( rs.getInt("horario") );
                // usuario = usuarioDao.findById( rs.getInt("usuario"));
                fecha = LocalDate.parse(rs.getString("fecha"));
                reserva = new Reserva(
                    rs.getLong("id"),
                    usuario,
                    horario,
                    fecha
                );
                reservas.add(reserva);
            } 
            conexion.destroy();
        } catch (SQLException se) {
            reservas = null;
        }
        return reservas;
    }

    @Override
    public boolean delete(Long reserva) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            String sql = 
                "DELETE FROM reserva WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);

            pstmt.setLong(1, reserva);
            if (pstmt.executeUpdate() > 1) 
                resultado = true;
            pstmt.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  "+ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean delete(Reserva reserva) {
        return delete(reserva.getId());
    }

}