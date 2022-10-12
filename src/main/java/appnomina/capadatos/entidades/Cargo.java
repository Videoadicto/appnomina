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
public class Cargo implements Serializable{
    private int id_cargo;
    private String nombre;
    private int pago;

    
    public Cargo(){
        super();
    }
    
    public Cargo(int id_cargo, String nombre, int pago) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
        this.pago = pago;
    } 

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Cargo{" + "id_cargo=" + id_cargo + ", nombre=" + nombre + ", pago=" + pago + '}';
    }
    
    
    
}
