import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



class TestClass7 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data7")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int result=0;
        for (int i = 0; i < N; i++) {
        	try{
        		boolean flag=true, isFirstIteration=true;
        		int startIndexA=0 , startIndexB=0 ,endIndexA=-1,endIndexB=-1;
	        	String s=br.readLine();
	        	int len=s.length();
	        	//int update=0;
	        	
	        	
	        	while(endIndexB<len-1 && endIndexA<len-1 && startIndexA<len-1 && startIndexB<len-1){
	        		if(isFirstIteration){
			        	startIndexA = s.indexOf('A',endIndexA+1);
			        	endIndexA = s.indexOf('A',startIndexA+1);
			        	
			        	startIndexB = s.indexOf('B',endIndexB+1);
			        	endIndexB = s.indexOf('B',startIndexB+1);
			        	isFirstIteration=false;
	        		}else{
	        			startIndexA=endIndexA;
	        			startIndexB=endIndexB;
	        			endIndexA = s.indexOf('A',startIndexA+1);
			        	endIndexB = s.indexOf('B',startIndexB+1);

	        		}
		        	//update=Math.max(endIndexA,endIndexB);
		        	
		        	if((startIndexB>startIndexA && startIndexB<endIndexA && endIndexB>endIndexA) || 
		        			(startIndexA>startIndexB && startIndexA<endIndexB && endIndexA>endIndexB)){
		        		flag=false;
		        		break;
		        	}
	        	}
	        	if(flag)
	        		result++;
        	}catch(Exception e){
        		return;
        	}
        	
		}
        System.out.println(result);
       

        
    }
}