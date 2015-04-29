import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



class TestClass4 {
	public static int result=0;
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */
    	
    	BufferedReader br = new BufferedReader(new FileReader(new File("Data4")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
       
        for (int i = 0; i < N; i++) {
        	result=0;
        	int count=Integer.parseInt(br.readLine());
        	long fact = 1;
        	long nfact = 1;
        	long fact_1 = 1;
        	//String paranthesis="D";
        	for (int j = 1; j <= count; j++) {
        		fact = fact * j;
            }
        	for (int j = 1; j <= 2*count; j++) {
        		nfact = nfact * j;
            }
        	for (int j = 1; j <= count+1; j++) {
        		fact_1 = fact * count+1;
            }
        	System.out.println(nfact/(fact_1*fact));
    		/*int numOpenPara=1;
    		int numClosePara=0;
    		TestClass4.getNumParanthesisPattern(numOpenPara,numClosePara,count);
    		System.out.println(result);*/
		}
        
       

        
    }
    private static void getNumParanthesisPattern(int numOpenPara, int numClosePara, int count) {
		// TODO Auto-generated method stub

		if(numClosePara<=numOpenPara){
			if(numOpenPara<count){
				getNumParanthesisPattern(numOpenPara+1,numClosePara,count);
			}
			if(numClosePara<count){
				getNumParanthesisPattern(numOpenPara,numClosePara+1,count);
			}			
		}
		
		if(numOpenPara==numClosePara && numOpenPara==count){
			//System.out.println(paranthesis);
			result++;
		}
		return;
	}
}