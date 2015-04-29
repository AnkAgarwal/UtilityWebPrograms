import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



class TestClass5 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running */

    	BufferedReader br = new BufferedReader(new FileReader(new File("Data3")));
        String line = br.readLine();
        int N = Integer.parseInt(line);
       
        for (int i = 0; i < N; i++) {
        	int numDrugs=Integer.parseInt(br.readLine());
        	ArrayList<Integer> dNo=new ArrayList<Integer>();
        	ArrayList<Boolean> flagList=new ArrayList<Boolean>();
        	for (int j = 0; j < numDrugs; j++) {
				dNo.add(Integer.parseInt(br.readLine()));
				flagList.add(false);
			}
        	Collections.sort(dNo);
        	int size=dNo.size();
        	int count=0;
        	for (int j = 0; j < dNo.size()-1; j++) {
				for (int k = j; k < dNo.size(); k++) {
					if(dNo.get(j)<dNo.get(k) && flagList.get(k)!=true){
						flagList.set(k,true);
						count++;
						break;
					}						
				}
			}
        	System.out.println(size-count);
		}
       

        
    }
}