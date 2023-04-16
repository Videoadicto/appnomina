/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appnomina.capadatos.entidades;

import java.io.Serializable;

/**
 *
 * @author videoadicto
 */
public class NominaEmpleado implements Serializable{
    private int id_nomina_empleado;
    private int id_nomina;
    private int id_empleado;
    private int id_concepto;
    private int valor;

    
    public NominaEmpleado(){
        super();
    }
    
    public NominaEmpleado(int id_nomina_empleado, int id_nomina, int id_empleado, int id_concepto, int valor) {
        this.id_nomina = id_nomina;
        this.id_empleado = id_empleado;
        this.id_concepto = id_concepto;
        this.valor = valor;
    } 

    public int getId_nomina_empleado() {
        return id_nomina_empleado;
    }

    public void setId_nomina_empleado(int id_nomina_empleado) {
        this.id_nomina_empleado = id_nomina_empleado;
    }

    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "NominaEmpleado{" + "id_nomina_empleado=" + id_nomina_empleado + ", id_nomina=" + id_nomina + ", id_empleado=" + id_empleado + ", id_concepto=" + id_concepto + ", valor=" + valor + '}';
    }

   

   
  
    
    
    
}
