import java.util.*;
public class Person {
    private  String personName;
    private int personAge;
        public Person( String name, int age){
            this.personName = name;
            this.personAge = age;
        }
        public void getInfo(){
            System.out.println("The name of the person is:" + personName);
            System.out.println("The age of the person is:" + personAge);
        }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean entry = true;
        while(entry == true){
        System.out.println("Enter the name of the person.");                
        String name = sc.nextLine();                                        // problem!!! not reading this line after 1st loop
        System.out.println("Enter the age of the person.");
        int age = sc.nextInt();
        Person person1 = new Person(name, age);
        person1.getInfo();
        System.out.println("Do you want to enter another person.\n Y for yes.");
        char anotherEntry = sc.next().charAt(0);
        sc.skip("\\R"); // sc.nextLine();
        if (anotherEntry != 'Y' && anotherEntry != 'y'){
        entry = false;
        }
    }        

    }
}


        
            