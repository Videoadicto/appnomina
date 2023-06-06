<%-- 
    Document   : listarEmpleados
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- 
<%
    String msg = request.getParameter("msg");
    if (msg.contains("0")) {
        msg = "";
    }
%>
--%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Empleados</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>

            <script>
                $("button").click(function () {

                    $("#box").load(verificarPagina($(this).val()), function () {
                    });
                });
            </script>
        </head>

        <body>
            <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
                <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EMPLEADOS INACTIVOS</h1>
            </div>

            <br>

            <div class="card-body">
                <div class="table-responsive">
                    <table id="tablaEmpleados" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Cedula</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>Cargo</th>
                                <th>Opción</th>
                            </tr>                            
                        </thead>
                        <tbody>
                        <% for (Empleado empleado : fachada.buscarEmpleados()) {
                                int estado = empleado.getEstado();
                                String testado = "";

                                if (estado == 0) {
                                    testado = "INACTIVO";
                        %>
                        <tr>                               
                            <td><%= empleado.getCedula()%></td>
                            <td><%= (empleado.getNombre()).replace("_", " ")%></td>
                            <td><%= (empleado.getApellido()).replace("_", " ")%></td>
                            <td><%= empleado.getTelefono()%></td>
                            <td><%= (empleado.getIdCargo().getNombre()).replace("_", " ")%></td>
                            <td>
                                <button  class="item" style="border:none" value="pg-empleado/editarEmpleado.jsp?idEmpleado=<%= empleado.getId_empleado()%>">
                                    <img src="img/editar.png" width="16" height="16" >
                                </button>
                                <%-- 
                                                                <button  class="item" style="border:none" value="pg-empleado/eliminarEmpleado.jsp?idEmpleado=<%= empleado.getId_empleado()%>">
                                                                    <img src="img/borrar.png" alt="alt"/>
                                                                </button>
                                --%>
                            </td>
                        </tr>
                        <%
                                }
                            }
                            //System.out.println(session.getAttribute("rol").toString());
                        %>
                    </tbody>

                </table>
            </div>
            <%
                {
                    String mensa = (request.getParameter("mens")).replace(".", " ");
                    if (mensa.equals("0")) {

                        mensa = "";
                    } else {
            %>

            <script>
                aparecerDiv("divListar");
            </script>

            <div id="divListar" style="display: none;" class="alert alert-success">
                <%= mensa%>
            </div>
            <%
                    }
                }
            %>

            <div id="boxListar">
            </div>    

            <div class="card-footer">
            </div>

            <div class="form-group">
                <button type="button" value="pg-empleado/listarEmpleado.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
            </div>

            <script src="js/dataTable/dataTables.buttons.min.js"></script>
            <script src="js/dataTable/buttons.flash.min.js"></script>
            <script src="js/dataTable/jszip.min.js"></script>
            <script src="js/dataTable/pdfmake.min.js"></script>
            <script src="js/dataTable/vfs_fonts.js"></script>
            <script src="js/dataTable/buttons.html5.min.js"></script>
            <script src="js/dataTable/buttons.print.min.js"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#tablaEmpleados').DataTable({
                        pageLength: 5,
                        dom: 'Bfrtip',
                        buttons: [
                            'copy', 'csv', 'excel', 'pdf', 'print'
                        ]
                    });
                });
            </script>
        </div>
    </body>
</html>