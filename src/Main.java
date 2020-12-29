import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String ADD_PRODUCT = "1/ Add product.";
    public static final String FIND_PRODUCT_BY_ID = "2/ Find product by id.";
    public static final String FIND_PRODUCT_BY_NAME = "3/ Find product by name.";
    public static final String FIND_PRODUCT_BY_MANUFACTURER = "4/ Find product by manufacturer.";
    public static final String FIND_PRODUCT_BY_PRICE = "5/ Find product by price.";
    public static final String DISPLAY_ALL_PRODUCTS = "6/ Display all products.";
    public static final String EXIT = "7. Exit.";

    static final Scanner scanner = new Scanner(System.in);
    public static final String NOT_AN_OPTION = "Not an option.";
    public static final String NO_PRODUCT_FOUND = "No product found.";

    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        displayOptions();
        int option = scanner.nextInt();
        while (option != 7) {
            if (option == 1) {
                addProduct();
            } else if (option == 2) {
                findProductById();
            } else if (option == 3) {
                findProductByName();
            } else if (option == 4) {
                findProductByManufacturer();
            } else if (option == 5) {
                findProductByPrice();
            } else if (option == 6) {
                displayAllProducts();
            } else {
                System.out.println(NOT_AN_OPTION);
            }

            displayOptions();
            option = scanner.nextInt();
        }
    }

    private static void displayOptions() {
        System.out.println(ADD_PRODUCT);
        System.out.println(FIND_PRODUCT_BY_ID);
        System.out.println(FIND_PRODUCT_BY_NAME);
        System.out.println(FIND_PRODUCT_BY_MANUFACTURER);
        System.out.println(FIND_PRODUCT_BY_PRICE);
        System.out.println(DISPLAY_ALL_PRODUCTS);
        System.out.println(EXIT);
    }

    private static void addProduct() {
        scanner.nextLine();
        System.out.println("Type: id, name, manufacturer, price, description.");
        productManager.addProduct(new Product(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
    }

    private static void findProductById() {
        scanner.nextLine();
        System.out.print("Type id: ");
        List<Product> result = productManager.findProductById(scanner.nextLine());
        if (result.size() == 0) {
            System.out.println(NO_PRODUCT_FOUND);
        } else {
            System.out.println(result.size() + " products found:");
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }

    private static void findProductByName() {
        scanner.nextLine();
        System.out.print("Type name: ");
        List<Product> result = productManager.findProductByName(scanner.nextLine());
        if (result.size() == 0) {
            System.out.println(NO_PRODUCT_FOUND);
        } else {
            System.out.println(result.size() + " products found:");
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }

    private static void findProductByManufacturer() {
        scanner.nextLine();
        System.out.print("Type manufacturer: ");
        List<Product> result = productManager.findProductByManufacturer(scanner.nextLine());
        if (result.size() == 0) {
            System.out.println(NO_PRODUCT_FOUND);
        } else {
            System.out.println(result.size() + " products found:");
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }

    private static void findProductByPrice() {
        scanner.nextLine();
        System.out.print("Type price: ");
        List<Product> result = productManager.findProductByPrice(scanner.nextLine());
        if (result.size() == 0) {
            System.out.println(NO_PRODUCT_FOUND);
        } else {
            System.out.println(result.size() + " products found:");
            for (Product product : result) {
                System.out.println(product);
            }
        }
    }

    private static void displayAllProducts() {
        if (productManager.getProducts().size() == 0) {
            System.out.println(NO_PRODUCT_FOUND);
        } else {
            System.out.println("All products:");
            for (Product product : productManager.getProducts()) {
                System.out.println(product);
            }
        }
    }

}
