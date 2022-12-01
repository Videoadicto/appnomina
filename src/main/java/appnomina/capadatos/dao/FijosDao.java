/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Fijos;
import appnomina.capadatos.entidades.HistoricoFijos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FijosDao {
    
    private HistoricoFijosDao hfd;
    
    public FijosDao() {
        hfd = new HistoricoFijosDao();
    }
    
    public boolean insertarFijosX(Fijos fijos , String nuevo)throws Exception{
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
        
        ps.setInt(1, fijos.getId_fijo());
        ps.setString(2, fijos.getNombre());
        ps.setInt(3, fijos.getValor());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    
    
    
    public boolean insertarFijos(Fijos fijos, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("FijosDao.insertarFijos()");

        String sql = "";

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String fecha = date.format(formatter);
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechax = sdf.parse(localDate.toString());
        java.sql.Date fechah = new java.sql.Date(fechax.getTime());
        
        if (nuevo.equals("0")) {
            sql = "REPLACE INTO fijos VALUES (?,?,?)";
        } else {
            sql = "INSERT INTO fijos VALUES (?,?,?)";
        }

        //String sql = "INSERT INTO empleado VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, fijos.getId_fijo());
        ps.setString(2, fijos.getNombre());
        ps.setInt(3, fijos.getValor());
        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        
        int X=0;
         if (nuevo.equals("0")) {
             X = fijos.getId_fijo();
        }
        
        
        HistoricoFijos hf = new HistoricoFijos(0, X, fijos.getValor(), fechah);
        Boolean mensaje = hfd.insertarHistoricoFijos(hf);
        //System.out.println(mensaje);
        
        return rta;
    }
    
    
    /*
    public Fijos buscarFijosX()throws Exception{
        Fijos p = new Fijos();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("FijosDao.buscarFijos()");
       
        String sql = "SELECT * FROM fijos LIMIT 1";
        Statement ps = conexion.createStatement();
        
        ResultSet rst = ps.executeQuery(sql);
        
        if (rst.next()){
            p.setId_fijo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setValor(rst.getInt(3));
        } else p=null;

        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    */
    
    public List<Fijos> buscarFijos()throws Exception{
        List<Fijos> fijos = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("FijosDao.buscarFijos()");
        String sql = "SELECT * FROM fijos ";
        PreparedStatement ps = conexion.prepareStatement(sql);
                
        ResultSet rst = ps.executeQuery();
        while (rst.next()){
            Fijos p = new Fijos();
            p.setId_fijo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setValor(rst.getInt(3));

            fijos.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return fijos;
    }
    
    
    public Fijos buscarFijo(int id_fijo) throws Exception {
        Fijos p = new Fijos();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("FijosDao.buscarFijo()");

        String sql = "SELECT * FROM fijos WHERE id_fijo = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_fijo);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_fijo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setValor(rst.getInt(3));
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
}