<%-- 
    Document   : guardarCargo.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Fijos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.FijosFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");
            
            //System.out.print("ojo1-idCargo2=" + idCargo3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCargo2=" + idCargo3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);

            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {
            
            int id3 = Integer.parseInt(request.getParameter("id2"));
            int eps3 = Integer.parseInt(request.getParameter("eps2"));
            int transporte3 = Integer.parseInt(request.getParameter("transporte2"));
            String nuevo3 = request.getParameter("nuevo2");
            
            //System.out.print("eps3=" + eps3 + "&transporte3=" + transporte3 + "&nuevo3=" + nuevo3 + "&validar3=" + validar3);
            
                Fijos p = new Fijos(id3, eps3, transporte3);
                msg3 = fachada.insertarFijos(p, nuevo3);

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