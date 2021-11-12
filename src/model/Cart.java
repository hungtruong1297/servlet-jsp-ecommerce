package model;

import java.util.ArrayList;
import java.util.List;

// Chua thong tin ve don hang hien tai. Bao gom nhieu ProductOrders
// ProductsOrders gom thong tin cua mot san pham trong don hang
public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void add(Product ci) {
        for (Product x : items) {
            if (ci.getId() == x.getId()) {
                x.setNumber(x.getNumber()+1);
                return;
            }
        }
        items.add(ci);
        // Pzo: add items, if same item, then increase item by 1
    }

    public void remove(int id) {
        for (Product x : items) {
            if (x.getId() == id) {
                items.remove(x);
                return;
            }
        }
    }

    public double getAmount() {
        double s = 0;
        for (Product x : items) {
            s += x.getPrice() * x.getNumber();
        }
        return Math.round(s*100.0) / 100.0;

    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
