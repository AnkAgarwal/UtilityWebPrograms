
public final class FinalExample {
	
	final int var1;
	int var2;
	
	public FinalExample() {
		var1 = 20;
		var2 = 40;
	}
	
	void printFinalMsg(){
		System.out.println("Hii, final methos is here with values "+var1 +" , "+var2++);
	}

}
