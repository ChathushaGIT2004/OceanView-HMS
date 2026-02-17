package Controllers;

import service.UserService;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    // GET API
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        User user = userService.getUser(username);

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (user != null) {
            out.println("User Found: " + user.getUsername());
        } else {
            out.println("User Not Found");
        }
    }

    // POST API
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        boolean success = userService.saveUser(user);

        PrintWriter out = response.getWriter();

        if (success) {
            out.println("User Saved Successfully");
        } else {
            out.println("Error Saving User");
        }
    }
}
