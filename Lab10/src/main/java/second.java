import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName= "Second",
        urlPatterns= { "/support1", "/bar/*"},
        servletNames= { "SupportServlet"})
public class second implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        resp.getWriter().println("this is from MyFilter doFilter second one");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
