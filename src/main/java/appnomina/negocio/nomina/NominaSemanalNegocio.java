/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.NominaSemanalDao;
import appnomina.capadatos.entidades.NominaSemanal;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaEmpleado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaSemanalNegocio {
    
    private NominaSemanalDao nominaSemanalDao;

    public NominaSemanalNegocio() {
        nominaSemanalDao = new NominaSemanalDao();
    }
            
    public String insertarNominaSemanal(NominaSemanal p, String nuevo){
        String rta="";
        try {
            NominaSemanal pe = nominaSemanalDao.buscarNominaSemanal(p.getId_nomina_semanal());
            if (pe==null || nuevo.equals("0")){
                boolean res = nominaSemanalDao.insertarNominaSemanal(p, nuevo);
                if (res) rta = "Nomina Semanal guardada con exito";
                else rta = "Error: No se pudo guardar la nomina semanal";
            } else rta = "Error: La nomina semanal ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar la nomina semanal";
            e.printStackTrace();
        }
        return rta;
    }
    
    public NominaSemanal buscarNominaSemanal(String id_semanal){
        NominaSemanal p = new NominaSemanal();
        try {
            p = nominaSemanalDao.buscarNominaSemanal(id_semanal);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<NominaSemanal> buscarNominasSemanales(){
        List<NominaSemanal>  nominasSemanales;
        try {
            nominasSemanales = nominaSemanalDao.buscarNominasSemanales();
        } catch (Exception e) {
            e.printStackTrace();
            nominasSemanales= null;
        }
        return nominasSemanales;
    }
    
    public List<NominaSemanal> buscarNominasSemanalesFechas(String fechai, String fechaf){
        List<NominaSemanal> nominasSemanales;
        try {
            nominasSemanales = nominaSemanalDao.buscarNominasSemanalesFechas(fechai, fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            nominasSemanales= null;
        }
        return nominasSemanales;
    }
    
    
    
    
    
    
    public List<Integer>  buscarNominaSemanalEmpleado(int id_empleado, int pago, String fechai, String fechaf) {
        List<Integer>  totales;
        try {
            totales = nominaSemanalDao.buscarNominaSemanalEmpleado( id_empleado, pago, fechai,  fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            totales= null;
        }
        return totales;
    }
    
    
    
        public List<Integer>  calcularNominaSemanalEmpleado(int id_empleado, int tipo, String fechai, String fechaf) {
        List<Integer>  totales;
        try {
            totales = nominaSemanalDao.calcularNominaSemanalEmpleado( id_empleado, tipo, fechai,  fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            totales= null;
        }
        return totales;
    }
    
    
    
    
    
    
    public String eliminarNominaSemanal(int id_semanal){
        String rta="";
        try {
                boolean res = nominaSemanalDao.eliminarNominaSemanal(id_semanal);
                if (res) rta = "Nomina semanal eliminada con exito." ;
                else rta = "Error al eliminar la nomina semanal";
        } catch (Exception e) {
            rta="Error al eliminar la nomina semanal";
            e.printStackTrace();
        }
        return rta;
    }
    
    
    
    
    
}
