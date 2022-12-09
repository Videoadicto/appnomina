/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.NominaMensualDao;
import appnomina.capadatos.entidades.DatosMensual;
import appnomina.capadatos.entidades.NominaMensual;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaEmpleado;
import appnomina.capadatos.entidades.Semanal;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaMensualNegocio {
    
    private NominaMensualDao nominaMensualDao;

    public NominaMensualNegocio() {
        nominaMensualDao = new NominaMensualDao();
    }
            
    public String insertarNominaMensual(NominaMensual p, String nuevo){
        String rta="";
        try {
            NominaMensual pe = nominaMensualDao.buscarNominaMensual(p.getId_nomina_mensual());
            if (pe==null || nuevo.equals("0")){
                boolean res = nominaMensualDao.insertarNominaMensual(p, nuevo);
                if (res) rta = "Nomina Mensual guardada con exito";
                else rta = "Error: No se pudo guardar la nomina mensual";
            } else rta = "Error: La nomina mensual ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar la nomina mensual";
            e.printStackTrace();
        }
        return rta;
    }
    
    public NominaMensual buscarNominaMensual(String id_mensual){
        NominaMensual p = new NominaMensual();
        try {
            p = nominaMensualDao.buscarNominaMensual(id_mensual);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    
    public int buscarIdNominaMensual(String id_semanal, Date fecha){
        int id_nomina =  0;
        try {
            id_nomina = nominaMensualDao.buscarIdNominaMensual(id_semanal, fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_nomina;
    }
    
    public List<NominaMensual> buscarNominasMensuales(){
        List<NominaMensual>  nominasMensuales;
        try {
            nominasMensuales = nominaMensualDao.buscarNominasMensuales();
        } catch (Exception e) {
            e.printStackTrace();
            nominasMensuales= null;
        }
        return nominasMensuales;
    }
    
    public List<Semanal> buscarNominasMensualesFechas(String fechai, String fechaf){
        List<Semanal> nominasMensuales;
        try {
            nominasMensuales = nominaMensualDao.buscarNominasMensualesFechas(fechai, fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            nominasMensuales= null;
        }
        return nominasMensuales;
    }
    
    
    public List<DatosMensual> buscarNominasMensualesTotalesFechas(String fechai, String fechaf){
        List<DatosMensual> nominasMensuales;
        try {
            nominasMensuales = nominaMensualDao.buscarNominasMensualesTotalesFechas(fechai, fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            nominasMensuales= null;
        }
        return nominasMensuales;
    }
    
    
    
    
    
    
    public List<Integer>  buscarNominaMensualEmpleado(int id_empleado, int pago, String fechai, String fechaf) {
        List<Integer>  totales;
        try {
            totales = nominaMensualDao.buscarNominaMensualEmpleado( id_empleado, pago, fechai,  fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            totales= null;
        }
        return totales;
    }
    
    
    
        public List<Integer>  calcularNominaMensualEmpleado(int id_empleado, int tipo, String fechai, String fechaf) {
        List<Integer>  totales;
        try {
            totales = nominaMensualDao.calcularNominaMensualEmpleado( id_empleado, tipo, fechai,  fechaf);
        } catch (Exception e) {
            e.printStackTrace();
            totales= null;
        }
        return totales;
    }
    
    
    
    
    
    
    public String eliminarNominaMensual(int id_mensual){
        String rta="";
        try {
                boolean res = nominaMensualDao.eliminarNominaMensual(id_mensual);
                if (res) rta = "Nomina mensual eliminada con exito." ;
                else rta = "Error al eliminar la nomina mensual";
        } catch (Exception e) {
            rta="Error al eliminar la nomina mensual";
            e.printStackTrace();
        }
        return rta;
    }
    
    
    
    
    
}
