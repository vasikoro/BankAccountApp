package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		// Read a CSV file and create new accounts based on that data
		String file = "/home/vasilis/eclipse-workspace/NewBankAccounts.csv";

		
		/*
		Checking checkacc1 = new Checking("null", "1234565789", 2500);
		
		Savings savacc1 = new Savings("Empty String", "9254959259", 2000 );
		
		savacc1.showInfo();
		savacc1.deposit(1000);
		savacc1.withdraw(2000);
		savacc1.transfer("Vasilis", 500);
		savacc1.compound();
		savacc1.printBalance();
		System.out.println("_____________________");
		checkacc1.showInfo();
		checkacc1.deposit(1000);
		checkacc1.withdraw(2000);
		checkacc1.transfer("Vasilis", 500);
		checkacc1.compound();
		checkacc1.printBalance();
		System.out.println("_____________________");
		*/

		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
			if (accountType.equals("Savings")) {
				//System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			else if (accountType.equals("Checking")) {
				//System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//accounts.get(3).showInfo();
		for  (Account acc : accounts) {
			acc.showInfo();
			System.out.println("\n-----------------------------");
		}
	}
}
