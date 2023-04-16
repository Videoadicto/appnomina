/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Semanal implements Serializable{
    private String cedula;
    private String nombre;
    private String apellido;
    private String fecha;
    private int total;
    private int prima;
    private int cesantias;
    
    public Semanal(){
        //super();
        this.cedula = "";
        this.nombre = "";
        this.apellido = "";
        this.fecha = "";
        this.total = 0;
        this.prima = 0;
       
        this.cesantias = 0;
    }
    
    public Semanal(String cedula, String nombre, String apellido, String fecha, int total, int prima, int cesantias) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.total = total;
        this.prima = prima;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

    public int getCesantias() {
        return cesantias;
    }

    public void setCesantias(int cesantias) {
        this.cesantias = cesantias;
    }

    @Override
    public String toString() {
        return "Semanal{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha + ", total=" + total + ", prima=" + prima + ", cesantias=" + cesantias + '}';
    }

    
  

     
}
