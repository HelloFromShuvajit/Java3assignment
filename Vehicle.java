import java.util.*;
import java.lang.*;
//1. Create a class named "Vehicle" with attributes: brand, model, year, and rentalPrice. Implement a method to display the vehicle information.

//2. Create a class named "Car" that extends "Vehicle" with an additional attribute: numberOfSeats.- Implement a method to retrieve the number of seats.

//3. Create a class named "Motorcycle" that extends "Vehicle" with an additional attribute: engineCapacity.- Implement a method to retrieve the engine capacity.

//4. In the main class, create instances of "Car" and "Motorcycle" classes and demonstrate:- Creating vehicles with specific attributes.- Displaying the information of each vehicle.
public class Vehicle{
    public static void main(String[] args){
        System.out.println("Welcome to Vehicle rental service.");
        VehicleClass vehicle = new VehicleClass();
        vehicle.setInformation("BMW", "N69", 2022, 12000);
        vehicle.displayInformation();
        Car car = new Car();
        car.setInformation("Hyundai", "Venue", 2021, 2000);
        car.setNumberofSeats(4);
        car.displayInformation();
        car.displaySeatNumber();
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setInformation("TVS", "Ronin", 2024, 1200);
        motorcycle.setEngineCapacity(220);
        motorcycle.displayInformation();
        motorcycle.displayEngineCapacity();
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

