<%-- 
    Document   : listarFijoss
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Fijos"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.FijosFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Fijos</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>

            <script>
                $("button").click(function () {

                    $("#box").load(verificarPagina($(this).val()) + uneFechas(), function () {
                    });
                });
            </script>
        </head>

        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">FIJOS</h1>
        </div>

        <br>

        
    <div class="card-body">
        <div class="table-responsive">
            <table id="tablaFijoss" class="table table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Valor</th>
                        <th>Opción</th>
                    </tr>                            
                </thead>
                <tbody>


                    <% for (Fijos fijos : fachada.buscarFijos()) {
                    %>
                    <tr>                               
                        <td><%= fijos.getId_fijo()%></td>
                        <td><%= (fijos.getNombre()).replace("_", " ")%></td>
                        <td><%= fijos.getValor()%></td>
                        <td>
                            <button  class="item" style="border:none" value="pg-fijos/editarFijos.jsp?idFijos=<%= fijos.getId_fijo()%>">
                                <img src="img/editar.png" width="16" height="16" >
                            </button>
                        </td>
                    </tr>
                    <%
                        }
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
    
    <br>
    
    <div class="form-group">
                    <button type="button" value="pg-semanal/listarSemanal.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
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
            $('#tablaFijoss').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            });
        });
    </script>
        </div>
</html>