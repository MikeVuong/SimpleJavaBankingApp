package ontario.accounts;
import java.math.BigDecimal;

public class Chequing extends Account
{
	private double serviceCharge;
	private int maxTransaction;
	private double transactions[];
	private int count;
	
	public Chequing()
	{
		super();
		this.serviceCharge = 0.25;
		this.maxTransaction = 0;
		this.transactions = new double[0];
		this.count = 0;
	}
	
	public Chequing(String n, String num, double bal, double serv, int ma)
	{
		super(n, num, bal);
		this.serviceCharge = serv;
		this.maxTransaction = ma;
		this.transactions = new double[maxTransaction];
		this.count = 0;
	}
	
	public boolean deposit(double amount)
	{		
		if(count >= maxTransaction || amount < 0)
		{
			return false;
		}
		else
		{
			if(super.deposit(amount) == true)
			{
				BigDecimal amountTemp = new BigDecimal(amount);
	
				transactions[count] = amountTemp.doubleValue();
				count++;
				
				BigDecimal calcTemp = new BigDecimal(super.getBalance());
				BigDecimal servCharge = new BigDecimal(serviceCharge);
				calcTemp = calcTemp.subtract(servCharge);
				super.setBalance(calcTemp.doubleValue());
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public boolean withdraw(double amount)
	{		
		if(count >= maxTransaction || amount < 0)
		{
			return false;
		}
		else
		{
			if(super.deposit(amount) == true)
			{
				BigDecimal amountTemp = new BigDecimal(amount);
				amountTemp = amountTemp.negate();
				transactions[count] = amountTemp.doubleValue();
				count++;
				BigDecimal calcTemp = new BigDecimal(super.getBalance());
				BigDecimal servCharge = new BigDecimal(serviceCharge);
				calcTemp = calcTemp.subtract(servCharge);
				super.setBalance(calcTemp.doubleValue());
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public String toString()
	{
		double total = count * serviceCharge;
		String output = "Account Type: Chequing\n" + super.toString() + "Total Service Charge: " + total + "\nMaximum Number of Transactions: " + maxTransaction + "\n";
		String trans = "List of Transactions: \n";
		
		for(int i=0;i<count;i++)
		{
			trans += transactions[i] + "\n";
		}
		return output + trans;
	}
	
	public boolean equals(Object n)
	{
		boolean result = super.equals(n);
		boolean check = false;
		
		if(result == true)
		{
			Chequing n2 = (Chequing) n;
			if(n2.serviceCharge == this.serviceCharge && n2.maxTransaction == this.maxTransaction && n2.transactions.length == this.transactions.length)
			{
				for(int i=0;i<this.transactions.length;i++)
				{
					if(n2.transactions[i] == this.transactions[i])
					{
						check = true;
					}
					else
					{
						check = false;
						return check;
					}
				}
				
				if(check == true)
				{
					return check;
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
	}
}  
  