/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import static java.lang.Integer.parseInt;
import appnomina.capadatos.entidades.Producto;
import appnomina.capadatos.entidades.Categoria;
import appnomina.negocio.nomina.ProductoNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoFacade {
    private ProductoNegocio productoNegocio;

    public ProductoFacade() {
        productoNegocio = new ProductoNegocio();
    }
    
    public String insertarProducto(Producto p, String nuevo){
        return productoNegocio.insertarProducto(p, nuevo);
    }  
    
    public Producto buscarProducto(String idProducto){
        return productoNegocio.buscarProducto(idProducto);
    }
    
    public List<Producto> buscarProductos(){
        return productoNegocio.buscarProductos();
    }
        
    public String eliminarProducto(String idProducto){
        return productoNegocio.eliminarProducto(idProducto);
    }  
    
   public int convertirNumero(String valor) {

    int numero = parseInt(valor);

    return numero;
}
   
       public List<Categoria> getCategoria(){
        return productoNegocio.getCategoria();  
    }
    
}
