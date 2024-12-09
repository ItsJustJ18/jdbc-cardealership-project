package dataBase;

import java.util.ArrayList;

public interface VehicleDAO {

    ArrayList<Vehicle> findAllVehicles();

    ArrayList<Vehicle> findAllVehiclesByVin(int vin);

    ArrayList<Vehicle> findAllVehiclesByYear(int year);

    ArrayList<Vehicle> findAllVehiclesByMake(String make);

    ArrayList<Vehicle> findAllVehiclesByModel(String model);

    ArrayList<Vehicle> findAllVehiclesByType(String type);

    ArrayList<Vehicle> findAllVehiclesByColor(String color);

    ArrayList<Vehicle> findAllVehiclesByOdometer(int minOdometer, int maxOdometer);

    ArrayList<Vehicle> findAllVehiclesByPrice(double minPrice,int maxPrice);

    void addVehicle(Vehicle vehicle);

    void removeVehicle(int vin);

    ArrayList<Vehicle> findAllVehiclesByPrice(double minPrice, double maxPrice);
}
