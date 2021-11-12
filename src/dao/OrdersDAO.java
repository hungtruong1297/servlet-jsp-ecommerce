package dao;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OrdersDAO {
    public void insertOrder(Orders o, Cart c) throws Exception {
        //Todo: waiting for Hung to fill in.
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String userMail = o.getUserMail();
        String address = o.getAddress();

        int productID;
        int productAmount;
        float productPrice;

        int orderID = -1;

        // Query - Separating into 2 Queries (AddToOrders and AddToOrdersDetail)
        // Add to Orders
        String queryAddToOrders = "INSERT INTO ORDERS " +
                "(USER_MAIL, ORDER_ADDRESS) " +
                "VALUES (?,?)";
        try {
            // Query for Add To Orders
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(queryAddToOrders, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, userMail);
            ps.setString(2, address);
            ps.execute();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                orderID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Add to Orders_detail
        String queryAddToOrdersDetail = "INSERT INTO ORDERS_DETAIL " +
                "(ORDER_ID, PRODUCT_ID, AMOUNT_PRODUCT, PRICE_PRODUCT)" +
                "VALUES (?,?,?,?);";

        try {
            // Query for Add To Orders_detail
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(queryAddToOrdersDetail);

            List<Product> cart = c.getItems();
            for (Product p : cart) {
                productID = p.getId();
                productAmount = p.getNumber();
                productPrice = p.getPrice();

                ps.setInt(1, orderID);
                ps.setInt(2, productID);
                ps.setInt(3, productAmount);
                ps.setFloat(4, productPrice);

                ps.execute();
                System.out.println(queryAddToOrdersDetail);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Orders orders = new Orders();
        orders.setUserMail("user@gmail.com");
        orders.setAddress("Dak Lak");

        Cart cart = new Cart();
        cart.add(new Product(1, "iPhone", "this is made by steve jobs", 55, "src", "cellphone", "apple",1));
        cart.add(new Product(2, "iPhone", "this is made by steve jobs", 55, "src", "cellphone", "apple",2));

        OrdersDAO dao = new OrdersDAO();
        dao.insertOrder(orders, cart);
    }
}
