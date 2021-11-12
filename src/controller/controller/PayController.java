package controller.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.OrdersDAO;
import java.io.IOException;
import java.io.PrintWriter;

import model.Cart;
import model.Orders;

@WebServlet(name = "/PayController" , value="/PayController")
public class PayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession(true);

            if (session.getAttribute("cart") == null) {

            }

            Cart c = (Cart) session.getAttribute("cart");
            String username = request.getParameter("name");
            String discount = request.getParameter("discount");
            String address = request.getParameter("address");

            Orders d = new Orders(username, 2, discount, address, "", null);

            OrdersDAO dao = new OrdersDAO();

            dao.insertOrder(d,c);
//            response.sendRedirect("pay.jsp");
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);


        } catch (Exception ex) {
            response.getWriter().println(ex);
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
