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
public class NominaSemanal implements Serializable{
    private int id_semanal;
    private Empleado idEmpleado;
    private String fecha;
    private int total;
    private int estado;
     
    public NominaSemanal(){
        //super();
        this.id_semanal = 0;
        this.idEmpleado = new Empleado();
        this.fecha = "";
        this.total = 0;
        this.estado = 0;
    }
    
    public NominaSemanal(int id_semanal, Empleado idEmpleado, String fecha, int total) {
        this.id_semanal = id_semanal;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.total = total;
        this.estado = 1;
    }

    public int getId_semanal() {
        return id_semanal;
    }

    public void setId_semanal(int id_semanal) {
        this.id_semanal = id_semanal;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdProduccion(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Total{" + "id_semanal=" + id_semanal + ", idEmpleado=" + idEmpleado + ", fecha=" + fecha + ", total=" + total + ", estado=" + estado + '}';
    }
    
}
