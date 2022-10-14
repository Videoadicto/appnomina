<%-- 
    Document   : editarCargo.jsp
    Created on : 7 abr. 2022, 13:55:08
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
                        $("#boxEditar").load("pg-cargo/guardarCargo.jsp?" + (validarDatosCargo(nuevo = 0)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));

        Cargo cargo = new Cargo();
        cargo.setId_cargo(idCargo);

        cargo = fachada.buscarCargo(idCargo);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR CARGO</h1>
        </div>

        <div class="card-body">
            <%
                if (cargo != null) {
            %>
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
                                                                   class="form-control" readonly
                                                                   value = "<%= cargo.getId_cargo()%>">
                                                        </div>

                            </th>
                        </tr>
%--%> 
                    <input name="idCargo" id="idCargo" style="display: none;" value ="<%= cargo.getId_cargo()%>" >

                    <tr>
                        <th>  
                            <div class="form-group">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" 
                                       placeholder="Ingrese el nombre" required
                                       class="form-control" 
                                       value = "<%= (cargo.getNombre()).replace("_", " ")%>">
                            </div>
                    </tr>

                    <tr>
                        <th>
                            <div class="form-group">
                                <label for="pago" class="form-label">Pago:</label>
                                <input type="text" name="pago" id="pago" 
                                       placeholder="Ingrese el valor del pago" required
                                       class="form-control"
                                       value = "<%= cargo.getPago()%>">
                            </div>
                        </th>
                    </tr>

                    </tbody>
                </table> 

                <br>

                <div id="boxEditar">
                </div>

                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>   

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
                    <button type="button" value="pg-cargo/listarCargo.jsp?mens=0" class="btn btn-success">Regresar</button>
                </div>

            </form>
            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Cargo no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>