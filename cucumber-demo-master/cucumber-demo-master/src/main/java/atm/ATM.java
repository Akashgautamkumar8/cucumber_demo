package atm;

public class ATM {

	private String screen;

	public String getScreen() {
		return screen;
	}

	public int withdraw(Account account, Integer amount) {
		try {
			account.withdraw(amount);
		} catch (Exception e) {
			screen = e.getMessage();
			amount = 0;
		}
		return amount;
	}
}
