<%-- 
    Document   : guardarCargo.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.CargoFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            int idCargo3 = Integer.parseInt(request.getParameter("idCargo2"));
            String nombre3 = request.getParameter("nombre2");
            int pago3 = Integer.parseInt(request.getParameter("pago2"));
            String validar3 = request.getParameter("validar2");
            String nuevo3 = request.getParameter("nuevo2");
            //System.out.print("ojo1-idCargo2=" + idCargo3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCargo2=" + idCargo3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);


            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {
                Cargo p = new Cargo(idCargo3, nombre3, pago3);
                msg3 = fachada.insertarCargo(p, nuevo3);

                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarCargo.jsp";
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
        $("#box").load("pg-cargo/" + ($(esto).val()) + "?mens=" + ($(esto1).val()), function () {
        });
    </script>
    <%
                }
            }
        }
    %>
</html>