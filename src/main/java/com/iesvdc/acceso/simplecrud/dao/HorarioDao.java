package com.iesvdc.acceso.simplecrud.dao;

import java.util.List;

import com.iesvdc.acceso.simplecrud.model.Horario;
import com.iesvdc.acceso.simplecrud.model.Instalacion;

public interface HorarioDao {
    
    public boolean create(Horario horario);
    public Horario findById(Integer id);
    public List<Horario> findAll();
    public List<Horario> findByInstalacion(Instalacion instalacion);
    public List<Horario> findByInstalacion(Integer instalacion);
    public List<Horario> findByInstalacionNotReserved(Instalacion instalacion);
    public List<Horario> findByInstalacionNotReserved(Integer instalacion,String date);
    public boolean update(Horario oldHorario, Horario newHorario);
    public boolean update(Long oldHorario, Horario newHorario);
    public boolean delete(Horario horario);
    public boolean delete(Long horario);

} 