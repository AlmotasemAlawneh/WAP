package Lab11.filters;

import Lab11.models.User;
import Lab11.storage.ApplicationStorage;
import Lab11.storage.StorageType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = ApplicationStorage
                        .getInstance(request, response)
                        .getValue(StorageType.Session, "user");

        if (user == null && (!request.getServletPath().contains("/login"))){
            response.sendRedirect( ((HttpServletRequest)servletRequest).getContextPath() + "/login");
            //filterChain.doFilter(servletRequest, servletResponse);
            //return;
        }
        else if (user != null && (!request.getServletPath().contains("/logout"))&& (!request.getServletPath().contains("/index"))) {
            response.sendRedirect(((HttpServletRequest)servletRequest).getContextPath() +"/Lab11/index.jsp");

            //return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
