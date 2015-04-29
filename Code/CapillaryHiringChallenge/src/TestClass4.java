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
        	int num=i+1;
        	System.out.println("Case: "+num);
        	String[] input=br.readLine().split("\\s");
        	int numStudents=Integer.parseInt(input[0]);
        	int[][] array=new int[numStudents][numStudents];
        	
        	for (int j = 0; j < Integer.parseInt(input[1]); j++) {
				String[] val=br.readLine().split("\\s");
				array[Integer.parseInt(val[0])-1][Integer.parseInt(val[1])-1]=Integer.parseInt(val[2]);
			}
        	for (int j = 0; j < Integer.parseInt(input[2]); j++) {
        		String[] val=br.readLine().split("\\s");
        		if(array[Integer.parseInt(val[0])-1][Integer.parseInt(val[1])-1] != 0)
        			System.out.println(array[Integer.parseInt(val[0])-1][Integer.parseInt(val[1])-1]);
        		else{
        			int minVal=Integer.MAX_VALUE;
        			for (int k = 1; k <numStudents; k++) {
        				if(array[k-1][Integer.parseInt(val[0])-1] != 0 && array[k-1][Integer.parseInt(val[1])-1] != 0){
        					int tempVal=array[k-1][Integer.parseInt(val[0])-1]+array[k-1][Integer.parseInt(val[1])-1];
        					if(tempVal<minVal){
        						minVal=tempVal;
        					}
        				}
						
					}
        			System.out.println(minVal);
        		}
			}
        }       
    }
}