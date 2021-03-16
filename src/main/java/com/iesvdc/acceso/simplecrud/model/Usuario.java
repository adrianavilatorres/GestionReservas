package com.iesvdc.acceso.simplecrud.model;

public class Usuario {
    
    String username;
    String email;
    String password;
    Integer id;
    
    public Usuario() {

    }

    public Usuario(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Usuario(Integer id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

    @Override 
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario u = (Usuario) o;
        
        return u.getId() == this.id &&
            u.getUsername().compareTo(this.username)==0 &&
            u.getPassword().compareTo(this.password)==0 &&
            u.getEmail().compareTo(this.email)==0;
    }
}