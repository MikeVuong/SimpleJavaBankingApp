package ontario.accounts;
import java.math.BigDecimal;

public class GIC extends Account
{
	private int investmentPeriod;
	private double annualInterestRate;
	
	
	public GIC()
	{
		super();
		this.investmentPeriod = 12;
		this.annualInterestRate = 1.24;
	}
	
	public GIC(String n, String num, double bal, int invest, double rate)
	{
		super(n, num, bal);
		this.investmentPeriod = invest;
		this.annualInterestRate = rate;
	}
	
	public boolean withdraw(double amount)
	{
		return false;
	}
	
	public boolean deposit(double amount)
	{
		return false;
	}
	
	public double getBalanceAtMaturity() 
	{
		BigDecimal result = new BigDecimal(0);
		BigDecimal principal = new BigDecimal(super.getBalance());
		BigDecimal rate = new BigDecimal(annualInterestRate+1);
		
		result = principal.multiply(rate.pow(investmentPeriod));
		return result.doubleValue();
	}
	
	public boolean equals(Object n)
	{
		boolean result = super.equals(n);
		
		if(result == true)
		{
			GIC n2 = (GIC) n;
			
			if(n2.investmentPeriod == this.investmentPeriod && n2.annualInterestRate == this.annualInterestRate)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String accInfo = super.toString();
		String output = "Account Type: GIC\n" + super.toString() + "Investment Period" + investmentPeriod + " months\n" + "Annual Interest Rate: " + annualInterestRate + "%\n";
		return accInfo + output;
	}
}
