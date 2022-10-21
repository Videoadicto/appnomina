/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.dao.EmpleadoDao;
import appnomina.capadatos.dao.NominaSemanalDao;
import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.NominaSemanal;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.Produccion;
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
public class NominaSemanalDao {

    public boolean insertarNominaSemanal(NominaSemanal nominaSemanal, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.insertarNominaSemanal()");

        String sql = "";

        if (nuevo.equals("0")) {
            sql = "REPLACE INTO nomina_semanal VALUES (?,?,?,?,?)";
        } else {
            sql = "INSERT INTO nomina_semanal VALUES (?,?,?,?,?)";
        }

        //String sql = "INSERT INTO produccion VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, nominaSemanal.getId_semanal());
        ps.setInt(2, nominaSemanal.getIdEmpleado().getId_empleado());
        ps.setString(3, nominaSemanal.getFecha());
        ps.setInt(4, nominaSemanal.getTotal());
        ps.setInt(5, 1);

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public NominaSemanal buscarNominaSemanal(int id_semanal) throws Exception {
        NominaSemanal p = new NominaSemanal();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("NominaSemanalDao.buscarNominaSemanal()");

        String sql = "SELECT * FROM nomina_semanal WHERE id_semanal = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ProduccionDao cd = new ProduccionDao();

        ps.setInt(1, id_semanal);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_semanal(rst.getInt(1));
            p.getIdEmpleado().setId_empleado(rst.getInt(2));

            //p.getIdProduccion().setId_produccion(rst.getInt(2));
            //p.getIdProduccion().setIdEmpleado(cd.buscarProduccion(rst.getInt(2)).getIdEmpleado());
            p.setFecha(rst.getString(3));
            p.setTotal(rst.getInt(4));
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

    public List<NominaSemanal> buscarNominasSemanales() throws Exception {
        List<NominaSemanal> nominasSemanales = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("ProduccionDao.buscarProducciones()");
        String sql = "SELECT * FROM nomina_semanal ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ProduccionDao cd = new ProduccionDao();

        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            NominaSemanal p = new NominaSemanal();
            p.setId_semanal(rst.getInt(1));
            p.getIdEmpleado().setId_empleado(rst.getInt(2));
            //p.getIdProduccion().setId_produccion(rst.getInt(2));
            //p.getIdProduccion().setIdEmpleado(cd.buscarProduccion(rst.getInt(2)).getIdEmpleado());
            p.setFecha(rst.getString(3));
            p.setTotal(rst.getInt(4));
            p.setEstado(rst.getInt(5));

            nominasSemanales.add(p);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return nominasSemanales;
    }

    public List<NominaSemanal> buscarNominasSemanalesFechas(String fechai, String fechaf) throws Exception {
        List<NominaSemanal> nominasSemanales = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.buscarNominasSemanalesFechas()");
        String sql = "SELECT * FROM nomina_semanal ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ProduccionDao cd = new ProduccionDao();

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechai2 = sdf.parse(fechai);
        Date fechai1 = new Date(fechai2.getTime() + TimeUnit.DAYS.toMillis(-1));
        
        Date fechaf2 = sdf.parse(fechaf);
        Date fechaf1 = new Date(fechaf2.getTime() + TimeUnit.DAYS.toMillis(1));

        while (rst.next()) {
            NominaSemanal p = new NominaSemanal();

            Date fechab = sdf.parse(rst.getString(3));

            if (fechab.after(fechai1) && fechab.before(fechaf1)) {

                p.setId_semanal(rst.getInt(1));
                p.getIdEmpleado().setId_empleado(rst.getInt(2));
                //p.getIdProduccion().setIdEmpleado(cd.buscarProduccion(rst.getInt(2)).getIdEmpleado());
                
                p.setFecha(rst.getString(3));
                p.setTotal(rst.getInt(4));
                p.setEstado(rst.getInt(5));

                nominasSemanales.add(p);
            }
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return nominasSemanales;
    }

    public boolean eliminarNominaSemanal(int id_semanal) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.eliminarNominaSemanal()");

        String sql = "DELETE FROM nomina_semanal WHERE id_semanal = ?";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setInt(1, id_semanal);

        ps.executeUpdate();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public List<Produccion> getProduccion() throws Exception {
        List<Produccion> producciones = new ArrayList<Produccion>();

        Conexion conexion = new Conexion();

        Connection con = conexion.conectar("ProduccionDao.getEmpleado");
        String sql = "SELECT * FROM produccion "
                + "ORDER BY id_produccion";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rst = ps.executeQuery();

        while (rst.next()) {
            Produccion produccion = new Produccion();
            produccion.setId_produccion(rst.getInt(1));
            //empleado.setNombre((rst.getString(2)));
            //empleado.setApellido((rst.getString(3)));
            //empleado.setCedula((rst.getString(4)));
            //empleado.setIdCargo((rst.get  .getString(5)));

            producciones.add(produccion);
        }
        rst.close();
        rst = null;

        ps.close();
        ps = null;

        con.close();
        con = null;

        return producciones;
    }

}
