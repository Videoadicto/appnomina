<%-- 
    Document   : insertarProduccion.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>

<%-- <%@page import="appnomina.capadatos.entidades.Produccion"%> --%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean> --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCCIONES</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val(), function () {
                });
            });


            $(document).ready(function () {
                $("#btnGuardar").click(function () {
                    $("#boxInsertar").load("pg-produccion/guardarProduccion.jsp?" + (validarDatosProduccion(nuevo = 1)), function () {
                    });
                });
            });
        </script>
    </head>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR PRODUCCION</h1>
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
                                    <label for="idProduccion" class="form-label">Id:</label>
                                    <input type="text" name="idProduccion" id="idProduccion" 
                                           placeholder="Ingrese el Id del produccion" required
                                           class="form-control" required>
                                </div>
                            </th>


                        </tr>                            

                        <tr> 

                            <th>
                                <div class="form-group">
                                    <label for="idEmpleado">Empleado:</label>
                                    <select id="idEmpleado" name="idEmpleado" required class="form-control">
                                        <option value="" selected >  </option>
                                        <%
                                            for (Empleado empleado : fachada1.buscarEmpleados()) {
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
                                           placeholder="Ingrese la produccion" required
                                           class="form-control" required>
                                </div>
                            </th>
                        </tr>

                        <tr>

                            <th>
                                <div class="form-group">
                                    <label for="fecha" class="form-label">Fecha:</label>
                                    <br>
                                    <input type="date" name="fecha" id="fecha" style="width: 200px; vertical-align:10px">
                                </div>
                            </th>
                        </tr>


                    </tbody>
                </table>


                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>

                <div id="boxInsertar">
                </div>

                <br>

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
                    <button type="button" value="pg-produccion/listarProduccion.jsp?mens=0" class="btn btn-success">Regresar</button>
                </div>


            </form>
        </div>                    
    </body>
</html>