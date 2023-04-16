<%-- 
    Document   : insertarEmpleado.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>

<%-- <%@page import="appnomina.capadatos.entidades.Empleado"%> --%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.CargoFacade"></jsp:useBean> --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val(), function () {
                });
            });


            $(document).ready(function () {
                $("#btnGuardar").click(function () {
                    $("#boxInsertar").load("pg-empleado/guardarEmpleado.jsp?" + (validarDatosEmpleado(nuevo = 1)), function () {
                    });
                });
            });
        </script>
    </head>

    <body>
        <%
            String fechaf3 = request.getParameter("fechaf3");
        %>
        
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR EMPLEADO</h1>
        </div>

        <div class="card-body">
            <form id="frmRegistrar" name="frmRegistrar">

                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>

                        <tr>
                            <%--
                            <th>                        
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Id:</label>
                                    <input type="text" name="idEmpleado" id="idEmpleado" 
                                           placeholder="Ingrese el Id del empleado" required
                                           class="form-control" required>
                                </div>
                            </th>
                            --%> 

                    <input name="idEmpleado" id="idEmpleado" style="display: none;" value = 0 >

                    <th>
                        <div class="form-group">
                            <label for="cedula" class="form-label">Cedula:</label>
                            <input type="text" name="cedula" id="cedula" 
                                   placeholder="Ingrese la cedula" required
                                   class="form-control" required>
                        </div>
                    </th>

                    <th>
                        <div class="form-group">
                            <label for="idCargo">Cargo:</label>
                            <select id="idCargo" name="idCargo" required class="form-control">
                                <option value="" selected >  </option>
                                <%
                                    for (Cargo cargo : fachada.getCargo()) {
                                    if (cargo.getEstado() == 1) {

                                %>
                                <option value="<%= cargo.getId_cargo()%>"> <%= (cargo.getNombre()).replace("_", " ")%></option>
                                <%
                                    }
                                    }
                                %>
                            </select>
                        </div>
                    </th>

                    </tr>                            

                    <tr>

                        <th>
                            <div class="form-group">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" 
                                       placeholder="Ingrese el nombre" required
                                       class="form-control" required>
                            </div>
                        </th>

                        <th>
                            <div class="form-group">
                                <label for="apellido" class="form-label">Apellido:</label>
                                <input type="text" name="apellido" id="apellido" 
                                       placeholder="Ingrese el apellido" required
                                       class="form-control" required>
                            </div>
                        </th>

                    </tr>

                    <tr>                               

                        <th>
                            <div class="form-group">
                                <label for="telefono" class="form-label">Telefono:</label>
                                <input type="text" name="telefono" id="telefono" 
                                       placeholder="Ingrese el telefono" required
                                       class="form-control" required>
                            </div>
                        </th>

                        <th>
                            <div class="form-group">
                                <label for="eps" class="form-label">EPS:</label>
                                <input type="text" name="eps" id="eps" 
                                       placeholder="Ingrese la EPS" required
                                       class="form-control" required>
                            </div>
                        </th>

                    </tr>                                       

                    <tr>



                        <th>
                            <div class="form-group">
                                <label for="fechanac" class="form-label">Fecha de Vinculacion:</label>
                                <br>
                                <input type="date" name="fechanac" id="fechanac" value="<%= fechaf3%>" style="width: 200px; vertical-align:10px">
                            </div>
                        </th>
                        
                        <th>
                            <div class="form-group">
                                <input type="text" name="estado" id="estado" 
                                value="1" style="display: none;">
                            </div>
                        </th>
                   </tr>   

                    <tr>                               
                        <th>
                            <div id="divInsertar" style="display: none;" class="alert alert-danger">
                            </div>

                            <div id="boxInsertar">
                            </div>

                            <div class="form-group">
                                <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)">
                                <button type="button" value="pg-empleado/listarEmpleado.jsp?mens=0&fechah2=<%=fechaf3%>" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
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