package ontario.business;
import java.util.*;
import ontario.accounts.Account;

public class Bank 
{
	private ArrayList<Account> accounts;
	private String bankName;
	
	public Bank()
	{
		this.bankName = "Seneca@York";
		this.accounts = new ArrayList<Account>();
	}
	
	public Bank(String n)
	{
		this.bankName = n;
		this.accounts = new ArrayList<Account>();
	}
	
	public boolean equals(Object bk)
	{

		boolean result = false;
		int size = accounts.size();
		Bank bnk = (Bank) bk;

		if(bnk.bankName.equals(this.bankName))
		{
			//
			for(int i=0;i<size;i++)
			{
				if(bnk.accounts.get(i).equals(this.accounts.get(i)))
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
		}
		else
		{
			result = false;
		}

		return result;
	}
	
	public String toString()
	{
		String out;
		int size = accounts.size();
		out = "Bank Information\n________________\nBank Name: " + bankName + "\n";
		out += "\nCurrent Accounts:\n";

		String acc = "";
		for(int i=0;i<size;i++)
		{
			//System.out.println("Success");
			acc += accounts.get(i).toString();
		}

		return out + acc;
	}
	
	public boolean addAccount(Account acc)
	{
		boolean check = false;
		int size = this.accounts.size();
		Account temp = new Account();

		if(acc == null)
		{
			System.out.println("Account Object is null, cannot be added to the Bank Object.");
			return false;
		}

		for(int i=0;i<size;i++)
		{
			temp = accounts.get(i);
			check = temp.equals(acc);

			if(check == true)
			{
				return false;
			}
		}

		accounts.add(acc);
		return true;
	}
	
	public Account removeAccount(String acc_num)
	{
		int size = accounts.size();

		if(acc_num == null)
		{
			return null;
		}

		//a temporary account variable is created to store the account that is being removed
		Account temp = new Account();

		//the loop interates over the accounts array and checks to see if the account number is equal() to any of the account objects
		for(int i=0;i<size;i++)
		{
			if(accounts.get(i).getAccount().equals(acc_num))
			{
				temp = accounts.get(i);
				accounts.remove(i);
				System.out.println("Success, "+acc_num+" was removed.");
				return temp;
			}
		}

		System.out.println("Account "+acc_num+" does not exist.");
		return temp;
	}
	
	public Account[] searchByBalance(double balance)
	{
		int size = accounts.size();
		int count = 0;
		int tempCount = 0;

		for(int i=0;i<size;i++)
		{
			if((accounts.get(i)) != null && (accounts.get(i).getBalance()) == balance)
			{
				count++;
			}
		}

		Account temp[] = new Account[count];

		for(int i=0;i<size;i++)
		{
			if((accounts.get(i)) != null && (accounts.get(i).getBalance()) == balance)
			{
				temp[tempCount] = accounts.get(i);
				tempCount++;
			}
		}

		return temp;
	}
	
	public Account[] getAllAccounts()
	{
		Account [] accArray = new Account[accounts.size()];
		return accounts.toArray(accArray);
	}
	
	public Account [] searchByAccountName( String accountName )
	{
		int size = accounts.size();
		int count = 0;
		int tempCount = 0;
		
		for(int i=0;i<size;i++)
		{
			if((accounts.get(i)) != null && (accounts.get(i).getFullName()).equals(accountName))
			{
				count++;
			}
		}
		
		Account temp[] = new Account[count];
		
		for(int i=0;i<size;i++)
		{
			if((accounts.get(i)) != null && (accounts.get(i).getFullName()).equals(accountName))
			{
				temp[tempCount] = accounts.get(i);
				tempCount++;
			}
		}
		
		return temp;
	}
}
