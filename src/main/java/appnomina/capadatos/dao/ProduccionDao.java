/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.dao.EmpleadoDao;
import appnomina.capadatos.dao.ProduccionDao;
import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class ProduccionDao {

    public boolean insertarProduccion(Produccion produccion, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.insertarProduccion()");

        String sql = "";

        if (nuevo.equals("0")) {
            sql = "REPLACE INTO produccion VALUES (?,?,?,?,?)";
        } else {
            sql = "INSERT INTO produccion VALUES (?,?,?,?,?)";
        }

        //String sql = "INSERT INTO produccion VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, produccion.getId_produccion());
        ps.setInt(2, produccion.getIdEmpleado().getId_empleado());
        ps.setString(3, produccion.getFecha());
        ps.setInt(4, produccion.getProduccion());
        ps.setInt(5, 0);

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public Produccion buscarProduccion(int id_produccion) throws Exception {
        Produccion p = new Produccion();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("ProduccionDao.buscarProduccion()");

        String sql = "SELECT * FROM produccion WHERE id_produccion = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        EmpleadoDao cd = new EmpleadoDao();

        ps.setInt(1, id_produccion);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(cd.buscarEmpleado(rst.getInt(2)).getNombre());
            p.getIdEmpleado().setApellido(cd.buscarEmpleado(rst.getInt(2)).getApellido());
            p.getIdEmpleado().setCedula(cd.buscarEmpleado(rst.getInt(2)).getCedula());
            p.getIdEmpleado().setIdCargo(cd.buscarEmpleado(rst.getInt(2)).getIdCargo());

            p.setFecha(rst.getString(3));
            p.setProduccion(rst.getInt(4));
            p.setEstado(rst.getInt(5));
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

    public List<Produccion> buscarProducciones() throws Exception {
        List<Produccion> producciones = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProducciones()");
        String sql = "SELECT * FROM produccion ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        EmpleadoDao cd = new EmpleadoDao();

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Produccion p = new Produccion();
            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(cd.buscarEmpleado(rst.getInt(2)).getNombre());
            p.getIdEmpleado().setApellido(cd.buscarEmpleado(rst.getInt(2)).getApellido());
            p.getIdEmpleado().setCedula(cd.buscarEmpleado(rst.getInt(2)).getCedula());
            p.getIdEmpleado().setIdCargo(cd.buscarEmpleado(rst.getInt(2)).getIdCargo());
            p.setFecha(rst.getString(3));
            p.setProduccion(rst.getInt(4));
            p.setEstado(rst.getInt(5));

            producciones.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return producciones;
    }

    public List<Produccion> buscarProduccionesFechas(String fechai, String fechaf) throws Exception {
        List<Produccion> producciones = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProduccionesFechas()");
        String sql = "SELECT * FROM produccion ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        EmpleadoDao cd = new EmpleadoDao();

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechai2 = sdf.parse(fechai);
        Date fechai1 = new Date(fechai2.getTime() + TimeUnit.DAYS.toMillis(-1));
        
        Date fechaf2 = sdf.parse(fechaf);
        Date fechaf1 = new Date(fechaf2.getTime() + TimeUnit.DAYS.toMillis(1));

        while (rst.next()) {
            Produccion p = new Produccion();

            Date fechab = sdf.parse(rst.getString(3));

            if (fechab.after(fechai1) && fechab.before(fechaf1)) {

                p.setId_produccion(rst.getInt(1));
                p.getIdEmpleado().setId_empleado(rst.getInt(2));
                p.getIdEmpleado().setNombre(cd.buscarEmpleado(rst.getInt(2)).getNombre());
                p.getIdEmpleado().setApellido(cd.buscarEmpleado(rst.getInt(2)).getApellido());
                p.getIdEmpleado().setCedula(cd.buscarEmpleado(rst.getInt(2)).getCedula());
                p.getIdEmpleado().setIdCargo(cd.buscarEmpleado(rst.getInt(2)).getIdCargo());
                p.setFecha(rst.getString(3));
                p.setProduccion(rst.getInt(4));
                p.setEstado(rst.getInt(5));

                producciones.add(p);
            }
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return producciones;
    }

    public boolean eliminarProduccion(int id_produccion) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.eliminarProduccion()");

        String sql = "DELETE FROM produccion WHERE id_produccion = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_produccion);

        ps.executeUpdate();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public List<Empleado> getEmpleado() throws Exception {
        List<Empleado> empleados = new ArrayList<Empleado>();

        Conexion conexion = new Conexion();

        Connection con = conexion.conectar("ProduccionDao.getEmpleado");
        String sql = "SELECT * FROM empleado "
                + "ORDER BY nombre";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {
            Empleado empleado = new Empleado();
            empleado.setId_empleado(rst.getInt(1));
            //empleado.setNombre((rst.getString(2)));
            //empleado.setApellido((rst.getString(3)));
            //empleado.setCedula((rst.getString(4)));
            //empleado.setIdCargo((rst.get  .getString(5)));

            empleados.add(empleado);
        }
        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return empleados;
    }

}
