/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioDao {

    public boolean insertarUsuario(Usuario usuario, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDao.insertarUsuario()");

        String sql = "";

        if (nuevo.equals("0")) {
            sql = "REPLACE INTO usuario VALUES (?,?,?,?)";
        } else {
            sql = "INSERT INTO usuario VALUES (?,?,?,?)";
        }

        //String sql = "INSERT INTO usuario VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuario.getNick());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getPassword());
        ps.setInt(4, 0);

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public Usuario buscarUsuario(String usuario) throws Exception {
        Usuario p = new Usuario();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("UsuarioDao.buscarUsuario()");

        String sql = "SELECT * FROM usuario WHERE nick = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuario);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setNick(rst.getString(1));
            p.setNombre(rst.getString(2));
            p.setPassword(rst.getString(3));
            p.setTipo(rst.getInt(4));
           

        } else {
            p = null;
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return p;
    }

    public List<Usuario> buscarUsuarios() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDao.buscarUsuarios()");
        String sql = "SELECT * FROM usuario ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Usuario p = new Usuario();
            p.setNick(rst.getString(1));
            p.setNombre(rst.getString(2));
            p.setPassword(rst.getString(3));
            p.setTipo(rst.getInt(4));

            usuarios.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return usuarios;
    }

    public boolean eliminarUsuario(int id_usuario) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("UsuarioDao.eliminarUsuario()");

        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_usuario);

        ps.executeUpdate();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }
}
