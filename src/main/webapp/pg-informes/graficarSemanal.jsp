<%-- 
    Document   : guardarEmpleado.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");

            //System.out.print("ojo1-idEmpleado2=" + idEmpleado3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);
            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {

                int idEmpleado3 = Integer.parseInt(request.getParameter("idEmpleado2"));
                
                String fechai3 = request.getParameter("fechai1");
                String fechaf3 = request.getParameter("fechaf1");
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechax = sdf.parse(request.getParameter("fecha2"));
                java.sql.Date fecha3 = new java.sql.Date(fechax.getTime());
                
                //String fecha3 = request.getParameter("fecha2");
                

                 for (Produccion produccion : fachada.buscarProduccionesFechasEmpleado(idEmpleado3, fechai3,  fechaf3)) {
                
                 
                 
                
                //msg3 = fachada.insertarProduccion(p, nuevo3);

                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarProduccion.jsp";
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
        $("#box").load("pg-produccion/" + ($(esto).val()) + "?mens=" + ($(esto1).val()) + uneFechas(), function () {
        });
    </script>
    <%
                }
            }
        }
}
    %>
</html>