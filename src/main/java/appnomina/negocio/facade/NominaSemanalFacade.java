/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.NominaSemanal;
import appnomina.negocio.nomina.ProduccionNegocio;
import appnomina.negocio.nomina.NominaSemanalNegocio;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaEmpleado;
import static java.lang.Integer.parseInt;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NominaSemanalFacade {

    private NominaSemanalNegocio nominaSemanalNegocio;

    public NominaSemanalFacade() {
        nominaSemanalNegocio = new NominaSemanalNegocio();
    }

    public String insertarNominaSemanal(NominaSemanal p, String nuevo) {
        return nominaSemanalNegocio.insertarNominaSemanal(p, nuevo);
    }

    public NominaSemanal buscarNominaSemanal(String id_semanal) {
        return nominaSemanalNegocio.buscarNominaSemanal(id_semanal);
    }

    public List<NominaSemanal> buscarNominasSemanales() {
        return nominaSemanalNegocio.buscarNominasSemanales();
    }
    
    public List<NominaSemanal> buscarNominasSemanalesFechas(String fechai, String fechaf) {
        return nominaSemanalNegocio.buscarNominasSemanalesFechas(fechai, fechaf);
    }
    
    
    public List<Integer> buscarNominaSemanalEmpleado(int id_empleado, int pago, String fechai, String fechaf) {
        return nominaSemanalNegocio.buscarNominaSemanalEmpleado( id_empleado,  pago,  fechai,  fechaf);
    }
    
    
    
    public List<Integer> calcularNominaSemanalEmpleado(int id_empleado, int tipo, String fechai, String fechaf) {
        return nominaSemanalNegocio.calcularNominaSemanalEmpleado( id_empleado, tipo, fechai,  fechaf);
    }
    

    public String eliminarNominaSemanal(int id_semanal) {
        return nominaSemanalNegocio.eliminarNominaSemanal(id_semanal);
    }
/*
    public List<Produccion> getProduccion() {
        return NominaSemanalNegocio.getProduccion();
    }
*/
    
       public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}

}
