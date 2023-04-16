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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HistoricoFijosDao {
    
    public boolean insertarHistoricoFijos(HistoricoFijos historico)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("HistoricoFijosDao.insertarHistoricoFijos()");
        
        String sql="";
        
        //System.out.println("xxx: "+historico.getId_historico() + " " + historico.getId_fijos() +  " " + historico.getId_historico()   + " "  + historico.getFecha());
        
        sql = "INSERT INTO historico_fijos VALUES (?,?,?,?)";
        
        //String sql = "INSERT INTO fijos VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, historico.getId_historico());
        ps.setInt(2, historico.getId_fijo());
        ps.setInt(3, historico.getValor());
        ps.setDate(4, historico.getFecha());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public HistoricoFijos buscarFijos(int id_historico)throws Exception{
        HistoricoFijos p = new HistoricoFijos();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("FijosDao.buscarFijos()");
                
       
        String sql = "SELECT * FROM historico_fijos WHERE id_historico = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_historico);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_historico(rst.getInt(1));
            p.setId_fijo(rst.getInt(2));
            p.setValor(rst.getInt(3));
            p.setFecha(rst.getDate(4));
        } else p=null;
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    public List<HistoricoFijos> buscarFijoss()throws Exception{
        List<HistoricoFijos> historicoFijos = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("FijosDao.buscarFijoss()");
        String sql = "SELECT * FROM historico_fijos ";
        PreparedStatement ps = conexion.prepareStatement(sql);
                
        ResultSet rst = ps.executeQuery();
        while (rst.next()){
            HistoricoFijos p = new HistoricoFijos();
            p.setId_historico(rst.getInt(1));
            p.setId_fijo(rst.getInt(2));
            p.setValor(rst.getInt(3));
            p.setFecha(rst.getDate(4));

            historicoFijos.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return historicoFijos;
    }
    
    public boolean eliminarFijos(int id_historico)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("FijosDao.eliminarFijos()");
        
        String sql= "DELETE FROM historico_fijos WHERE id_historico = ?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_historico);
        
        
        ps.executeUpdate();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    

    public HistoricoFijos buscarHistoricoFijosFechas(int id_fijo, String fechai, String fechaf) throws Exception {
        //List<HistoricoFijos> historico = new ArrayList<>();

        
        Conexion con = new Conexion();
        Connection conexion = con.conectar("HistoricoFijosDao.buscarHistoricoFijosFechas()");
        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());

        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        
        //String sql = "SELECT * FROM produccion ";
        //String sql = "SELECT id_historico_empleado, id_fijos, id_historico, fecha FROM historico_empleado WHERE id_fijos=" + id_fijos  + "and he.fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT * FROM historico_fijos WHERE id_fijo=" + id_fijo  + " and fecha<=" + "'" + fechaf + "'" + " ORDER BY fecha DESC LIMIT 1";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);

        //while (rst.next()) {
            rst.next();
            
                HistoricoFijos p = new HistoricoFijos();

            p.setId_historico(rst.getInt(1));
            p.setId_fijo(rst.getInt(2));
            p.setValor(rst.getInt(3));
            p.setFecha(rst.getDate(4));

            //historico.add(p);
        //}

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        //return historico;
        
        //System.out.println("id_historico: " + p.getId_historico() + " fijos_id: " + p.getId_fijos() + " pago: " + p.getPago() );
        
        return p;
    }
}
    

    
