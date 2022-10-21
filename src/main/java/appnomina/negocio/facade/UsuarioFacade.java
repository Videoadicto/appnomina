/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.facade;

import appnomina.capadatos.entidades.Usuario;
import appnomina.negocio.nomina.UsuarioNegocio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioFacade {
    private UsuarioNegocio usuarioNegocio;

    public UsuarioFacade() {
        usuarioNegocio = new UsuarioNegocio();
    }
    
    public Usuario buscarUsuario(String usuario){
        return usuarioNegocio.buscarUsuario(usuario);
    }
   
      public String validarUsuario(String usuario, String password){
        return usuarioNegocio.validarUsuario(usuario, password);  
      }
}
