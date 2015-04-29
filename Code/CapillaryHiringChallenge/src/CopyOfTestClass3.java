import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;



class CopyOfTestClass3 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data2")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        
        
       
        for (int i = 0; i < N; i++) {
        	try{
	        	int result=0;
	        	String[] range=br.readLine().split("\\s");
	        	BigDecimal lowerRange=new BigDecimal(range[0]);
	        	BigDecimal upperRange=new BigDecimal(range[1]);
	        	ArrayList<BigDecimal> triangularNmber=getTraingularList(upperRange);
        	
				for (int j2 = 0; j2 < triangularNmber.size(); j2++) {
					for (int k = j2; k < triangularNmber.size(); k++) {
						BigDecimal val= triangularNmber.get(j2).add(triangularNmber.get(k));
						//if(val>=lowerRange && val<= upperRange)
						if(val.compareTo(lowerRange)>=0 && val.compareTo(upperRange)<=0)
							result++;
					}
				}
				
				System.out.println(result);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
			
        }
       

        
    }

	private static ArrayList<BigDecimal> getTraingularList(BigDecimal upperRange) {
		// TODO Auto-generated method stub
		ArrayList<BigDecimal> returnList=new ArrayList<BigDecimal>();
		int count=1;
		BigDecimal val=new BigDecimal(1);
		while(val.compareTo(upperRange)<0){
			count++;
			returnList.add(val);
			val=new BigDecimal((count*(count+1))/2);
		}
		return returnList;
	}
}