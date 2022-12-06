<%-- 
    Document   : guardarEmpleado.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="appnomina.capadatos.entidades.NominaMensual"%>
<%@page import="appnomina.capadatos.entidades.NominaEmpleado"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaMensualFacade" scope="page"></jsp:useBean>
    <jsp:useBean id="fachada1" class="appnomina.negocio.facade.NominaEmpleadoFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");

            //System.out.print("ojo1-idEmpleado2=" + idEmpleado3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);
            //System.out.print("" + ids3.toString() + " " + totales3.toString());
            String pagina = "";
            String msg3 = "";

            
            
            
            if (validar3.equals("1")) {
            
            
            
                String ids3[] = request.getParameter("ids2").toString().split(",");
                String primas3[] = request.getParameter("primas2").toString().split(",");
                String cesantias3[] = request.getParameter("cesantias2").toString().split(",");
                String icesantias3[] = request.getParameter("icesantias2").toString().split(",");
                String totales3[] = request.getParameter("totales2").toString().split(",");
                //String fechaf3 = request.getParameter("fechaf2");
                int idNomina3 = Integer.parseInt(request.getParameter("idNomina2"));
                String nuevo3 = request.getParameter("nuevo2");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaf3 = sdf.parse(request.getParameter("fechaf2"));
                java.sql.Date fecha3 = new java.sql.Date(fechaf3.getTime());
                
                
//                System.out.println("siiii");
                
                
                for (int i = 0; i < ids3.length; i++) {
                
                //System.out.println(""+ids3[i]);
                    
                    //Empleado e = new Empleado(Integer.parseInt(ids3[i]), "", "", "", "", "", "", c, 1);
                    NominaMensual p = new NominaMensual(idNomina3, "2-" + ids3[i] , fecha3);
                    msg3 = fachada.insertarNominaMensual(p, nuevo3);
                    
                    NominaEmpleado q = new NominaEmpleado(idNomina3, "2-" + ids3[i], Integer.parseInt(ids3[i]), 1, Integer.parseInt(totales3[i]) );
                    msg3 = fachada1.insertarNominaEmpleado(q, nuevo3);
                     //System.out.println(""+1);
                    
                     NominaEmpleado r = new NominaEmpleado(idNomina3, "2-" + ids3[i], Integer.parseInt(ids3[i]), 3, Integer.parseInt(primas3[i]) );
                     msg3 = fachada1.insertarNominaEmpleado(r, nuevo3);
                     //System.out.println(""+2);
                     
                     NominaEmpleado s = new NominaEmpleado(idNomina3, "2-" + ids3[i], Integer.parseInt(ids3[i]), 4, (Integer.parseInt(cesantias3[i]) + Integer.parseInt(icesantias3[i])) );
                     msg3 = fachada1.insertarNominaEmpleado(s, nuevo3);
                     //System.out.println(""+3);
                    
                    
                }
                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarMensual.jsp";
    %> 
    <div id="divGuardar" style="display: none;" class="alert alert-success">
        <%= msg3%>
    </div>
    <%
        }
        String msg4 = msg3.replace(" ", ".");
        {
    %>
    <input id="esto" style="display: none;" value =<%= pagina%> >
    <input id="esto1" style="display: none;" value = <%= msg4%> >

    <script>
        $("#box").load("pg-mensual/" + ($(esto).val()) + "?mens=" + ($(esto1).val()) + uneFechas(), function () {
        });
    </script>
    <%
                }
            }
        }
    %>
</html>