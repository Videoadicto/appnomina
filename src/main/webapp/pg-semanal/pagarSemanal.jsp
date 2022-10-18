<%-- 
    Document   : listarSemanals
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.NominaSemanal"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaSemanalFacade"></jsp:useBean>
<jsp:useBean id="fachada1" class="appnomina.negocio.facade.ProduccionFacade"></jsp:useBean>
<jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Pagos Semanales</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>

            <script>
                $("button").click(function () {
                    $("#box").load(verificarPaginaS($(this).val()), function () {
                    });
                });
            </script>
        </head>

        <body>

        <%
            //String fechai3 = request.getParameter("fechai2");
            //String fechaf3 = request.getParameter("fechaf2");
            String fechai3 = request.getParameter("fechal2");
            String fechaf3 = request.getParameter("fechah2");

        %>



        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">PAGOS GENERADOS</h1>
        </div>

        <br>

        <div class="card-body">
            <div class="table-responsive">

                <table class="table table-borderless">
                    <thead>


                        <tr>
                            <th>
                                <div>
                                    <button class="btn" id="btnBuscar" value="pg-semanal/pagarSemanal.jsp?mens=0" style="width:11em; background:rgb(0, 195, 255);left : 0%; position:relative;">
                                        <i class="fa fa-toolbox" >
                                        </i> Recalcular
                                    </button>
                                </div>
                            </th>

                            <th>
                                <div>
                                    <label style="width:10em; text-align:right;">Fecha Inicial: </label>
                                </div>
                            </th>

                            <th>
                                <div>
                                    <input type="date" name="fechaix" id="fechaix" value = '<%= fechai3%>'  style="width: 150px; vertical-align:10px">
                                </div>
                            </th>

                            <th>
                                <div>
                                    <label style="width:10em; text-align:right;">Fecha Final: </label>
                                </div>
                            </th>

                            <th>
                                <div>
                                    <input type="date" name="fechafx" id="fechafx" value = '<%= fechaf3%>' style="width: 150px; vertical-align:10px">
                                </div>
                            </th>




                        </tr>

                    </thead>
                    <tbody>

                    </tbody>
                </table>

                <table id="tablaSemanals" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id Emp.</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Cedula</th>
                            <th>Cargo</th>
                            <th>Total</th>
                        </tr>                            
                    </thead>
                    <tbody>
                        <%  for (Empleado empleado : fachada2.buscarEmpleados()) {

                        %>

                    <td> <%= empleado.getId_empleado()%> </td>
                    <td> <%= empleado.getNombre().replace("_", " ") %> </td>
                    <td> <%= empleado.getApellido().replace("_", " ") %> </td>
                    <td> <%= empleado.getCedula()%> </td>
                    <td> <%= empleado.getIdCargo().getNombre() %> </td>


                   <td> <%=      fachada1.buscarProduccionesUsuarioFechas(empleado.getId_empleado(), empleado.getIdCargo().getPago(), fechai3, fechaf3) %> </td>


                    

                        
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
                $('#tablaSemanals').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'csv', 'excel', 'pdf', 'print'
                    ]
                });
            });
        </script>

        <br>

        <div class="form-group">
            <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
            <button type="button" value="pg-semanal/listarSemanal.jsp?mens=0" class="btn btn-success">Regresar</button>
        </div>

    </body>
</html>