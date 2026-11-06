package opps27_10_2026;
import java.util.*;

interface Rentable {
    double calculateRent(int days);
    boolean isAvailable();
}

abstract class Vehicle implements Rentable {
    String id, model;
    double rate;
    boolean available = true;

    Vehicle(String id, String model, double rate) {
        this.id = id;
        this.model = model;
        this.rate = rate;
    }

    public boolean isAvailable() {
        return available;
    }

    String details() {
        return getClass().getSimpleName() + " " + model + " (" + id + ")";
    }
}

class Car extends Vehicle {
    Car(String i, String m, double r) { super(i, m, r); }
    public double calculateRent(int d) { return rate * d; }
}

class Bike extends Vehicle {
    Bike(String i, String m, double r) { super(i, m, r); }
    public double calculateRent(int d) {
        return rate * d * (d >= 7 ? 0.9 : 1);
    }
}

class Truck extends Vehicle {
    Truck(String i, String m, double r) { super(i, m, r); }
    public double calculateRent(int d) { return rate * d + 500; }
}

class Customer {
    String name;
    ArrayList<Rental> history = new ArrayList<>();
    Customer(String name) { this.name = name; }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle v, Customer c, int d) {
        vehicle = v;
        customer = c;
        days = d;
    }
}

class RentalShop {
    ArrayList<Vehicle> fleet = new ArrayList<>();

    void add(Vehicle v) { fleet.add(v); }

    void rent(Vehicle v, Customer c, int d) throws Exception {
        if (!fleet.contains(v))
            throw new Exception("Vehicle not found");
        if (!v.available)
            throw new Exception(v.details() + " is already rented");

        v.available = false;
        Rental r = new Rental(v, c, d);
        c.history.add(r);

        System.out.printf("%s rented %s for %d days = %.2f%n",
                c.name, v.details(), d, v.calculateRent(d));
    }

    void giveBack(Vehicle v) { v.available = true; }

    void showAvailable() {
        System.out.println("Available vehicles:");
        for (Vehicle v : fleet)
            if (v.available)
                System.out.println("  " + v.details());
    }
}

public class oopsQuestion {
    public static void main(String[] args) {
        RentalShop shop = new RentalShop();

        Car car = new Car("C1", "Swift", 2000);
        Bike bike = new Bike("B1", "Activa", 400);
        Truck truck = new Truck("T1", "Tata Ace", 2500);

        shop.add(car);
        shop.add(bike);
        shop.add(truck);

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        try {
            shop.rent(bike, asha, 8);
            shop.rent(truck, ravi, 2);
            shop.rent(bike, ravi, 3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        shop.giveBack(bike);
        shop.showAvailable();
    }
}