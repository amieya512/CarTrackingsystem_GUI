public class Customer {
    private String customerID;
    private String name;

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void viewAvailableCars() {
        for (Car car : CarInventory.getInstance().getAvailableCars()) {
            System.out.println(car.getDetails());
        }
    }

    public boolean buyCar(String vin) {
        for (Car car : CarInventory.getInstance().getAvailableCars()) {
            if (car.getVin().equals(vin)) {
                car.sellCar();
                return true;
            }
        }
        return false;
    }
}
