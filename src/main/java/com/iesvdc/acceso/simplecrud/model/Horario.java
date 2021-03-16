package com.iesvdc.acceso.simplecrud.model;


public class Horario {
    Instalacion instalacion;
    String    inicio;
    String    fin;
    Long id;

    public Horario() {
    }

    public Horario(Long id, Instalacion instalacion, String inicio, String fin) {
        this.instalacion = instalacion;
        this.inicio = inicio;
        this.fin = fin;
        this.id = id;
    }

    public Instalacion getInstalacion() {
        return this.instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public String getInicio() {
        return this.inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return this.fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horario instalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
        return this;
    }

    public Horario inicio(String inicio) {
        this.inicio = inicio;
        return this;
    }

    public Horario fin(String fin) {
        this.fin = fin;
        return this;
    }

    public Horario id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Horario)) {
            return false;
        }
        Horario horario = (Horario) o;
        
        return horario.id == this.id &&
            horario.inicio.compareTo(this.inicio)==0 &&
            horario.fin.compareTo(this.fin)==0 &&
            horario.instalacion.equals(this.instalacion);
    }


    @Override
    public String toString() {
        return "{" +
            " instalacion='" + getInstalacion().toString() + "'" +
            ", inicio='" + getInicio() + "'" +
            ", fin='" + getFin() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }


}
