package com.iesvdc.acceso.simplecrud.dao;

import java.time.LocalDate;
import java.util.List;

import com.iesvdc.acceso.simplecrud.model.*;

public interface ReservaDao {

    public boolean create(Usuario usuario, Horario horario, LocalDate fecha);
    public boolean create(Integer usuario, Long horario, LocalDate fecha);
    public boolean update(Reserva oldReserva, Reserva newReserva);
    public boolean update(Long oldReserva, Reserva newReserva);
    public Reserva findOne(Long idReserva);
    public List<Reserva> findAll();
    public List<Reserva> findByInstalacion(Instalacion instalacion);
    public List<Reserva> findByInstalacionFromNow(Instalacion instalacion);
    public List<Reserva> findByDate(LocalDate fecha);
    public List<Reserva> findByUsuario(Usuario usuario);
    public boolean delete(Long reserva);
    public boolean delete(Reserva reserva);
    
}