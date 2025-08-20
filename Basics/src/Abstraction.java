public class Abstraction {
    public static void main(String[] args) {
        Car c= new Car();
        c.start();
        c.fuelType();
    }
}
abstract  class Vehicle {
    abstract void start();
    void fuelType(){
        System.out.println("Fuel Type Not Specifed");
    }
}
class Car extends Vehicle{
    void fuelType(){
        System.out.println("Car Uses Petrol..");
    }
    void start(){
        System.out.println("Car is Starting...");
    }
}