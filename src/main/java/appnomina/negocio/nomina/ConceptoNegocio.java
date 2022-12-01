/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.ConceptoDao;
import appnomina.capadatos.entidades.Concepto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConceptoNegocio {
    
    private ConceptoDao conceptoDao;

    public ConceptoNegocio() {
        conceptoDao = new ConceptoDao();
    }
            
    public String insertarConcepto(Concepto p, String nuevo){
        String rta="";
        try {
            Concepto pe = conceptoDao.buscarConcepto(p.getId_concepto());
            if (pe==null || nuevo.equals("0")){
                boolean res = conceptoDao.insertarConcepto(p, nuevo);
                if (res) rta = "Concepto guardado con exito";
                else rta = "Error: No se pudo guardar el concepto";
            } else rta = "Error: El concepto ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar el concepto";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Concepto buscarConcepto(int id_concepto){
        Concepto p = new Concepto();
        try {
            p = conceptoDao.buscarConcepto(id_concepto);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<Concepto> buscarConceptos(){
        List<Concepto> conceptos;
        try {
            conceptos = conceptoDao.buscarConceptos();
        } catch (Exception e) {
            e.printStackTrace();
            conceptos= null;
        }
        return conceptos;
    }
    
    public String eliminarConcepto(int id_concepto){
        String rta="";
        try {
                boolean res = conceptoDao.eliminarConcepto(id_concepto);
                if (res) rta = "Concepto eliminado con exito." ;
                else rta = "Error al eliminar el concepto";
        } catch (Exception e) {
            rta="Error al eliminar el concepto";
            e.printStackTrace();
        }
        return rta;
    }
}
