/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import appnomina.capadatos.entidades.Empleado;
import appnomina.negocio.nomina.EmpleadoNegocio;
import appnomina.capadatos.entidades.Cargo;
import static java.lang.Integer.parseInt;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmpleadoFacade {

    private EmpleadoNegocio empleadoNegocio;

    public EmpleadoFacade() {
        empleadoNegocio = new EmpleadoNegocio();
    }

    public String insertarEmpleado(Empleado p, String nuevo) {
        return empleadoNegocio.insertarEmpleado(p, nuevo);
    }

    public Empleado buscarEmpleado(int id_empleado) {
        return empleadoNegocio.buscarEmpleado(id_empleado);
    }

    public List<Empleado> buscarEmpleados() {
        return empleadoNegocio.buscarEmpleados();
    }

    public String eliminarEmpleado(int id_empleado) {
        return empleadoNegocio.eliminarEmpleado(id_empleado);
    }

    public List<Cargo> getCargo() {
        return empleadoNegocio.getCargo();
    }
    
       public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}

}
