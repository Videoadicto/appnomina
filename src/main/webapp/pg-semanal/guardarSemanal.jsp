<%-- 
    Document   : guardarEmpleado.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.NominaSemanal"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaSemanalFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");

            //System.out.print("ojo1-idEmpleado2=" + idEmpleado3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);
            //System.out.print("" + ids3.toString() + " " + totales3.toString());
            String pagina = "";
            String msg3 = "";

            if (validar3.equals("1")) {

                String ids3[] = request.getParameter("ids2").toString().split(",");
                String totales3[] = request.getParameter("totales2").toString().split(",");
                String fechaf3 = request.getParameter("fechaf2");
                int idNomina3 = Integer.parseInt(request.getParameter("idNomina2"));
                String nuevo3 = request.getParameter("nuevo2");

                for (int i = 0; i < ids3.length; i++) {
                    Cargo c = new Cargo(0, "", 0);
                    Empleado e = new Empleado(Integer.parseInt(ids3[i]), "", "", "", "", "", "", c, 1);
                    NominaSemanal p = new NominaSemanal(idNomina3, e, fechaf3, Integer.parseInt(totales3[i]));
                    msg3 = fachada.insertarNominaSemanal(p, nuevo3);
                }
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