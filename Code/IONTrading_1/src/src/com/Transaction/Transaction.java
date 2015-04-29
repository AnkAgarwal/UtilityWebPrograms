package src.com.Transaction;

import java.util.Comparator;
import java.util.Date;

public class Transaction  {

	private String type;
	private double amount;
	private Date txnDate;

	public Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
		this.txnDate = new Date();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type + "||" + this.amount + "||" + this.txnDate;
	}

	public static Comparator<Transaction> amountComparator = new Comparator<Transaction>() {

		public int compare(Transaction transaction1, Transaction transaction2) {

			Double amount1 = transaction1.amount;
			Double amount2 = transaction2.amount;

			// descending order
			return amount2.compareTo(amount1);

		}
	};

	public static Comparator<Transaction> dateComparator = new Comparator<Transaction>() {

		public int compare(Transaction transaction1, Transaction transaction2) {

			Date date1 = transaction1.txnDate;
			Date date2 = transaction2.txnDate;

			// descending order
			return date2.compareTo(date1);

		}

	};

}
