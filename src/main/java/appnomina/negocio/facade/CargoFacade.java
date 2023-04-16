/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.Cargo;
import appnomina.negocio.nomina.CargoNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CargoFacade {
    private CargoNegocio cargoNegocio;

    public CargoFacade() {
        cargoNegocio = new CargoNegocio();
    }
    
    public String insertarCargo(Cargo p, String nuevo){
        return cargoNegocio.insertarCargo(p, nuevo);
    }  
    
    public Cargo buscarCargo(int id_cargo){
        return cargoNegocio.buscarCargo(id_cargo);
    }
    
    public List<Cargo> buscarCargos(){
        return cargoNegocio.buscarCargos();
    }
        
    public String eliminarCargo(int id_cargo){
        return cargoNegocio.eliminarCargo(id_cargo);
    }  
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
    
    
}
