/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Cargo;
import appnomina.capadatos.entidades.HistoricoCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HistoricoCargoDao {
    
    public boolean insertarHistoricoCargo(HistoricoCargo historico)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("HistoricoCargoDao.insertarHistoricoCargo()");
        
        String sql="";
        
        //System.out.println("xxx: "+historico.getId_historico() + " " + historico.getId_cargo() +  " " + historico.getId_historico()   + " "  + historico.getFecha());
        
        sql = "INSERT INTO historico_cargo VALUES (?,?,?,?)";
        
        //String sql = "INSERT INTO cargo VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, historico.getId_historico());
        ps.setInt(2, historico.getId_cargo());
        ps.setInt(3, historico.getPago());
        ps.setDate(4, historico.getFecha());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public HistoricoCargo buscarCargo(int id_historico)throws Exception{
        HistoricoCargo p = new HistoricoCargo();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("CargoDao.buscarCargo()");
                
       
        String sql = "SELECT * FROM historico_cargo WHERE id_historico = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_historico);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_historico(rst.getInt(1));
            p.setId_cargo(rst.getInt(2));
            p.setPago(rst.getInt(3));
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
    
    public List<HistoricoCargo> buscarCargos()throws Exception{
        List<HistoricoCargo> historicoCargo = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.buscarCargos()");
        String sql = "SELECT * FROM historico_cargo ";
        PreparedStatement ps = conexion.prepareStatement(sql);
                
        ResultSet rst = ps.executeQuery();
        while (rst.next()){
            HistoricoCargo p = new HistoricoCargo();
            p.setId_historico(rst.getInt(1));
            p.setId_cargo(rst.getInt(2));
            p.setPago(rst.getInt(3));
            p.setFecha(rst.getDate(4));

            historicoCargo.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return historicoCargo;
    }
    
    public boolean eliminarCargo(int id_historico)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.eliminarCargo()");
        
        String sql= "DELETE FROM historico_cargo WHERE id_historico = ?";
        
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
    

    public HistoricoCargo buscarHistoricoCargoFechas(int id_cargo, String fechai, String fechaf) throws Exception {
        //List<HistoricoCargo> historico = new ArrayList<>();

        
        Conexion con = new Conexion();
        Connection conexion = con.conectar("HistoricoCargoDao.buscarHistoricoCargoFechas()");
        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());

        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        
        //String sql = "SELECT * FROM produccion ";
        //String sql = "SELECT id_historico_empleado, id_cargo, id_historico, fecha FROM historico_empleado WHERE id_cargo=" + id_cargo  + "and he.fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT * FROM historico_cargo WHERE id_cargo=" + id_cargo  + " and fecha<=" + "'" + fechaf + "'" + " ORDER BY fecha DESC LIMIT 1";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);

        //while (rst.next()) {
            rst.next();
            
                HistoricoCargo p = new HistoricoCargo();

            p.setId_historico(rst.getInt(1));
            p.setId_cargo(rst.getInt(2));
            p.setPago(rst.getInt(3));
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
        
        //System.out.println("id_historico: " + p.getId_historico() + " cargo_id: " + p.getId_cargo() + " pago: " + p.getPago() );
        
        return p;
    }
}
    

    
