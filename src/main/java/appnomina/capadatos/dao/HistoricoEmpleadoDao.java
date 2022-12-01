/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Cargo;
import appnomina.capadatos.entidades.HistoricoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HistoricoEmpleadoDao {

    public boolean insertarHistoricoEmpleado(HistoricoEmpleado historico) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("HistoricoEmpleadoDao.insertarHistoricoEmpleado()");

        String sql = "";

        //System.out.println("xxx: " + historico.getId_historico() + " " + historico.getId_empleado() + " " + historico.getId_cargo() + " " + historico.getFecha());

        sql = "INSERT INTO historico_empleado VALUES (?,?,?,?)";

        //String sql = "INSERT INTO cargo VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, historico.getId_historico());
        ps.setInt(2, historico.getId_empleado());
        ps.setInt(3, historico.getId_cargo());
        ps.setDate(4, historico.getFecha());

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public Cargo buscarCargo(int id_cargo) throws Exception {
        Cargo p = new Cargo();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("CargoDao.buscarCargo()");

        String sql = "SELECT * FROM cargo WHERE id_cargo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_cargo);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_cargo(rst.getInt(1));
            p.setNombre(rst.getString(2));
            p.setPago(rst.getInt(3));
            p.setEstado(rst.getInt(4));
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

    public List<Cargo> buscarCargos() throws Exception {
        List<Cargo> cargos = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("CargoDao.buscarCargos()");
        String sql = "SELECT * FROM cargo ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
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

        rst = null;
        ps = null;
        conexion = null;
        return cargos;
    }

    public boolean eliminarCargo(int id_cargo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("CargoDao.eliminarCargo()");

        String sql = "DELETE FROM cargo WHERE id_cargo = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_cargo);

        ps.executeUpdate();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public HistoricoEmpleado buscarHistoricoEmpleadoFechas(int id_empleado, String fechai, String fechaf) throws Exception {
        //HistoricoEmpleado historico = new HistoricoEmpleado();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("HistoricoEmpleadoDao.buscarHistoricoEmpleadoFechas()");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        //String sql = "SELECT TOP 1 Lectura FROM tabla Where (FechaDocumento< '2013/12/04 ') ORDER BY FechaDocumento DESC";
        //String sql = "SELECT id_historico_empleado, id_empleado, id_cargo, fecha FROM historico_empleado WHERE id_empleado=" + id_empleado  + "and he.fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT * FROM historico_empleado WHERE id_empleado=" + id_empleado  + " and fecha<=" + "'" + fechaf + "'" + " ORDER BY fecha DESC LIMIT 1";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);
        HistoricoEmpleado p = new HistoricoEmpleado();

        rst.next();

            p.setId_historico(rst.getInt(1));
            p.setId_empleado(rst.getInt(2));
            p.setId_cargo(rst.getInt(3));
            p.setFecha(rst.getDate(4));

        

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        
        //System.out.println("id_historico: " + p.getId_historico() + " empleado_id: " + p.getId_empleado() + " id-cargo: " + p.getId_cargo() );
        
        return p;
    }

}
