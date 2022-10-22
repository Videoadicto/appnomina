package org.apache.jsp.pg_002dempleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sistemainventarios.capadatos.entidades.Empleado;

public final class guardarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registrar Empleado</title>\n");
      out.write("    </head>\n");
      out.write("    ");
      sistemainventarios.negocio.facade.EmpleadoFacade fachada = null;
      synchronized (_jspx_page_context) {
        fachada = (sistemainventarios.negocio.facade.EmpleadoFacade) _jspx_page_context.getAttribute("fachada", PageContext.PAGE_SCOPE);
        if (fachada == null){
          fachada = new sistemainventarios.negocio.facade.EmpleadoFacade();
          _jspx_page_context.setAttribute("fachada", fachada, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");

        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nuevo = request.getParameter("nuevo");

        /*
        if (numero==null) numero="0";
        if (numero.equals("")) numero="0";        
        int precio = Integer.parseInt(numero);
        
        numero = request.getParameter("existencias");
        if (numero==null) numero="0";
        if (numero.equals("")) numero="0";        
        int existencias = Integer.parseInt(numero);
        
        numero = request.getParameter("costo");
        if (numero==null) numero="0";
        if (numero.equals("")) numero="0";        
        int costo = Integer.parseInt(numero);
         */
        Empleado p = new Empleado(cedula, nombre, email, password);

        String msg = fachada.insertarEmpleado(p, nuevo);
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"divGuardar\" class=\"alert alert-success\">\n");
      out.write("            ");
      out.print( msg);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
