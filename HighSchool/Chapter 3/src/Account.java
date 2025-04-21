
public class Account {
	
	private double balance;
	
	public Account (double initialBalance) {
		setBalance(initialBalance);
	}
	
	public void setBalance(double initialBalance) {
		if(initialBalance<0.0)
			balance = 0.0;
		else
			balance = initialBalance;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	
	@Override
	public String toString() {
		return "Account [balance="+balance+"]";
	}
	
	
	public void debit (double amount) {
		
		if (amount > balance)
			System.out.println("Withrawal amount exceeded account balance.");
		else
			balance -= amount;
	}
	
	public void credit (double amount) {
		
		if (amount > 0)
			balance += amount;
		else
			System.out.println("Invalid deposit amount- account balance unchanged.");
	}

	
	


}
