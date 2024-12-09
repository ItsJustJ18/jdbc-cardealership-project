package dataBase;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class CarDealershipDAO implements DealershipDAO {

    DataSource dataSource;

    public CarDealershipDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Dealership findDealershipByID(int id) {
        String name = " ";
        String address = " ";
        String phone = " ";

        try(Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM dealerships WHERE id = ?
                    """);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                phone = resultSet.getString("phone");
            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return findDealershipById(id, name, address, phone);
    }

    @Override
    public List<Dealership> findAllCarDealerships() {
        ArrayList<Dealership> dealerships = new ArrayList<Dealership>();

        int id = 0;
        String name = " ";
        String address = " ";
        String phone = " ";

        try(Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM dealerships
                    """);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                phone = resultSet.getString("phone");

                Dealership dealership = new Dealership(id, name, address, phone);
                dealerships.add(dealership);
            }
        } catch (SQLDataException e) {
            throw new RuntimeException();
        }
        return dealerships;
    }


}
