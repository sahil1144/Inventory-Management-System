import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {
        if (findProductById(product.getId()) != null) return false;
        products.add(product);
        return true;
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public boolean updateQuantity(int id, int newQuantity) {
        Product product = findProductById(id);
        if (product == null) return false;
        product.setQuantity(newQuantity);
        return true;
    }

    public boolean deleteProduct(int id) {
        Product product = findProductById(id);
        if (product == null) return false;
        products.remove(product);
        return true;
    }

    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Product product : products) {
            total += product.getTotalValue();
        }
        return total;
    }
}
