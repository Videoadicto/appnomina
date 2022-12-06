/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.Cargo;
import appnomina.capadatos.dao.HistoricoEmpleadoDao;
import appnomina.capadatos.entidades.HistoricoEmpleado;
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
public class EmpleadoDao {

    private HistoricoEmpleadoDao hed;

    public EmpleadoDao() {
        hed = new HistoricoEmpleadoDao();
    }

    public boolean insertarEmpleado(Empleado empleado, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.insertarEmpleado()");

        String sql = "";

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String fecha = date.format(formatter);
        LocalDate localDate = LocalDate.parse(fecha, formatter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechax = sdf.parse(localDate.toString());
        java.sql.Date fechah = new java.sql.Date(fechax.getTime());
        
        if (nuevo.equals("0")) {
            sql = "REPLACE INTO empleado VALUES (?,?,?,?,?,?,?,?,?)";
        } else {
            sql = "INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?,?)";
        }

        //String sql = "INSERT INTO empleado VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, empleado.getId_empleado());
        ps.setString(2, empleado.getNombre());
        ps.setString(3, empleado.getApellido());
        ps.setString(4, empleado.getCedula());
        ps.setString(5, empleado.getFecha_vinculacion());
        ps.setString(6, empleado.getTelefono());
        ps.setString(7, empleado.getEps());
        ps.setInt(8, empleado.getIdCargo().getId_cargo());
        ps.setInt(9, empleado.getEstado());

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        
        int X=0;
         if (nuevo.equals("0")) {
             X = empleado.getId_empleado();
        } else {
             X = ultimoEmpleado();
        }
        
        
        HistoricoEmpleado he = new HistoricoEmpleado(0, X, empleado.getIdCargo().getId_cargo(), fechah);
        Boolean mensaje = hed.insertarHistoricoEmpleado(he);
        //System.out.println(mensaje);
        
        return rta;
    }

    public Empleado buscarEmpleado(int id_empleado) throws Exception {
        Empleado p = new Empleado();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("EmpleadoDao.buscarEmpleado()");

        //String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        String sql = "SELECT e.id_empleado, e.nombre, e.apellido, e.cedula, e.fecha_vinculacion, e.telefono, e.eps, e.id_cargo, c.nombre, c.pago, e.estado FROM empleado e, cargo c WHERE e.id_cargo=c.id_cargo and e.id_empleado = ?;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ps.setInt(1, id_empleado);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_empleado(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setApellido(rst.getString(3));
            p.setCedula(rst.getString(4));
            p.setFecha_vinculacion(rst.getString(5));
            p.setTelefono(rst.getString(6));
            p.setEps(rst.getString(7));
            p.getIdCargo().setId_cargo(rst.getInt(8));
            p.getIdCargo().setNombre(rst.getString(9));
            p.getIdCargo().setPago(rst.getInt(10));
            p.setEstado(rst.getInt(11));
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
    
    
    public Empleado buscarEmpleadoCedula(String cedula) throws Exception {
        Empleado p = new Empleado();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("EmpleadoDao.buscarEmpleadoCedula()");

        //String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        String sql = "SELECT e.id_empleado, e.nombre, e.apellido, e.cedula, e.fecha_vinculacion, e.telefono, e.eps, e.id_cargo, c.nombre, c.pago, e.estado FROM empleado e, cargo c WHERE e.id_cargo=c.id_cargo and e.cedula = ?;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ps.setString(1, cedula);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_empleado(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setApellido(rst.getString(3));
            p.setCedula(rst.getString(4));
            p.setFecha_vinculacion(rst.getString(5));
            p.setTelefono(rst.getString(6));
            p.setEps(rst.getString(7));
            p.getIdCargo().setId_cargo(rst.getInt(8));
            p.getIdCargo().setNombre(rst.getString(9));
            p.getIdCargo().setPago(rst.getInt(10));
            p.setEstado(rst.getInt(11));
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
    
    

    public List<Empleado> buscarEmpleados() throws Exception {
        List<Empleado> empleados = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.buscarEmpleados()");
        //String sql = "SELECT * FROM empleado ";
        String sql = "SELECT e.id_empleado, e.nombre, e.apellido, e.cedula, e.fecha_vinculacion, e.telefono, e.eps, e.id_cargo, c.nombre, c.pago, e.estado FROM empleado e, cargo c WHERE e.id_cargo=c.id_cargo;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {
            Empleado p = new Empleado();
            p.setId_empleado(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setApellido(rst.getString(3));
            p.setCedula(rst.getString(4));
            p.setFecha_vinculacion(rst.getString(5));
            p.setTelefono(rst.getString(6));
            p.setEps(rst.getString(7));
            p.getIdCargo().setId_cargo(rst.getInt(8));
            p.getIdCargo().setNombre(rst.getString(9));
            p.getIdCargo().setPago(rst.getInt(10));
            p.setEstado(rst.getInt(11));

            empleados.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return empleados;
    }

    public boolean eliminarEmpleado(int id_empleado) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("EmpleadoDao.eliminarEmpleado()");

        String sql = "DELETE FROM empleado WHERE id_empleado = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_empleado);

        ps.executeUpdate();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public List<Cargo> getCargo() throws Exception {
        List<Cargo> cargos = new ArrayList<Cargo>();

        Conexion conexion = new Conexion();
        Connection con = conexion.conectar("EmpleadoDao.getCargo");
        String sql = "SELECT * FROM cargo "
                + "ORDER BY nombre";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {
            Cargo cargo = new Cargo();
            cargo.setId_cargo(rst.getInt(1));
            cargo.setNombre((rst.getString(2)));
            cargo.setPago((rst.getInt(3)));
            cargo.setEstado((rst.getInt(4)));
            cargos.add(cargo);
        }
        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return cargos;
    }
    
    
    

    public int ultimoEmpleado() throws Exception {
        //Empleado p = new Empleado();
        int X=0;
        Conexion con = new Conexion();

        Connection conexion = con.conectar("EmpleadoDao.ultimoEmpleado()");

        //String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        //SELECT TOP 1 * FROM Table ORDER BY ID DESC//
        //String sql = "SELECT TOP 1 FROM empleado ORDER BY id_empleado DESC";
        String sql = "SELECT * FROM empleado ORDER BY id_empleado DESC LIMIT 1";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

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
