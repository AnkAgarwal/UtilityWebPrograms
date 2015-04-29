package src.com.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionManager {

	ConcurrentHashMap<String, ArrayList<Transaction>> transactionLog=new ConcurrentHashMap<String, ArrayList<Transaction>>();
	
	public ConcurrentHashMap<String, ArrayList<Transaction>> getTransactionLog(){
		return this.transactionLog;
	}
	
	public void addTransaction(String accountID,Transaction transaction){
		try{
		ArrayList<Transaction> transList=transactionLog.get(accountID);
			if(transList == null){
				transList=new ArrayList<Transaction>();
				transList.add(transaction);
			}else{
				transList.add(transaction);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<Transaction> getTransaction(String accountID){
		try{
			ArrayList<Transaction> transList=transactionLog.get(accountID);
			if(transList == null){
				System.out.println("No transaction made for the given ID");
				return null;
			}else{
				if(transList.size()>10)
					return (ArrayList<Transaction>) transList.subList(transList.size()-10, transList.size());
				else
					return transList;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Transaction> getTransactionByAmount(String accountID){
		try{
			ArrayList<Transaction> transList=transactionLog.get(accountID);
			if(transList == null){
				System.out.println("No transaction made for the given ID");
				return null;
			}else{
				Collections.sort(transList, Transaction.amountComparator);
				return transList;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Transaction> getTransactionByDate(String accountID){
		try{
			ArrayList<Transaction> transList=transactionLog.get(accountID);
			if(transList == null){
				System.out.println("No transaction made for the given ID");
				return null;
			}else{
				Collections.sort(transList, Transaction.dateComparator);
				return transList;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
