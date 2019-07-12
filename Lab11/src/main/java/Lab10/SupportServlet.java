package Lab10;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;


public class SupportServlet extends HttpServlet {
    String supportEmail;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        supportEmail="cstech@mum.edu";

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(
                String.format("<html><head><title>SupportServlet</title></head><body><p>Thank you! <strong><em>%s</em></strong> for contacting us. We should receive reply from us with in 24 hrs </br> in " +
                                "your email address <strong>[%s]</strong>. Let us know in our support email <strong>[%s]</strong> if " +
                                "you don't receive reply within 24 hrs.</b> Please be sure to attach your reference <strong>[" +
                                "%s]</strong> in your email.</p></body></html>",
                        request.getParameter("name"),
                        request.getParameter("email"),
                        supportEmail,
                        UUID.randomUUID().toString()
                )
        );
        /*
i. Support_email should come from context param.
ii. Support_ticket_id is generated automatically for every request.
        */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Postback received</p>");
        out.print("att Val is " +  (String)req.getSession().getAttribute("myAttr"));
        out.print("</body></html>");
    }
}
