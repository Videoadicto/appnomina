/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Empleado implements Serializable{
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String fecha_vinculacion;
    private String telefono;
    private String eps;
    private Cargo idCargo;
    private int estado;
    
    public Empleado(){
        //super();
        this.id_empleado = 0;
        this.nombre = "";
        this.apellido = "";
        this.cedula = "";
        this.fecha_vinculacion = "";
        this.telefono = "";
        this.eps = "";
        this.idCargo = new Cargo();
        this.estado = 0;
    }
    
    public Empleado(int id_empleado, String nombre, String apellido, String cedula, String fecha_vinculacion, String telefono, String eps, Cargo id_Cargo, int estado) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fecha_vinculacion = fecha_vinculacion;
        this.telefono = telefono;
        this.eps = eps;
        this.idCargo = id_Cargo;
        this.estado = estado;
    }

    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(String fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", nombre=" + nombre + ", apellido=" + apellido  + ", cedula=" + cedula + ", fecha_vinculacion=" + fecha_vinculacion + ", telefono=" + telefono + ", eps=" + eps + ", idCargo=" + idCargo + ", estado=" + estado + '}';
    }

  

     
}
