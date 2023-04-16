/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.NominaEmpleadoDao;
import appnomina.capadatos.entidades.NominaEmpleado;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaEmpleadoNegocio {
    
    private NominaEmpleadoDao nominaempleadoDao;

    public NominaEmpleadoNegocio() {
        nominaempleadoDao = new NominaEmpleadoDao();
    }
            
    public String insertarNominaEmpleado(NominaEmpleado p, String nuevo){
        String rta="";
        try {
            NominaEmpleado pe = nominaempleadoDao.buscarNominaEmpleado(p.getId_nomina_empleado());
            if (pe==null || nuevo.equals("0")){
                boolean res = nominaempleadoDao.insertarNominaEmpleado(p, nuevo);
                if (res) rta = "La nomina se ha guardado con exito";
                else rta = "Error: No se pudo guardar la nomina";
            } else rta = "Error: La nomina ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar la nomina";
            e.printStackTrace();
        }
        return rta;
    }
    
    public NominaEmpleado buscarNominaEmpleado(int id_nomina_empleado){
        NominaEmpleado p = new NominaEmpleado();
        try {
            p = nominaempleadoDao.buscarNominaEmpleado(id_nomina_empleado);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<NominaEmpleado> buscarNominaEmpleados(){
        List<NominaEmpleado> nominaempleados;
        try {
            nominaempleados = nominaempleadoDao.buscarNominaEmpleados();
        } catch (Exception e) {
            e.printStackTrace();
            nominaempleados= null;
        }
        return nominaempleados;
    }
    
    public List<NominaEmpleado> buscarNominasEmpleados(String id_nomina){
        List<NominaEmpleado> nominaempleados;
        try {
            nominaempleados = nominaempleadoDao.buscarNominasEmpleados(id_nomina);
        } catch (Exception e) {
            e.printStackTrace();
            nominaempleados= null;
        }
        return nominaempleados;
    }
    
    public String eliminarNominaEmpleado(int id_nominaempleado){
        String rta="";
        try {
                boolean res = nominaempleadoDao.eliminarNominaEmpleado(id_nominaempleado);
                if (res) rta = "NominaEmpleado eliminado con exito." ;
                else rta = "Error al eliminar el nominaempleado";
        } catch (Exception e) {
            rta="Error al eliminar el nominaempleado";
            e.printStackTrace();
        }
        return rta;
    }
}
