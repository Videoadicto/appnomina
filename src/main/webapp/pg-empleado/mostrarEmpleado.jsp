<%-- 
    Document   : editarEmpleado.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade" scope="page"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <script>

                $(document).ready(function () {

                    $("#btnCancelar").click(function () {
                        $("#box").load("pg-empleado/listarEmpleado.jsp?mens=0", function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

        Empleado empleado = fachada.buscarEmpleado(idEmpleado);

        if (empleado != null) {
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">INFORMACION DEL EMPLEADO</h1>
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
                                    <label for="idCategoria" class="form-label">Categoria:</label>
                                    <input type="text" name="idCategoria" id="idCategoria" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value="<%= (empleado.getIdCargo().getNombre()).replace("_", " ")%>">
                                </div>
                            </th>
                        </tr>                            

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="nombre" class="form-label">Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" 
                                           placeholder="Ingrese el nombre" required
                                           class="form-control" readonly
                                           value = "<%= (empleado.getNombre()).replace("_", " ")%>">
                                </div>
                            </th>


                            <th>
                                <div class="form-group">
                                    <label for="apellido" class="form-label">Apellido:</label>
                                    <input type="text" name="apellido" id="apellido" 
                                           placeholder="Ingrese el apellido" required
                                           class="form-control" readonly
                                           value = "<%= (empleado.getApellido()).replace("_", " ")%>">
                                </div>
                            </th>

                        </tr>

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="cedula" class="form-label">Cedula:</label>
                                    <input type="text" name="cedula" id="cedula" 
                                           placeholder="Ingrese la cedula" required
                                           class="form-control" readonly
                                           value = "<%= empleado.getCedula()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="eps" class="form-label">EPS</label>
                                    <input type="text" name="eps" id="eps" 
                                           placeholder="Ingrese la EPS" required
                                           class="form-control" readonly
                                           value = "<%= (empleado.getEps()).replace("_", " ")%>">
                                </div>
                            </th>
                        </tr>                                          

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="telefono" class="form-label">Telefono:</label>
                                    <input type="text" name="telefono" id="telefono" 
                                           placeholder="Ingrese el telefono" required
                                           class="form-control" readonly
                                           value = "<%= empleado.getTelefono()%>">
                                </div>
                            </th>

                            <th>
                                <div class="form-group">
                                    <label for="fechanac" class="form-label">Fecha de Nacimiento:</label>
                                    <input type="text" name="fechanac" id="fechanac" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value="<%= empleado.getFecha_nacimiento()%>">
                                </div>
                            </th>

                        </tr>

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="estado" class="form-label">Estado:</label>
                                    <%{
                                            String etd = "";
                                            if (empleado.getEstado() == 1) {
                                                etd = "ACTIVO";
                                            } else {
                                                etd = "INACTIVO";
                                            }
                                    %>
                                    <input type="text" name="estado" id="estado" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value = "<%= etd%>">
                                    <%
                                        }
                                    %>
                                </div>
                            </th>
                        </tr>

                        <tr>                               
                            <th>
                                <div class="form-group">
                                    <input type="button" id="btnCancelar" value="Regresar" class="btn" style="background:rgb(0, 195, 255)">
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
        <%
            }
        %>
    </body>
</html>