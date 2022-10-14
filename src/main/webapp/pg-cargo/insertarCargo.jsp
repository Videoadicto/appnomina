<%-- 
    Document   : insertarCargo.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.CargoFacade" scope="page"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Cargos</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val(), function () {
                    });
                });


                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        $("#boxInsertar").load("pg-cargo/guardarCargo.jsp?" + (validarDatosCargo(nuevo = 1)), function () {
                        });
                    });
                });
            </script>
        </head>

        <body>
            <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
                <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR CARGO</h1>
            </div>

            <div class="card-body">
                <form id="frmRegistrar" name="frmRegistrar">

                    <table class="table table-borderless">
                        <thead>
                        </thead>
                        <tbody>

                        <%--
                                                <tr>
                                                    <th>                        
                                                        <div class="form-group">
                                                            <label for="idCargo" class="form-label">Id:</label>
                                                            <input type="text" name="idCargo" id="idCargo" 
                                                                   placeholder="Ingrese el Id del cargo" required
                                                                   class="form-control" required>
                                                        </div>
                                                    </th>
                                                </tr>
                        --%> 
                    <input name="idCargo" id="idCargo" style="display: none;" value = 0 >

                    <tr>
                        <th>
                            <div class="form-group">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" 
                                       placeholder="Ingrese el nombre" required
                                       class="form-control" required>
                            </div>
                        </th>

                    </tr>                            

                    <tr>

                        <th>
                            <div class="form-group">
                                <label for="pago" class="form-label">Pago:</label>
                                <input type="text" name="pago" id="pago" 
                                       placeholder="Ingrese el valor del pago" required
                                       class="form-control" required>
                            </div>
                        <th>

                    </tr>


                    </tbody>
                </table>
                <br>

                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>

                <div id="boxInsertar">
                </div>

                <br>

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
                    <button type="button" value="pg-cargo/listarCargo.jsp?mens=0" class="btn btn-success">Regresar</button>
                </div>
            </form>
        </div>          
    </body>
</html>