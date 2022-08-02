package atm;

public class Account {

	private Integer balance;

	public Account(Integer amount){
		this.balance = amount;
	}

	public Integer getBalance(){
		return balance;
	}

	public void withdraw(Integer amount){
		validateAmountToWithdraw(amount);
		this.balance -= amount;
	}

	private void validateAmountToWithdraw(Integer amount) {
		if(amount < 0){
			throw new IllegalArgumentException("Cannot withdraw negative amount!");
		}
		if(balance < amount){
			throw new IllegalArgumentException("Your account dont have enough money!");
		}
	}
}
