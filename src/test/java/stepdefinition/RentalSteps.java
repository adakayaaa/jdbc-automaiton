package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Rental;
import org.assertj.core.api.Assertions;
import service.RentalService;

import java.util.List;
import java.util.Map;

public class RentalSteps {
    RentalService rentalService;
    Rental rental;
    List<Rental> rentals;
    Map<String,Object> detailsOfRentals;

    @Given("the rental service is up and running")
    public void theRentalServiceIsUpAndRunning() {
        rentalService= new RentalService();
    }

    @When("I request a list of all rentals")
    public void iRequestAListOfAllRentals() {
        rentals= rentalService.getAllRentals();
    }

    @Then("I should receive a list containing all rentals in the database")
    public void iShouldReceiveAListContainingAllRentalsInTheDatabase() {
        Assertions.assertThat(rentals).isNotEmpty().isNotNull();
    }

    @When("I request the rental with ID {int}")
    public void iRequestTheRentalWithID(int rentalId) {
        rental= rentalService.getARentalByRentalId(rentalId);
    }

    @Then("I should receive the details of the rental with ID {int}")
    public void iShouldReceiveTheDetailsOfTheRentalWithID(int rentalId) {
        Assertions.assertThat(rental).isNotNull();
        Assertions.assertThat(rental.getRentalId()).isEqualTo(rentalId);
    }

    @When("I request rentals in the {int} inventory id")
    public void iRequestRentalsInTheInventoryId(int inventoryId) {
       rentals=rentalService.getRentalByInventoryId(inventoryId);
    }

    @Then("I should receive a list of rentals located in the {int} inventory id")
    public void iShouldReceiveAListOfRentalsLocatedInTheInventoryId(int inventoryId) {
        Assertions.assertThat(rentals).isNotNull().isNotEmpty();
        Assertions.assertThat(rentals.get(0).getInventoryId()).isEqualTo(inventoryId);
    }

    @Then("I should receive the rental with customer id {},staff id {}, inventory id {}")
    public void iShouldReceiveTheRentalWithCustomerIdStaffIdInventoryId(int customerId, int staffId, int inventoryId) {
        Assertions.assertThat(rental.getCustomerId()).isEqualTo(customerId);
        Assertions.assertThat(rental.getStaffId()).isEqualTo(staffId);
        Assertions.assertThat(rental.getInventoryId()).isEqualTo(inventoryId);
    }

    @When("I request the staff id and inventory id of the actor with ID {}")
    public void iRequestTheStaffIdAndInventoryIdOfTheActorWithID(int rentalId) {
        detailsOfRentals=rentalService.getDetailsOfRentalByRentalId(rentalId);
    }

    @Then("I should receive the staff id {} and inventory id {} of the rental with ID")
    public void iShouldReceiveTheStaffIdAndInventoryIdOfTheRentalWithID(int staffId,int inventoryId) {
        Assertions.assertThat(detailsOfRentals.get("inventory_id")).isEqualTo(inventoryId);
        Assertions.assertThat(detailsOfRentals.get("staff_id")).isEqualTo(staffId);
    }
}
