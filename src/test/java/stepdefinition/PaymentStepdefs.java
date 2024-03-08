package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Payment;
import org.assertj.core.api.Assertions;
import service.PaymentService;

import java.util.List;

public class PaymentStepdefs {
    private PaymentService paymentService;
    private List<Payment> payments;
    private Payment payment;
    @Given("the payment service is up and running")
    public void thePaymentServiceIsUpAndRunning() {
        paymentService=new PaymentService();
    }

    @When("I request a list of all payments")
    public void iRequestAListOfAllPayments() {
        payments=paymentService.getAllPayments();
    }

    @Then("I should receive a list containing all payments in the database")
    public void iShouldReceiveAListContainingAllPaymentsInTheDatabase() {
        Assertions.assertThat(payments).isNotNull();
        Assertions.assertThat(payments).isNotEmpty();
    }

    @When("I request the payment with ID {int}")
    public void iRequestThePaymentWithID(int paymentId) {
        payment=paymentService.getAPaymentByPaymentId(paymentId);
    }

    @Then("I should receive the details of the payment with ID {int}")
    public void iShouldReceiveTheDetailsOfThePaymentWithID(int paymentId) {
       Assertions.assertThat(payment).isNotNull();
       Assertions.assertThat(payment.getPaymentId()).isEqualTo(paymentId);
    }

    @Then("I should receive the film with rental id {} and customer id {}")
    public void iShouldReceiveTheFilmWithRentalIdAndCustomerId(int rentalId,int customerId) {
        Assertions.assertThat(payment).isNotNull();
        Assertions.assertThat(payment.getRentalId()).isEqualTo(rentalId);
        Assertions.assertThat(payment.getCustomerId()).isEqualTo(customerId);
    }
}
