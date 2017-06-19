package ontario.accounts;

public class Savings extends Account 
{
	private double interestRate;
	
	public Savings()
	{
		super();
		this.interestRate = 0.03;
	}
	
	public Savings(String n, String num, double bal, double rate)
	{
		super(n,num,bal);
		this.interestRate = rate;
	}
	
	public String toString()
	{
		String output = "Account Type: Savings\n" + super.toString() + "Annual Interest Rate: "+interestRate+"%\n";
		return output;
	}
	
	public boolean equals(Object n)
	{
		boolean result = super.equals(n);
		if(result == true)
		{
			Savings n2 = (Savings) n;
			if(n2.interestRate == this.interestRate)
			{
				return true;
			}
		}
		return false;
	}
}
