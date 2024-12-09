package dataBase;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;

public class VehicleDAOMySQL implements VehicleDAO {

    DataSource dataSource;

    public VehicleDAOMySQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Vehicle> findAllVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles;
                    """);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                allVehicles.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return allVehicles;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByVin(int vin) {
        ArrayList<Vehicle> vehicleByVin = new ArrayList<>();
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles Where vin = ?;
                    """);

            statement.setInt(1, vin);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehicleByVin.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehicleByVin;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByYear(int year) {
        ArrayList<Vehicle> vehicleByYear = new ArrayList<>();
        int vin;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE year = ?;
                    """);

            statement.setInt(1, year);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehicleByYear.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehicleByYear;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByMake(String make) {
        ArrayList<Vehicle> vehicleByMake = new ArrayList<>();
        int vin;
        int year;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE make = ?;
                    """);

            statement.setString(1, make);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehicleByMake.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehicleByMake;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByModel(String model) {
        ArrayList<Vehicle> vehicleByModel = new ArrayList<>();
        int vin;
        int year;
        String make;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE model = ?;
                    """);

            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehicleByModel.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehicleByModel;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByType(String Type) {
        ArrayList<Vehicle> vehicleType = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE  vehicleType = ?;
                    """);

            statement.setString(1, Type);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehicleType.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehicleType;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE color = ?;
                    """);

            statement.setString(1, color);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehiclesByColor.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehiclesByColor;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByOdometer(int minOdometer, int maxOdometer) {
        ArrayList<Vehicle> vehiclesByOdometer = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minOdometer);
            statement.setDouble(2, maxOdometer);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehiclesByOdometer.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehiclesByOdometer;
    }

    @Override
    public ArrayList<Vehicle> findAllVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean isSold;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, price);
            statement.setDouble(2, price);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("vehicleType");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                isSold = resultSet.getBoolean("sold");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                vehiclesByPrice.add(vehicle);

            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return vehiclesByPrice;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        int vin = 0;
        int year = 0;
        String make = " ";
        String model = " ";
        String vehicleType = " ";
        String color = " ";
        int odometer = 0;
        double price = 0.0;
        boolean isSold = false;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                    """);

            statement.setInt(1, vin);
            statement.setInt(2, year);
            statement.setString(3, make);
            statement.setString(4, model);
            statement.setString(5, vehicleType);
            statement.setString(6, color);
            statement.setInt(7, odometer);
            statement.setDouble(8, price);
            statement.setBoolean(9, isSold);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " rows has been updated to current. ");

        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void removeVehicle(int vin) {

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    DELETE FROM vehicles WHERE vin = ?;
                    """);

            statement.setInt(1, vin);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " rows have been deleted from the query. ");
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
    }
}