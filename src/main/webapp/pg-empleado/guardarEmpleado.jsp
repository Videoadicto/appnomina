<%-- 
    Document   : guardarEmpleado.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");
            
            //System.out.print("ojo1-idEmpleado2=" + idEmpleado3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);

            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {
            
            int idEmpleado3 = Integer.parseInt(request.getParameter("idEmpleado2"));
            String nombre3 = request.getParameter("nombre2");
            String apellido3 = request.getParameter("apellido2");
            String cedula3 = request.getParameter("cedula2");
            String fechanac3 = request.getParameter("fechanac2");
            String telefono3 = request.getParameter("telefono2");
            String eps3 = request.getParameter("eps2");
            int idCargo3 = Integer.parseInt(request.getParameter("idCargo2"));
            int estado3 = Integer.parseInt(request.getParameter("estado2"));
            String nuevo3 = request.getParameter("nuevo2");            
            
                Cargo c = new Cargo(idCargo3, "", 0,1);
                Empleado p = new Empleado(idEmpleado3, nombre3, apellido3, cedula3, fechanac3, telefono3, eps3, c, estado3);

                msg3 = fachada.insertarEmpleado(p, nuevo3);

                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarEmpleado.jsp";
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
        $("#box").load("pg-empleado/" + ($(esto).val()) + "?mens=" + ($(esto1).val()), function () {
        });
    </script>
    <%
                }
            }
        }
    %>
</html>