<%-- 
    Document   : listarUsuarios
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.Usuario"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.UsuarioFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Usuarios</title>
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

        <%
            String tipo = session.getAttribute("rol").toString();
            String nick = session.getAttribute("nick").toString();
        %>

        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">USUARIOS</h1>
        </div>

        <br>
        
        <table class="table table-borderless">
            <thead>
                <tr>

                    <%
                        if (tipo.equals("1")) {

                    %>
                    <th>
                        <button class="btn" id="nuevo" value="pg-usuario/insertarUsuario.jsp" style="background:rgb(0, 195, 255);left : 1.2%; position:relative;">
                            <i class="fa fa-toolbox" >
                            </i> Agregar Usuario
                        </button>
                    </th>

                    <% }

                    %>

                </tr>
            </thead>
        </table>

        <div class="card-body">
            <div class="table-responsive">
                <table id="tablaUsuarios" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Nombre</th>
                            <th>Tipo</th>
                            <th>Opción</th>
                        </tr>                            
                    </thead>
                    <tbody>
                        <% for (Usuario usuario : fachada.buscarUsuarios()) {
                                int estado = usuario.getTipo();
                                String testado = "";

                                if (estado == 1) {
                                    testado = "Administrador";
                                } else {
                                    testado = "Usuario";
                                }

                        %>
                        <tr>                               
                            <td><%= usuario.getNick()%></td>
                            <td><%= (usuario.getNombre()).replace("_", " ")%></td>
                            <td><%= testado%></td>
                            <td>

                                <%
                                    if (tipo.equals("1") || nick.equals(usuario.getNick())) {
                                %> 

                                <button  class="item" style="border:none" value="pg-usuario/editarUsuario.jsp?nick=<%= usuario.getNick()%>">
                                    <img src="img/editar.png" width="16" height="16" >
                                </button>

                                <%
                                    }
                                %>   

                                <%
                                    if (tipo.equals("1") && !(nick.equals(usuario.getNick()))) {
                                %>   

                                <button  class="item" style="border:none" value="pg-usuario/eliminarUsuario.jsp?nick=<%= usuario.getNick()%>">
                                    <img src="img/borrar.png" alt="alt"/>
                                </button>

                                <%
                                    }
                                %>   

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
                $('#tablaUsuarios').DataTable({
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