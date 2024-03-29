<%-- 
    Document   : listarVentas
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Venta"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.VentaFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Gestión Ventas</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>

            <script>
                $("button").click(function () {

                    $("#box").load(verificarPagina2($(this).val()), function () {
                    });
                });
            </script>
        </head>

         <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">PRODUCCION</h1>
        </div>

        <br>

        <div>
        <%--            <button class="btn" onclick="location.href = 'ventaForm.html'" style="top : 15%; left : 87%; position:relative"> --%>
        <button class="btn" id="nuevo" value="pg-venta/insertarVenta.jsp" style="background:rgb(0, 195, 255);left : 1.2%; position:relative;">
            <i class="fa fa-toolbox" >
            </i>Buscar
        </button>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table id="tablaVentas" class="table table-bordered">
                <thead>
                    <tr>
                        <th>Id Factura</th>
                        <th>Id Cliente</th>
                        <th>Id Empleado</th>
                        <th>Total</th>
                        <th>Fecha</th>
                        <th>opciones</th>
                    </tr>                            
                </thead>
                <tbody>
                    <% for (Venta venta : fachada.buscarVentas()) {
                    %>
                    <tr>                               
                        <td><%= venta.getIdVenta()%></td>
                        <td><%= venta.getIdCliente()%></td>
                        <td><%= venta.getIdEmpleado()%></td>
                        <td><%= venta.getTotal()%></td>
                        <td><%= venta.getFecha()%></td>

                        <td>
                            <button  class="item" style="border:none" value="pg-venta/mostrarVenta.jsp?idVenta=<%= venta.getIdVenta()%>">
                                <img src="img/info.png" alt="alt"/>
                            </button>

                            <% if (session.getAttribute("rol").equals("1")) {
                            %>

                            <button  class="item" style="border:none" value="pg-venta/eliminarVenta.jsp?idVenta=<%= venta.getIdVenta()%>">
                                <img src="img/borrar.png" alt="alt"/>
                            </button>
                            <%
                                }
                            %>


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
            $('#tablaVentas').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        });
    </script>

    <%  String idEmpleado4 = request.getParameter("emple");
        {
    %>

    <input id="emplea" style="display: none;" value = <%= idEmpleado4%> >

    <%
        }
    %>

</html>