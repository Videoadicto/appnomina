<%-- 
    Document   : guardarUsuario.jsp
    Created on : 13 may. 2021, 08:48:52
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Usuario"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="fachada" class="appnomina.negocio.facade.UsuarioFacade" scope="page"></jsp:useBean>
    <%
        if (true) {

            String validar3 = request.getParameter("validar2");
            
            //System.out.print("ojo1-idUsuario2=" + idUsuario3 + "&nombre2=" + nombre3 + "&precio2=" + precio3 + "&cantidad2=" + cantidad3 + "&iva2=" + iva3 + "&retencion2=" + retencion3 + "&cantidadMinima2=" + cantidadMinima3 + "&idCategoria2=" + idCategoria3 + "& nuevo2=" + nuevo3 + "&validar3=" + validar3);

            String pagina = "";
            String msg3 = "";
            if (validar3.equals("1")) {
            
            String nick3 = request.getParameter("nick2");
            String nombre3 = request.getParameter("nombre2");
            String password3 = request.getParameter("password2");
            int tipo3 = Integer.parseInt(request.getParameter("tipo2"));
            String nuevo3 = request.getParameter("nuevo2");            
            
                Usuario p = new Usuario(nick3, nombre3, password3, tipo3);
                msg3 = fachada.insertarUsuario(p, nuevo3);

                if (msg3.contains("Error")) {
    %> 
    <div id="divGuardar" class="alert alert-danger">
        <%= msg3%>
    </div>
    <% } else {
        pagina = "listarUsuario.jsp";
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
        $("#box").load("pg-usuario/" + ($(esto).val()) + "?mens=" + ($(esto1).val()), function () {
        });
    </script>
    <%
                }
            }
        }
    %>
</html>