package com.iesvdc.acceso.simplecrud.dao;

import com.iesvdc.acceso.simplecrud.model.Usuario;
import java.util.List;

public interface UsuarioDao {
    public boolean create(Usuario usuario);
    public Usuario findById(Integer id);
    public List<Usuario> findAll();
    public List<Usuario> findByUsername(String username);
    public boolean update(Usuario oldUsuario, Usuario newUsuario);
    public boolean update(Integer oldUsuario, Usuario newUsuario);
    public boolean delete(Usuario usuario);
    public boolean delete(Integer usuario);
}