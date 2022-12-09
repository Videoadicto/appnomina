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
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean> --%>
    </head>

    <body>

        <%

            
            String validar3 = request.getParameter("validar");

            if (validar3.equals("1")) {

                String fechai3 = request.getParameter("fechai2");
                String fechaf3 = request.getParameter("fechaf2");
                //int idEmpleado3 = Integer.parseInt(request.getParameter("idEmpleado2"));

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                for (Produccion produccion : fachada.buscarProduccionesFechasCargos(fechai3, fechaf3)) {

                    //System.out.println(produccion.getFecha() + " " + produccion.getIdEmpleado().getCedula() + " " + produccion.getIdEmpleado().getNombre());
                    dataset.setValue(produccion.getCantidad(), produccion.getIdEmpleado().getIdCargo().getNombre().replace("_", " "), produccion.getFecha());
                }

                JFreeChart chart = ChartFactory.createBarChart3D("Produccion", "fechas",
                        "Producido", dataset, PlotOrientation.VERTICAL, true,
                        true, true);

                final CategoryPlot p = chart.getCategoryPlot();

                BarRenderer renderer = (BarRenderer) p.getRenderer();
                DecimalFormat decimanlformat = new DecimalFormat("##.##");
                renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimanlformat));
                p.setRenderer(renderer);
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.TOP_LEFT));
                //renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.HALF_ASCENT_CENTER));
                renderer.setItemLabelsVisible(true);
                chart.getCategoryPlot().setRenderer(renderer);

                //CategoryPlot plot = (CategoryPlot) 
                //chart.getPlot();
                //NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
                //rangeAxis.setRange(0, 500);
                //response.setContentType("image/png");
                //OutputStream sa = response.getOutputStream();
                File f = new File("filename.png");
                //f.createNewFile();
                ChartUtilities.saveChartAsJPEG(f, chart, 1100, 500);

                //System.out.print(f.getAbsolutePath());
                //ChartUtilities.writeChartAsPNG(sa, chart, 500, 500);
                //sa.flush();
                //String X = "file" + f.getAbsolutePath();
                //System.out.println(X);
                FileInputStream fis = new FileInputStream(f);
                //create FileInputStream which obtains input bytes from a file in a file system
                //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                try {
                    for (int readNum; (readNum = fis.read(buf)) != -1;) {

                        bos.write(buf, 0, readNum);

                    }
                } catch (IOException ex) {
                    // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
                }

                byte[] bytes = bos.toByteArray();

                byte[] encodeBase64 = Base64.encodeBase64(bytes);
                String base64Encoded = new String(encodeBase64, "UTF-8");



        %>

        <img src="data:image/jpeg;base64,<%=base64Encoded%>"/>

        <%
            }
        %>

    </body>
</html>