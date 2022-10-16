<%-- 
    Document   : listarCargos
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Cargo"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.CargoFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Cargos</title>
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

        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">CARGOS</h1>
        </div>

        <br>

        <div>
        <%--            <button class="btn" onclick="location.href = 'cargoForm.html'" style="top : 15%; left : 87%; position:relative"> --%>
        <button class="btn" id="nuevo" value="pg-cargo/insertarCargo.jsp" style="background:rgb(0, 195, 255);left : 1.2%; position:relative;">
            <i class="fa fa-toolbox" >
            </i> Agregar Cargo
        </button>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table id="tablaCargos" class="table table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Pago</th>
                        <th>Opción</th>
                    </tr>                            
                </thead>
                <tbody>
                    <% for (Cargo cargo : fachada.buscarCargos()) {
                    %>
                    <tr>                               
                        <td><%= cargo.getId_cargo()%></td>
                        <td><%= (cargo.getNombre()).replace("_", " ")%></td>
                        <td><%= cargo.getPago()%></td>
                        <td>
                            <button  class="item" style="border:none" value="pg-cargo/editarCargo.jsp?idCargo=<%= cargo.getId_cargo()%>">
                                <img src="img/editar.png" width="16" height="16" >
                            </button>

                            <button  class="item" style="border:none" value="pg-cargo/mostrarCargo.jsp?idCargo=<%= cargo.getId_cargo()%>">
                                <img src="img/info.png" alt="alt"/>
                            </button>

                            <button  class="item" style="border:none" value="pg-cargo/eliminarCargo.jsp?idCargo=<%= cargo.getId_cargo()%>">
                                <img src="img/borrar.png" alt="alt"/>
                            </button>

                        </td>
                    </tr>
                    <%
                        }
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
            $('#tablaCargos').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        });
    </script>
</html>