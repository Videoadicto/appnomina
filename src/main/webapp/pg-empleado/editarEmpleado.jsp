<%-- 
    Document   : editarEmpleado.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada2" class="appnomina.negocio.facade.CargoFacade"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Empleados</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val(), function () {
                    });
                });


                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        $("#boxEditar").load("pg-empleado/guardarEmpleado.jsp?" + (validarDatosEmpleado(nuevo = 0)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

        Empleado empleado = new Empleado();
        empleado.setId_empleado(idEmpleado);

        empleado = fachada.buscarEmpleado(idEmpleado);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR EMPLEADO</h1>
        </div>

        <div class="card-body">
            <%
                if (empleado != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">
                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Id:</label>
                                    <input type="text" name="idEmpleado" id="idEmpleado" 
                                           placeholder="Ingrese el Id del empleado" required
                                           class="form-control" readonly
                                           value = "<%= empleado.getId_empleado()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="idCargo" class="form-label">Cargo:</label>
                                    <select id="idCargo" name="idCargo" class="form-control" >
                                        <%
                                            for (Cargo cargo : fachada2.buscarCargos()) {
                                        %>
                                        <option value="<%= cargo.getId_cargo()%>" <%if ((empleado.getIdCargo().getId_cargo()) == (cargo.getId_cargo())) {%> selected <%}%>  > <%= (cargo.getNombre()).replace("_", " ")%> </option>
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
                                    <label for="nombre" class="form-label">Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" 
                                           placeholder="Ingrese el nombre" required
                                           class="form-control" 
                                           value = "<%= (empleado.getNombre()).replace("_", " ")%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="apellido" class="form-label">Apellido:</label>
                                    <input type="text" name="apellido" id="apellido" 
                                           placeholder="Ingrese el apellido" required
                                           class="form-control" 
                                           value = "<%= empleado.getApellido()%>">
                                </div>
                            </th>
                        </tr>

                        <tr>

                            <th>
                                <div class="form-group">
                                    <label for="cedula" class="form-label">Cedula:</label>
                                    <input type="text" name="cedula" id="cedula" 
                                           placeholder="Ingrese la cedula" required
                                           class="form-control" 
                                           value = "<%= empleado.getCedula()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="eps" class="form-label">EPS</label>
                                    <input type="text" name="eps" id="eps" 
                                           placeholder="Ingrese la EPS" required
                                           class="form-control" 
                                           value = "<%= empleado.getEps()%>">
                                </div>
                            </th>
                        </tr>                                          

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="telefono" class="form-label">Telefono:</label>
                                    <input type="text" name="telefono" id="telefono" 
                                           placeholder="Ingrese el telefono" required
                                           class="form-control" 
                                           value = "<%= empleado.getTelefono()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="fechanac" class="form-label">Fecha de Nacimiento:</label>
                                    <div class="form-group">
                                        <input type="date" name="fechanac" id="fechanac" value="<%= empleado.getFecha_nacimiento()%>" style="width: 200px; vertical-align:10px">
                                    </div>
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
                                    <button type="button" value="pg-empleado/listarEmpleado.jsp?mens=0" class="btn btn-success">Regresar</button>
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
                Error: Empleado no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>