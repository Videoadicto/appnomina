<%-- 
    Document   : editarFijos.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Fijos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.FijosFacade" scope="page"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Fijoss</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val(), function () {
                    });
                });

                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        $("#boxEditar").load("pg-fijos/guardarFijos.jsp?" + (validarDatosFijos(nuevo = 0)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idFijos = Integer.parseInt(request.getParameter("idFijos"));

        Fijos fijos = new Fijos();
        fijos.setId_fijos(idFijos);

        fijos = fachada.buscarFijos(idFijos);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR FIJOS</h1>
        </div>

        <div class="card-body">
            <%
                if (fijos != null) {
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
                                                            <label for="idFijos" class="form-label">Id:</label>
                                                            <input type="text" name="idFijos" id="idFijos" 
                                                                   placeholder="Ingrese el Id del fijos" required
                                                                   class="form-control" readonly
                                                                   value = "<%= fijos.getId_fijos()%>">
                                                        </div>

                            </th>
                        </tr>
%--%> 
                    <input name="idFijos" id="idFijos" style="display: none;" value ="<%= fijos.getId_fijos()%>" >

                    <tr>
                        <th>  
                            <div class="form-group">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" 
                                       placeholder="Ingrese el nombre" required
                                       class="form-control" 
                                       value = "<%= (fijos.getNombre()).replace("_", " ")%>">
                            </div>
                    </tr>

                    <tr>
                        <th>
                            <div class="form-group">
                                <label for="pago" class="form-label">Pago:</label>
                                <input type="text" name="pago" id="pago" 
                                       placeholder="Ingrese el valor del pago" required
                                       class="form-control"
                                       value = "<%= fijos.getPago()%>">
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
                    <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)" >
                    <button type="button" value="pg-fijos/listarFijos.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
                </div>

            </form>
            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Fijos no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>