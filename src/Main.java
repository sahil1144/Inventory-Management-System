import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Delete Product");
            System.out.println("6. Total Inventory Value");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    if (price < 0 || quantity < 0) {
                        System.out.println("Price and quantity cannot be negative.");
                    } else {
                        Product product = new Product(id, name, price, quantity);
                        if (manager.addProduct(product))
                            System.out.println("Product added successfully.");
                        else
                            System.out.println("Product ID already exists.");
                    }
                    break;

                case 2:
                    manager.displayAllProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    id = scanner.nextInt();
                    Product product = manager.findProductById(id);
                    System.out.println(product != null ? product : "Product not found.");
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();

                    if (quantity < 0)
                        System.out.println("Quantity cannot be negative.");
                    else if (manager.updateQuantity(id, quantity))
                        System.out.println("Quantity updated successfully.");
                    else
                        System.out.println("Product not found.");
                    break;

                case 5:
                    System.out.print("Enter product ID: ");
                    id = scanner.nextInt();

                    if (manager.deleteProduct(id))
                        System.out.println("Product deleted successfully.");
                    else
                        System.out.println("Product not found.");
                    break;

                case 6:
                    System.out.println("Total inventory value: "
                            + manager.calculateTotalInventoryValue());
                    break;

                case 7:
                    scanner.close();
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
