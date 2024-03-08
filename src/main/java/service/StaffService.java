package service;

import mappers.StaffMapper;
import model.Staff;
import utils.DBUtils;

import java.util.List;

public class StaffService {

    public List<Staff> getAllStaffs(){
        String query="SELECT * FROM staff;";
        return DBUtils.executeQuery(query, new StaffMapper());
    }

    public Staff getAStaffById(int staffId){
        String query="SELECT * FROM staff WHERE staff_id='"+staffId+"'";
        List<Staff> listOfStaffs=DBUtils.executeQuery(query, new StaffMapper());
        return listOfStaffs.isEmpty()? null: listOfStaffs.get(0);
    }
}
