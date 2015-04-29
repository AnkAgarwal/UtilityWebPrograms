
public class FibonaciRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFibonacci(0));
		System.out.println(getFibonacci(1));
		System.out.println(getFibonacci(2));
		System.out.println(getFibonacci(3));
		System.out.println(getFibonacci(4));
		System.out.println(getFibonacci(5));
	}
	
	static int getFibonacci(int num){
		if (num == 0 || num ==1){
			return num;
		}
		
		return (getFibonacci(num - 1 )+ getFibonacci(num - 2));
		
	}

}
