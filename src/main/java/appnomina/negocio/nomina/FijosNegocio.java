/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.FijosDao;
import appnomina.capadatos.entidades.Fijos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FijosNegocio {
    
    private FijosDao fijosDao;

    public FijosNegocio() {
        fijosDao = new FijosDao();
    }
            
     public String insertarFijos(Fijos p, String nuevo){
        String rta="";
        try {
            Fijos pe = fijosDao.buscarFijo(p.getId_fijo());
            if (pe==null || nuevo.equals("0")){
                boolean res = fijosDao.insertarFijos(p, nuevo);
                if (res) rta = "Fijo guardado con exito";
                else rta = "Error: No se pudo guardar el Fijo";
            } else rta = "Error: El fijo ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar el fijo";
            e.printStackTrace();
        }
        return rta;
    }
    
    public List<Fijos> buscarFijos(){
        List<Fijos> p;
        try {
            p = fijosDao.buscarFijos();
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    
    public Fijos buscarFijo(int id_fijo){
        Fijos p = new Fijos();
        try {
            p = fijosDao.buscarFijo(id_fijo);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
}
