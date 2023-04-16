/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.entidades;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author Usuario
 */
public class HistoricoEmpleado implements Serializable{
    private int id_historico;
    private int id_empleado;
    private int id_cargo;
    private Date fecha;
    
           public HistoricoEmpleado(){
        //super();
        this.id_historico = 0;
        this.id_empleado = 0;
        this.id_cargo=0;
        this.fecha = null;

    }
    
    
    public HistoricoEmpleado(int id_historico, int id_empleado, int id_cargo, Date fecha) {
        this.id_historico = id_historico;
        this.id_empleado = id_empleado;
        this.id_cargo = id_cargo;
        this.fecha = fecha;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistoricoEmpleado{" + "id_historico=" + id_historico + ", id_empleado=" + id_empleado + ", id_cargo=" + id_cargo + ", fecha=" + fecha + '}';
    }

    


     
}
