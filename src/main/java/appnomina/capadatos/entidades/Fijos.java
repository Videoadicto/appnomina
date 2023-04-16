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
public class Fijos implements Serializable{
    private int id_fijo;
    private String nombre;
    private int valor;
    
    public Fijos(){
        super();
    }
    
    public Fijos(int id_fijo, String nombre, int valor) {
        this.id_fijo = id_fijo;
        this.nombre = nombre;
        this.valor = valor;
    } 

    public int getId_fijo() {
        return id_fijo;
    }

    public void setId_fijo(int id_fijo) {
        this.id_fijo = id_fijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Fijos{" + "id_fijo=" + id_fijo + ", nombre=" + nombre + ", valor=" + valor + '}';
    }

   

    

}
