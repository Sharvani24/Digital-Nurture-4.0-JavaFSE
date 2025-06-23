//Exercise 2: E-commerce Platform Search Function
//1. Understanding Asymptotic Notation
/*Big O Notation helps analyze how the runtime of an algorithm grows as the input size increases. It gives an upper bound on time or space complexity.
Best Case: Minimum time taken (e.g., element is at the start)
Average Case: Expected time over all possible inputs
Worst Case: Maximum time taken (e.g., element is at the end or not present)*/


//3. Implementation – Linear and Binary Search
// ECommerceSearch.java

import java.util.Arrays;
import java.util.Comparator;
//2. Setup – Product Class
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(name);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(4, "Phone", "Electronics"),
            new Product(5, "T-shirt", "Clothing")
        };

        System.out.println("=== Linear Search ===");
        String target = "Phone";
        Product result1 = linearSearch(productList, target);
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n=== Binary Search ===");
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2 = binarySearch(productList, target);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}

/*4. Analysis: Time Complexity
Algorithm	Best Case	Average Case	Worst Case
Linear Search	O(1)	O(n)	O(n)
Binary Search	O(1)	O(log n)	O(log n)

Which is better?
Linear Search is simple but inefficient for large datasets.
Binary Search is much faster but requires the array to be sorted.
*/