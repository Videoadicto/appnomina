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
    private int id;
    private int eps;
    private int transporte;
    
    public Fijos(){
        super();
    }
    
    public Fijos(int id, int eps, int transporte) {
        this.id = id;
        this.eps = eps;
        this.transporte = transporte;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Fijos{" + "id=" + id + ", eps=" + eps + ", transporte=" + transporte + '}';
    }


}
