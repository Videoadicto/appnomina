<%-- 
    Document   : editarUsuario.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Usuario"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.UsuarioFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada2" class="appnomina.negocio.facade.CargoFacade"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Usuarios</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val(), function () {
                    });
                });


                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        $("#boxEditar").load("pg-usuario/guardarUsuario.jsp?" + (validarDatosUsuario(nuevo = 0)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        String nick = request.getParameter("nick");

        Usuario usuario = new Usuario();
        usuario.setNick(nick);

        usuario = fachada.buscarUsuario(nick);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR USUARIO</h1>
        </div>

        <div class="card-body">
            <%
                if (usuario != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">
                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="nick" class="form-label">Usuario:</label>
                                    <input type="text" name="nick" id="nick" 
                                           placeholder="" readonly
                                           class="form-control" 
                                           value = "<%= usuario.getNick()%>">
                                </div>
                            </th>
                        </tr>                            

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="nombre" class="form-label">Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" 
                                           placeholder="Ingrese el nombre" required
                                           class="form-control" 
                                           value = "<%= (usuario.getNombre()).replace("_", " ")%>">
                                </div>
                            </th>
                        </tr>

                        <tr>

                            <th>
                                <div class="form-group">
                                    <label for="password" class="form-label">Contraseña:</label>
                                    <input type="text" name="password" id="password" 
                                           placeholder="Ingrese la nueva contraseña" required
                                           class="form-control" 
                                           value = "">
                                </div>
                            </th>
                            
                            <input name="tipo" id="tipo" style="display: none;" value = "<%= usuario.getTipo()%>" >
                        </tr>

                        <tr>                               
                            <th>
                                <div id="boxEditar">
                                </div>

                                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                                </div>

                                <div class="form-group">
                                    <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)" >
                                    <button type="button" value="pg-usuario/listarUsuario.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
                                </div>
                            </th>
                            <th>

                            </th>
                        </tr> 
                    </tbody>
                </table>
            </form>

            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Usuario no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>