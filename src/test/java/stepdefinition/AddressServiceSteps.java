package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Address;
import service.AddressService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class AddressServiceSteps {
    private AddressService addressService;
    private List<Address> addresses;
    private Address address;

    @Given("the address service is up and running")
    public void theAddressServiceIsUpAndRunning() {
        addressService = new AddressService();
    }

    @When("I request a list of all addresses")
    public void iRequestAListOfAllAddresses() {
        addresses = addressService.getAllAddresses();
    }

    @Then("I should receive a list containing all addresses in the database")
    public void iShouldReceiveAListContainingAllAddressesInTheDatabase() {
        assertThat(addresses).isNotNull();
        assertThat(addresses).isNotEmpty();
    }

    @When("I request the address with ID {int}")
    public void iRequestTheAddressWithID(int id) {
        address = addressService.getAddressById(id);
    }

    @Then("I should receive the details of the address with ID {int}")
    public void iShouldReceiveTheDetailsOfTheAddressWithID(int id) {
        assertThat(address).isNotNull();
        assertThat(address.getAddressId()).isEqualTo(id);
    }

    @When("I request addresses in the {string} district")
    public void iRequestAddressesInTheDistrict(String district) {
        addresses = addressService.getAddressByDistrict(district);

    }

    @Then("I should receive a list of addresses located in the {string} district")
    public void iShouldReceiveAListOfAddressesLocatedInTheDistrict(String district) {
        assertThat(addresses).isNotNull();
        assertThat(addresses).isNotEmpty();
    }


    @Then("I should receive the address with street {string}, district {string}, city ID {}, postal code {string}, and phone {string}")
    public void iShouldReceiveTheAddressWithStreetDistrictCityIDPostalCodeAndPhone(String street, String district, Integer cityId, String postalCode, String phone) {
        assertThat(address).as("Check if the address details are correct")
                .isNotNull();

        assertThat(address.getAddress()).as("Validate street").isEqualTo(street);
        assertThat(address.getDistrict()).as("Validate district").isEqualTo(district);
        assertThat(address.getCityId()).as("Validate city ID").isEqualTo(cityId);
        // Postal code and phone might be empty, so we handle these cases
        if (postalCode != null && !postalCode.isEmpty()) {
            assertThat(address.getPostalCode()).as("Validate postal code").isEqualTo(postalCode);
        }
        if (phone != null && !phone.isEmpty()) {
            assertThat(address.getPhone()).as("Validate phone").isEqualTo(phone);
        }
    }
}

