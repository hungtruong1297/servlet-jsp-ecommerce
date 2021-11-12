package controller.product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ListProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import model.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SearchController", value= "/SearchController")
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("search");
            // Open DAO and return list of result by "name"

            // Todo: Fix search(name) in ListProductDAO()
            List<Product> ls = new ListProductDAO().search(name);
            request.setAttribute("products", ls);
            RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
