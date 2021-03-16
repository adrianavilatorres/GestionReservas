package com.iesvdc.acceso.simplecrud.model;

import java.time.LocalDate;

public class Reserva {
    Long id;
    Usuario usuario;
    Horario horario;
    LocalDate fecha;


    public Reserva() {
    }

    public Reserva(Usuario usuario, Horario horario, LocalDate fecha) {
        this.usuario = usuario;
        this.horario = horario;
        this.fecha = fecha;
    }

    public Reserva(Long id, Usuario usuario, Horario horario, LocalDate fecha) {
        this.id = id;
        this.usuario = usuario;
        this.horario = horario;
        this.fecha = fecha;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Reserva id(Long id) {
        this.id = id;
        return this;
    }

    public Reserva usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Reserva horario(Horario horario) {
        this.horario = horario;
        return this;
    }

    public Reserva fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reserva)) {
            return false;
        }
        Reserva reserva = (Reserva) o;
        return usuario.equals(reserva.usuario) && 
            horario.equals(reserva.horario) && 
            fecha.compareTo(reserva.fecha)!=0;
    }

   

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " usuario='" + this.getUsuario().toString() + "'" +
            ", horario='" + this.getHorario().toString() + "'" +
            ", fecha='" + getFecha().toString() + "'" +
            "}";
    }

    
}
