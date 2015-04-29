
public class StarQues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("* ");
			}		
			
			System.out.println();
		}
		
		for (int i = 3; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("* ");
			}		
			
			System.out.println();
		}
		
			
	}

	

}
