import java.util.Scanner;

public class Vehicle {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
       while(true){
    System.out.println("----------Welcome to Vehicle rental service.----------");
    System.out.println("Enter 1 for filling up the details of a vehicle\nEnter 2 for displaying the details of the vehicle.\nEnter 3 for filling up the deatils of a car.\nEnter 4 for displaying the details of the car.\nEnter 5 for filling up the details of a motorcycle.\nEnter 6 for displaying the details of the motorcycle.\nEnter 7 to exit.");
    int choice = sc.nextInt();
            Car carNew = new Car();
            VehicleClass vehicleNew = new VehicleClass();
            Motorcycle motorcycleNew = new Motorcycle();
    switch (choice){
        case 1:
            System.out.println("Enter the brand of the vehicle:");
            String brand = sc.next();
            System.out.println("Enter the model of the vehicle:");
            String model = sc.next();
            System.out.println("Enter the manufacturing year of the vehicle:");
            int year = sc.nextInt();
            System.out.println("Enter the rental price of the vehicle:");
            double rentalPrice = sc.nextDouble();
            vehicleNew.setInformation(brand, model, year, rentalPrice);
            break;
        case 2:
            vehicleNew.displayInformation();
            break;
        case 3:
            System.out.println("Enter the brand of the car:");
            String carBrand = sc.next();
            System.out.println("Enter the model of the car:");
            String carModel = sc.next();
            System.out.println("Enter the manufacturing year of the car:");
            int carYear = sc.nextInt();
            System.out.println("Enter the rental price of the car:");
            double carRentalPrice = sc.nextDouble();
            System.out.println("Enter the number of seats in the car:");
            int seats = sc.nextInt();
            carNew.setInformation(carBrand, carModel, carYear, carRentalPrice);
            carNew.setNumberofSeats(seats);
            break;
        case 4:
            carNew.displayInformation();
            carNew.displaySeatNumber();
            break;
        case 5:
            System.out.println("Enter the brand of the motorcycle:");
            String motoBrand = sc.next();
            System.out.println("Enter the model of the motorcycle:");
            String motoModel = sc.next();
            System.out.println("Enter the manufacturing year of the motorcycle:");
            int motoYear = sc.nextInt();
            System.out.println("Enter the rental price of the motorcycle:");
            double motoRentalPrice = sc.nextDouble();
            System.out.println("Enter the engine capacity of the motorcycle (in cc):");
            int engineCapacity = sc.nextInt();
            motorcycleNew.setInformation(motoBrand, motoModel, motoYear, motoRentalPrice);
            motorcycleNew.setEngineCapacity(engineCapacity);
            break;
        case 6:
            motorcycleNew.displayInformation();
            motorcycleNew.displayEngineCapacity();
            break;
        case 7:
            System.out.println("Exiting the program. Thank you!");
            return;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    } 
    }
}
}

class VehicleClass {
        private String brand;
        private String model;
        private int year;
        private double rentalPrice;
        public void setInformation(String brand, String model, int year, double rentalPrice){
            this.brand = brand;
            this.model = model; 
            this.year = year;
            this.rentalPrice = rentalPrice;
        }
        public void displayInformation(){
            System.out.println("The brand of the vehicle is " + this.brand+".\nThe model name is "+ this.model + ".\nManufaturing year is "+ this.year+".\nThe rental price is "+ this.rentalPrice+".");
        }
}
class Car extends VehicleClass{
        private int seats;
        public void setNumberofSeats(int seats){
            this.seats= seats;
        }
        public void displaySeatNumber(){
            System.out.println("This number of this car is "+this.seats+".");
        }

}
class Motorcycle extends VehicleClass{
    private int engineCapacity;
    public void setEngineCapacity(int capacity){
        this.engineCapacity= capacity;
    }
    public void displayEngineCapacity(){
        System.out.println("The engine capacity of this motorcycle is "+engineCapacity+"cc.");
    }
}    

