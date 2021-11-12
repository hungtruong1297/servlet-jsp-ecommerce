package controller.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ListProductDAO;
import java.io.IOException;
import java.util.List;

import model.Cart;
import model.Product;

@WebServlet(name = "AddToCartController", value = "/AddToCartController")
public class AddToCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);

            String action = request.getParameter("action");
            String id = request.getParameter("id");


            if (action != null && action.equalsIgnoreCase("add")) {

                // If cart is null, create a new Cart
                if (session.getAttribute("cart") == null) {
                    session.setAttribute("cart", new Cart());
                }

                // Get product by ID
                List<Product> list = new ListProductDAO().getProduct(id);
                Product p = list.get(0);

                // Add product to Cart
                // "cart" here is same with "cart" above. Same object.
                Cart c = (Cart) session.getAttribute("cart");
                c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(),
                        p.getSrc(), p.getType(), p.getBrand(), 1));

            } else if (action != null && action.equalsIgnoreCase("delete")) {
                // Remove cart by ID
                Cart c = (Cart) session.getAttribute("cart");
                c.remove(Integer.parseInt(id));

            }
            // Redirect to cart.jsp
            response.sendRedirect("cart.jsp");
        } catch (Exception ex) {
            response.getWriter().println(ex);
        }
    }
}
