import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



class TestClass3 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data2")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
       
        
        String arrString[]=br.readLine().split("\\s");
        int[] arr=new int[arrString.length];
        for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(arrString[i]);
		}
        //String arr[]=br.readLine().split("\\s");
        int numQueries=Integer.parseInt(br.readLine());
        
        for (int i = 0; i < numQueries; i++) {
			String query[]=br.readLine().split("\\s");
			int startIndex=Integer.parseInt(query[0]);
			int endIndex=Integer.parseInt(query[1]);
			int x=Integer.parseInt(query[2]);
			int min=Integer.MAX_VALUE;
			int count=0;
			int selectedVal=Integer.MIN_VALUE;
			for (int j = startIndex-1; j < endIndex; j++) {
				//int abc=Integer.parseInt(arr[j]);
				int temp=arr[j] ^ x;
				if(selectedVal==arr[j])
					count++;
				else if(temp < min){
					selectedVal=arr[j];
					min=temp;
					count=1;
				}
			}
			System.out.println(selectedVal+" "+count);
        }
       

        
    }
}