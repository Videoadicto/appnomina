<%-- 
    Document   : guardarCargo.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>
<%@page import="javax.swing.text.html.parser.Element"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.CargoFacade" scope="page"></jsp:useBean>
        </head>
        <body>
        <%
            String sino = request.getParameter("sn");

            if (sino.contains("true")) {

                int idCargo = Integer.parseInt(request.getParameter("idCargo"));
                Cargo p = fachada.buscarCargo(idCargo);

                if (p != null) {
                    String msg = fachada.eliminarCargo(idCargo);
                    String msg4 = msg.replace(" ", ".");
        %>
        <input id="esto1" style="display: none;" value = <%= msg4%> >
        <script>
            $("#box").load("pg-cargo/listarCargo.jsp?mens=" + ($(esto1).val()), function () {
            });
        </script>
        <%
            }
        } else {
        %>
        <script>
            $("#box").load("pg-cargo/listarCargo.jsp?mens=Se.ha.cancelado.la.operacion", function () {
            });
        </script>
        <%    }
        %>
    </body>
</html>