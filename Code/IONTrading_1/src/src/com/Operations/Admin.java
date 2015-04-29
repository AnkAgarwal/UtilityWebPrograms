package src.com.Operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import src.com.Account.Account;
import src.com.Transaction.Transaction;
import src.com.Transaction.TransactionManager;

public class Admin {

	ConcurrentHashMap<String, Account> accountMap = new ConcurrentHashMap<String, Account>();
	TransactionManager transactionManager = new TransactionManager();

	public String createAccount(String accountID) {
		try {
			Account newAccount = new Account(accountID);
			this.accountMap.put(newAccount.getId(), newAccount);
			return newAccount.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean deleteAccount(String accountID) {
		try {
			Account acc = this.accountMap.get(accountID);
			if (acc != null && validateDeleteAccount(accountID)) {
				this.accountMap.remove(accountID);
				transactionManager.getTransactionLog().remove(accountID);
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean withdrawAmount(String accountID, double amount) {
		Account acc = this.accountMap.get(accountID);
		synchronized (acc) {			
			try {
				//Account acc = this.accountMap.get(accountID);
				if (acc != null && validateTransferFund(accountID, amount)) {
					acc.setBalance(acc.getBalance() - amount);
					Transaction transaction = new Transaction("Debit", amount);
					populateTransaction(accountID, transaction);
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	private void populateTransaction(String accountID, Transaction transaction) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transList = transactionManager
				.getTransactionLog().get(accountID);
		if (transList == null) {
			transList = new ArrayList<Transaction>();
			transList.add(transaction);
			transactionManager.getTransactionLog().put(accountID, transList);
		} else {
			transList.add(transaction);
		}

	}

	public boolean depositAmount(String accountID, double amount) {
		Account acc = this.accountMap.get(accountID);
		
		synchronized (acc) {
			try {
				//Account acc = this.accountMap.get(accountID);
				if (acc != null) {
					acc.setBalance(acc.getBalance() + amount);
					Transaction transaction = new Transaction("Credit", amount);
					populateTransaction(accountID, transaction);
					return true;
				} else
					return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public double getBalance(String accountID) {
		Account acc = this.accountMap.get(accountID);
		synchronized (acc) {
			try {		
				if (acc != null)
					return acc.getBalance();
				else {
					System.out.println("Please provide valid user ID");
					return -1.0;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -1.0;
			}
		}
	}

	public boolean transferFund(String fromAccountID,
			String toAccountID, double amount) {
		synchronized (fromAccountID) {
			try {
				if (validateTransferFund(fromAccountID, amount)) {
					if (withdrawAmount(fromAccountID, amount)) {
						if (depositAmount(toAccountID, amount)) {
							return true;
						} else {
							// To maintain the atomicity, if deposit amount is
							// Unsuccessful, credit back amount
							depositAmount(fromAccountID, amount);
							return false;
						}
					} else
						return false;
				}
	
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean validateBalance(String accountID) {
		if (getBalance(accountID) < 0)
			return false;
		else
			return true;
	}

	public boolean validateDeleteAccount(String accountID) {
		try {
			if (getBalance(accountID) == 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateTransferFund(String accountID, double amount) {
		try {
			if (getBalance(accountID) >= amount)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Transaction> getTransactionByDate(String accountID) {
		return transactionManager.getTransactionByDate(accountID);
	}

	public ArrayList<Transaction> getTransactionByAmount(String accountID) {
		return transactionManager.getTransactionByAmount(accountID);
	}

	public ArrayList<Transaction> getTransaction(String accountID) {
		return transactionManager.getTransaction(accountID);
	}

}
