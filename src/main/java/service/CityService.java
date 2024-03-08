package service;

import mappers.CityMapper;
import model.City;
import utils.DBUtils;

import java.util.List;

public class CityService {

    public List<City> getAllCities (){
        String query="SELECT * FROM city;";
        return DBUtils.executeQuery(query,new CityMapper());
    }

    public City getCityById(int cityId){
        String query="SELECT * FROM city WHERE city_id='"+cityId +"'";
        List<City> listOfCity=DBUtils.executeQuery(query,new CityMapper());
        return listOfCity.isEmpty()? null: listOfCity.get(0);
    }


}
