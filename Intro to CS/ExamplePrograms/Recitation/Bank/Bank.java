public class Bank
{
	private double balance;
	private String fname;
	private String lname;

	public double getBalance()
	{
		return this.balance;
	}
	public String getFname()
	{
		return this.fname;
	}
	public String getLname()
	{
		return this.lname;
	}

	Bank( double user_balance, String user_fname, String user_lname )
	{
		this.balance = user_balance;
		this.fname = user_fname;
		this.lname = user_lname;
	}
	
	public double deposit( double depositMoney )
	{
		this.balance += depositMoney;
		return this.balance;
	}
	public double withdraw( double withdrawMoney )
	{
		this.balance -= withdrawMoney;
		return this.balance;
	}
}
