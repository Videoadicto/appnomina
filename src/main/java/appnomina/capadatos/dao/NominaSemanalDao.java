/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appnomina.capadatos.dao;

import appnomina.capadatos.Conexion;
import appnomina.capadatos.entidades.Produccion;
import appnomina.capadatos.entidades.Empleado;
import appnomina.capadatos.entidades.NominaSemanal;
import appnomina.capadatos.entidades.HistoricoEmpleado;
import appnomina.capadatos.entidades.HistoricoCargo;
import appnomina.capadatos.entidades.HistoricoFijos;
import appnomina.capadatos.entidades.NominaEmpleado;
import appnomina.capadatos.entidades.Semanal;
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
public class NominaSemanalDao {

    private HistoricoEmpleadoDao hed;
    private HistoricoCargoDao hcd;
    private HistoricoFijosDao hfd;
    private EmpleadoDao ed;
    private ProduccionDao pd;
    private NominaEmpleadoDao ne;

    public NominaSemanalDao() {
        hed = new HistoricoEmpleadoDao();
        hcd = new HistoricoCargoDao();
        hfd = new HistoricoFijosDao();
        ed = new EmpleadoDao();
        pd = new ProduccionDao();
        ne = new NominaEmpleadoDao();
    }

    public boolean insertarNominaSemanal(NominaSemanal nominasemanal, String nuevo) throws Exception {
        boolean rta = false;

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.insertarNominaSemanal()");

        String sql = "";

        if (nuevo.equals("0")) {
            sql = "REPLACE INTO nomina_semanal VALUES (?,?,?)";
        } else {
            sql = "INSERT INTO nomina_semanal VALUES (?,?,?)";
        }

        //String sql = "INSERT INTO produccion VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, nominasemanal.getId_nomina());
        ps.setString(2, nominasemanal.getId_nomina_semanal());
        ps.setDate(3, nominasemanal.getFecha());

        ps.execute();
        rta = true;

        ps.close();
        conexion.close();

        ps = null;
        conexion = null;
        return rta;
    }

    public NominaSemanal buscarNominaSemanal(String id_nomina_semanal) throws Exception {
        NominaSemanal p = new NominaSemanal();

        Conexion con = new Conexion();

        Connection conexion = con.conectar("NominaSemanalDao.buscarNominaSemanal()");

        String sql = "SELECT * FROM nomina_semanal WHERE id_nomina = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, id_nomina_semanal);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            p.setId_nomina(rst.getInt(1));
            p.setId_nomina_semanal(rst.getString(1));
            p.setFecha(rst.getDate(2));
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

    public int buscarIdNominaSemanal(String id_semanal, Date fecha) throws Exception {

        int id_nomina = 0;

        Conexion con = new Conexion();

        Connection conexion = con.conectar("NominaSemanalDao.buscarIdNominaSemanal()");

        String sql = "SELECT * FROM nomina_semanal ORDER BY id_nomina DESC LIMIT 1";

        PreparedStatement ps = conexion.prepareStatement(sql);

        //CargoDao cd = new CargoDao();
        //ps.setInt(1, id_empleado);
        ResultSet rst = ps.executeQuery();
        if (rst.next()) {
            id_nomina = rst.getInt(1);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;
        return id_nomina;
    }

    public List<NominaSemanal> buscarNominasSemanales() throws Exception {
        List<NominaSemanal> producciones = new ArrayList<>();

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

    public List<Semanal> buscarNominasSemanalesFechas(String fechai, String fechaf) throws Exception {
        List<Semanal> nominaempleado = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.buscarNominasSemanalesFechas()");

        //String sql = "SELECT ne. FROM nomina_semanal ns, nomina_empleado ne WHERE ns.id_nomina=ne.id_nomina and ns.fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT e.cedula, e.nombre, e.apellido, ns.fecha, ne.id_concepto, ne.valor FROM nomina_semanal ns, nomina_empleado ne, empleado e WHERE ns.id_nomina=ne.id_nomina and ns.fecha between '" + fechai + "' and '" + fechaf + "' and ne.id_empleado=e.id_empleado;";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        Semanal p = new Semanal();
        while (rst.next()) {
            

            if (rst.getInt(5) == 1) {
                p.setCedula(rst.getString(1));
                p.setNombre(rst.getString(2));
                p.setApellido(rst.getString(3));
                p.setFecha(""+ rst.getDate(4));
                p.setTotal(rst.getInt(6));
            } else {
                if (rst.getInt(5) == 3) {
                    p.setPrima(rst.getInt(6));

                }
                else
                {
                    p.setCesantias(rst.getInt(6));
                    nominaempleado.add(p);
                    p = new Semanal();
                }
            }
            //System.out.println(rst.getString(4) + " cedula: " + rst.getString(1) + " " + rst.getString(2) + " " + rst.getString(3) + " concepto: " + rst.getInt(5) + " " + rst.getInt(6));
        }

        
        
        
        
    rst.close ();

    ps.close ();

    conexion.close ();

    rst  = null;
    ps  = null;
    conexion  = null;
    return nominaempleado ;
}

public List<NominaSemanal> buscarNominasSemanalesFechasX(String fechai, String fechaf) throws Exception {
        List<NominaSemanal> producciones = new ArrayList<>();

        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.buscarNominasSemanalesFechas()");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechai2 = sdf.parse(fechai);
        //java.sql.Date fechai1 = new java.sql.Date(fechai2.getTime());
        //java.util.Date fechaf2 = sdf.parse(fechaf);
        //java.sql.Date fechaf1 = new java.sql.Date(fechaf2.getTime());
        //String sql = "SELECT * FROM produccion ";
        String sql = "SELECT * FROM nomina_semanal WHERE fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        CargoDao cd = new CargoDao();

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);
        while (rst.next()) {
            NominaSemanal p = new NominaSemanal();
            p.setId_nomina(rst.getInt(1));
            p.setId_nomina_semanal(rst.getString(2));
            p.setFecha(rst.getDate(3));
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

    public boolean eliminarNominaSemanal(int id_produccion) throws Exception {
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

    public List<Integer> buscarNominaSemanalEmpleado(int id_empleado, int pago, String fechai, String fechaf) throws Exception {

        List<Integer> totales = new ArrayList<>();

        //List<HistoricoEmpleado> historicos = hed.buscarHistoricoEmpleadoFechas(id_empleado, fechai, fechaf);

        //System.out.println("fechai : " + fechai + " fechaf: " + fechaf );
        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.buscarNominaSemanalEmpleado()");

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

    public List<Integer> calcularNominaSemanalEmpleado(int id_empleado, int tipo, String fechai, String fechaf) throws Exception {

        //System.out.println("id_empleado: " + id_empleado + " tipo: " + tipo + " fechai: " + fechai + " fechaf: " + fechaf);
        List<Integer> totales = new ArrayList<>();

        //HistoricoEmpleado he = hed.buscarHistoricoEmpleadoFechas(id_empleado, fechai, fechaf );
        //HistoricoCargo hc = hcd.buscarHistoricoCargoFechas(he.getId_cargo(), fechai, fechaf );
        Conexion con = new Conexion();
        Connection conexion = con.conectar("NominaSemanalDao.calcularNominaSemanalEmpleado()");

        //String sql = "SELECT fecha, cantidad FROM produccion WHERE id_empleado=" + id_empleado  + " and fecha between '" + fechai + "' and '" + fechaf + "';";
        String sql = "SELECT p.fecha, p.cantidad FROM produccion p WHERE p.id_empleado=" + id_empleado + " and fecha between '" + fechai + "' and '" + fechaf + "';";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ResultSet rst = ps.executeQuery();

        //System.out.println("fechai: " + fechai + " fechaf: " + fechaf);
        int base = 0;
        int fijo1 = 0;
        int fijo2 = 0;
        int fijo3 = 0;

        Empleado e = ed.buscarEmpleado(id_empleado);
        String fechav = e.getFecha_vinculacion();

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //java.util.Date fechavin = sdf.parse(fechav);
        //java.util.Date fechaini = sdf.parse(fechai);
        //java.util.Date fechafin = sdf.parse(fechaf);
        //int dias1= (int)((fechavin.getTime()-fechaini.getTime()));
        //int dias2= (int)((fechavin.getTime()-fechafin.getTime()));
        LocalDate d1 = LocalDate.parse(fechav);
        LocalDate d2 = LocalDate.parse(fechai);
        LocalDate d3 = LocalDate.parse(fechaf);

        long dias1 = ChronoUnit.DAYS.between(d1, d2);
        long dias2 = ChronoUnit.DAYS.between(d1, d3) + 1;

        long k = dias2 - dias1;

        //boolean prima = false;
        //boolean cesan = false;
        int multip = 0;
        int multic = 0;

        long dias3 = dias1;

        for (int i = 0; i < k; i++) {
            if ((dias3 % 365) == 0) {
                //prima = true;
                //multip = (int) (dias3 / 365);
                multip = 1;
            }

            if ((dias3 % 182) == 0) {
                //cesan = true;
                //multic = (int) (dias3 / 182);
                multic = 1;
            }
            dias3++;

        }

        //System.out.println("dias1: " + dias1 + " dias2: " + dias2);

        //if (dias1>=-1 && dias dias 
        while (rst.next()) {

            HistoricoEmpleado he = hed.buscarHistoricoEmpleadoFechas(id_empleado, fechai, rst.getDate(1).toString());
            HistoricoCargo hc = hcd.buscarHistoricoCargoFechas(he.getId_cargo(), fechai, rst.getDate(1).toString());
            base = base + (hc.getPago() * rst.getInt(2));

            HistoricoFijos hf1 = hfd.buscarHistoricoFijosFechas(1, fechai, rst.getDate(1).toString());
            HistoricoFijos hf2 = hfd.buscarHistoricoFijosFechas(2, fechai, rst.getDate(1).toString());
            HistoricoFijos hf3 = hfd.buscarHistoricoFijosFechas(3, fechai, rst.getDate(1).toString());

            fijo1 = fijo1 + (hf1.getValor() / 20);
            fijo2 = fijo2 + ((hf2.getValor() * (hc.getPago() * rst.getInt(2))) / 2000);
            //fijo3 = fijo3 + ((hf3.getValor() * (hc.getPago() * rst.getInt(2))) / 2000);
            
            //fijo3 = fijo3 + ((hf3.getValor() * (hc.getPago() * rst.getInt(2))) / 400);
            fijo3= hf3.getValor();

            //System.out.println("" + hf3.getValor());
        }

        totales.add(base);
        totales.add(fijo1);
        totales.add(fijo2);

        
        if (tipo ==1){
        
        
        totales.add ((base*4 * multip)/2);
        totales.add (base*4 * multic);
        
        //cesantias
        //totales.add(fijo3);
        //totales.add(((base*4 * multic * fijo3)/200));
        totales.add(((base*4 * multic * fijo3)/100));
        }
        else
        {
           int laborados =  pd.contarProducciones(id_empleado);
            totales.add ((base*4 * laborados)/730);
            totales.add ((base*4 * laborados)/360);
            totales.add ((base*4 * fijo3)/100);
        }

        rst.close();
        ps.close();
        conexion.close();

        rst = null;
        ps = null;
        conexion = null;

        return totales;
    }

}
