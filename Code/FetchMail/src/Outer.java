
public class Outer {

	public static void main(String[] args) {
		System.out.println("Main is called");
		
		Main mainObj= new Main();
		Main.Inner innnerObj = mainObj.new Inner();
		
		
		
		innnerObj.printMsg();
	}

}

class Main{
	
String text = "I am Outer private!";
	
	class Inner{
		String text = "I am innner private!";
		String text1 = "I am inner text1 private!";
		
		void printMsg(){
			System.out.println(text);
			System.out.println(text1);
		}

	}
	
}