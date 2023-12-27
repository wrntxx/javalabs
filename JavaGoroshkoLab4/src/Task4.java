import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import shop.Categories;
import shop.Product;

public class Task4 {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<Product>();

        products.add(new Product("T-Shirt", Categories.MENS_CLOTHING, 19.99));
        products.add(new Product("Jeans", Categories.WOMENS_CLOTHING, 49.99));
        products.add(new Product("Sneakers", Categories.MENS_CLOTHING, 39.99));
        products.add(new Product("Dress Shirt", Categories.WOMENS_CLOTHING, 29.99));
        products.add(new Product("Running Shoes", Categories.MENS_CLOTHING, 59.99));
        products.add(new Product("Skirt", Categories.WOMENS_CLOTHING, 34.99));
        products.add(new Product("Hoodie", Categories.MENS_CLOTHING, 44.99));
        products.add(new Product("Blouse", Categories.WOMENS_CLOTHING, 27.99));
        products.add(new Product("Casual Shoes", Categories.MENS_CLOTHING, 49.99));
        products.add(new Product("Jacket", Categories.WOMENS_CLOTHING, 69.99));

        printBill(products);
    }

    private static void printBill(List<Product> products) {
        Formatter formatter = new Formatter(System.out);

        formatter.format("\nDate and time of purchase:%28s%n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        formatter.format("======================================================\n");
        formatter.format("%-5s%-20s%-20s%-10s%n", "#", "Product", "Category", "Price");
        formatter.format("======================================================\n");

        int productNumber = 1;
        double totalCost = 0;

        for (Product product : products) {
            formatter.format("%-5d%-20s%-20s%.2f $\n",
                    productNumber++,
                    product.getName(),
                    product.getCategory(),
                    product.getPrice());
            totalCost += product.getPrice();
        }

        formatter.format("======================================================\n");
        formatter.format("%-45s%.2f $\n", "Total:", totalCost);

        formatter.flush();
        formatter.close();
    }
}
