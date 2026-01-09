import java.util.*;
public class AddToCart{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice=0;
            ProductRepository product = new ProductRepository();
            Cart cart= new Cart();
            try {
                System.out.println("--------------This is add to cart--------------\n\n        Main Menu");
                System.out.println("1.Register new product.\n2.Cart\n3.Exit.");
                choice= sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error in main menu input.");
            }
            switch (choice) {
                case 1:
                    product.addNewProduct();
                    break;
                case 2:
                    cart.cartOptionsList();
                    break;
                case 3:
                    System.out.println("Exiting...... ... ..   .");
                    return;
                default:
                    System.out.println("Enter a valid option.");
                    break;
            }
        }
    }
}
class Product{
    private String productID;
    private String productName;
    int productQuantity=0;
    double productPrice;
    public Product(String proName, double proPrice){
        this.productID = SetProductID.setProductID();
        this.productName = proName;
        this.productPrice = proPrice;
    }
        public String getProductId(){
        return productID;
    }
    
        public String getProductName(){
            return productName;
        }
    }
    class ProductRepository{
    static List<Product> products = new ArrayList<>();

public void addNewProduct() { 
        Scanner sc = new Scanner(System.in);
    try {
            System.out.println("Enter the name of the product you want to add:");
            String proName = sc.nextLine();
            System.out.println("Enter the Price of "+proName +" :");
            double proPrice =sc.nextDouble();
            Product p = new Product(proName, proPrice);
            products.add(p);
            System.out.println("New product added to the cart with ID:" + p.getProductId());
        } catch (Exception e) {
            System.out.println("Error in adding new product.");
        }
    }
    public List<Product> getProductList(){
        return products;
    }
}   // end of ProductRepository class
class SetProductID{
    static int id = 170;
    public static String setProductID() {
            return "PID"+ id++;
    }
}
class Cart{
    public void cartOptionsList(){
    Scanner sc = new Scanner(System.in);
    CartOptions cartOptions = new CartOptions();
    int choice=0;
    while (true) {
    try {
        System.out.println("            :Cart Options:\n1.Add to Cart\n2.Update quantity\n3.View products in cart\n4.Check out\n5.Exit");
        choice= sc.nextInt();  
    }
    catch (Exception e) {
        System.out.println("Error in reading cart options");
    }
        switch (choice) {
            case 1:
                cartOptions.addToCart();
                break;
            case 2:
                cartOptions.updateQuantity();
                break;
            case 3:
                cartOptions.viewCart();    
                break;
            case 4:
                cartOptions.checkOut();
                break;
            case 5:
                System.out.println("Exiting.... ...... .... ... . ");
                return;
            default:
                System.out.println("Enter a valid option.");
                break;
        }
        
    }
}
}
    class CartOptions{
        
        String productName=null;
        Scanner sc= new Scanner(System.in);
        List<Product> productInCartList = new ArrayList<>();        
        ProductRepository PR = new ProductRepository();
        List<Product> products =  PR.getProductList();

// addtoCart()

        public void addToCart(){
        boolean empty = products.isEmpty();
        boolean found= false;
        if(empty){
            System.out.println("No product is registered.");
        }else{
        try{
            System.out.println("Enter the name of the product you want to add:");
            productName = sc.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("Error in reading product name in cart options");
        }
        for(Product p : products){
           String pName =p.getProductName();
            if(pName.equals(productName)){
                    productInCartList.add(p);
                    System.out.println(pName+" is added to the cart list.");
                    found=true; 
                    break;

            }
        }
        if(!found){
            System.out.println(productName+ " not found");
        }
    }
}
   public void updateQuantity(){
    boolean empty = products.isEmpty();
    boolean found= false;
        if(empty){
            System.out.println("No product is registered.");
        }else{
        try{
            System.out.println("Enter the name of the product whose quantity you want to update:");
            productName = sc.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("Error in reading product name in cart options");
        }
        for(Product p : products){
           String pName =p.getProductName();
            if(pName.equals(productName)){
                    System.out.println("Enter the quantity you want to add:");
                    p.productQuantity= sc.nextInt();
                    found = true;
                    break;
            }

        } if(!found){
            System.out.println(productName+ " not found");
        }
    }
}
    public void viewCart(){
        boolean empty = productInCartList.isEmpty();
        if (empty) {
            System.out.println("No item in the cart.");
        }
        else{
            for(Product CO : productInCartList ){
                System.out.println("Name of the product "+CO.getProductName()+" Quantity: "+CO.productQuantity);
            }
        }
    }
    public void checkOut(){
            boolean empty = productInCartList.isEmpty();
            double total=0;
        if (empty) {
            System.out.println("No item in the cart.");
        }
        else{
            for(Product CO : productInCartList ){
                String pName= CO.getProductName();
                double pPrice= CO.productPrice;
                int pquantity = CO.productQuantity;
                double pTotalPrice = pPrice*pquantity;
                total+=pTotalPrice;
                System.out.println("Total for "+pName+" is"+pTotalPrice+".");
            }
        }
        System.out.println("Your total amount to be paid is:"+total);
    }
}