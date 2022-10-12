/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.EmpleadoDao;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.Cargo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmpleadoNegocio {
    
    private EmpleadoDao empleadoDao;

    public EmpleadoNegocio() {
        empleadoDao = new EmpleadoDao();
    }
            
    public String insertarEmpleado(Empleado p, String nuevo){
        String rta="";
        try {
            Empleado pe = empleadoDao.buscarEmpleado(p.getId_empleado());
            if (pe==null || nuevo.equals("0")){
                boolean res = empleadoDao.insertarEmpleado(p, nuevo);
                if (res) rta = "Empleado guardado con exito";
                else rta = "Error: No se pudo guardar el empleado";
            } else rta = "Error: El empleado ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar el empleado";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Empleado buscarEmpleado(int id_empleado){
        Empleado p = new Empleado();
        try {
            p = empleadoDao.buscarEmpleado(id_empleado);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<Empleado> buscarEmpleados(){
        List<Empleado> empleados;
        try {
            empleados = empleadoDao.buscarEmpleados();
        } catch (Exception e) {
            e.printStackTrace();
            empleados= null;
        }
        return empleados;
    }
    
    public String eliminarEmpleado(int id_empleado){
        String rta="";
        try {
                boolean res = empleadoDao.eliminarEmpleado(id_empleado);
                if (res) rta = "Empleado eliminado con exito." ;
                else rta = "Error al eliminar el empleado";
        } catch (Exception e) {
            rta="Error al eliminar el empleado";
            e.printStackTrace();
        }
        return rta;
    }
    
    public List<Cargo> getCargo(){
        List<Cargo> categorias = new ArrayList<Cargo>();
        try {
            categorias = empleadoDao.getCargo();
        } catch (Exception e) {
            categorias=null;
            e.printStackTrace();
        }
        return categorias;
    }
    
    
    
}
