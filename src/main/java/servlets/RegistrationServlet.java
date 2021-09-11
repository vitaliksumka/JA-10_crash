package servlets;

import domain.UserRole;
import domain.User_domain;
import service_implementation.UserService;
import service_implementation.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getUserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
            request.setAttribute("firstName", firstName);
            userService.create(new User_domain(firstName, lastName, email, UserRole.USER.toString(), password));
        }
        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }
}
