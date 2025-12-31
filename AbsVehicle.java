import java.util.*;
public class AbsVehicle {
            public static void main(String[] args){
              Scanner sc = new Scanner(System.in);
              while (true) {
                System.out.println("----------Enter the vehicle details.----------");
                System.out.println("What type of vehicle do you want to add.\n1 for Car.\n2 for Motorcycle.\n3 to see added car details\n4 to see added motorcycle details\n5 for calculating mileage\n6 for calculating speed\n7 for updating information\n8 for search a vehicle \n9 for exit.");
                int vehicleChoice= sc.nextInt();
                Car carNew= new Car();
                Motorcycle motorcycleNew= new Motorcycle();

                switch (vehicleChoice) {
                  case 1:
                    carNew.carDetails();                    
                    break;
                  case 2:
                    motorcycleNew.motorCycleDetails();
                    break;
                  case 3:
                    carNew.displayDetails();
                    break;
                  case 4:
                    motorcycleNew.displayDetails();
                    break;
                  case 5:
                    carNew.calculateMileage();
                    break;
                  case 6:
                    motorcycleNew.calculateSpeed();
                    break;
                  case 7:
                    updateInfo();
                    break;
                  case 8:
                    searchVehicle();
                    break;
                  case 9:
                    System.out.println("Exiting------");
                    return;
                  default:
                    System.out.println("Enter a valid choice!!");
                    break;
                }
            }
          }
public static void updateInfo(){
        System.out.println("What type of vehicle do you want to update.\n1 for Car.\n2 for Motorcycle.");
        Scanner sc = new Scanner(System.in);
        int updateChoice= sc.nextInt();
        switch (updateChoice) {
          case 1:
            Car.updateCar();                    
            break;
          case 2:
            Motorcycle.updateMotorcycle();
            break;
          default:
            System.out.println("Enter a valid choice!!");
            break;
        }
}
public static void searchVehicle(){
        System.out.println("What type of vehicle do you want to search.\n1 for Car.\n2 for Motorcycle.");
        Scanner sc = new Scanner(System.in);
        int searchChoice= sc.nextInt();
        switch (searchChoice) {
          case 1:
            Car.searchCar();                    
            break;
          case 2:
            Motorcycle.searchMotorcycle();
            break;
          default:
            System.out.println("Enter a valid choice!!");
            break;
        }
}
}
class CarRecord{
  int id;
  String make;
  String model;
  int year; 
  double price;
  int door;
  String fuel;
  CarRecord(int id, String make, String model, int year, double price, int door, String fuel){
    
    this.id= id;
    this.make= make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.door = door;
    this.fuel = fuel;
  }
   void displayCar(){
    System.out.println("Car Details:");
      System.out.println("Year: " + year);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Door: " + door);
        System.out.println("Fuel: " + fuel);
      
    }

}
class MotorcycleRecord{
  int id;
  String make;
  String model;
  int year; 
  double price;
  int engineCapacity;
  boolean hasSidecar;
  MotorcycleRecord(int id, String make, String model, int year, double price, boolean hasSidecar, int engineCapacity){
    this.id= id;
    this.make= make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.hasSidecar = hasSidecar;
    this.engineCapacity = engineCapacity;
  }
   void displayMotorCycle(){
      System.out.println("Motor Cycle Details:");
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
  static List<CarRecord> carList = new ArrayList<>();
    public void carDetails(){
    boolean entryChoice = true;
    int i= 0;
    while (entryChoice == true){
      i++;
      s.nextLine();
    s.skip("\\R");   
    System.out.println("Enter the make of the car:");
    String makeCar = s.nextLine();
  
    System.out.println("Enter the model of the car:");
    String modelCar = s.nextLine();
    
    System.out.println("Enter the year of the car:");
    int yearCar =s.nextInt();

    System.out.println("Enter the price of the car:");
    double priceCar = s.nextDouble();
            s.nextLine();

    System.out.println("Enter the type of fuel of the car:");
    String fuelCar = s.nextLine(); 
    
    System.out.println("Enter the number of doors of the car:");
    int numdoorsCar = s.nextInt();
                                     
s.nextLine();
    s.skip("\\R");   
                carList.add(new CarRecord(i,makeCar, modelCar, yearCar, priceCar, numdoorsCar,fuelCar)); 

    System.out.println("Do want to enter another car details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    }
    }
    }
    
    public void displayDetails(){
                
                  // for showing all car details

                if (carList.isEmpty()) {
                  System.out.println("No car details available.");
                } 

                for (int j = 0; j < carList.size(); j++) {   
                  System.out.println("Car ID: " + (j + 1));
                  carList.get(j).displayCar();
                }
            }
        static void updateCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (CarRecord c : carList) {
            if (c.id == id) {
              System.out.println("Do you want to update the following details?\n 1 for price\n 2 for door number\n 3 for both");
              int updateChoice = sc.nextInt();
              if (updateChoice == 1){
                System.out.print("New price: ");
                c.price = sc.nextDouble();
                System.out.println("Car updated!");
                return;
              }
              else if (updateChoice == 2){
                System.out.print("New door number: ");
                c.door = sc.nextInt();
                System.out.println("Car updated!");
                return;
              }
              else if (updateChoice == 3){  
              System.out.print("New price: ");
                c.price = sc.nextDouble();
                System.out.print("New door number: ");
                c.door = sc.nextInt();
                System.out.println("Car updated!");
                return;
            }
      }
        else{System.out.println("Car not found.");
        }
    }
  }
    public void calculateMileage(){
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
    static void searchCar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for searching by make.\n2 for searching by year.\n3 for searching by price range.");
        int searchChoice = sc.nextInt();
        sc.nextLine();
        sc.skip("\\R");
        if (searchChoice == 1) {
          System.out.print("Enter car make to search: ");
        String searchMake = sc.nextLine();
        boolean found = false;

        for (CarRecord c : carList) {
            if (c.make.equalsIgnoreCase(searchMake)) {
                c.displayCar();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No car found with make: " + searchMake);
        }
    } else if (searchChoice == 2){
        System.out.print("Enter car year to search: ");
        int searchYear = sc.nextInt();
        boolean found = false;
        for (CarRecord c : carList) {
            if (c.year == searchYear) {
                c.displayCar();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No car found from year: " + searchYear);
      }
    }
       else if (searchChoice == 3){
        System.out.print("Enter minimum price: ");
        double minPrice = sc.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = sc.nextDouble();
        boolean found = false;
        for (CarRecord c : carList) {
            if (c.price >= minPrice && c.price <= maxPrice) {
                c.displayCar();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No car found in the price range.");
        }
    }
  }
  }
class Motorcycle extends Vehicle {
            boolean hasSidecar;
            int engineCapacity;
            Scanner s = new Scanner(System.in);
      static List<MotorcycleRecord> motorList = new ArrayList<>();

    public void motorCycleDetails(){
    boolean entryChoice = true;
    int i= 0;
    while (entryChoice == true){
      i++;
      s.nextLine();
    s.skip("\\R");   
    System.out.println("Enter the make of the motorcycle:");
    String makeMotor = s.nextLine();
  
    System.out.println("Enter the model of the motorcycle:");
    String modelMotor = s.nextLine();
    
    System.out.println("Enter the year of the motorcycle:");
    int yearMotor =s.nextInt();
    
    System.out.println("Enter the engine capacity of the motorcycle:");
    int engineCapacity = s.nextInt();

    System.out.println("Enter the price of the motorcycle:");
    double priceMotor = s.nextDouble();

    System.out.println("Enter \"true\" if the motorcycle has a side car\n \"false\" otherwise:");
    boolean hasSidecar = s.nextBoolean();
    s.nextLine();
    s.skip("\\R");           //to remove \n issue
    motorList.add(new MotorcycleRecord(i,makeMotor, modelMotor, yearMotor, priceMotor, hasSidecar,engineCapacity));        // this has to change

    System.out.println("Do want to enter another motorcycle details? [Y/N]");
    char newcarEntry = s.next().charAt(0);
    if (newcarEntry == 'N' || newcarEntry == 'n'){
        entryChoice = false; 
    } 
    }
  }
            public static void searchMotorcycle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 for searching by make.\n2 for searching by year.\n3 for searching by price range.\n4 for searching by engine capacity.\n5 for searching by sidecar availability.");
        int searchChoice = sc.nextInt();
        sc.nextLine();
        sc.skip("\\R");
        switch (searchChoice) {
          case 1:
            System.out.print("Enter motorcycle make to search: ");
            String searchMake = sc.next();
            boolean found = false;
            for (MotorcycleRecord m : motorList) {
                if (m.make.equalsIgnoreCase(searchMake)) {
                    m.displayMotorCycle();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No motorcycle found with make: " + searchMake);
            }
            break;
          case 2:
            System.out.print("Enter motorcycle year to search: ");
            int searchYear = sc.nextInt();
            found = false;
            for (MotorcycleRecord m : motorList) {
                if (m.year == searchYear) {
                    m.displayMotorCycle();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No motorcycle found from year: " + searchYear);
            }
            break;
          case 3:
            System.out.print("Enter minimum price: ");
            double minPrice = sc.nextDouble();
            System.out.print("Enter maximum price: ");
            double maxPrice = sc.nextDouble();
            found = false;
            for (MotorcycleRecord m : motorList) {
                if (m.price >= minPrice && m.price <= maxPrice) {
                    m.displayMotorCycle();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No motorcycle found in the price range.");
            }
          case 4:
              System.out.print("Enter engine capacity to search: ");
              int searchEngineCapacity = sc.nextInt();
              found = false;
              for (MotorcycleRecord m : motorList) {
                  if (m.engineCapacity == searchEngineCapacity) {
                      m.displayMotorCycle();
                      found = true;
                  }
              }
              if (!found) {
                  System.out.println("No motorcycle found with engine capacity: " + searchEngineCapacity);
              }
              break;
          case 5:
              System.out.print("Enter sidecar availability [true/false]: ");
              boolean hasSidecarSearch = sc.nextBoolean();
              found = false;
              for (MotorcycleRecord m : motorList) {
                  if (m.hasSidecar == hasSidecarSearch) {
                      m.displayMotorCycle();
                      found = true;
                  }
              }
              if (!found) {
                  System.out.println("No motorcycle with sidecar availability: " + hasSidecarSearch);
              }
              break;

          default:
            break;
        }
      }
            public void calculateSpeed(){
        System.out.print("Enter the distance traveled (in km): ");
        double distance = s.nextDouble();
        System.out.print("Enter the time taken (in hours): ");
        double time = s.nextDouble();
        if (time > 0) {
            double speed = distance / time;
            System.out.println("The speed of the vehicle is: " + speed + " km/h");
        } else {
            System.out.println("Time cannot be zero or negative.");
        }

            }
            
            public void displayDetails(){
                
                  // for showing all Motorcycle details

               if (motorList.isEmpty()) {
                  System.out.println("No motorcycle details available.");
                } 

                for (int j = 0; j < motorList.size(); j++) {   
                  System.out.println("Motorcycle ID: " + (j + 1));
                  motorList.get(j).displayMotorCycle();
                }
              }
        static void updateMotorcycle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter motorcycle ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (MotorcycleRecord c : motorList) {
            if (c.id == id) {
              System.out.print("Do you want to update the following details:\n1 for price of the motorcycle\n2 for engine capacity\n3 for both\n");
              int updateChoice = sc.nextInt();
              if (updateChoice == 1){
              System.out.print("New price: ");
                c.price = sc.nextDouble();
                System.out.println("Motorcycle updated!");
                return;
              }
              else if (updateChoice == 2){
                System.out.print("New engine capacity: ");
                c.engineCapacity = sc.nextInt();
                System.out.println("Motorcycle updated!");
                return;
              }
              else if (updateChoice == 3){
                System.out.print("New price: ");
                c.price = sc.nextDouble();
                System.out.print("New engine capacity: ");
                c.engineCapacity = sc.nextInt();
                System.out.println("Motorcycle updated!");
                return;
            }
                System.out.println("Motorcycle not found.");
}
    }
  }
}