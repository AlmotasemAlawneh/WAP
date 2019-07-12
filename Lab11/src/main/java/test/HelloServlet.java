package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("myAttr", "noval");
        RequestDispatcher dispatcher= req.getRequestDispatcher("Test/result.jsp");
        dispatcher.forward(req,resp);
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("<p>Please click the button</p>");
        out.print("<input type='submit' value='Click me'/>");
        out.print("att Val is " +  (String)req.getSession().getAttribute("myAttr"));
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] fruit= new String[]{"Banana","Orange","Apple"};
        req.setAttribute("myFruitList", fruit);
        RequestDispatcher dispatcher= req.getRequestDispatcher("Test/demo.jsp");
        dispatcher.forward(req,resp);
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Postback received</p>");
        out.print("att Val is " +  (String)req.getSession().getAttribute("myAttr"));
        out.print("</body></html>");
        //support
    }
}

