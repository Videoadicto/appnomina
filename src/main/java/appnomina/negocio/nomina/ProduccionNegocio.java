/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.ProduccionDao;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProduccionNegocio {
    
    private ProduccionDao produccionDao;

    public ProduccionNegocio() {
        produccionDao = new ProduccionDao();
    }
            
    public String insertarProduccion(Produccion p, String nuevo){
        String rta="";
        try {
            Produccion pe = produccionDao.buscarProduccion(p.getId_produccion());
            if (pe==null || nuevo.equals("0")){
                boolean res = produccionDao.insertarProduccion(p, nuevo);
                if (res) rta = "Produccion guardada con exito";
                else rta = "Error: No se pudo guardar la produccion";
            } else rta = "Error: La produccion ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar la produccion";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Produccion buscarProduccion(int id_produccion){
        Produccion p = new Produccion();
        try {
            p = produccionDao.buscarProduccion(id_produccion);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<Produccion> buscarProducciones(){
        List<Produccion> producciones;
        try {
            producciones = produccionDao.buscarProducciones();
        } catch (Exception e) {
            e.printStackTrace();
            producciones= null;
        }
        return producciones;
    }
    
    public String eliminarProduccion(int id_produccion){
        String rta="";
        try {
                boolean res = produccionDao.eliminarProduccion(id_produccion);
                if (res) rta = "Produccion eliminada con exito." ;
                else rta = "Error al eliminar la produccion";
        } catch (Exception e) {
            rta="Error al eliminar la produccion";
            e.printStackTrace();
        }
        return rta;
    }
    
    public List<Empleado> getEmpleado(){
        List<Empleado> categorias = new ArrayList<Empleado>();
        try {
            categorias = produccionDao.getEmpleado();
        } catch (Exception e) {
            categorias=null;
            e.printStackTrace();
        }
        return categorias;
    }
    
    
    
}
