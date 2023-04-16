<%-- 
    Document   : insertarProduccion.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>



<%@page import="appnomina.capadatos.entidades.DatosMensual"%>
<%@page import="appnomina.capadatos.entidades.NominaEmpleado"%>
<%@page import="appnomina.capadatos.entidades.NominaMensual"%>
<%@page import="org.jfree.ui.TextAnchor"%>
<%@page import="org.jfree.chart.labels.ItemLabelPosition"%>
<%@page import="org.jfree.chart.labels.ItemLabelAnchor"%>
<%@page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.jfree.chart.renderer.category.BarRenderer"%>
<%@page import="org.jfree.chart.axis.NumberAxis"%>
<%@page import="org.jfree.chart.plot.CategoryPlot"%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%-- <%@page import="appnomina.capadatos.entidades.Produccion"%> --%>
<%@page import="appnomina.capadatos.entidades.NominaMensual"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/dataTable/jquery.dataTables.min.css" rel="stylesheet">
            <link href="css/dataTable/buttons.dataTables.min.css" rel="stylesheet">
            <script src="js/validaciones.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="js/dataTable/jquery.dataTables.min.js"></script>
        
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean> --%>
    </head>

    <body>

        <div class="card-body">
            <div class="table-responsive">
                <table id="tablaEmpleados" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Cargo</th>
                            <th>Cantidad</th>
                            <th>Fecha</th>
                        </tr>                            
                    </thead>
                    <tbody>




                        <%

                            String validar3 = request.getParameter("validar");

                            if (validar3.equals("1")) {

                                String fechai3 = request.getParameter("fechai2");
                                String fechaf3 = request.getParameter("fechaf2");

                                for (Produccion produccion : fachada.buscarProduccionesFechasCargos(fechai3, fechaf3)) {

                        %>

                        <tr>               
                            <td><%= produccion.getIdEmpleado().getIdCargo().getNombre()%></td>
                            <td><%= produccion.getCantidad()%></td>
                            <td><%= produccion.getFecha()%></td>
                        </tr>

                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
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

         <%
            }
        %>
        
    </body>
</html>