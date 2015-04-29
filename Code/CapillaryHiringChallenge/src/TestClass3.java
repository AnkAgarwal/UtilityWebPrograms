import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
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
        
        
        
       
        for (int i = 0; i < N; i++) {
        	int result=0;
        	String[] range=br.readLine().split("\\s");
        	int lowerRange=Integer.parseInt(range[0]);
        	int upperRange=Integer.parseInt(range[1]);
        	ArrayList<Integer> triangularNmber=getTraingularList(upperRange);
        	
				for (int j2 = 0; j2 < triangularNmber.size(); j2++) {
					for (int k = j2; k < triangularNmber.size(); k++) {
						int val= triangularNmber.get(j2)+triangularNmber.get(k);
						if(val>=lowerRange && val<= upperRange){
							System.out.print(triangularNmber.get(j2)+","+triangularNmber.get(k)+","+val+"<-->");
							result++;
						}
					}
				}
				
			System.out.println(result);
			
        }
       

        
    }

	private static ArrayList<Integer> getTraingularList(int upperRange) {
		// TODO Auto-generated method stub
		ArrayList<Integer> returnList=new ArrayList<Integer>();
		int count=1;
		int val=1;
		while(val<upperRange){
			count++;
			returnList.add(val);
			val=(count*(count+1))/2;
		}
		return returnList;
	}
}