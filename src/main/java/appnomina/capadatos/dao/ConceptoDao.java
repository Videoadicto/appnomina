/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Concepto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConceptoDao {
    
    public boolean insertarConcepto(Concepto concepto , String nuevo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("ConceptoDao.insertarConcepto()");
        
        String sql="";
        
        if (nuevo.equals("0")){
        sql = "REPLACE INTO concepto VALUES (?,?)";}
        else{
        sql = "INSERT INTO concepto VALUES (?,?)";}
        
        //String sql = "INSERT INTO concepto VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, concepto.getId_concepto());
        ps.setString(2, concepto.getNombre());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public Concepto buscarConcepto(int id_concepto)throws Exception{
        Concepto p = new Concepto();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("ConceptoDao.buscarConcepto()");
                
       
        String sql = "SELECT * FROM concepto WHERE id_concepto = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_concepto);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_concepto(rst.getInt(1));
            p.setNombre(rst.getString(2));
        } else p=null;
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    public List<Concepto> buscarConceptos()throws Exception{
        List<Concepto> conceptos = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("ConceptoDao.buscarConceptos()");
        String sql = "SELECT * FROM concepto ";
        PreparedStatement ps = conexion.prepareStatement(sql);
                
        ResultSet rst = ps.executeQuery();
        while (rst.next()){
            Concepto p = new Concepto();
            p.setId_concepto(rst.getInt(1));
            p.setNombre(rst.getString(2));

            conceptos.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return conceptos;
    }
    
    public boolean eliminarConcepto(int id_concepto)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("ConceptoDao.eliminarConcepto()");
        
        String sql= "DELETE FROM concepto WHERE id_concepto = ?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_concepto);
        
        
        ps.executeUpdate();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
}