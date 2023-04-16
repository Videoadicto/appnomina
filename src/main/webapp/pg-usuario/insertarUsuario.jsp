<%-- 
    Document   : insertarUsuario.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>

<%-- <%@page import="appnomina.capadatos.entidades.Usuario"%> --%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.UsuarioFacade" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.CargoFacade"></jsp:useBean> --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val(), function () {
                });
            });


            $(document).ready(function () {
                $("#btnGuardar").click(function () {
                    $("#boxInsertar").load("pg-usuario/guardarUsuario.jsp?" + (validarDatosUsuario(nuevo = 1)), function () {
                    });
                });
            });
        </script>
    </head>

    <body>
       
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR USUARIO</h1>
        </div>

        <div class="card-body">
            <form id="frmRegistrar" name="frmRegistrar">

                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="nick" class="form-label">Nick</label>
                                    <input type="text" name="nick" id="nick" 
                                           placeholder="Ingrese el nick" required
                                           class="form-control" 
                                           value = "">
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
                                           value = "">
                                </div>
                            </th>
                        </tr>

                        <tr>

                            <th>
                                <div class="form-group">
                                    <label for="password" class="form-label">Contraseña</label>
                                    <input type="text" name="password" id="password" 
                                           placeholder="Ingrese la contraseña" required
                                           class="form-control" 
                                           value = "">
                                </div>
                            </th>
                            
                            <input name="tipo" id="tipo" style="display: none;" value = "0" >
                        </tr>                          

                        <tr>                               
                        <th>
                            <div id="divInsertar" style="display: none;" class="alert alert-danger">
                            </div>

                            <div id="boxInsertar">
                            </div>

                            <div class="form-group">
                                <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)">
                                <button type="button" value="pg-usuario/listarUsuario.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
                            </div>
                        </th>
                        <th>

                        </th>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>                    
    </body>
</html>