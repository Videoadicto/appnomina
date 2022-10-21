/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.dao.CargoDao;
import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Empleado;
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
public class EmpleadoDao {
    
    public boolean insertarEmpleado(Empleado empleado , String nuevo)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.insertarEmpleado()");
        
        String sql="";
        
         if (nuevo.equals("0")){
        sql = "REPLACE INTO empleado VALUES (?,?,?,?,?,?,?,?,?)";}
        else{
        sql = "INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?,?)";}
        
        //String sql = "INSERT INTO empleado VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, empleado.getId_empleado());
        ps.setString(2, empleado.getNombre());
        ps.setString(3, empleado.getApellido());
        ps.setString(4, empleado.getCedula());
        ps.setString(5, empleado.getFecha_nacimiento());
        ps.setString(6, empleado.getTelefono());
        ps.setString(7, empleado.getEps());
        ps.setInt(8, empleado.getIdCargo().getId_cargo());
        ps.setInt(9, empleado.getEstado());

        
        ps.execute();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    public Empleado buscarEmpleado(int id_empleado)throws Exception{
        Empleado p = new Empleado();
        
        Conexion con= new Conexion();
        
        Connection conexion = con.conectar("EmpleadoDao.buscarEmpleado()");
                
       
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        CargoDao cd = new CargoDao();
        
        ps.setInt(1, id_empleado);                
        ResultSet rst = ps.executeQuery();
        if (rst.next()){
            p.setId_empleado(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setApellido(rst.getString(3));
            p.setCedula(rst.getString(4));
            p.setFecha_nacimiento(rst.getString(5));
            p.setTelefono(rst.getString(6));
            p.setEps(rst.getString(7));
            p.getIdCargo().setId_cargo(rst.getInt(8));
            p.getIdCargo().setNombre(cd.buscarCargo(rst.getInt(8)).getNombre());
            p.getIdCargo().setPago(cd.buscarCargo(rst.getInt(8)).getPago());
            p.setEstado(rst.getInt(9));
        } else p=null;
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return p;
    }
    
    public List<Empleado> buscarEmpleados()throws Exception{
        List<Empleado> empleados = new ArrayList<>();
                
        Conexion con= new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.buscarEmpleados()");
        String sql = "SELECT * FROM empleado ";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        CargoDao cd = new CargoDao();
                
        ResultSet rst = ps.executeQuery();
       while (rst.next()){
            Empleado p = new Empleado();
            p.setId_empleado(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setApellido(rst.getString(3));
            p.setCedula(rst.getString(4));
            p.setFecha_nacimiento(rst.getString(5));
            p.setTelefono(rst.getString(6));
            p.setEps(rst.getString(7));
            
            
            p.getIdCargo().setId_cargo(rst.getInt(8));
            p.getIdCargo().setNombre(cd.buscarCargo(rst.getInt(8)).getNombre());
            p.getIdCargo().setPago(cd.buscarCargo(rst.getInt(8)).getPago());
            
            p.setEstado(rst.getInt(9));
            
            empleados.add(p);
        }
        
        rst.close();        
        ps.close();
        conexion.close();
        
        rst=null;
        ps=null;
        conexion=null;
        return empleados;
    }
    
    public boolean eliminarEmpleado(int id_empleado)throws Exception{
        boolean rta=false;
        
        Conexion con= new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.eliminarEmpleado()");
        
        String sql= "DELETE FROM empleado WHERE id_empleado = ?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, id_empleado);
        
        
        ps.executeUpdate();
        rta=true;
        
        ps.close();
        conexion.close();
        
        ps=null;
        conexion=null;
        return rta;
    }
    
    
        public List<Cargo> getCargo() throws Exception{
        List<Cargo> cargos = new ArrayList<Cargo>();
        
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar("EmpleadoDao.getCargo");
        String sql = "SELECT * FROM cargo "
                + "ORDER BY nombre";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rst = ps.executeQuery();
        
        while (rst.next()){
            Cargo cargo = new Cargo();
            cargo.setId_cargo(rst.getInt(1));
            cargo.setNombre((rst.getString(2)));
            cargo.setPago((rst.getInt(3)));
            
            cargos.add(cargo);
        }
        rst.close();
        rst=null;
        
        ps.close();
        ps=null;
        
        con.close();
        con=null;
        
        return cargos;
    }
    
    
    
}
