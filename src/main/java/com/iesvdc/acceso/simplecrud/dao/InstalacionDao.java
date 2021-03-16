package com.iesvdc.acceso.simplecrud.dao;

import java.util.List;

import com.iesvdc.acceso.simplecrud.model.Instalacion;

public interface InstalacionDao {
    public boolean create(Instalacion instala);
    public Instalacion findById(Integer id);
    public List<Instalacion> findAll();
    public List<Instalacion> findByNombre(String nombre);
    public boolean update(Instalacion old_al, Instalacion new_al);
    public boolean update(Integer old_id, Instalacion new_al);
    public boolean delete(Instalacion instala);
    public boolean delete(Integer id_al);
}