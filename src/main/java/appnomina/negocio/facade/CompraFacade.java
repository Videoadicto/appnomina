/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.Compra;
import appnomina.capadatos.entidades.Proveedor;
import appnomina.negocio.nomina.CompraNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CompraFacade {
    private CompraNegocio compraNegocio;

    public CompraFacade() {
        compraNegocio = new CompraNegocio();
    }
    
    public String insertarCompra(Compra p, String nuevo){
        return compraNegocio.insertarCompra(p, nuevo);
    }  
    
    public Compra buscarCompra(String idCompra){
        return compraNegocio.buscarCompra(idCompra);
    }
    
    public List<Compra> buscarCompras(){
        return compraNegocio.buscarCompras();
    }
        
    public String eliminarCompra(String idCompra){
        return compraNegocio.eliminarCompra(idCompra);
    }  
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
   
       public List<Proveedor> getProveedor(){
        return compraNegocio.getProveedor();  
    }
    
}
