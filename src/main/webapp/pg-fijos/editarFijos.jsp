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
        //int idFijos = Integer.parseInt(request.getParameter("idFijos"));

        Fijos fijos = new Fijos();
        fijos = fachada.buscarFijos();
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
                    <tr>
                        <th>  
                            <div class="form-group">
                                <label for="eps" class="form-label">Eps:</label>
                                <input type="text" name="eps" id="eps" 
                                       placeholder="Ingrese el % de la EPS" required
                                       class="form-control" 
                                       value = "<%= (fijos.getEps())%>">
                            </div>
                    </tr>

                    <tr>
                        <th>
                            <div class="form-group">
                                <label for="transporte" class="form-label">Subsidio de transporte:</label>
                                <input type="text" name="transporte" id="transporte" 
                                       placeholder="Ingrese el subsidio de transporte" required
                                       class="form-control"
                                       value = "<%= fijos.getTransporte()%>">
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
                    <button type="button" value="pg-semanal/listarSemanal.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
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