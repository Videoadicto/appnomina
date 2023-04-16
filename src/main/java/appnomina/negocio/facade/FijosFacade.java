/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.Fijos;
import appnomina.negocio.nomina.FijosNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FijosFacade {
    private FijosNegocio fijosNegocio;

    public FijosFacade() {
        fijosNegocio = new FijosNegocio();
    }
    
    public String insertarFijos(Fijos p, String nuevo){
        return fijosNegocio.insertarFijos(p, nuevo);
    }  
    
    
    public Fijos buscarFijo(int id_fijo){
        return fijosNegocio.buscarFijo(id_fijo);
    }
    
    public List<Fijos> buscarFijos(){
        return fijosNegocio.buscarFijos();
    }
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
    
    
}
