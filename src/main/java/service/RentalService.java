package service;

import mappers.RentalMapper;
import model.Rental;
import utils.DBUtils;

import java.util.List;
import java.util.Map;


public class RentalService {

    public List<Rental> getAllRentals(){
        String query= "SELECT * FROM rental;";
        return DBUtils.executeQuery(query,new RentalMapper());
    }

    public Rental getARentalByRentalId(int rentalId){
        String query= "SELECT * FROM rental WHERE rental_id='"+rentalId+"'";
        List<Rental> listOfRentals= DBUtils.executeQuery(query,new RentalMapper());
        return listOfRentals.isEmpty()? null: listOfRentals.get(0);
    }

    public List<Rental> getRentalByInventoryId(int inventoryId){
        String query= "SELECT * FROM rental WHERE inventory_id='"+inventoryId+"'";
        return DBUtils.executeQuery(query,new RentalMapper());
    }

    public Map<String,Object> getDetailsOfRentalByRentalId(int rentalId){
        String query= "SELECT inventory_id,staff_id FROM rental WHERE rental_id='"+rentalId+"'";
        return DBUtils.executeQueryForMapList(query).get(0);
    }
}
