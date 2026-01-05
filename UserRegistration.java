import java.util.*;
public class UserRegistration {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Registration");
        UserRepository userRepository = new UserRepository();
        User user = new User();
        while(true){
        System.out.println("1.Add User\n2.Show all Users\n3.Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                userRepository.addUser(user);
                break;
            case 2:
                userRepository.showUsers();
                break;
            case 3:
                System.out.println("Exiting...");
                return;
            default:
                break;
        }
    }
    }
}
class User{
    private String name;
    private String email;
    private String password;
    private String address;
    public User(){
        
    }
    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
    public String getAddress(){
        return address;
    }
}
class UserRepository {
    static List<User> users = new ArrayList<>();
    
    public static boolean isValidEmail(String emailcheck) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    return emailcheck != null && emailcheck.matches(emailRegex);

}
    public void addUser(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user name:");
        String name = scanner.nextLine();
        String email = null;
        boolean isemailvalid = false;
        while(!isemailvalid){
        System.out.println("Enter the user email:");
        email = scanner.nextLine(); 
        isemailvalid = isValidEmail(email);
        }        
        System.out.println("Enter the user password:");
        String password = scanner.nextLine();
        System.out.println("Enter the user shipping address:");
        String address = scanner.nextLine();   
        users.add(new User(name, email, password, address));
    }
    public void showUsers() {
        int IDcounter = 1;
        boolean isempty = users.isEmpty();
        if (isempty) {
            System.out.println("No users registered.");
            return;
        }else{
        for (User user : users) {
            System.out.println("User ID: " + IDcounter++);
            System.out.println("Name: " + user.getName() + ", \nEmail: " + user.getEmail() + ", \nShipping Address: " + user.getAddress());
        }
    }
    }
}