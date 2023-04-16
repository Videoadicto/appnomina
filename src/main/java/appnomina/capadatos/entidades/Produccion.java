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
public class Produccion implements Serializable{
    private int id_produccion;
    private Empleado idEmpleado;
    private Date fecha;
    private int cantidad;
    private int estado;
     
    public Produccion(){
        //super();
        this.id_produccion = 0;
        this.idEmpleado = new Empleado();
        this.fecha = null;
        this.cantidad = 0;
        this.estado = 0;
    }
    
    public Produccion(int id_produccion, Empleado idEmpleado, Date fecha, int cantidad) {
        this.id_produccion = id_produccion;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = 1;
    }

    public int getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Produccion{" + "id_produccion=" + id_produccion + ", idEmpleado=" + idEmpleado + ", fecha=" + fecha + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }
    
}
