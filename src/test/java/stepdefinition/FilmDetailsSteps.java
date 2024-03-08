package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.FilmDetails;
import org.assertj.core.api.Assertions;
import service.FilmDetailsService;

import java.util.List;

public class FilmDetailsSteps {
    private FilmDetailsService filmDetailsService;
    private FilmDetails filmDetail;
    private List<FilmDetails> filmDetails;
    @Given("the film detail service is up and running")
    public void theFilmDetailIsUpAndRunning() {
        filmDetailsService=new FilmDetailsService();
    }

    @When("I request a list of all film details")
    public void iRequestAListOfAllFilmDetails() {
        filmDetails=filmDetailsService.getAllFilmDetails();
    }

    @Then("I should receive a list containing all film details in the database")
    public void iShouldReceiveAListContainingAllFilmDetailsInTheDatabase() {
        Assertions.assertThat(filmDetails).isNotNull().isNotEmpty();
    }

    @When("I request the film detail with title {string}")
    public void iRequestTheFilmDetailWithTitle(String title) {
        filmDetail=filmDetailsService.getAFilmDetailByTitle(title);
    }

    @Then("I should receive the details of the film detail with title {string}")
    public void iShouldReceiveTheDetailsOfTheFilmDetailWithTitle(String title) {
        Assertions.assertThat(filmDetail).isNotNull();
        Assertions.assertThat(filmDetail.getTitle()).isEqualTo(title);
    }

    @Then("I should receive the film detail with release year {} and category {string}")
    public void iShouldReceiveTheFilmDetailWithReleaseYearAndCategory(int releaseYear, String category) {
        Assertions.assertThat(filmDetail).isNotNull();
        Assertions.assertThat(filmDetail.getReleaseYear()).isEqualTo(releaseYear);
        Assertions.assertThat(filmDetail.getCategory()).isEqualTo(category);
    }
}
