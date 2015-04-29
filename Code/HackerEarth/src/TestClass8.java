import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;



class TestClass8 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data8")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++) {
        	try{
        		String arrString[]=br.readLine().split("\\s");
        		
        		BigInteger[] arr=new BigInteger[arrString.length];
        		for (int j = 0; j < arrString.length; j++) {
        			arr[j]=new BigInteger(arrString[j]);
				}
        		
        		if(arr[0].modPow(arr[1], arr[2].pow(arr[3].intValue())).intValue()==0)
        			System.out.println("Divisible");
        		else
        			System.out.println("Not divisible");
        	}catch(Exception e){
        		return;
        	}
        	
		}
       

        
    }
}