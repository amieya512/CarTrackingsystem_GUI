import java.util.ArrayList;

public class CarInventory {
    private static CarInventory instance;
    private final ArrayList<Car> cars;

    // Private constructor to prevent instantiation
    private CarInventory() {
        cars = new ArrayList<>();
    }

    public static CarInventory getInstance() {
        if (instance == null) {
            instance = new CarInventory();
        }
        return instance;
    }

    // Method to add a car to the inventory
    public void addCar(Car car) {
        cars.add(car);
    }

    // Method to remove a car from the inventory by VIN
    public void removeCar(String vin) {
        cars.removeIf(car -> car.getVin().equals(vin));
    }

    // Method to get a list of available cars
    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.checkAvailability()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    // Method to preload cars for testing or demonstration
    public void preloadCars() {
        cars.add(new Car("Toyota", "Camry", 2010, 5000, "VIN001"));
        cars.add(new Car("Honda", "Civic", 2018, 12000, "VIN002"));
        cars.add(new Car("Ford", "F-150", 2015, 20000, "VIN003"));
        cars.add(new Car("Tesla", "Model 3", 2021, 35000, "VIN004"));
    }
}
