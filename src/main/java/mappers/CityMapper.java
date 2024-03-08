package mappers;

import model.City;
import utils.RowMapper;

import java.sql.ResultSet;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs) throws Exception {
        return new City(
                rs.getInt("city_id"),
                rs.getString("city"),
                rs.getInt("country_id"),
                rs.getTimestamp("last_update")
        );
    }
}
