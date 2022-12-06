/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Cargo;
import appnomina.capadatos.dao.HistoricoEmpleadoDao;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.HistoricoCargo;
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
public class CargoDao {
    
    private HistoricoCargoDao hcd;

    public CargoDao() {
        hcd = new HistoricoCargoDao();
    }
    
    /*
    public boolean insertarCargo(Cargo cargo , String nuevo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("CargoDao.insertarCargo()");
        
        String sql="";
        
        //System.out.println("xxx: "+nuevo);
        
        if (nuevo.equals("0")){
        sql = "REPLACE INTO cargo VALUES (?,?,?,?)";}
        else{
        sql = "INSERT INTO cargo VALUES (?,?,?,?)";}
        
        //String sql = "INSERT INTO cargo VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, cargo.getId_cargo());
        ps.setString(2, cargo.getNombre());
        ps.setInt(3, cargo.getPago());
        ps.setInt(4, cargo.getEstado());
        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }

*/
    
    public boolean insertarCargo(Cargo cargo, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("CargoDao.insertarCargo()");

        String sql = "";

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String fecha = date.format(formatter);
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechax = sdf.parse(localDate.toString());
        java.sql.Date fechah = new java.sql.Date(fechax.getTime());
        
        if (nuevo.equals("0")) {
            sql = "REPLACE INTO cargo VALUES (?,?,?,?)";
        } else {
            sql = "INSERT INTO cargo VALUES (?,?,?,?)";
        }

        //String sql = "INSERT INTO empleado VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, cargo.getId_cargo());
        ps.setString(2, cargo.getNombre());
        ps.setInt(3, cargo.getPago());
        ps.setInt(4, cargo.getEstado());
        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        
        int X=0;
         if (nuevo.equals("0")) {
             X = cargo.getId_cargo();
        } else {
             X = ultimoCargo();
        }
        
        
        HistoricoCargo hc = new HistoricoCargo(0, X, cargo.getPago(), fechah);
        Boolean mensaje = hcd.insertarHistoricoCargo(hc);
        //System.out.println(mensaje);
        
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
            p.setEstado(rst.getInt(4));
        } else p=null;
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    
    public Cargo buscarCargoNombre(String nombre)throws Exception{
        Cargo p = new Cargo();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("CargoDao.buscarCargoNombre()");
                
       
        String sql = "SELECT * FROM cargo WHERE nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, nombre);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_cargo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setPago(rst.getInt(3));
            p.setEstado(rst.getInt(4));
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
            p.setEstado(rst.getInt(4));

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
    
    public int ultimoCargo() throws Exception {
        //Empleado p = new Empleado();
        int X=0;
        Conexion con = new Conexion();

        Connection conexion = con.conectar("CargoDao.ultimoCargo()");

        //String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        //SELECT TOP 1 * FROM Table ORDER BY ID DESC//
        //String sql = "SELECT TOP 1 FROM empleado ORDER BY id_empleado DESC";
        String sql = "SELECT * FROM cargo ORDER BY id_cargo DESC LIMIT 1";

        PreparedStatement ps = conexion.prepareStatement(sql);

        //CargoDao cd = new CargoDao();

        //ps.setInt(1, id_empleado);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
           X = rst.getInt(1);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return X;
    }
    
    
}