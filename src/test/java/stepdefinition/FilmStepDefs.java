package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Film;
import org.assertj.core.api.Assertions;
import service.FilmService;

import java.util.List;

public class FilmStepDefs {
    private Film film;
    private List<Film> films;
    private FilmService filmService;

    @Given("the film service is up and running")
    public void theFilmServiceIsUpAndRunning() {
        filmService = new FilmService();
    }

    @When("I request a list of all films")
    public void iRequestAListOfAllFilms() {
        films = filmService.getAllFilms();
    }

    @Then("I should receive a list containing all films in the database")
    public void iShouldReceiveAListContainingAllFilmsInTheDatabase() {
        Assertions.assertThat(films).isNotEmpty();
        Assertions.assertThat(films).isNotNull();
    }

    @When("I request the film with ID {int}")
    public void iRequestTheFilmWithID(int filmId) {
        film=filmService.getAFilmByFilmId(filmId);
    }

    @Then("I should receive the details of the film with ID {int}")
    public void iShouldReceiveTheDetailsOfTheFilmWithID(int filmId) {
        Assertions.assertThat(film).isNotNull();
        Assertions.assertThat(film.getFilmId()).isEqualTo(filmId);
    }

    @Then("I should receive the film with title {string} and rental_duration {}")
    public void iShouldReceiveTheFilmWithTitleAndReleaseYear(String title, int rentalDuration) {
        Assertions.assertThat(film).isNotNull();
        Assertions.assertThat(film.getTitle()).isEqualTo(title);
        Assertions.assertThat(film.getRentalDuration()).isEqualTo(rentalDuration);

    }
}
