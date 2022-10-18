<%-- 
    Document   : guardarProduccion.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Semanal"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.SemanalFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            int idSemanal3 = Integer.parseInt(request.getParameter("idSemanal2"));
            
            int idProduccion3 = Integer.parseInt(request.getParameter("idProduccion2"));
            String fecha3 = request.getParameter("fecha2");
            int semanal3 = Integer.parseInt(request.getParameter("semanal2"));
            
            String validar3 = request.getParameter("validar2");
            String nuevo3 = request.getParameter("nuevo2");
            //System.out.print("ojo1-idProduccion2=" + idProduccion3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);


            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {
                Cargo c = new Cargo (0, "", 0);
                Produccion e = new Produccion(idProduccion3, "", "", "", "", "", "", c);
                Semanal p = new Semanal(idSemanal3, e, fecha3, semanal3);
                msg3 = fachada.insertarSemanal(p, nuevo3);

                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarSemanal.jsp";
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
        $("#box").load("pg-semanal/" + ($(esto).val()) + "?mens=" + ($(esto1).val()) + uneFechas(), function () {
        });
    </script>
    <%
                }
            }
        }
    %>
</html>