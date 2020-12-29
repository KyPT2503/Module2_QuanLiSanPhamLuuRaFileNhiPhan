import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new LinkedList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("products.dat"));

            Product product = null;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                products.add(product);
            }

            objectInputStream.close();
        } catch (IOException e) {

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Can't open file");
        }
    }

    public void addProduct(Product product) {
        try {
            products.add(product);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("products.dat"));

            for (Product productOfProducts : products) {
                objectOutputStream.writeObject(productOfProducts);
            }

            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Can't open file");
            products.remove(products.size() - 1);
        }
    }

    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductById(String id) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductByManufacturer(String manufacturer) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getManufacturer().equals(manufacturer)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findProductByPrice(String price) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().equals(price)) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProducts() {
        return products;
    }
}
