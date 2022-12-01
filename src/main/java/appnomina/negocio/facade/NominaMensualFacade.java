/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.NominaMensual;
import appnomina.negocio.nomina.ProduccionNegocio;
import appnomina.negocio.nomina.NominaMensualNegocio;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaEmpleado;
import static java.lang.Integer.parseInt;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaMensualFacade {

    private NominaMensualNegocio nominaMensualNegocio;

    public NominaMensualFacade() {
        nominaMensualNegocio = new NominaMensualNegocio();
    }

    public String insertarNominaMensual(NominaMensual p, String nuevo) {
        return nominaMensualNegocio.insertarNominaMensual(p, nuevo);
    }

    public NominaMensual buscarNominaMensual(String id_mensual) {
        return nominaMensualNegocio.buscarNominaMensual(id_mensual);
    }

    public List<NominaMensual> buscarNominasMensuales() {
        return nominaMensualNegocio.buscarNominasMensuales();
    }
    
    public List<NominaMensual> buscarNominasMensualesFechas(String fechai, String fechaf) {
        return nominaMensualNegocio.buscarNominasMensualesFechas(fechai, fechaf);
    }
    
    
    public List<Integer> buscarNominaMensualEmpleado(int id_empleado, int pago, String fechai, String fechaf) {
        return nominaMensualNegocio.buscarNominaMensualEmpleado( id_empleado,  pago,  fechai,  fechaf);
    }
    
    
    
    public List<Integer> calcularNominaMensualEmpleado(int id_empleado, int tipo, String fechai, String fechaf) {
        return nominaMensualNegocio.calcularNominaMensualEmpleado( id_empleado, tipo, fechai,  fechaf);
    }
    

    public String eliminarNominaMensual(int id_mensual) {
        return nominaMensualNegocio.eliminarNominaMensual(id_mensual);
    }
/*
    public List<Produccion> getProduccion() {
        return NominaMensualNegocio.getProduccion();
    }
*/
    
       public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}

}
