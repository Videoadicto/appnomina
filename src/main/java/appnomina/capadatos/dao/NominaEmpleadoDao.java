/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaEmpleado;
import appnomina.capadatos.entidades.HistoricoEmpleado;
import appnomina.capadatos.entidades.HistoricoCargo;
import appnomina.capadatos.entidades.HistoricoFijos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class NominaEmpleadoDao {

    private HistoricoEmpleadoDao hed;
    private HistoricoCargoDao hcd;
    private HistoricoFijosDao hfd;
    private EmpleadoDao ed;
    private ProduccionDao pd;

    public NominaEmpleadoDao() {
        hed = new HistoricoEmpleadoDao();
        hcd = new HistoricoCargoDao();
        hfd = new HistoricoFijosDao();
        ed = new EmpleadoDao();
        pd = new ProduccionDao();
    }

    public boolean insertarNominaEmpleado(NominaEmpleado nominaempleado, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaEmpleadoDao.insertarNominaEmpleado()");

        String sql = "";

        if (nuevo.equals("0")) {
            sql = "REPLACE INTO nomina_empleado VALUES (?,?,?,?,?)";
        } else {
            sql = "INSERT INTO nomina_empleado VALUES (?,?,?,?,?)";
        }

        //String sql = "INSERT INTO produccion VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, nominaempleado.getId_nomina_empleado());
        ps.setString(2, nominaempleado.getId_nomina());
        ps.setInt(3, nominaempleado.getId_empleado());
        ps.setInt(4, nominaempleado.getId_concepto());
        ps.setInt(5, nominaempleado.getValor());

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public NominaEmpleado buscarNominaEmpleado(int id_nomina_empleado) throws Exception {
        NominaEmpleado p = new NominaEmpleado();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("NominaEmpleadoDao.buscarNominaEmpleado()");

        String sql = "SELECT * FROM nomina_empleado WHERE id_nomina_empleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_nomina_empleado);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_nomina_empleado(rst.getInt(1));
            p.setId_nomina(rst.getString(2));
            p.setId_empleado(rst.getInt(3));
            p.setId_concepto(rst.getInt(4));
            p.setValor(rst.getInt(5));
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

    public List<NominaEmpleado> buscarNominasEmpleados(String id_nomina) throws Exception {
        List<NominaEmpleado> producciones = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaEmpleadoDao.buscarNominasEmpleados()");
        //String sql = "SELECT * FROM produccion ";

        String sql = "SELECT * FROM nomina_empleado WHERE id_nomina=" + id_nomina;

        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            NominaEmpleado p = new NominaEmpleado();
            p.setId_nomina_empleado(rst.getInt(1));
            p.setId_nomina(rst.getString(2));
            p.setId_empleado(rst.getInt(3));
            p.setId_concepto(rst.getInt(4));
            p.setValor(rst.getInt(5));

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

    public List<NominaEmpleado> buscarNominaEmpleados() throws Exception {
        List<NominaEmpleado> producciones = new ArrayList<>();

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

            //producciones.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return producciones;
    }

    public List<NominaEmpleado> buscarNominasSemanalesFechas(String fechai, String fechaf) throws Exception {
        List<NominaEmpleado> producciones = new ArrayList<>();

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

            //producciones.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return producciones;
    }

    public int buscarNominasSemanalesUsuarioFechasX(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

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

    public int buscarNominasSemanalesUsuarioFechas(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

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

    public boolean eliminarNominaEmpleado(int id_produccion) throws Exception {
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

    public List<Integer> buscarNominaEmpleadoEmpleado(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

        List<Integer> totales = new ArrayList<>();

        //List<HistoricoEmpleado> historicos = hed.buscarHistoricoEmpleadoFechas(id_empleado, fechai, fechaf);
        //System.out.println("fechai : " + fechai + " fechaf: " + fechaf );
        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaEmpleadoDao.buscarNominaEmpleadoEmpleado()");

        //String sql = "SELECT p.id_produccion, p.id_empleado, e.nombre, e.apellido, e.cedula, e.id_cargo, p.fecha, p.cantidad, p.estado FROM produccion p, empleado e WHERE p.id_empleado=e.id_empleado and p.fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT id_empleado, id_cargo, cantidad, fecha FROM produccion WHERE id_empleado=" + id_empleado + "and fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        int total = 0;

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        while (rst.next()) {
            //Date fechab = sdf.parse(rst.getString(3));
            //int idempleado = rst.getInt(2);

//            System.out.println("fechai: " + fechab.after(fechai1));
//            System.out.println(" fechaf: " + fechab.before(fechaf1));
//            System.out.println(" id_empleado: " + id_empleado);
//            System.out.println(" idEmpleadorst: " + idempleado );
            if (totales.isEmpty()) {
                total = total + rst.getInt(3) * pago;
            } else {

            }

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

        return totales;
    }

}
