import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
class ShoppingCart{
    private final CopyOnWriteArrayList<String> items;
public ShoppingCart(){
    this.items =  new CopyOnWriteArrayList<>();
}
public void addItem(String item){
    items.add(item);
    System.out.println(Thread.currentThread().getName() +" added : " + item);
}
public void removeItem(String item){
    if(items.remove(item)){
        System.out.println(Thread.currentThread().getName() +" removed : "+ item);
     } else {
        System.out.println(Thread.currentThread().getName() + " tried to remove " + item +", but could not find.");
    }
}
public List<String> getItems(){
        return new ArrayList<>(items);
}
}
class CustomThread extends Thread{
    private final ShoppingCart cart;
    private final String[] list;
    private String name;
    public CustomThread(String name, ShoppingCart cart, String[] list){
        this.name = name;
        this.cart = cart;
        this.list = list;
    }

    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        for(int i =0; i< list.length; i++){
            System.out.println("Do you want to add "+ list[i]+"\ny/n");
            char choice = sc.next().charAt(0);
            if(choice == 'y'){
                cart.addItem(list[i]);
            }
            else{
                cart.removeItem(list[i]);
            }

        }
    }
}
public class ThreadsafeShoppingCart {
    public static void main(String[] args) throws InterruptedException{
        ShoppingCart cart = new ShoppingCart();
        String[] list1 = {"Pen","Pineapple","Applepen"};
        String[] list2 = {"Bottle","Mug","Drum"};
        String[] list3 = {"Fan","Tubelight","Microwave"};
        CustomThread C1 = new CustomThread("Custormer 1", cart, list1);
        CustomThread C2 = new CustomThread("Custormer 2", cart, list2);
        CustomThread C3 = new CustomThread("Custormer 3", cart, list3);
        C1.start();
        C2.start();
        C3.start();
        C1.join();
        C2.join();
        C3.join();
        System.out.println("Final items in the cart:");
        System.out.println(cart.getItems());

    }
}
