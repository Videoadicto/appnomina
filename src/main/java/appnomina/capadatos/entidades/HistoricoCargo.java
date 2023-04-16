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
public class HistoricoCargo implements Serializable{
    private int id_historico;
    private int id_cargo;
    private int pago;
    private Date fecha;
    
           public HistoricoCargo(){
        //super();
        this.id_historico = 0;
        this.id_cargo = 0;
        this.pago=0;
        this.fecha = null;

    }
    
    
    public HistoricoCargo(int id_historico, int id_cargo, int pago, Date fecha) {
        this.id_historico = id_historico;
        this.id_cargo = id_cargo;
        this.pago = pago;
        this.fecha = fecha;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistoricoEmpleado{" + "id_historico=" + id_historico + ", id_cargo=" + id_cargo + ", pago=" + pago + ", fecha=" + fecha + '}';
    }

    


     
}
