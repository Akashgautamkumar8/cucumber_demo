package atm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WithdrawSteps {

	private static Account account;
	private static ATM atm = new ATM();
	private static Integer returnedAmount;

	@Given("^I have (\\d+) rupees on my account$")
	public void i_have_rupees_on_my_account(int amount) throws Throwable {
	    account = new Account(amount);
	}

	@When("^I withdraw (-?\\d+) rupees$")
	public void withdraw_rupees(int amount) throws Throwable {
	    returnedAmount = atm.withdraw(account, amount);
	}

	@Then("^I get (\\d+) rupees from the ATM$")
	public void i_get_rupees_from_the_ATM(int amount) throws Throwable {
	    assertThat(returnedAmount, is(amount));
	}

	@Then("^error message about the lack of money is displayed$")
	public void error_message_about_the_lack_of_money_is_displayed() throws Throwable {
	    assertThat(atm.getScreen(), is("Your account dont have enough money!"));
	}

	@Then("^My account has (\\d+) rupees left$")
	public void my_account_has_rupees_left(int amount) throws Throwable {
	    assertThat(account.getBalance(), is(amount));
	}

	@Then("^error message about incorrect amount is displayed$")
	public void error_message_about_incorrect_amount_is_displayed() throws Throwable {
		assertThat(atm.getScreen(), is("Cannot withdraw negative amount!"));
	}
}
