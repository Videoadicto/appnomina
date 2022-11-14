/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.FijosDao;
import appnomina.capadatos.entidades.Fijos;
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
            Fijos pe = fijosDao.buscarFijos();
            if (pe==null || nuevo.equals("0")){
                boolean res = fijosDao.insertarFijos(p, nuevo);
                if (res) rta = "Los Bonos/Descuentos se han modificado con exito";
                else rta = "Error: No se pudieron guardar los Bonos/Descuentos";
            } else rta = "Error: Los Bonos/Descuentos ya existen";
        } catch (Exception e) {
            rta="Error: No se pudieron guardar los Bonos/Descuentos";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Fijos buscarFijos(){
        Fijos p = new Fijos();
        try {
            p = fijosDao.buscarFijos();
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
}
