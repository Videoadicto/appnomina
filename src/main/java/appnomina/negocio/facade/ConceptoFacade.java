/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.Concepto;
import appnomina.negocio.nomina.ConceptoNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConceptoFacade {
    private ConceptoNegocio conceptoNegocio;

    public ConceptoFacade() {
        conceptoNegocio = new ConceptoNegocio();
    }
    
    public String insertarConcepto(Concepto p, String nuevo){
        return conceptoNegocio.insertarConcepto(p, nuevo);
    }  
    
    public Concepto buscarConcepto(int id_concepto){
        return conceptoNegocio.buscarConcepto(id_concepto);
    }
    
    public List<Concepto> buscarConceptos(){
        return conceptoNegocio.buscarConceptos();
    }
        
    public String eliminarConcepto(int id_concepto){
        return conceptoNegocio.eliminarConcepto(id_concepto);
    }  
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
    
    
}
