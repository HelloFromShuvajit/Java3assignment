 //the instructions below to complete the assignment:

//1. Create an abstract class called `Vehicle` with the following attributes and methods:
//- Attributes:
//- `make` (String): Represents the make of the vehicle.
//- `model` (String): Represents the model of the vehicle.
//- `year` (int): Represents the year of manufacture of the vehicle. - `price` (double): Represents the price of the vehicle.
//- Methods:
//- `displayDetails()`: Abstract method that should be implemented by the subclasses to display the details of the vehicle.

//2. Create two subclasses of `Vehicle`: `Car` and `Motorcycle`. Each subclass should inherit from the `Vehicle` class and add its own specific attributes and methods:
//- `Car`:
//- Additional attributes:
//- `numDoors` (int): Represents the number of doors the car has.
//- `fuelType` (String): Represents the type of fuel the car uses.
//- Additional methods:
//- `calculateMileage()`: Calculates and returns the mileage of the car based on certain criteria.
//- `Motorcycle`:
//- Additional attributes:
//- `hasSidecar` (boolean): Indicates whether the motorcycle has a sidecar or not. - `engineCapacity` (int): Represents the engine capacity of the motorcycle. - Additional methods:
//- `calculateSpeed()`: Calculates and returns the top speed of the motorcycle based on certain criteria.
//3. In the `displayDetails()` method of each subclass, override the method from the `Vehicle` class to display the specific details of the car or motorcycle, including the additional attributes.

//4. In the `Main` class, create an inventory system where you can add and manage different vehicles. Implement the following functionalities:
//- Allow the user to add vehicles to the inventory by providing details such as make, model, year, price, and any specific attributes related to the vehicle type.
//- Provide an option to display the details of all the vehicles in the inventory.
//- Implement a search functionality that allows the user to search for a vehicle based on a specific criteria (e.g., make, model, price range).
//- Allow the user to update the details of a specific vehicle in the inventory.
//- Implement a feature to remove a vehicle from the inventory.

//5. Test the program by adding multiple vehicles to the inventory, displaying the details of all vehicles, searching for specific vehicles, updating vehicle details, and removing vehicles from the inventory.
import java.util.*;
import java.util.HashMap;
import java.util.Map;
public class AbsVehicle {
            public static void main(String[] args){
              
                System.out.println("Enter the vehicle details.");
                Scanner sc = new Scanner(System.in);
                System.out.println("What type of vehicle do you want to add./n1 for Car./n2 for Motorcycle./n3 to see added car details/n4 to see added motorcycle details/n5 for exit.");
                int vehicleChoice= sc.nextInt();

                switch (vehicleChoice) {
                  case 1:
                    Car carNew= new Car();  
                    carNew.carDetails();                    
                    main(args);
                    break;
                  case 2:
                    Motorcycle motorcycleNew= new Motorcycle();
                    motorcycleNew.motorCycleDetails();
                    main(args);
                    break;
                  case 3:
                    Car carDisplay= new Car();
                    carDisplay.displayDetails();
                    main(args);
                    break;
                  case 4:
                    Motorcycle motorDisplay= new Motorcycle();
                    motorDisplay.displayDetails();
                    main(args);
                    break;
                  case 5:
                    System.out.println("Exiting------");
                    break;
                  default:
                    System.out.println("Enter a valid choice!!");
                    main(args);
                    break;
                }
            }   
    
}
class CarRecord{
  String make;
  String model;
  int year; 
  double price;
  int door;
  String fuel;
  CarRecord(String make, String model, int year, double price, int door, String fuel){
    this.make= make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.door = door;
    this.fuel = fuel;
  }
   void displayCar(){
      System.out.println("Year: " + year);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Door: " + door);
        System.out.println("Fuel: " + fuel);
      
    }

}
class MotorcycleRecord{
  String make;
  String model;
  int year; 
  double price;
  int engineCapacity;
  boolean hasSidecar;
  MotorcycleRecord(String make, String model, int year, double price, boolean hasSidecar, int engineCapacity){
    this.make= make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.hasSidecar = hasSidecar;
    this.engineCapacity = engineCapacity;
  }
   void displayMotorCycle(){
      System.out.println("Year: " + year);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Side car: " + hasSidecar);
        System.out.println("Engine Capacity: " + engineCapacity +"cc"); 
    }
}

 abstract class Vehicle {
    String Make;
    String Model;
    int year;
    double price;
    public abstract displayDetails(){

    }
 }
  class Car extends Vehicle {
    int numDoors;
    String fuelType;
    Scanner s = new Scanner(System.in);
    Map<Integer, CarRecord> carMap = new HashMap<>();

    public void carDetails(){
    boolean entryChoice = true;
    int i= 0;
    while (entryChoice == true){
      i++;
    System.out.println("Enter the make of the car:");
    String makeCar = s.nextLine();
  
    System.out.println("Enter the model of the car:");
    String modelCar = s.nextLine();
    
    System.out.println("Enter the year of the car:");
    int yearCar =s.nextInt();

    System.out.println("Enter the price of the car:");
    double priceCar = s.nextDouble();
    
    System.out.println("Enter the number of doors of the car:");
    int numdoorsCar = s.nextInt();
    
    System.out.println("Enter the type of fuel of the car:");
    String fuelCar = s.nextLine();                                  
   // s.skip("\\R");           //to remove /n issue
    System.out.println(fuelCar);
            carMap.put(i,new CarRecord(makeCar, modelCar, yearCar, priceCar, numdoorsCar,fuelCar));

    System.out.println("Do want to enter another car details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    }
    }
    }
    public void displayDetails(){
                
                  // for showing all car details

                for (Map.Entry<Integer, CarRecord> entry :carMap .entrySet()) {
                  System.out.println("Car ID: " + entry.getKey());
                  entry.getValue().displayCar();
                } 
            }
    public double calculateMileage(){

    }
  }

  class Motorcycle extends Vehicle {
            boolean hasSidecar;
            int engineCapacity;
            Scanner s = new Scanner(System.in);
    Map<Integer, MotorcycleRecord> motorMap = new HashMap<>();

    public void motorCycleDetails(){
    boolean entryChoice = true;
    int i= 0;
    while (entryChoice == true){
      i++;
    System.out.println("Enter the make of the motorcycle:");
    String makeCar = s.nextLine();
  
    System.out.println("Enter the model of the motorcycle:");
    String modelCar = s.nextLine();
    
    System.out.println("Enter the year of the motorcycle:");
    int yearCar =s.nextInt();

    System.out.println("Enter the price of the motorcycle:");
    double priceCar = s.nextDouble();
    
    System.out.println("Enter \"true\" if the motorcycle has a side car:");
    boolean hasSidecar = s.nextBoolean();
    
    System.out.println("Enter the engine capacity of the motorcycle:");
    int engineCapacity = s.nextInt();
    //s.skip("\\R");           //to remove /n issue
    motorMap.put(i,new MotorcycleRecord(makeCar, modelCar, yearCar, priceCar, hasSidecar,engineCapacity));

    System.out.println("Do want to enter another car details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    }
    }
    }
            public double calculateSpeed(){


            }
            
            public void displayDetails(){
                
                  // for showing all Motorcycle details

                for (Map.Entry<Integer, MotorcycleRecord> entry : motorMap.entrySet()) {
                  System.out.println("Motor Cycle ID: " + entry.getKey());
                  entry.getValue().displayMotorCycle();
                } 
            }
    
  }