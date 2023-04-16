<%-- 
    Document   : guardarUsuario.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>
<%@page import="javax.swing.text.html.parser.Element"%>
<%@page import="appnomina.capadatos.entidades.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.UsuarioFacade" scope="page"></jsp:useBean>
        </head>
        <body>
        <%
            String sino = request.getParameter("sn");

            if (sino.contains("true")) {

                String nick =request.getParameter("nick");
                Usuario p = fachada.buscarUsuario(nick);

                if (p != null) {
                    String msg = fachada.eliminarUsuario(nick);
                    String msg4 = msg.replace(" ", ".");
        %>
        <input id="esto1" style="display: none;" value = <%= msg4%> >
        <script>
            $("#box").load("pg-usuario/listarUsuario.jsp?mens=" + ($(esto1).val()), function () {
            });
        </script>
        <%
            }
        } else {
        %>
        <script>
            $("#box").load("pg-usuario/listarUsuario.jsp?mens=Se.ha.cancelado.la.operacion", function () {
            });
        </script>
        <%    }
        %>
    </body>
</html>