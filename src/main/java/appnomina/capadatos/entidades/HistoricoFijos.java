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
public class HistoricoFijos implements Serializable{
    private int id_historico;
    private int id_fijo;
    private int valor;
    private Date fecha;
    
           public HistoricoFijos(){
        //super();
        this.id_historico = 0;
        this.id_fijo = 0;
        this.valor=0;
        this.fecha = null;

    }
    
    
    public HistoricoFijos(int id_historico, int id_fijo, int valor, Date fecha) {
        this.id_historico = id_historico;
        this.id_fijo = id_fijo;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getId_fijo() {
        return id_fijo;
    }

    public void setId_fijo(int id_fijo) {
        this.id_fijo = id_fijo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistoricoFijos{" + "id_historico=" + id_historico + ", id_fijo=" + id_fijo + ", valor=" + valor + ", fecha=" + fecha + '}';
    }

    
    


     
}
