/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.negocio.nomina;

import appnomina.capadatos.dao.UsuarioDao;
import appnomina.capadatos.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioNegocio {
    
    private UsuarioDao usuarioDao;

    public UsuarioNegocio() {
        usuarioDao = new UsuarioDao();
    }
            
    public String insertarUsuario(Usuario p, String nuevo){
        String rta="";
        try {
            Usuario pe = usuarioDao.buscarUsuario(p.getNick());
            if (pe==null || nuevo.equals("0")){
                boolean res = usuarioDao.insertarUsuario(p, nuevo);
                if (res) rta = "Usuario guardado con exito";
                else rta = "Error: No se pudo guardar el usuario";
            } else rta = "Error: El usuario ya existe";
        } catch (Exception e) {
            rta="Error: No se pudo guardar el usuario";
            e.printStackTrace();
        }
        return rta;
    }
    
    public Usuario buscarUsuario(String usuario){
        Usuario p = new Usuario();
        try {
            p = usuarioDao.buscarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
        }
        return p;
    }
    
    public List<Usuario> buscarUsuarios(){
        List<Usuario> usuarios;
        try {
            usuarios = usuarioDao.buscarUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            usuarios= null;
        }
        return usuarios;
    }
    
    public String eliminarUsuario(String nick){
        String rta="";
        try {
                boolean res = usuarioDao.eliminarUsuario(nick);
                if (res) rta = "Usuario eliminado con exito." ;
                else rta = "Error al eliminar el usuario";
        } catch (Exception e) {
            rta="Error al eliminar el usuario";
            e.printStackTrace();
        }
        return rta;
    }
    
    public String validarUsuario(String usuario, String password){
        String rta="Ok";
        
        Usuario p = new Usuario();
        try {
            p = usuarioDao.buscarUsuario(usuario);
            if (!p.getPassword().equals(password)){
                rta="Usuario o contraseña incorrecto";
            }
        } catch (Exception e) {
            e.printStackTrace();
            p= null;
            rta="Usuario o contraseña incorrecto";
        }
        return rta;
    }
    
}
