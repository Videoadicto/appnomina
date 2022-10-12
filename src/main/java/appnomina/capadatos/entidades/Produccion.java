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
public class Produccion implements Serializable{
    private int id_produccion;
    private Empleado idEmpleado;
    private String fecha;
    private int produccion;
    private int estado;
     
    public Produccion(){
        //super();
        this.id_produccion = 0;
        this.idEmpleado = new Empleado();
        this.fecha = "";
        this.produccion = 0;
        this.estado = 0;
    }
    
    public Produccion(int id_produccion, Empleado idEmpleado, String fecha, int produccion) {
        this.id_produccion = id_produccion;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.produccion = produccion;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Produccion{" + "id_produccion=" + id_produccion + ", idEmpleado=" + idEmpleado + ", fecha=" + fecha + ", produccion=" + produccion + ", estado=" + estado + '}';
    }
    
}
