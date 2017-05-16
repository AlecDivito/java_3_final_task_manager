package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_url = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_param_value_name_nobody.release();
    _jspx_tagPool_c_import_url.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Project Management</title>\n");
      out.write("  \t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style/headerStyle.css\"/>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        html {\n");
      out.write("            background: url(images/pictures/login.jpg);\n");
      out.write("            background-size: cover;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-attachment: fixed;\n");
      out.write("            background-position: top center;\n");
      out.write("        }\n");
      out.write("\t\t.FD-forms {\n");
      out.write("            width: 500px;\n");
      out.write("            height: 400px;\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tmargin: -200px -250px ;\n");
      out.write("            display: none;\n");
      out.write("            background-color: white;\n");
      out.write("            z-index: 1000;\n");
      out.write("            padding: 20px;\n");
      out.write("            position: absolute;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            box-shadow: 0 0 50px black;\n");
      out.write("\t\t}\n");
      out.write("        FD-forms-from {\n");
      out.write("            width: 250px;\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tmargin: auto;\n");
      out.write("            background-color: white;\n");
      out.write("            z-index: 1100;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\t\t.FD-login-form {\n");
      out.write("\t\t\tdisplay: block;\n");
      out.write("\t\t\twidth: 250px;\n");
      out.write("            background-color: white;\n");
      out.write("            z-index: 1100;\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tmargin: auto;\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\t.FD-register-form {\n");
      out.write("\t\t\tdisplay: none;\n");
      out.write("\t\t\twidth: 250px;\n");
      out.write("            background-color: white;\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tmargin: auto;\n");
      out.write("            z-index: 1000;\n");
      out.write("\t\t}\n");
      out.write("        #id { color:red; }\n");
      out.write("        \n");
      out.write("        #overlay {\n");
      out.write("            position: fixed;\n");
      out.write("            height: calc(100% - 75px);\n");
      out.write("            width: 100%;\n");
      out.write("            left: 0;\n");
      out.write("            top: 75px;\n");
      out.write("            z-index: -100;\n");
      out.write("            background-color: rgba(0, 0, 255, 0.6);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .FD-desc {\n");
      out.write("            color: black;\n");
      out.write("            position: absolute;\n");
      out.write("            width: 800px;\n");
      out.write("            height: 400px;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            margin: -200px 0 0 -400px;\n");
      out.write("        }\n");
      out.write("        .FD-desc p {font-size: 24px; color: white;}\n");
      out.write("        #button {\n");
      out.write("            width: 150px;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: green;\n");
      out.write("            border: 1px solid darkgreen;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        input[type=\"text\"], input[type=\"password\"], input[type=\"email\"]{\n");
      out.write("            padding: 10px;\n");
      out.write("            border: none;\n");
      out.write("            border-bottom: solid 2px #c9c9c9;\n");
      out.write("            transition: border 0.3s;\n");
      out.write("            width: 100%;\n");
      out.write("            font-family: sans-serif;\n");
      out.write("            font-size: 14px;\n");
      out.write("                  }\n");
      out.write("        input[type=\"text\"]:focus, input[type=\"password\"]:focus, input[type=\"email\"]:focus {  border-bottom: solid 2px #969696;}\n");
      out.write("\n");
      out.write("        input[type=submit], button {\n");
      out.write("              margin-top: 5px;\n");
      out.write("              padding:5px 15px; \n");
      out.write("              background:#ccc; \n");
      out.write("              border:0 none;\n");
      out.write("              cursor:pointer;\n");
      out.write("              -webkit-border-radius: 5px;\n");
      out.write("              border-radius: 5px;\n");
      out.write("                font-size: 14px;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          input[type=submit]:focus, button:focus {\n");
      out.write("              background-color: #aaa;\n");
      out.write("          }\n");
      out.write("          #error {\n");
      out.write("              position: fixed;\n");
      out.write("              bottom: 25px;\n");
      out.write("              left: calc(50% - 150px);\n");
      out.write("              width: 300px;\n");
      out.write("              background-color: red;\n");
      out.write("              padding: 10px;\n");
      out.write("          }\n");
      out.write("\t</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    \n");
      out.write("<div class=\"FD-forms\">\n");
      out.write("\t<h2 id=\"header\">Login</h2>\n");
      out.write("\t<button id=\"login\">Login</button>\n");
      out.write("\t<button id=\"register\">Register</button>\n");
      out.write("\t<div class=\"FD-login-form FD-forms-from\" >\n");
      out.write("\t\t<form method=\"post\" action=\"login\">\n");
      out.write("\t\t\t<input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"email..\" required>\n");
      out.write("\t\t\t<input type=\"password\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"password\" required>\n");
      out.write("\t\t\t<input type=\"submit\" name=\"submitbtn\" value=\"submit\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"FD-register-form FD-forms-from\">\n");
      out.write("\t\t<form method=\"post\" action=\"Register\">\n");
      out.write("            <input type=\"text\" name=\"firstname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"first name...\" required>\n");
      out.write("\t\t\t<input type=\"text\" name=\"lastname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lastname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"last name...\" required>\n");
      out.write("\t\t\t<input type=\"text\" name=\"company\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${company}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"company..\" required>\n");
      out.write("            <input type=\"email\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"email..\" required>\n");
      out.write("\t\t\t<input type=\"password\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"password..\" required>\n");
      out.write("\t\t\t<input type=\"submit\" name=\"submitbtn\" value=\"submit\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<center>\n");
      out.write("    <div class=\"FD-desc\">\n");
      out.write("        <p>Project Management isn't a option but a life style</p>\n");
      out.write("        <p>Create Progects that your proud to show your friends</p>\n");
      out.write("        <div id=\"button\">\n");
      out.write("            <p>Get Started</p>\n");
      out.write("        </div>    \n");
      out.write("    </div>    \n");
      out.write("</center>\n");
      out.write("<center>\n");
      out.write("    <p id='error'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("    <div id=\"overlay\"></div>    \n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(\"#login\").click( function () {\n");
      out.write("\t\t$('.FD-login-form').eq(0).slideDown(250);\n");
      out.write("\t\t$('.FD-register-form').eq(0).hide();\n");
      out.write("\t\tdocument.getElementById('header').innerHTML = \"Register\";\n");
      out.write("\t});\n");
      out.write("\t$(\"#register\").click( function () {\n");
      out.write("\t\t$('.FD-login-form').eq(0).hide();\n");
      out.write("\t\t$('.FD-register-form').eq(0).slideDown(250);\n");
      out.write("\t\tdocument.getElementById('header').innerHTML = \"Login\";\n");
      out.write("\t});\n");
      out.write("    \n");
      out.write("    $(\"#button\").click(function() {\n");
      out.write("        $(\".FD-forms\").show(750);\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("includes/header.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_c_import_0[0]++;
          _jspx_th_c_import_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_import_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_import_0, _jspx_page_context, _jspx_push_body_count_c_import_0))
            return true;
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_import_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_import_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_c_import_0[0]--;
      }
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_import_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_import_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_import_0);
    _jspx_th_c_param_0.setName("title");
    _jspx_th_c_param_0.setValue(": Login");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }
}
