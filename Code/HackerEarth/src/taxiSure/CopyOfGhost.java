// This is backup code that is submitted online

/*package taxiSure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Element implements Comparable<Element>{
	int ghostAge;
	int count;
	
	public Element(int ghostAge) {
		// TODO Auto-generated constructor stub
		this.ghostAge=ghostAge;
	}

	@Override
	public int compareTo(Element comparePriority) {
		
		int count = (int) comparePriority.count;
		int ghostAge = (int) comparePriority.ghostAge;
		// for desending order
		if(count != this.count)
			return count - this.count;
		else
			return ghostAge - this.ghostAge;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(arg0 == null)
			return false;
		
		if(arg0 instanceof Element){
			Element obj=(Element) arg0;
			
			if(this.ghostAge==obj.ghostAge)
				return true;
		}
		return false;
	
	}
}

public class CopyOfGhost {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BufferedReader br;
		 //HashMap<String,Integer> elementList = new HashMap<String, Integer>();
		 ArrayList<Element> elementList=new ArrayList<Element>();
		try {
			br = new BufferedReader(new FileReader(new File("DataGhost")));
			String line = br.readLine();
	        int N = Integer.parseInt(line.split("\\s")[0]);
	        
	        String[] input = br.readLine().split("\\s");
	        
	        for (int i = 0; i < N; i++) {
	        	int ghostAge = Integer.parseInt(input[i]);
	        	Element obj=new Element(ghostAge);
	        	if(elementList.contains(obj)){
	        		int index = elementList.indexOf(obj);
	        		obj = elementList.remove(index);
	        		obj.count=obj.count+1;
	        		elementList.add(obj);
	        	}else{
	        		obj.count=1;
	        		elementList.add(obj);
	        	}
	        	Collections.sort(elementList);
	        	System.out.println(elementList.get(0).ghostAge+" "+elementList.get(0).count);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        

	}

}
*/