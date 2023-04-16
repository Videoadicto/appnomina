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
public class NominaSemanal implements Serializable{
    private int id_nomina;
    private String id_nomina_semanal;
    private Date fecha;
     
    public NominaSemanal(){
        super();
    }
    
    public NominaSemanal(int id_nomina, String id_nomina_semanal, Date fecha) {
        this.id_nomina_semanal = id_nomina_semanal;
        this.fecha = fecha;
    }

    public String getId_nomina_semanal() {
        return id_nomina_semanal;
    }

    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }

    

    public void setId_nomina_semanal(String id_nomina_semanal) {
        this.id_nomina_semanal = id_nomina_semanal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "NominaSemanal{" + "id_nomina=" + id_nomina + ", id_nomina_semanal=" + id_nomina_semanal + ", fecha=" + fecha + '}';
    }

    
    
    
}
