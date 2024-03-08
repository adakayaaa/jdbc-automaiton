package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private int staffId;
    private String firstName;
    private String lastName;
    private int addressId;
    private String email;
    private int storeId;
    private boolean active;
    private String  username;
    private String password;
    private Timestamp lastUpdate;
    private String picture;


}
