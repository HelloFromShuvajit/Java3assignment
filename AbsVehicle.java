import java.util.*;
import java.util.HashMap;
import java.util.Map;
public class AbsVehicle {
            public static void main(String[] args){
              while (true) {
    System.out.println("----------Enter the vehicle details.----------");
                Scanner sc = new Scanner(System.in);
                System.out.println("What type of vehicle do you want to add.\n1 for Car.\n2 for Motorcycle.\n3 to see added car details\n4 to see added motorcycle details\n5 for exit.");
                int vehicleChoice= sc.nextInt();
                Car carNew= new Car();
                Motorcycle motorcycleNew= new Motorcycle();

                switch (vehicleChoice) {
                  case 1:
                    carNew.carDetails();                    
                    main(args);
                    break;
                  case 2:
                    motorcycleNew.motorCycleDetails();
                    main(args);
                    break;
                  case 3:
                    carNew.displayDetails();
                    main(args);
                    break;
                  case 4:
                    motorcycleNew.displayDetails();
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
    public abstract void displayDetails();
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
     s.nextLine();            // s.skip("\\n");
               //to remove /n issue
    System.out.println(fuelCar);
            carMap.put(i,new CarRecord(makeCar, modelCar, yearCar, priceCar, numdoorsCar,fuelCar));

    System.out.println("Do want to enter another car details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    }
     for (Map.Entry<Integer, CarRecord> entry :carMap .entrySet()) {
                  System.out.println("Car ID: " + entry.getKey());
                  entry.getValue().displayCar();
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
        System.out.print("Enter distance traveled in km: ");
        double distance = s.nextDouble();

        System.out.print("Enter fuel used in liters: ");
        double fuel = s.nextDouble();

        if (fuel <= 0) {
            System.out.println("Fuel used cannot be zero or negative.");
        } else {
            double mileage = distance / fuel;
            System.out.printf("The mileage is: %.2f km/L\n", mileage);
        }
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
    String makeMotor = s.nextLine();
  
    System.out.println("Enter the model of the motorcycle:");
    String modelMotor = s.nextLine();
    
    System.out.println("Enter the year of the motorcycle:");
    int yearMotor =s.nextInt();

    System.out.println("Enter the price of the motorcycle:");
    double priceMotor = s.nextDouble();
    
    System.out.println("Enter \"true\" if the motorcycle has a side car:");
    boolean hasSidecar = s.nextBoolean();
    
    System.out.println("Enter the engine capacity of the motorcycle:");
    int engineCapacity = s.nextInt();
    s.skip("\\R");           //to remove /n issue
    motorMap.put(i,new MotorcycleRecord(makeMotor, modelMotor, yearMotor, priceMotor, hasSidecar,engineCapacity));

    System.out.println("Do want to enter another car details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    }
    }
  }
            public double calculateSpeed(){
        System.out.print("Enter the distance traveled (in km): ");
        double distance = s.nextDouble();
        System.out.print("Enter the time taken (in hours): ");
        double time = s.nextDouble();
        if (time > 0) {
            double speed = distance / time;
            System.out.println("The speed of the motorcycle is: " + speed + " km/h");
        } else {
            System.out.println("Time cannot be zero or negative.");
        }

            }
            
            public void displayDetails(){
                
                  // for showing all Motorcycle details

                for (Map.Entry<Integer, MotorcycleRecord> entry : motorMap.entrySet()) {
                  System.out.println("Motor Cycle ID: " + entry.getKey());
                  entry.getValue().displayMotorCycle();
                } 
            }
    
  }