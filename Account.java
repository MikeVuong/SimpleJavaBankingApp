package ontario.accounts;

public class Account
{
	private String name;
	private String account_num;
	private double current_balance;

	//default constructor sets the name and account number to empty strings, the current balance is set to 0.0
	public Account()
	{
		this.name = "";
		this.account_num = "";
		this.current_balance = 0.0;
	}

	//constructor calls the 3 set functions to instantiate the class variables
	public Account(String n, String num, double bal)
	{
		setFullName(n);
		setAccount(num);
		setBalance(bal);
	}

	//Takes in a string and checks to see if it is equal to null if so it sets the name to an empty string 
	//Otherwise it sets the name variable to the given string
	public void setFullName(String n)
	{	
		if(n == null)
		{
			name = "";
		}
		else
		{
			name = n;
		}
	}

	//Takes in a string and checks to see if it is equal to null if so it sets the account number to an empty string 
	//Otherwise it sets the account name variable to the given string
	public void setAccount(String a)
	{
		if(a == null)
		{
			account_num = "";
		}
		else
		{
			account_num = a;
		}
	}

	//Takes in a double that represents the accounts current balance and sets this as the current balance of the account
	public void setBalance(double n)
	{
		current_balance = n;
	}

	//returns the account holders full name
	public String getFullName()
	{
		return name;
	}

	//returns the account number
	public String getAccount()
	{
		return account_num;
	}

	//returns the accounts current balance 
	public double getBalance()
	{
		return current_balance;
	}

	//creates a string called output which is set to the a string that displays all of the information about the current account class
	//returns the output string with all relevent data
	public String toString()
	{
		String output = "Account Info\n" + "Full Name: " + name + "\n" + "Account Number: " + account_num + "\n" + "Current Balance: " + current_balance + "\n";
		return output;
	}

	//The equals method compares two Account objects to see if they are the same
	//It takes in a raw Object and then casts that object into an Account object
	//It then compares the account name string, account number string, and the account balances between both objects
	//The method then returns a boolean value of either true or false depending on whether two objects are the same
	public boolean equals(Object n)
	{
		boolean result = false;

		Account n2 = (Account) n;

		if(n instanceof Account)
		{
			if(n2.name.equals(this.name) && n2.account_num.equals(this.account_num) && n2.current_balance == this.current_balance)
			{
				result = true;
			}
		}

		return result;
	}
	
	public boolean deposit(double amount)
	{
		double check = 0;
		if(amount < 0)
		{
			return false;
		}
		else
		{
			check = current_balance + amount;
			if(check <= 0)
			{
				return false;
			}
			else
			{
				current_balance += amount;
				return true;
			}
		}
	}
	
	public boolean withdraw(double amount)
	{
		double check = 0;
		if(amount<0)
		{
			return false;
		}
		else
		{
			check = current_balance - amount;
			if(check < 0)
			{
				return false;
			}
			else
			{
				current_balance -= amount;
				return true;
			}
		}
	}
}
