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
public class NominaMensual implements Serializable{
    private int id_nomina;
    private String id_nomina_mensual;
    private Date fecha;
     
    public NominaMensual(){
        super();
    }
    
    public NominaMensual(int id_nomina, String id_nomina_mensual, Date fecha) {
        this.id_nomina_mensual = id_nomina_mensual;
        this.fecha = fecha;
    }

    public String getId_nomina_mensual() {
        return id_nomina_mensual;
    }

    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }

    

    public void setId_nomina_mensual(String id_nomina_mensual) {
        this.id_nomina_mensual = id_nomina_mensual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "NominaMensual{" + "id_nomina=" + id_nomina + ", id_nomina_mensual=" + id_nomina_mensual + ", fecha=" + fecha + '}';
    }

    
    
    
}
