//Exercise 2: E-commerce Platform Search Function
import java.util.*;

// Product class to store product details
class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name + ", Category: " + category + ", Price: $" + price);
    }
}

// Main class with search function
public class ECommerceSearch {
    public static void main(String[] args) {
        //Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple iPhone 15", "Electronics", 999.99));
        products.add(new Product("Samsung Galaxy S24", "Electronics", 899.99));
        products.add(new Product("Apple MacBook Pro", "Electronics", 1999.00));
        products.add(new Product("Sony Headphones", "Audio", 199.99));
        products.add(new Product("Nike Running Shoes", "Footwear", 129.49));
        products.add(new Product("Apple Watch", "Wearables", 399.00));
        products.add(new Product("Dell XPS 13", "Electronics", 1349.00));

        //Get user input for keyword search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter keyword to search products: ");
        String keyword = scanner.nextLine().toLowerCase();

        //Search products using basic string matching
        List<Product> matchedProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(keyword)) {
                matchedProducts.add(p);
            }
        }

        //Sort matched products by price in ascending order
        matchedProducts.sort(Comparator.comparingDouble(p -> p.price));

        //Display results
        if (matchedProducts.isEmpty()) {
            System.out.println("No products found for keyword: " + keyword);
        } else {
            System.out.println("\nSearch Results:");
            for (Product p : matchedProducts) {
                p.display();
            }
        }

        scanner.close();
    }
}
