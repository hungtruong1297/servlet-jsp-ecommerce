package controller.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ListProductDAO;
import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchController2", value="/SearchController2")
public class SearchController2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String text = request.getParameter("searchValue");
            request.setAttribute("products", new ListProductDAO().search(text));
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            response.getWriter().println(ex);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



}
