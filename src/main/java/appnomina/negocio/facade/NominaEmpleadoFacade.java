/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.NominaEmpleado;
import appnomina.negocio.nomina.NominaEmpleadoNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaEmpleadoFacade {
    private NominaEmpleadoNegocio nominaempleadoNegocio;

    public NominaEmpleadoFacade() {
        nominaempleadoNegocio = new NominaEmpleadoNegocio();
    }
    
    public String insertarNominaEmpleado(NominaEmpleado p, String nuevo){
        return nominaempleadoNegocio.insertarNominaEmpleado(p, nuevo);
    }  
    
    public NominaEmpleado buscarNominaEmpleado(int id_nomina_empleado){
        return nominaempleadoNegocio.buscarNominaEmpleado(id_nomina_empleado);
    }
    
    public List<NominaEmpleado> buscarNominaEmpleados(){
        return nominaempleadoNegocio.buscarNominaEmpleados();
    }
    
    public List<NominaEmpleado> buscarNominasEmpleados(String id_nomina){
        return nominaempleadoNegocio.buscarNominasEmpleados(id_nomina);
    }
        
    public String eliminarNominaEmpleado(int id_nominaempleado){
        return nominaempleadoNegocio.eliminarNominaEmpleado(id_nominaempleado);
    }  
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
    
    
}
