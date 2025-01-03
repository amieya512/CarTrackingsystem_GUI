public class Employee {
    private String employeeID;
    private String name;

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }

    public void addCar(Car car) {
        CarInventory.getInstance().addCar(car);
    }

    public boolean markCarAsSold(String vin) {
        for (Car car : CarInventory.getInstance().getAvailableCars()) {
            if (car.getVin().equals(vin)) {
                car.sellCar();
                return true;
            }
        }
        return false;
    }
}

