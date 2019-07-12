package Lab11.filters;

import Lab11.models.User;
import Lab11.storage.ApplicationStorage;
import Lab11.storage.StorageType;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        List<User> users = getUsersDb();

        ApplicationStorage
                .getInstance(arg0.getServletContext())
                .setValue(StorageType.Application, "users", users);
    }

    private List<User> getUsersDb() {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        users.add(u);

        u = new User();
        u.setUsername("user1");
        u.setPassword("pass");
        users.add(u);

        u = new User();
        u.setUsername("user2");
        u.setPassword("pass");
        users.add(u);

        return users;
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
}