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
public class DatosMensual implements Serializable{
    private String cargo;
    private Date fecha;
    private int valor;
     
    public DatosMensual(){
        super();
    }
    
    public DatosMensual(String cargo, Date fecha, int valor) {
        this.cargo = cargo;
        this.fecha = fecha;
        this.valor = valor;
        
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    
    
    
}
