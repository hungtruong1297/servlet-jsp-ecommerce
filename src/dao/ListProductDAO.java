package dao;

import context.DBContext;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListProductDAO {
    // Todo: Hung's edit
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

    public List<Product> search(String characters) throws Exception {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products WHERE product_name LIKE " + "'%" + characters + "%'";
        System.out.println("Query: " + query);
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // According to Product's constructor.
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }

        } catch (Exception e) {

        }

        return list;
    }

    public List<Product> getProduct(String product_id) throws Exception {
        List<Product> list = new ArrayList<>();
        String query = "select * from products where product_id = " + product_id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // According to Product's constructor.
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    // Todo: Hung's edit
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "select * from products";
        try {

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // According to Product's constructor.
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }



        } catch (Exception e) {

        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        ListProductDAO listProductDao = new ListProductDAO();
        List<Product> products= listProductDao.getAllProducts();
        System.out.println(products.toString());
    }
}
