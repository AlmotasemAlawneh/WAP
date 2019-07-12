package Lab11.servlets;

import Lab11.models.User;
import Lab11.storage.ApplicationStorage;
import Lab11.storage.StorageType;
import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = ApplicationStorage
                .getInstance(request, response)
                .getValue(StorageType.Cookie, "username");

        if(username == null || username.isEmpty()){
            username = "";
        } else{
            username = "?username=" + username;
        }

       response.sendRedirect( request.getContextPath()+"/Lab11/login.jsp"+ username);
        //response.setHeader("Location", "/Lab11/login.jsp"+ username);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationStorage storage = ApplicationStorage.getInstance(request, response);

        List<User> users = storage.getValue(StorageType.Application, "users");
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if(users.stream().noneMatch(u ->
            u.getUsername().equals(user.getUsername()) &&
            u.getPassword().equals(user.getPassword())
        )){
            response.sendRedirect(request.getContextPath() +"/Lab11/login.jsp");
            return;
        }

        String rememberMe = request.getParameter("remember");

        if(rememberMe == null) {
            storage.clean(StorageType.Cookie);
        } else {
            storage.setValue(StorageType.Cookie, "username", user.getUsername());
        }

        storage.setValue(StorageType.Session, "user", user);
        response.sendRedirect(request.getContextPath() +"/Lab11/index.jsp?username=" + user.getUsername());
    }


}
