
public class ParathesisCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =4;
		String paranthesis="(";
		int numOpenPara=1;
		int numClosePara=0;
		ParathesisCount.getNumParanthesisPattern(paranthesis,numOpenPara,numClosePara,count);

	}
	
	
	private static void getNumParanthesisPattern(String paranthesis, int numOpenPara, int numClosePara, int count) {
		// TODO Auto-generated method stub

		if(numClosePara<=numOpenPara){
			if(numOpenPara<count){
				getNumParanthesisPattern(paranthesis+"(",numOpenPara+1,numClosePara,count);
			}
			if(numClosePara<count){
				getNumParanthesisPattern(paranthesis+")",numOpenPara,numClosePara+1,count);
			}			
		}
		
		if(numOpenPara==numClosePara && numOpenPara==count){
			System.out.println(paranthesis);
		}
	}
	
	/*private static void leftSubtree(String paranthesis, int numOpenPara, int numClosePara, int count) {
		paranthesis=paranthesis+"(";
		numOpenPara++;
		if(numClosePara<=numOpenPara){ 
			if(numOpenPara<count){
				leftSubtree(paranthesis,numOpenPara,numClosePara,count);
			}
			if(numClosePara<count){
				rightSubtree(paranthesis,numOpenPara,numClosePara,count);
			}

		}
		if(numOpenPara==numClosePara && 
				numOpenPara==count){
			System.out.println(paranthesis);
		}
		
	}
	
	private static void rightSubtree(String paranthesis, int numOpenPara, int numClosePara, int count) {
		paranthesis=paranthesis+")";
		numClosePara++;
		if(numClosePara<=numOpenPara){ 
			if(numOpenPara<count){
				leftSubtree(paranthesis,numOpenPara,numClosePara,count);
			}
			if(numClosePara<count){
				rightSubtree(paranthesis,numOpenPara,numClosePara,count);
			}

		}
		if(numOpenPara==numClosePara && 
				numOpenPara==count){
			System.out.println(paranthesis);
		}
	}

	private static void getNumParanthesisPattern(String paranthesis, int numOpenPara, int numClosePara, int count) {
		leftSubtree(paranthesis,numOpenPara,numClosePara,count);
		rightSubtree(paranthesis,numOpenPara,numClosePara,count);
	}*/
	
}
