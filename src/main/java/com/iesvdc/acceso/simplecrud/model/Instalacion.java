package com.iesvdc.acceso.simplecrud.model;

public class Instalacion {
    
    private int id;
    private String name;

    public Instalacion(){}

    public Instalacion(String name) {
        this.name = name;
    }
    
    public Instalacion(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Instalacion)) {
            return false;
        }
        Instalacion instalacion = (Instalacion) o;
        
        return instalacion.id == this.id && 
            instalacion.name.compareTo(this.name)==0;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    

}