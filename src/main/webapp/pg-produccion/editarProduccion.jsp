<%-- 
    Document   : editarProduccion.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Produccions</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val(), function () {
                    });
                });


                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        $("#boxEditar").load("pg-produccion/guardarProduccion.jsp?" + (validarDatosProduccion(nuevo = 0)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idProduccion = Integer.parseInt(request.getParameter("idProduccion"));

        Produccion produccion = new Produccion();
        produccion.setId_produccion(idProduccion);

        produccion = fachada.buscarProduccion(idProduccion);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR PRODUCCION</h1>
        </div>

        <div class="card-body">
            <%
                if (produccion != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">
                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idProduccion" class="form-label">Id:</label>
                                    <input type="text" name="idProduccion" id="idProduccion" 
                                           placeholder="Ingrese el Id de la produccion" required
                                           class="form-control" readonly
                                           value = "<%= produccion.getId_produccion()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Cargo:</label>
                                    <select id="idEmpleado" name="idEmpleado" class="form-control" selected="Empleado">
                                        <% for (Empleado empleado : fachada2.buscarEmpleados()) {
                                        %>

                                        <option value="<%= empleado.getId_empleado()%>"> <%= empleado.getCedula() + "-" + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </th>
                        </tr>                            

                        <tr>       
                            
                             <th>
                                <div class="form-group">
                                    <label for="produccion" class="form-label">Produccion:</label>
                                    <input type="text" name="produccion" id="produccion" 
                                           placeholder="Ingrese la cedula" required
                                           class="form-control" 
                                           value = "<%= produccion.getProduccion()%>">
                                </div>
                            </th>
                            
                            <th>
                                <div class="form-group">
                                   <label for="fecha" class="form-label">Fecha:</label>
                                   <br>
                                    <input type="date" name="fecha" id="fecha" value="<%= produccion.getFecha()%>" style="width: 200px; vertical-align:10px">
                                </div>
                            </th>
                           
                        </tr>

                        <tr>                               
                            <th>
                                <div id="boxEditar">
                                </div>

                                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                                </div>   

                                <div class="form-group">
                                    <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
                                    <button type="button" value="pg-produccion/listarProduccion.jsp?mens=0" class="btn btn-success">Regresar</button>
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
                Error: Produccion no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>