<%-- 
    Document   : insertarProduccion.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>



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
<%@page import="appnomina.capadatos.entidades.Empleado"%>
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

            String SITIO_2 = "SOLETERO";

                /**
                 * Sitio web 2
                 */
                String SITIO_1 = "LIMPIADOR";

                String SITIO_3 = "ASEADOR";
                
                String SITIO_4 = "CORTADOR";
                
                String SITIO_5 = "PELADOR";
            
                

                // Creamos y rellenamos el modelo de datos
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                // Visitas del sitio web 1
                dataset.setValue(100, SITIO_1, "Lunes");
                dataset.setValue(120, SITIO_1, "Martes");
                dataset.setValue(110, SITIO_1, "Miércoles");
                dataset.setValue(103, SITIO_1, "Jueves");
                dataset.setValue(106, SITIO_1, "Viernes");

                // Visitas del sitio web 2
                dataset.setValue(60, SITIO_2, "Lunes");
                dataset.setValue(62, SITIO_2, "Martes");
                dataset.setValue(61, SITIO_2, "Miércoles");
                dataset.setValue(63, SITIO_2, "Jueves");
                dataset.setValue(66, SITIO_2, "Viernes");
                
                
                dataset.setValue(60, SITIO_3, "Lunes");
                dataset.setValue(62, SITIO_3, "Martes");
                dataset.setValue(61, SITIO_3, "Miércoles");
                dataset.setValue(63, SITIO_3, "Jueves");
                dataset.setValue(66, SITIO_3, "Viernes");
                
                dataset.setValue(60, SITIO_4, "Lunes");
                dataset.setValue(62, SITIO_4, "Martes");
                dataset.setValue(61, SITIO_4, "Miércoles");
                dataset.setValue(63, SITIO_4, "Jueves");
                dataset.setValue(66, SITIO_4, "Viernes");
                
                
                dataset.setValue(60, SITIO_5, "Lunes");
                dataset.setValue(62, SITIO_5, "Martes");
                dataset.setValue(61, SITIO_5, "Miércoles");
                dataset.setValue(63, SITIO_5, "Jueves");
                dataset.setValue(66, SITIO_5, "Viernes");

                JFreeChart chart = ChartFactory.createBarChart("Visitas", "día",
                        "Número visitas", dataset, PlotOrientation.VERTICAL, true,
                        true, false);

                

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
            
        %>

    </body>
</html>