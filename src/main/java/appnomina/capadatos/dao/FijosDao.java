/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Fijos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FijosDao {
    
    public boolean insertarFijos(Fijos fijos , String nuevo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("FijosDao.insertarFijos()");
        
        String sql="";
        
        if (nuevo.equals("0")){
        sql = "REPLACE INTO fijos VALUES (?,?,?)";}
        else{
        sql = "INSERT INTO fijos VALUES (?,?,?)";}
        
        //String sql = "INSERT INTO fijos VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, fijos.getId());
        ps.setInt(2, fijos.getEps());
        ps.setInt(3, fijos.getTransporte());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public Fijos buscarFijos()throws Exception{
        Fijos p = new Fijos();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("FijosDao.buscarFijos()");
       
        String sql = "SELECT * FROM fijos LIMIT 1";
        Statement ps = conexion.createStatement();
        
        ResultSet rst = ps.executeQuery(sql);
        
        if (rst.next()){
            p.setId(rst.getInt(1));
            p.setEps(rst.getInt(2));
            p.setTransporte(rst.getInt(3));
        } else p=null;

        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
}