package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.City;
import org.assertj.core.api.Assertions;
import service.CityService;

import java.util.List;
import java.util.Map;

public class CityStepDefs {

    private City city;
    private List<City> cities;
    private CityService cityService;

    @Given("the city service is up and running")
    public void theCityServiceIsUpAndRunning() {
        cityService=new CityService();
    }

    @When("I request a list of all cities")
    public void iRequestAListOfAllCities() {
       cities= cityService.getAllCities();
    }

    @Then("I should receive a list containing all cities in the database")
    public void iShouldReceiveAListContainingAllCitiesInTheDatabase() {
        Assertions.assertThat(cities).isNotNull();
        Assertions.assertThat(cities).isNotEmpty();
    }

    @When("I request the city with ID {int}")
    public void iRequestTheCityWithID(int cityId) {
        city= cityService.getCityById(cityId);
    }

    @Then("I should receive the details of the city with ID {int}")
    public void iShouldReceiveTheDetailsOfTheCityWithID(int cityId) {
        Assertions.assertThat(city).isNotNull();
        Assertions.assertThat(city.getCityId()).isEqualTo(cityId);
    }

    @Then("I should receive the city with name {string} and country ID {}")
    public void iShouldReceiveTheCityWithNameAndCountryID(String cityName, int countryId) {
        Assertions.assertThat(city).isNotNull();
        Assertions.assertThat(city.getCountryId()).isEqualTo(countryId);
        Assertions.assertThat(city.getCity()).isEqualTo(cityName);
    }
}
