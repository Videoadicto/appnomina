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
public class Concepto implements Serializable{
    private int id_concepto;
    private String nombre;

    
    public Concepto(){
        super();
    }
    
    public Concepto(int id_concepto, String nombre, int pago) {
        this.id_concepto = id_concepto;
        this.nombre = nombre;
    } 

    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Override
    public String toString() {
        return "Cargo{" + "id_concepto=" + id_concepto + ", nombre=" + nombre + '}';
    }
    
    
    
}
