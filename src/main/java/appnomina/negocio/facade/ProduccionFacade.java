/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import appnomina.capadatos.entidades.Produccion;
import appnomina.negocio.nomina.ProduccionNegocio;
import appnomina.capadatos.entidades.Empleado;
import static java.lang.Integer.parseInt;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProduccionFacade {

    private ProduccionNegocio produccionNegocio;

    public ProduccionFacade() {
        produccionNegocio = new ProduccionNegocio();
    }

    public String insertarProduccion(Produccion p, String nuevo) {
        return produccionNegocio.insertarProduccion(p, nuevo);
    }

    public Produccion buscarProduccion(int id_produccion) {
        return produccionNegocio.buscarProduccion(id_produccion);
    }

    public List<Produccion> buscarProducciones() {
        return produccionNegocio.buscarProducciones();
    }
    
    public List<Produccion> buscarProduccionesFechas(String fechai, String fechaf) {
        return produccionNegocio.buscarProduccionesFechas(fechai, fechaf);
    }

    public String eliminarProduccion(int id_produccion) {
        return produccionNegocio.eliminarProduccion(id_produccion);
    }

    public List<Empleado> getEmpleado() {
        return produccionNegocio.getEmpleado();
    }
    
       public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}

}
