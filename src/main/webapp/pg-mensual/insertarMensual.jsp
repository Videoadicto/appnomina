<%-- 
    Document   : listarMensuales
    Created on : 31 mar. 2022, 08:43:44
    Author     : Videoadicto
--%>

<%@page import="java.util.List"%>
<%@page import="appnomina.capadatos.entidades.NominaMensual"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page import="appnomina.capadatos.entidades.Concepto"%>
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
<jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaMensualFacade"></jsp:useBean>
<jsp:useBean id="fachada1" class="appnomina.negocio.facade.ProduccionFacade"></jsp:useBean>
<jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>
<jsp:useBean id="fachada3" class="appnomina.negocio.facade.ConceptoFacade"></jsp:useBean>
<jsp:useBean id="fachada4" class="appnomina.negocio.facade.NominaMensualFacade"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registro de Pagos Mensuales</title>
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

                function checkTodo()
                {
                    var allRows = document.getElementsByName("idx");
                    for (var i = 0; i < allRows.length; i++) {
                        if (allRows[i].type === 'checkbox')
                        {
                            if (miCheck.checked === true) {
                                allRows[i].checked = true;
                            } else
                            {
                                allRows[i].checked = false;
                            }
                        }
                    }
                }

                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        var table = $('#tablaMensuales').DataTable();
                        //console.log(table.row(this).data());

                        //window.alert("" + table.data().length);
                        //window.alert("" + table.row(0).data().toString());
                        //window.alert("" + table.data().count());
                        //Procesar(X = ("" + table.data().length), Y = ("" + table.row(0).data().toString()));
                        var valores = null;
                        //var lista1 = "";
                        //var total1 = 0;
                        //var inicial = parseInt(table.data().length);
                        //const lista = [];

                        //lista = request.getParameterValues("selected");
                        //window.alert("" + lista.toString());
                        //const xxx = [];
                        //window.alert("" + xxx.toString());
                        //xxx = request.getParameterValues("idx");

                        var allRows1 = document.getElementsByName("idx");
                        var ids = [];
                        var primas = [];
                        var cesantias = [];
                        var icesantias = [];
                        var totales = [];
                        //window.alert("allrows: " + allRows1.length + " tablelenght: " + inicial);

                        var validos = 0;
                        for (var i = 0; i < allRows1.length; i++) {
                            //if (allRows1[i].type === 'checkbox')
                            //{
                            if (allRows1[i].checked === true) {
                                //casillas.push(allRows1[i].checked);

                                valores = (table.row(i).data().toString()).split(",");
                                ids.push(valores[1]);
                                primas.push(valores[8]);
                                cesantias.push(valores[9]);
                                icesantias.push(valores[10]);
                                totales.push(valores[11]);
                                //window.alert("ids: " + ids.toString());
                                //window.alert("totales: " + totales.toString());
                                validos++;

                            }

                            //window.alert("total: " +  allRows1[i].checked);
                            //window.alert("total: " + casillas.toString());
                        }

                        if (validos === 0) {
                            //window.alert("No se han seleccionado empleados");
                            document.getElementById("validax").value = "0";
                            //window.alert("validax0: " +  document.getElementById("validax").value );
                        } else {
                            document.getElementById("validax").value = "1";
                        }
                        var ids1 = ids.toString();
                        var primas1 = primas.toLocaleString();
                        var cesantias1 = cesantias.toLocaleString();
                        var icesantias1 = icesantias.toLocaleString();
                        var totales1 = totales.toString();
                        $("#boxInsertar").load("pg-mensual/guardarMensual.jsp?" + (validarDatosSemanal(nuevo = 1, idsx = ids1, primasx = primas1, cesantiasx = cesantias1, icesantiasx = icesantias1, totalesx = totales1)), function () {
                        });


                        //}
                        //for (var i = 0; i < inicial; i++) {

                        //  valores = (table.row(i).data().toString()).split(",");

                        //window.alert("total: " + (valores[0]));
                        //window.alert("total: " + (valores[6]));

                        //}
                        //document.getElementById("total").value = total1;

                        //document.getElementById("lista").value = lista1;

                        //$("#boxInsertar").load("pg-mensual/guardarMensual.jsp?" + (validarDatosMensual(nuevo = 1, filas = inicial)), function () {
                        //});
                    }
                    );
                });
            </script>
        </head>

        <body>

        <%
            //String fechai3 = request.getParameter("fechai2");
            //String fechaf3 = request.getParameter("fechaf2");
            String fechai3 = request.getParameter("fechal2");
            String fechaf3 = request.getParameter("fechah2");
            int tipo3 = Integer.parseInt(request.getParameter("tipo2"));
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
                                    <button class="btn" id="btnBuscar" value="pg-mensual/insertarMensual.jsp?mens=0" style="width:11em; background:rgb(0, 195, 255);left : 0%; position:relative;">
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
                        <tr>
                            <th>
                                <div>
                                    <label class="switch">
                                        <input type="checkbox"  id="miCheck" onclick="checkTodo()">
                                        <span class="slider round"></span>
                                    </label>
                                </div>
                            </th>
                            <th>
                                <div>
                                    <label style="width:10em; text-align:right;">Concepto: </label>
                                </div>
                            </th>
                            <th>
                                <div class="form-group">
                                    
                                    <select id="tipo" name="tipo" required class="form-control">
                                        <option value="" selected >  </option>
                                        <%
                                            
                                            
                                            
                                            for (Concepto concepto : fachada3.buscarConceptos().subList(0, 2)) {
                                        %>
                                        
                                        <option value="<%= concepto.getId_concepto()%>" <%if (tipo3 == ( concepto.getId_concepto())) {%> selected <%}%>  > <%= (concepto.getNombre()).replace("_", " ")%> </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </th>
                        </tr>
                    </tbody>
                </table>

                <table id="tablaMensuales" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Sel.</th>
                            <th>Id Emp.</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Cedula</th>
                            <th>Base</th>
                            <th>Transporte</th>
                            <th>Salud</th>
                            <th>Prima</th>
                            <th>Cesantias</th>
                            <th>I.Cesantias</th>
                            <th>Total</th>
                        </tr>                            
                    </thead>
                    <tbody>
                        <%  for (Empleado empleado : fachada2.buscarEmpleados()) {
                                if (empleado.getEstado() == 1) {
                                
                                List<Integer> totales = fachada4.calcularNominaMensualEmpleado(empleado.getId_empleado(), tipo3, fechai3, fechaf3);
                        %>
                        <tr>
                            <td>
                                <input type="checkbox" name="idx" value="<%= empleado.getId_empleado()%>" > 
                            </td>	
                            <td> <%= empleado.getId_empleado()%> </td>
                            <td> <%= empleado.getNombre().replace("_", " ")%> </td>
                            <td> <%= empleado.getApellido().replace("_", " ")%> </td>
                            <td> <%= empleado.getCedula()%> </td>
                            
                            <td> <%= totales.get(0) %> </td>
                            <td> <%= totales.get(1) %> </td>
                            <td> <%= totales.get(2) %> </td>
                            <td> <%= totales.get(3) %> </td>
                            <td> <%= totales.get(4) %> </td>
                            <td> <%= totales.get(5) %> </td>
                            <td> <%= totales.get(0) + totales.get(1) - totales.get(2) + totales.get(3) + totales.get(4) + totales.get(5) %> </td>
                            
                        </tr>
                        <%
                                }
                            }
                             //
                            //S                                n(session.getAttribute("ro                                                         %>
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

        <div id="divInsertar" style="display: none;" class="alert alert-danger">
        </div>  

        <div id="boxInsertar">
        </div>

        <input name="idNomina" id="idNomina" style="display: none;" value = 0 >

        <input name="validax" id="validax" style="display: none;" value = "1" >
        
                <br>

        <div class="form-group">

            <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)">
            <button type="button" value="pg-mensual/listarMensual.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
        </div>

        <div class="card-footer">
        </div>

        <input id="lista" style="display: none;" value = "" >

        <script src="js/dataTable/dataTables.buttons.min.js"></script>
        <script src="js/dataTable/buttons.flash.min.js"></script>
        <script src="js/dataTable/jszip.min.js"></script>
        <script src="js/dataTable/pdfmake.min.js"></script>
        <script src="js/dataTable/vfs_fonts.js"></script>
        <script src="js/dataTable/buttons.html5.min.js"></script>
        <script src="js/dataTable/buttons.print.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#tablaMensuales').DataTable({
                    //pageLength: 5,
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