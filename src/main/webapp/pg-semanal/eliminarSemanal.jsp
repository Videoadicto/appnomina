<%-- 
    Document   : guardarSemanal.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>
<%@page import="javax.swing.text.html.parser.Element"%>
<%@page import="appnomina.capadatos.entidades.NominaSemanal"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaSemanalFacade" scope="page"></jsp:useBean>
        </head>
        <body>
        <%
            String sino = request.getParameter("sn");

            if (sino.contains("true")) {

                int idSemanal = Integer.parseInt(request.getParameter("idSemanal"));
                NominaSemanal p = fachada.buscarNominaSemanal(idSemanal);

                if (p != null) {
                    String msg = fachada.eliminarNominaSemanal(idSemanal);
                    String msg4 = msg.replace(" ", ".");
        %>
        <input id="esto1" style="display: none;" value = <%= msg4%> >
        <script>
            $("#box").load("pg-semanal/listarSemanal.jsp?mens=" + ($(esto1).val()) + uneFechas(), function () {
            });
        </script>
        <%
            }
        } else {
        %>
        <script>
            $("#box").load("pg-semanal/listarSemanal.jsp?mens=Se.ha.cancelado.la.operacion" + uneFechas(), function () {
            });
        </script>
        <%    }
        %>
    </body>
</html>