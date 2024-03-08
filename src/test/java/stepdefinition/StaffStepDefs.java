package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Staff;
import org.assertj.core.api.Assertions;
import service.StaffService;

import java.util.List;

public class StaffStepDefs {
    StaffService staffService;
    Staff staff;
    List<Staff> staffs;
    @Given("the staff service is up and running")
    public void theStaffServiceIsUpAndRunning() {
        staffService=new StaffService();
    }

    @When("I request a list of all staffs")
    public void iRequestAListOfAllStaffs() {
        staffs=staffService.getAllStaffs();
    }

    @Then("I should receive a list containing all staffs in the database")
    public void iShouldReceiveAListContainingAllStaffsInTheDatabase() {
        Assertions.assertThat(staffs).isNotEmpty().isNotNull();
    }

    @When("I request the staff with ID {int}")
    public void iRequestTheStaffWithID(int staffId) {
        staff= staffService.getAStaffById(staffId);
    }

    @Then("I should receive the details of the staff with ID {int}")
    public void iShouldReceiveTheDetailsOfTheStaffWithID(int staffId) {
        Assertions.assertThat(staff).isNotNull();
        Assertions.assertThat(staff.getStaffId()).isEqualTo(staffId);
    }

    @Then("I should receive the staff with first name {string} and address id {}")
    public void iShouldReceiveTheStaffWithFirstNameAndRental_duration(String firstName, int addressId) {
        Assertions.assertThat(staff).isNotNull();
        Assertions.assertThat(staff.getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(staff.getAddressId()).isEqualTo(addressId);
    }
}
