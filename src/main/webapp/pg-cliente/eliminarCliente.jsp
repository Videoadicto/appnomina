<%-- 
    Document   : guardarCliente.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>
<%@page import="javax.swing.text.html.parser.Element"%>
<%@page import="appnomina.capadatos.entidades.Cliente"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ClienteFacade" scope="page"></jsp:useBean>
        </head>
        <body>
        <%
            String sino = request.getParameter("sn");

            if (sino.contains("true")) {

                String cedula = request.getParameter("cedula");
                Cliente p = fachada.buscarCliente(cedula);

                if (p != null) {
                    String msg = fachada.eliminarCliente(cedula);
                    String msg4 = msg.replace(" ", ".");
        %>
        <input id="esto1" style="display: none;" value = <%= msg4%> >
        <script>
            $("#box").load("pg-cliente/listarCliente.jsp?mens=" + ($(esto1).val()), function () {
            });
        </script>
        <%
            }
        } else {
        %>
        <script>
            $("#box").load("pg-cliente/listarCliente.jsp?mens=Se.ha.cancelado.la.operacion", function () {
            });
        </script>
        <%    }
        %>
    </body>
</html>