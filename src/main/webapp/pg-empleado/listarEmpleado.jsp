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
                <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EMPLEADOS</h1>
            </div>

            <table class="table table-borderless">
                <thead>
                    <tr>
                        <th>
                        <%--            <button class="btn" onclick="location.href = 'empleadoForm.html'" style="top : 15%; left : 87%; position:relative"> --%>
                        <button class="btn" id="nuevo" value="pg-empleado/insertarEmpleado.jsp" style="background:rgb(0, 195, 255);left : 1.2%; position:relative;">
                            <i class="fa fa-toolbox" >
                            </i> Agregar Empleado
                        </button>
                    </th>

                    <th>
                        <div>
                            <button class="btn" id="btnBuscar" title="Inactivos" value="pg-fijos/editarFijos.jsp?mens=0" style="width:3em; background:rgb(0, 195, 255);left : 0%; position:relative;">
                                <i class="fa fa-trash-alt" >
                                </i>
                            </button>
                        </div>
                    </th>
                </tr>
            </thead>
        </table>

        <div class="card-body">
            <div class="table-responsive">
                <table id="tablaEmpleados" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Cedula</th>
                            <th>Telefono</th>
                            <th>Cargo</th>
                            <th>Estado</th>
                            <th>Opción</th>
                        </tr>                            
                    </thead>
                    <tbody>
                        <% for (Empleado empleado : fachada.buscarEmpleados()) {
                                int estado = empleado.getEstado();
                                String testado = "";

                                if (estado == 1) {
                                    testado = "ACTIVO";
                                } else {
                                    testado = "INACTIVO";
                                }

                        %>
                        <tr>                               
                            <td><%= empleado.getId_empleado()%></td>
                            <td><%= (empleado.getNombre()).replace("_", " ")%></td>
                            <td><%= (empleado.getApellido()).replace("_", " ")%></td>
                            <td><%= empleado.getCedula()%></td>
                            <td><%= empleado.getTelefono()%></td>
                            <td><%= (empleado.getIdCargo().getNombre()).replace("_", " ")%></td>
                            <td><%= testado%></td>

                            <td>
                                <button  class="item" style="border:none" value="pg-empleado/editarEmpleado.jsp?idEmpleado=<%= empleado.getId_empleado()%>">
                                    <img src="img/editar.png" width="16" height="16" >
                                </button>

                                <button  class="item" style="border:none" value="pg-empleado/mostrarEmpleado.jsp?idEmpleado=<%= empleado.getId_empleado()%>">
                                    <img src="img/info.png" alt="alt"/>
                                </button>

                                <button  class="item" style="border:none" value="pg-empleado/eliminarEmpleado.jsp?idEmpleado=<%= empleado.getId_empleado()%>">
                                    <img src="img/borrar.png" alt="alt"/>
                                </button>
                            </td>
                        </tr>
                        <%
                            }
                            //System.out.println(session.getAttribute("rol").toString());
                        %>
                    </tbody>

                </table>
            </div>
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
    </body>
</html>