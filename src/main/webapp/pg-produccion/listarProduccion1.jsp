<%-- 
    Document   : listarProduccions
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Produccion"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Producción</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>

            <script>
                $("button").click(function () {
                    $("#box").load(verificarPaginaP($(this).val()), function () {
                    });
                });
            </script>
        </head>

        <body>

        <%
            String fechai3 = request.getParameter("fechal2");
            String fechaf3 = request.getParameter("fechah2");

        %>



        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">PRODUCCION</h1>
        </div>

        <br>

        <div>
            <%--            <button class="btn" onclick="location.href = 'produccionForm.html'" style="top : 15%; left : 87%; position:relative"> --%>
            <button class="btn" id="nuevo" value="pg-produccion/insertarProduccion.jsp?mens=0" style="background:rgb(0, 195, 255);left : 1.2%; position:relative;">
                <i class="fa fa-toolbox" >
                </i> Agregar Produccion
            </button>



        </div>

        <div class="card-body">
            <div class="table-responsive">

                <table class="table table-borderless">
                    <thead>


                        <tr>
                            <th>
                                <div>
                                    <button class="btn" id="btnBuscar" value="pg-produccion/listarProduccion.jsp?mens=0" style="width:11em; background:rgb(0, 195, 255);left : 0%; position:relative;">
                                        <i class="fa fa-toolbox" >
                                        </i> Buscar
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

                <table id="tablaProduccions" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Cedula</th>
                            <th>Cargo</th>
                            <th>Fecha</th>
                            <th>Produccion</th>
                            <th>Opción</th>
                        </tr>                            
                    </thead>
                    <tbody>
                        <% for (Produccion produccion : fachada.buscarProduccionesFechas(fechai3, fechaf3)) {
                        %>
                        <tr>                               
                            <td><%= produccion.getId_produccion()%></td>
                            <td><%= (produccion.getIdEmpleado().getNombre()).replace("_", " ")%></td>
                            <td><%= (produccion.getIdEmpleado().getApellido()).replace("_", " ")%></td>
                            <td><%= (produccion.getIdEmpleado().getCedula()).replace("_", " ")%></td>
                            <td><%= (produccion.getIdEmpleado().getIdCargo().getNombre())%></td>
                            <td><%= (produccion.getFecha())%></td>
                            <td><%= (produccion.getCantidad())%></td>
                            <td>
                                <button  class="item" style="border:none" value="pg-produccion/editarProduccion.jsp?idProduccion=<%= produccion.getId_produccion()%>">
                                    <img src="img/editar.png" width="16" height="16" >
                                </button>

                                <button  class="item" style="border:none" value="pg-produccion/mostrarProduccion.jsp?idProduccion=<%= produccion.getId_produccion()%>">
                                    <img src="img/info.png" alt="alt"/>
                                </button>
<%-- 
                                <button  class="item" style="border:none" value="pg-produccion/eliminarProduccion.jsp?idProduccion=<%= produccion.getId_produccion()%>">
                                    <img src="img/borrar.png" alt="alt"/>
                                </button>
--%>


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
                $('#tablaProduccions').DataTable({
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