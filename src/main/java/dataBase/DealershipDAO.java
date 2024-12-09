package dataBase;

import java.util.ArrayList;

public interface DealershipDAO {

    Dealership findDealershipById(int id);

    ArrayList<Dealership> findAllCarDealerships();

    ArrayList<Dealership> findDealershipByID(int id);




}
