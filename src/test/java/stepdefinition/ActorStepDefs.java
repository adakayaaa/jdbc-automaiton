package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Actor;
import org.assertj.core.api.Assertions;
import service.ActorService;

import java.util.List;
import java.util.Map;

public class ActorStepDefs {
    private Actor actor;
    private List<Actor> actors;
    private ActorService actorService;
    private Map<String ,Object> actorDetails;

    @Given("the actor service is up and running")
    public void theActorServiceIsUpAndRunning() {
        actorService=new ActorService();
    }

    @When("I request a list of all actors")
    public void iRequestAListOfAllActors() {
        actors= actorService.getAllActors();
    }

    @Then("I should receive a list containing all actors in the database")
    public void iShouldReceiveAListContainingAllActorsInTheDatabase() {
        Assertions.assertThat(actors).isNotEmpty();
        Assertions.assertThat(actors).isNotNull();
    }

    @When("I request the actor with ID {int}")
    public void iRequestTheActorWithID(int actorId) {
        actor=actorService.getActorById(actorId);
    }

    @Then("I should receive the details of the actor with ID {int}")
    public void iShouldReceiveTheDetailsOfTheActorWithID(int actorId) {
        Assertions.assertThat(actor).isNotNull();
        Assertions.assertThat(actor.getActorId()).isEqualTo(actorId);
    }

    @When("I request the name and last name of the actor with ID {int}")
    public void iRequestTheNameAndLastNameOfTheActorWithID(int actorId) {
        actorDetails= actorService.getActorNameAndLastNameById(actorId);
    }

    @Then("I should receive the first name and last name of the actor with ID {int}")
    public void iShouldReceiveTheFirstNameAndLastNameOfTheActorWithID(int actorId) {
        Assertions.assertThat(actorDetails).isNotNull();
        Assertions.assertThat(actorDetails).containsKeys("first_name","last_name");

        String firstName = (String) actorDetails.get("first_name");
        String lastName = (String) actorDetails.get("last_name");

        Assertions.assertThat(firstName).isNotNull();
        Assertions.assertThat(lastName).isNotNull();
    }

    @Then("I should receive the first name {string} and last name {string} of the actor with ID")
    public void iShouldReceiveTheFirstNameAndLastNameOfTheActorWithID(String firstName, String lastName) {
        Assertions.assertThat(actorDetails.get("first_name")).isEqualTo(firstName);
        Assertions.assertThat(actorDetails.get("last_name")).isEqualTo(lastName);

    }
}
