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
        <title>PRODUCCION</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val() + uneFechas(), function () {
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
        <%
            String fechax3 = request.getParameter("fechah2");
            int idEmpleado3 = Integer.parseInt(request.getParameter("idEmpleado"));


        %>

        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR PRODUCCION</h1>
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
                                    <label for="idProduccion" class="form-label">Id:</label>
                                    <input type="text" name="idProduccion" id="idProduccion" 
                                           placeholder="Ingrese el Id de la produccion" required
                                           class="form-control" required>
                                </div>
                            </th>


                        </tr> 

                        --%> 

                        <tr> 

                    <input name="idProduccion" id="idProduccion" style="display: none;" value = 0 >

                    <th>
                           <% Empleado empleado = fachada1.buscarEmpleado(idEmpleado3);

                            %>

                            <tr>
                                <th>
                                    <div class="form-group">
                                        <label for="idEmpleado1" class="form-label">Empleado:</label>
                                        <input type="text" name="idEmpleado1" id="idEmpleado1" 
                                               placeholder="Ingrese la produccion" readonly
                                               class="form-control" value = '<%= empleado.getCedula() + " - " + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%>'>
                                    
                                    <input  type="text" name="idEmpleado" id="idEmpleado" value = '<%= idEmpleado3%>' style="display: none">
                                    </div>
                                </th>
                            </tr>

                    <tr>
                        <th>
                            <div class="form-group">
                                <label for="produccion" class="form-label">Produccion:</label>
                                <input type="number" name="produccion" id="produccion" 
                                       placeholder="Ingrese la produccion"
                                       class="form-control" required autofocus>
                            </div>
                        </th>
                    </tr>

                    <tr>

                        <th>
                                <input  type="date" name="fecha" id="fecha" value = '<%= fechax3%>' style="display: none">
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
                    <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)" >
                    <button type="button" value="pg-produccion/listarProduccion.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
                </div>


            </form>
        </div>                    
    </body>
</html>