import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;



class TestClass6 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data5")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
       
        for (int i = 0; i < N; i++) {
        	try{
	        	int numDays=Integer.parseInt(br.readLine());
	        	String arrString[]=br.readLine().split("\\s");
	        	BigInteger[] arr=new BigInteger[arrString.length];
	        	 BigInteger sumArr=new BigInteger("0");
	        	 BigInteger zero=new BigInteger("0");
        		for (int j = 0; j < arrString.length; j++) {
        			arr[j]=new BigInteger(arrString[j]);
        			sumArr=sumArr.add(arr[j]);
				}
        		int count=numDays-1;
	             BigInteger mileStone=new BigInteger(br.readLine());
	             if(mileStone.compareTo(zero) !=0){
		             BigInteger quotient=mileStone.divide(sumArr);
		             mileStone=mileStone.subtract(quotient.multiply(sumArr));
		             
		             
		             if(mileStone.compareTo(zero) !=0){
			             while(mileStone.compareTo(zero) >0){
			            	 count=(count+1)%numDays;
			            	 mileStone=mileStone.subtract(arr[count]);    	 
			            	
			             }
		             }else
		            	 count=numDays-1;
	             }else
	            	 count=0;
	        
	             System.out.println(count+1);
        	}catch(Exception e){
        		return;
        	}
		}
       

        
    }
}