<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Inventarios</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/jquery-3.2.1.min.js"></script>
        <link rel="stylesheet" href="css/estilos3.css" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" src="js/validaciones.js"></script>

    </head>
    <body>
        <script>
            $(document).ready(function () {
                $("#btnAceptar").click(function () {
                    $("#boxIndex").load("validarUsuario.jsp?" + (preValidar()), function () {
                    });
                });
            });
        </script>

        <div class="card-body">
            <form id="frmRegistrar" name="frmRegistrar" action="menu.jsp" method="post" 
                  onsubmit="return validar()">


                <table id="tablaEmpleados" class="table-responsive">                

                    <thead>

                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <h1 style="left : 153%; position:relative; font-size:45px;">Sign in</h1>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="img/login.png" width="400" height="300" style="left : 120%; position:relative;" >
                            </td>
                        </tr>
                        <tr>
                            <td>

                                <input style="left : 140%; position:relative; font-size:20px;" type="text" name="usuario" id="usuario" 
                                       placeholder="Usuario" required >

                            </td>
                        </tr>                            

                        <tr>                               
                            <td>
                                <br>
                                <input style="left : 140%; position:relative; font-size:20px;" type="password" name="password" id="password" 
                                       placeholder="Password" required >
                            </td>
                        </tr>

                        <tr>

                            <td>


                                <br>
                                <input style="left : 140%; position:relative; font-size:20px; width:270px;background:rgb(71, 82, 94);" type="button" id="btnAceptar" value="Aceptar" class="btn btn-success" >
                            </td>
                        </tr>

                        <tr>

                            <td>   

                                <br>
                                <div style="left : 140%; position:relative; font-size:16px; width:273px;" id="boxIndex">
                                </div>

                            </td>
                        </tr>


                    </tbody>
                </table>

                <script src="js/bootstrap.min.js"></script>
                <script src="js/jquery-3.2.1.min.js"></script>
            </form>
        </div>          
    </body>
</html>