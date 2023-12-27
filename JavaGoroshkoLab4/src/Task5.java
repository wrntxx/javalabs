import shop.Categories;
import shop.Product;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Task5 {

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
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

        Formatter formatter = new Formatter(System.out);

        printBill(formatter, products, new Locale("en_US"));
        System.out.println();
        printBill(formatter, products, new Locale("uk_UA"));
        System.out.println();
        printBill(formatter, products, new Locale("pl_PL"));
        System.out.println();

        formatter.close();
    }

    private static void printBill(Formatter formatter, List<Product> products, Locale locale) {
        LocalDateTime dateTime = LocalDateTime.now();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.data", locale);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        String divider = "=".repeat(55) + "\n";
        String formattedDateTime = dateTime.format(dateFormatter);

        formatter.format("%-30s%25s%n", resourceBundle.getString("date.time.purchase"), formattedDateTime);
        formatter.format(divider);
        formatter.format("%-5s%-20s%-20s%-10s%n", "#",
                resourceBundle.getString("product"),
                resourceBundle.getString("category"),
                resourceBundle.getString("price"));
        formatter.format(divider);

        int productNumber = 1;
        double totalCost = 0;

        for (Product product : products) {
            formatter.format("%-5d%-20s%-20s%-10s\n",
                    productNumber++,
                    product.getName(),
                    product.getCategory(),
                    currencyFormat.format(product.getPrice()));
            totalCost += product.getPrice();
        }

        formatter.format(divider);
        formatter.format("%-45s%-10s\n", resourceBundle.getString("total"), currencyFormat.format(totalCost));
    }
}