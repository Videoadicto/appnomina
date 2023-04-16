/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.dao.EmpleadoDao;
import appnomina.capadatos.dao.ProduccionDao;
import appnomina.capadatos.dao.CargoDao;
import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class ProduccionDao {
    
    private EmpleadoDao ed;
    
    public ProduccionDao() {
        ed = new EmpleadoDao();
       
    }
    

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

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fecha2 = sdf.parse(produccion.getFecha());
        //java.sql.Date fecha1 = new java.sql.Date(fechai2.getTime());
        ps.setDate(3, produccion.getFecha());
        ps.setInt(4, produccion.getCantidad());
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

        //String sql = "SELECT * FROM produccion WHERE id_produccion = ?";
        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.id_produccion=?;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ps.setInt(1, id_produccion);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(rst.getString(3));
            p.getIdEmpleado().setApellido(rst.getString(4));
            p.getIdEmpleado().setCedula(rst.getString(5));
            p.getIdEmpleado().setIdCargo(cd.buscarCargo(rst.getInt(6)));

            p.setFecha(rst.getDate(7));
            p.setCantidad(rst.getInt(8));
            p.setEstado(rst.getInt(9));
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
        //String sql = "SELECT * FROM produccion ";

        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Produccion p = new Produccion();
            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(rst.getString(3));
            p.getIdEmpleado().setApellido(rst.getString(4));
            p.getIdEmpleado().setCedula(rst.getString(5));
            p.getIdEmpleado().setIdCargo(cd.buscarCargo(rst.getInt(6)));

            p.setFecha(rst.getDate(7));
            p.setCantidad(rst.getInt(8));
            p.setEstado(rst.getInt(9));

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

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);
        while (rst.next()) {
            Produccion p = new Produccion();

            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(rst.getString(3));
            p.getIdEmpleado().setApellido(rst.getString(4));
            p.getIdEmpleado().setCedula(rst.getString(5));
            p.getIdEmpleado().setIdCargo(cd.buscarCargo(rst.getInt(6)));

            p.setFecha(rst.getDate(7));
            p.setCantidad(rst.getInt(8));
            p.setEstado(rst.getInt(9));

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
    
    
    public List<Produccion> buscarProduccionesFechasCargos(String fechai, String fechaf) throws Exception {
        List<Produccion> producciones = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProduccionesFechas()");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);
        while (rst.next()) {
            Produccion p = new Produccion();

            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(rst.getString(3));
            p.getIdEmpleado().setApellido(rst.getString(4));
            p.getIdEmpleado().setCedula(rst.getString(5));
            p.getIdEmpleado().setIdCargo(cd.buscarCargo(rst.getInt(6)));

            p.setFecha(rst.getDate(7));
            p.setCantidad(rst.getInt(8));
            p.setEstado(rst.getInt(9));

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
    

    public int buscarProduccionesUsuarioFechasX(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

        //System.out.println("fechai : " + fechai + " fechaf: " + fechaf );
        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProduccionesFechas()");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        int total = 0;

        while (rst.next()) {
            //Date fechab = sdf.parse(rst.getString(3));
            //int idempleado = rst.getInt(2);

//            System.out.println("fechai: " + fechab.after(fechai1));
//            System.out.println(" fechaf: " + fechab.before(fechaf1));
//            System.out.println(" id_empleado: " + id_empleado);
//            System.out.println(" idEmpleadorst: " + idempleado );
            //if (fechab.after(fechai1) && fechab.before(fechaf1) && id_empleado==idempleado ) {
            if (id_empleado == rst.getInt(2)) {
                total = total + rst.getInt(8);
            }
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;

        //CargoDao cargo = new CargoDao();
        //System.out.println(id_cargo);
        //cargo.buscarCargo(total)
        //System.out.println("pago " + pago);
        total = total * pago;

        return total;
    }

    public int buscarProduccionesUsuarioFechas(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

        //System.out.println("fechai : " + fechai + " fechaf: " + fechaf );
        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProduccionesFechas()");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        int total = 0;

        while (rst.next()) {
            //Date fechab = sdf.parse(rst.getString(3));
            //int idempleado = rst.getInt(2);

//            System.out.println("fechai: " + fechab.after(fechai1));
//            System.out.println(" fechaf: " + fechab.before(fechaf1));
//            System.out.println(" id_empleado: " + id_empleado);
//            System.out.println(" idEmpleadorst: " + idempleado );
            //if (fechab.after(fechai1) && fechab.before(fechaf1) && id_empleado==idempleado ) {
            if (id_empleado == rst.getInt(2)) {
                total = total + rst.getInt(8);
            }
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;

        //CargoDao cargo = new CargoDao();
        //System.out.println(id_cargo);
        //cargo.buscarCargo(total)
        //System.out.println("pago " + pago);
        total = total * pago;

        return total;
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

    public int contarProducciones(int id_empleado) throws Exception {

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.contarProducciones()");

        String sql = "SELECT count(id_empleado) FROM produccion WHERE id_empleado=" + id_empleado;

        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        rst.next();
        int total = rst.getInt(1);

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;

        return total;
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
    
    
    public List<Produccion> buscarProduccionesFechasEmpleado(int id_empleado, String fechai, String fechaf) throws Exception {
        List<Produccion> producciones = new ArrayList<>();

        //System.out.println(id_empleado + " fechai: " + fechai + " fechaf: " + fechaf);
        
        
        Empleado empleado = new Empleado();
        
        empleado = ed.buscarEmpleado(id_empleado);
        
        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProduccionesFechas()");

        String sql = "SELECT * FROM produccion WHERE id_empleado=" + id_empleado + " and fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        while (rst.next()) {
           
            if (rst.getInt(2)==id_empleado){
                
            Produccion p = new Produccion();

            p.setId_produccion(rst.getInt(1));

            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            p.getIdEmpleado().setNombre(empleado.getNombre());
            p.getIdEmpleado().setApellido(empleado.getApellido());
            p.getIdEmpleado().setCedula(empleado.getCedula());
            p.getIdEmpleado().setIdCargo(null);

            p.setFecha(rst.getDate(3));
            p.setCantidad(rst.getInt(4));
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
    

}
