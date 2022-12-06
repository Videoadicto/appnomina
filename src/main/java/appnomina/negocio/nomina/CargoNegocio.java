/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.CargoDao;
import appnomina.capadatos.entidades.Cargo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CargoNegocio {
    
    private CargoDao cargoDao;

    public CargoNegocio() {
        cargoDao = new CargoDao();
    }
            
    public String insertarCargo(Cargo p, String nuevo){
        String rta="";
        try {
            Cargo pe = cargoDao.buscarCargoNombre(p.getNombre());
            if (pe==null || nuevo.equals("0")){
                boolean res = cargoDao.insertarCargo(p, nuevo);
                if (res) rta = "Cargo guardado con exito";
                else rta = "Error: No se pudo guardar el cargo";
            } else rta = "Error: El cargo ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar el cargo";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Cargo buscarCargo(int id_cargo){
        Cargo p = new Cargo();
        try {
            p = cargoDao.buscarCargo(id_cargo);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<Cargo> buscarCargos(){
        List<Cargo> cargos;
        try {
            cargos = cargoDao.buscarCargos();
        } catch (Exception e) {
            e.printStackTrace();
            cargos= null;
        }
        return cargos;
    }
    
    public String eliminarCargo(int id_cargo){
        String rta="";
        try {
                boolean res = cargoDao.eliminarCargo(id_cargo);
                if (res) rta = "Cargo eliminado con exito." ;
                else rta = "Error al eliminar el cargo";
        } catch (Exception e) {
            rta="Error al eliminar el cargo";
            e.printStackTrace();
        }
        return rta;
    }
}
