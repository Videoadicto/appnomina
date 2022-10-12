/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.entidades;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Usuario implements Serializable{
    private int id_usuario;
    private String nombre;
    private String password;
    private int tipo;
    
    public Usuario(){
        super();
    }
    
    public Usuario(int id_usuario, String nombre, String password, int tipo ) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.tipo = 1;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", password=" + password + ", tipo=" + tipo + '}';
    }

    
     
}
