package controller.controller;

import dao.ListProductDAO;
import model.Product;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/HomeController")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //s1: get data from dao
        ListProductDAO listProductDao = new ListProductDAO();
        List<Product> products= listProductDao.getAllProducts();
        //s2: set attribute
        request.setAttribute("products",products);

        //s3: push data to .jsp
        request.getRequestDispatcher("home.jsp").forward(request,response);
//        response.sendRedirect("home2.jsp");
    }
}
