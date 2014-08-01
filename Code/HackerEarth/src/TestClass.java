/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TestClass {
    public static void main(String args[] ) throws Exception {
        
        //* Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new FileReader(new File("Data")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	StringBuilder result=new StringBuilder();
            //System.out.println("hello world");
            String[] frndsDet=br.readLine().split("\\s");
            int numFrnds=Integer.parseInt(frndsDet[0]);
            int numFrndsRem=Integer.parseInt(frndsDet[1]);
            
            int remFrndCount=0;
        	String[] popularity=br.readLine().split("\\s");
        	
        	ArrayList<Integer> popularityList=new ArrayList<Integer>();
        	for (int j = 0; j < popularity.length; j++) {
        		popularityList.add(Integer.parseInt(popularity[j]));
			}
        	//while(remFrndCount<numFrndsRem){
	            for(int j = 0; j < popularityList.size()-1 && numFrndsRem>remFrndCount; j++) {
	            	if(popularityList.get(j)<popularityList.get(j+1)){
	            		popularityList.remove(j); 	
	            		remFrndCount++;
	            		if(j>=2)
	            			j=j-2;
	            		else
	            			j=-1;
	            	}		            
	            }
        	//}
	        for (int j = 0; j < popularityList.size(); j++) {
	        	result.append(popularityList.get(j)).append(" ");
			}	
    	
            System.out.println(result);
        

        //System.out.println("Hello World!");
        }
    }
}
