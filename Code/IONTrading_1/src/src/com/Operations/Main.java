package src.com.Operations;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Admin admin = new Admin();
		//Create the amount Mohan
		String userMohanID_1 = admin.createAccount("Mohan");
		System.out.println(admin.getBalance(userMohanID_1));

		admin.depositAmount(userMohanID_1, 10000);
		System.out.println(admin.getBalance(userMohanID_1));

		if (admin.withdrawAmount(userMohanID_1, 5000) == false) {
			System.out.println("Insufficient amount");
		}
		System.out.println(admin.getBalance(userMohanID_1));

		if (admin.withdrawAmount(userMohanID_1, 6000) == false) {
			System.out.println("Insufficient amount");
		}
		System.out.println(admin.getBalance(userMohanID_1));

		if (admin.deleteAccount(userMohanID_1) == false) {
			System.out
					.println("Account balance is non zero, cannot delete the account");
		}
		System.out.println(admin.getBalance(userMohanID_1));

		if (admin.withdrawAmount(userMohanID_1, 3000) == false) {
			System.out.println("Insufficient amount");
		}
		System.out.println(admin.getBalance(userMohanID_1));

		String userMohanID_2 = admin.createAccount("Mohan");
		if (admin.transferFund(userMohanID_1, userMohanID_2, 3000) == false) {
			System.out.println("Insufficient fund to transfer");
		}

		if (admin.transferFund(userMohanID_1, userMohanID_2, 2000) == false) {
			System.out.println("Insufficient fund to transfer");
		}
		System.out.println(admin.getBalance(userMohanID_1));

		admin.deleteAccount(userMohanID_1);
		System.out.println(admin.getBalance(userMohanID_1));

		System.out.println(admin.getTransaction(userMohanID_1));
		System.out.println(admin.getTransactionByAmount(userMohanID_2));
		System.out.println(admin.getTransactionByDate(userMohanID_2));

	}

}
