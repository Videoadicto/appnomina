<!DOCTYPE html>
<!--
    Document   : editarEmpleado.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
-->
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page import="appnomina.capadatos.entidades.Producto"%>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.EmpleadoFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachadaP" class="appnomina.negocio.facade.ProductoFacade"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="js/jquery-3.2.1.min.js"></script>
            <link rel="stylesheet" href="css/estilos3.css" type="text/css"/>
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <script type="text/javascript" src="js/validaciones.js"></script>

            <style>
                .item {
                    cursor: pointer;
                }

                .content{
                    width: calc(100% - 270px);
                    margin-left: 270px;
                    margin-top: 5px;
                    background: rgb(198, 215, 206);
                }
            </style>

            <script>
                $(document).ready(function () {
                    $("#btnAlertas").click(function () {
                        $("#box").load("pg-alerta/listarProducto.jsp?mens=0", function () {
                        });
                    });
                });

                $(document).ready(function () {

                    $("#menu1").click(function () {
                        $("#box").load("dashboard.html", function () {

                        });
                    });
                    $("#menu6").click(function () {
                        //$("#box").load("pg-empleado/listarEmpleado.jsp?msg='0'", function () {
                        $("#box").load("pg-empleado/listarEmpleado.jsp?mens=0", function () {
                        });
                    });
                    $("#menu7").click(function () {
                        $("#box").load("pg-cliente/listarCliente.jsp?mens=0", function () {
                        });
                    });
                    $("#menu8").click(function () {
                        $("#box").load("pg-venta/listarVenta.jsp?mens=0&emple=" + document.getElementById("emple").value, function () {

                        });
                    });
                    $("#menu9").click(function () {
                        $("#box").load("listarInformes.jsp", function () {

                        });
                    });
                    $("#menu10").click(function () {
                        window.location.href = "index.jsp";
                    });
                });

            </script>
            <title>Gestion Empleados</title>
        </head>

        <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");

            try {
                String cedula1 = session.getAttribute("uid").toString();
                //System.out.println("" + cedula1);
                if (session.getAttribute("uid") != null) {
                    session.setAttribute("uid", null);
                }
            } catch (Exception e) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div class="wrapper">
            <div class="section">
                <div class="top_navbar">
                    <div class="hamburger">
                        <a href="#">
                            <i class="fas fa-bars"></i>
                        </a>
                    </div>
                </div>
            </div>

            <div class="sidebar">
                <input type="text" style="background-color: rgb(75, 131, 145); display: block; color: rgb(255, 255, 255); top:-21px; height:52px; position:relative;"  id="usuario"
                       placeholder="" required
                       class="form-control" readonly
                       value = "">
                <br>
                
                
                
                <div class="profile">
                    <img src="img/casa1.png" alt="profile_picture" style="width:120px">
                    <h3></h3>
                    <p> </p>
                </div>

                <div id="alerta" style="display: none;">
                    <button class="btn btn-danger" id="btnAlertas" style="left : 37%; position:relative; width:50px">
                        <i class="fa fa-info-circle" >
                        </i> 
                    </button>
                </div>

                <ul>
                    <!--
                    <li>
                        <a>
                            <span class="icon"><i class="fas fa-tachometer-alt"></i></span>
                            <span id="menu1" name ="menu1" class="item">Dashboard</span>
                        </a>
                    </li>
                    
                    -->
                    <li  id="emp" >
                        <a>
                            <span class="icon"><i class="fas fa-user"></i></span>
                            <span id="menu6" class="item">Empleados</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <span class="icon"><i class="fas fa-dollar-sign"></i></span>
                            <span id="menu7" class="item">Nomina</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <span class="icon"><i class="fas fa-project-diagram"></i></span>
                            <span id="menu8" class="item">Produccion</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <span class="icon"><i class="fas fa-clipboard"></i></span>
                            <span id="menu9" class="item">Informes</span>
                        </a>
                    </li>
                    <li>
                        <a>
                            <span class="icon"><i class="fas fa-running"></i></span>
                            <span id="menu10" class="item">Log Out</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="content" id="box" style="height:610px">
        </div>

        <%
            String cedula = request.getParameter("cedula");
            //String password = request.getParameter("password");
            //System.out.print("cedula: " + cedula + " password: " + password);

            Empleado empleado = new Empleado();
            empleado.setCedula(cedula);

            empleado = fachada.buscarEmpleado(cedula);

            session.setAttribute("rol", empleado.getTipo());

            {
        %>

        <input id="valor" style="display: none;" value = <%= empleado.getTipo()%> >
        <script>
            $("#box").load("dashboard.html", function () {
            });
            modificarMenu();
        </script>

        <input id="emple" style="display: none;" value = <%= empleado.getCedula()%> >

        <%  }

        %>

        <script>

            var tipo = "";
            if (document.getElementById("valor").value !== "0")
                tipo = "Administrador: ";
            else
                tipo = "Usuario: ";


            document.getElementById("usuario").value = tipo + document.getElementById("emple").value;
        </script>

        <% for (Producto producto : fachadaP.buscarProductos()) {

                if (producto.getCantidad() < producto.getCantidadMinima()) {
        %>

        <script>
            document.getElementById("alerta").style = 'display:"";';
        </script>

        <%
                }
            }
        %>

    </body>  
</html>