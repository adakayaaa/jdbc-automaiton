package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private int cityId;
    private String city;
    private int countryId;
    private Timestamp lastUpdate;
}
