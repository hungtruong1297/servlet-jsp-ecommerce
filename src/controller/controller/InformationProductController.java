package controller.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ListProductDAO;
import java.io.IOException;

@WebServlet(name = "InformationProductController", value= "/InformationProductController")
public class InformationProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        try {
//            int id = Integer.parseInt(request.getParameter("id"));
            String id = request.getParameter("id");
            ListProductDAO listProductDAO = new ListProductDAO();
            request.setAttribute("productDetail", listProductDAO.getProduct(id));
//            request.setAttribute("product", new ListProductDAO().getProduct(id));
            RequestDispatcher rd = request.getRequestDispatcher("infoProduct.jsp");
            rd.forward(request,response);
        }
        catch (Exception ex) {
            response.getWriter().println(ex);
        }
    }
}
