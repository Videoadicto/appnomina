/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CargoDao {
    
    public boolean insertarCargo(Cargo cargo , String nuevo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.insertarCargo()");
        
        String sql="";
        
        if (nuevo.equals("0")){
        sql = "REPLACE INTO cargo VALUES (?,?,?)";}
        else{
        sql = "INSERT INTO cargo VALUES (?,?,?)";}
        
        //String sql = "INSERT INTO cargo VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, cargo.getId_cargo());
        ps.setString(2, cargo.getNombre());
        ps.setInt(3, cargo.getPago());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public Cargo buscarCargo(int id_cargo)throws Exception{
        Cargo p = new Cargo();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("CargoDao.buscarCargo()");
                
       
        String sql = "SELECT * FROM cargo WHERE id_cargo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_cargo);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_cargo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setPago(rst.getInt(3));
        } else p=null;
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    public List<Cargo> buscarCargos()throws Exception{
        List<Cargo> cargos = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.buscarCargos()");
        String sql = "SELECT * FROM cargo ";
        PreparedStatement ps = conexion.prepareStatement(sql);
                
        ResultSet rst = ps.executeQuery();
        while (rst.next()){
            Cargo p = new Cargo();
            p.setId_cargo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setPago(rst.getInt(3));

            cargos.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return cargos;
    }
    
    public boolean eliminarCargo(int id_cargo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.eliminarCargo()");
        
        String sql= "DELETE FROM cargo WHERE id_cargo = ?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_cargo);
        
        
        ps.executeUpdate();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
}