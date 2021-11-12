package controller.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", value="/LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //Data from Login Form
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        //Data from web.xml
        String uid = getServletContext().getInitParameter("username"); //hungtruong1297
        String pwd = getServletContext().getInitParameter("password"); //1234567890

        if (username.equalsIgnoreCase(uid) && password.equals(pwd)) {
            response.sendRedirect("adminPage.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            out.println("<font color='red'>Username or password is invalid</font>");
            dispatcher.include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
