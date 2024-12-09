import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //global variable for the user from the programmer

    //Dealership is represented as name, address, and phoneNumber
    private String name;
    private String address;
    private String phoneNumber;

    //Get Arraylist of cars from the inventory csv file
    private ArrayList<Vehicle> inventory;

    //"mcQueen" is the shortcut containing the src file for inventory file
    // public static final String mcQueen = "src/main/resources/inventory.csv";
    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addVehicles(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle v) {
        inventory.remove(v);
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> byPrice = new ArrayList<>();

        //find a price that is the requested price range from the user
        for (Vehicle v : inventory) {
            if (v.price <= max && v.price >= min) {
                byPrice.add(v);
            }
        }
        return byPrice;

    }

    public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        List<Vehicle> byMandM = new ArrayList<>();

        //for vehicles found in the Vehicle class
        for (Vehicle vehicle : inventory)
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))

                byMandM.add(vehicle);

        return byMandM;

    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> byYear = new ArrayList<>();

        //for vehicles that matches the same input as the userInput
        for (Vehicle vehicle : inventory)
            if (vehicle.year <= max && vehicle.year >= min) {
                byYear.add(vehicle);
            }

        return byYear;

    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> byColor = new ArrayList<>();

        //user inputs a color desired and adds it to the list
        for (Vehicle vehicle : inventory)
            if (vehicle.getColor().equalsIgnoreCase(color))
                byColor.add(vehicle);

        return byColor;

    }

    public List<Vehicle> getVehiclesByOdometer(int min , int max) {
        List<Vehicle> byOdometer = new ArrayList<>();

        //gets the amount of mileage on a vehicle that the user is looking for then returns
        for (Vehicle vehicle : inventory)
            if (vehicle.odometer >= min && vehicle.odometer <= max)
            byOdometer.add(vehicle);

        return byOdometer;

    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> byVehicleType = new ArrayList<>();

        //if user wants a specific vehicle type
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                byVehicleType.add(vehicle);
            }
        }

        return byVehicleType;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inventory=" + inventory +
                '}';
    }

    public Vehicle[] getVehiclesByPrice() {
        return null;
    }
}
