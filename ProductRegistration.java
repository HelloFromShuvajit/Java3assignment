import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ProductRegistration {
        public static void main (String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------Product Registration--------------");
            ProductRepository productRepository = new ProductRepository();
            int choice;
            while(true){
                try{
                    System.out.println("1.Add Product\n2.Show all Products\n3.Check to expiration\n4.Search Product by ID\n5.Remove Product\n6.Exit");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine(); // clear the invalid input
                continue;
            }
                
                switch (choice) {
                    case 1:
                        productRepository.addProduct();
                        break;
                    case 2:
                        productRepository.showProducts();
                        break;
                    case 3:
                        productRepository.checkExpiration();
                        break; 
                    case 4:
                        productRepository.searchProductByID();
                        break;
                    case 5:
                        productRepository.removeProduct();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
            }
        }
}
class SetProductID{
    static int id = 169;
    public static String generateID(){
        return "PID"+id++;
    }
}
class Product{
    String productID;
    String productName;
    String productManufacturer;
    String productExpirationDate;
    String productDescription;
    public Product(String productName, String productManufacturer, String productExpirationDate, String productDescription) {
        this.productID = SetProductID.generateID();
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productExpirationDate = productExpirationDate;
        this.productDescription = productDescription;

    }
}
class ProductRepository {
    static List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addProduct(){
        String name;
        String manufacturer;
        String expirationDate;
        String description = null;
        try{
        System.out.print("Enter Product Name: ");
        name = scanner.nextLine();
        } catch (Exception e) {
        System.out.println("Error reading product name.");
        return;
        }
        try{
        System.out.print("Enter Product Manufacturer: ");
        manufacturer = scanner.nextLine();
        } catch (Exception e) {
        System.out.println("Error reading product manufacturer.");
        return;
        }
        try{
        System.out.print("Enter Product Expiration Date (yyyy-MM-dd): ");
        expirationDate = scanner.nextLine();
        } catch (Exception e) {
        System.out.println("Error reading product expiration date.");
        return;
        }
        try{
        System.out.print("Enter Product Description: ");
        description = scanner.nextLine();
        } catch (Exception e) {
        System.out.println("Error reading product description.");
        }
        Product product = new Product(name, manufacturer, expirationDate, description);
        products.add(product);
        System.out.println("Product added successfully with ID: " + product.productID);
    }
    public void showProducts(){
        boolean empty = products.isEmpty();
        if(empty){
            System.out.println("No products registered.");
            return;
        }else{
        for(Product p : products){
            System.out.println("ID: " + p.productID + ", \nName: " + p.productName + ", \nManufacturer: " + p.productManufacturer + ", \nExpiration Date: " + p.productExpirationDate + ", \nDescription: " + p.productDescription);
        }
    }
    }
    public void checkExpiration(){
        boolean empty =products.isEmpty();
        if(empty){
            System.out.println("No products registered in the system.");
            return;
        }else{
        }
        try{

        System.out.print("Enter Product ID to check expiration: ");
        String id = scanner.nextLine();
        for(Product p : products){
            if(p.productID.equals(id)){
                LocalDate expirationDate = LocalDate.parse(p.productExpirationDate);
                LocalDate today = LocalDate.now();
                if(expirationDate.isBefore(today)){
                    System.out.println("Product ID: " + id + " " + p.productName + " is Expired.");
                } else {
                    System.out.println("Product ID: " + id + " " + p.productName + " is Still valid.");
                }
                return;
            }
        }
        System.out.println("Product ID not found.");
        }
        catch(Exception e){
            System.out.println("Error processing expiration check.");
        }
    }
    public void searchProductByID(){
        boolean empty =products.isEmpty();
        if(empty){
            System.out.println("No products registered in the system.");
            return;
        }else{
            try{
                System.out.println("Enter Product ID that you want to search:");
        String id= scanner.nextLine();
        boolean found = false;
        for(Product p : products){
            if(p.productID.equals(id)){
                System.out.println("ID: " + p.productID + ", \nName: " + p.productName + ", \nManufacturer: " + p.productManufacturer + ", \nExpiration Date: " + p.productExpirationDate + ", \nDescription: " + p.productDescription);
                return;
            }
            if(!found){
                System.out.println("Product ID not found.");
            }
        }
        } catch (Exception e){
            System.out.println("Error processing product search.");
            }
        
    }
    }

public void removeProduct(){
    boolean empty = products.isEmpty();
    if(empty){
        System.out.println("No products registered in the system.");
        return;
    } else{
        try{
            System.out.println("Enter the Product ID that you want to remove:");
            String id = scanner.nextLine();
            Iterator<Product> iterator = products.iterator();
            while(iterator.hasNext()){
                Product p = iterator.next();
                if(p.productID.equals(id)){
                    iterator.remove();
                    System.out.println("Product ID: " + id + " has been removed.");
                    return;
                }
            }
        } catch (Exception e){
            System.out.println("Error processing product removal.");
    }
    }
}
}

