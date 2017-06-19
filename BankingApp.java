package seneca.btp400;
import java.io.File;
import java.io.PrintWriter;
//package seneca.btp400;
import java.util.*;
//import ontario.accounts.*;
//import ontario.business.*;

import ontario.accounts.Account;
import ontario.accounts.Chequing;
import ontario.accounts.GIC;
import ontario.accounts.Savings;
import ontario.business.Bank;

public class BankingApp 
{
	/** 
	 * 
	 * @param bankName
	 */
	public static void displayMenu(String bankName)
	{
		String name = bankName;
		System.out.println(
						"Welcome to the "+ name +" Banking!\n"+
						"1. Add an account.\n" +
						"2. Remove an account.\n" +
						"3. Search by account balance.\n" +
						"4. Search by account name.\n"+
						"5. Exit\n"
				);
	}
	
	public static String getDataValues(String message)
	{
		String result = "";
		
		return result;
	}
	
	public static void displayAccount(Account account)
	{
		System.out.println(account.toString());
	}
	
	public static void loadBank(Bank bank)
	{
		GIC a = new GIC("Manjot Sandhu", "KEK123", 1050.50, 12, 0.1);
		bank.addAccount(a);
		
		GIC b = new GIC("Michael Vuong", "LEL123", 3650.50, 10, 0.07);
		bank.addAccount(b);
		
		Savings c = new Savings("Soutrik Barua", "IDK420", 50000.90, 0.05);
		bank.addAccount(c);
		
		Savings d = new Savings("Sajjad Patel", "LOL690", 3480.89, 0.06);
		bank.addAccount(d);
		
		Chequing e = new Chequing("Raymond Lee", "YOLO420", 7832.04, 0.50, 5);
		bank.addAccount(e);
		
		Chequing f = new Chequing("Artour Babaev", "RTZ235", 802950.19, 0.75, 10);
		bank.addAccount(f);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);  
		Bank CIBC = new Bank("CIBC");
		boolean check = true;
		loadBank(CIBC);
		
		while(check == true)
		{
			displayMenu("CIBC");
			System.out.println("Enter your choice");
			String userInput = input.nextLine();
			
			if(userInput.equals("5"))
			{
				System.out.println("Exiting program, thank you and have a good day!");
				check = false;
			}
			else if(userInput.equals("1"))
			{
				boolean accountAddCheck = true;
				while(accountAddCheck)
				{
					System.out.println("Enter the type of account SAV, CHQ, GIC");
					String accInput = input.nextLine();
					
					if(accInput.equals("SAV") || accInput.equals("sav") || accInput.equals("Sav"))
					{
						System.out.println("Enter your account information in the "
								+ "format of Name,AccountNumber, Bank Balance, Interest Rate");
						String userInput2 = input.nextLine();
						String delimiter = ",";
						String tempArray[];
						tempArray = userInput2.split(delimiter);
						String Name = tempArray[0];
						String AccNumber = tempArray[1];
						Double BankBalance = Double.parseDouble(tempArray[2]);
						Double Interest = Double.parseDouble(tempArray[3]);
						
						Savings t = new Savings(Name,AccNumber,BankBalance,Interest);
						CIBC.addAccount(t);
						accountAddCheck = false;
					}
					else if(accInput.equals("CHQ") ||accInput.equals("chq") || accInput.equals("Chq") )
					{
						
						System.out.println("Enter your account information in the "
								+ "format of Name,AccountNumber, Bank Balance, Max Transaction, Service Charge");
						String userInput2 = input.nextLine();
						String delimiter = ",";
						String tempArray[];
						tempArray = userInput2.split(delimiter);
						String Name = tempArray[0];
						String AccNumber = tempArray[1];
						Double BankBalance = Double.parseDouble(tempArray[2]);
						Double serviceCharge = Double.parseDouble(tempArray[3]);
						Integer maxTransaction = Integer.parseInt(tempArray[4]);
						
						
						Chequing m = new Chequing(Name,AccNumber,BankBalance,serviceCharge,maxTransaction);
						CIBC.addAccount(m);
						accountAddCheck = false;
					}
					else if(accInput.equals("GIC") || accInput.equals("Gic")|| accInput.equals("gic"))
					{
						System.out.println("Enter your account information in the "
								+ "format of Name,AccountNumber, Bank Balance, Investment period, annual interest rate");
						String userInput2 = input.nextLine();
						String delimiter = ",";
						String tempArray[];
						tempArray = userInput2.split(delimiter);
						String Name = tempArray[0];
						String AccNumber = tempArray[1];
						Double BankBalance = Double.parseDouble(tempArray[2]);
						int investmentPeriod = Integer.parseInt(tempArray[3]);
						double annualInterest = Double.parseDouble(tempArray[4]);
						
						GIC t = new GIC(Name,AccNumber,BankBalance,investmentPeriod,annualInterest);
						CIBC.addAccount(t);
						accountAddCheck = false;
					}
					else
					{
						System.out.println("Incorrect Account Type, please try again.");
					}
				}
				System.out.println("Account Added");
				System.out.println(CIBC.toString());
				
			}
			else if(userInput.equals("2"))
			{
				System.out.println("Choose an account to remove");
				String remAcc = input.nextLine();
				if(remAcc != null)
				{
					CIBC.removeAccount(remAcc);
				}
				
			}
			else if(userInput.equals("3"))
			{
				System.out.println("Search by Account Balance");
				Double inputBal = Double.parseDouble(input.nextLine());
				
				if(inputBal.equals(null))
				{
					System.out.println("Please Input a Balance");
					inputBal = Double.parseDouble(input.nextLine());
				}
				else
				{
					Account [] displayAccounts = CIBC.searchByBalance(inputBal);
				     
				     for(int i = 0; i < displayAccounts.length; i++)
				     {
				    	 displayAccount(displayAccounts[i]);
				     }
				}
			}
			else if(userInput.equals("4"))
			{
				System.out.println("Search by Account Name");
				String inputName= input.nextLine(); 
				
				if(inputName.isEmpty())
				{
					System.out.println("Please Input a Name");
					inputName = input.nextLine();
				}
				else
				{
					Account [] displayAccounts = CIBC.searchByAccountName(inputName);
				     
				     for(int i = 0; i < displayAccounts.length; i++)
				     {
				    	 displayAccount(displayAccounts[i]);
				     }
				}
			}
		}
		PrintWriter x = null;
		try
		{
			x = new PrintWriter(new File ( "mssandhu12_mvuong3_btp400a1out.txt"));
			x.println(CIBC.toString());
			x.close();
		}
		catch(Exception a)
		{
			System.out.println("File did not open");
		}
	
		if(x.equals(null))
		{
			System.out.println("Invalid cmd line argument");
		}
		input.close();
	}

}
