package com.ArrayList;

import java.util.LinkedHashMap;

public class LinkedHashMapSample {
	
	
	
	
	public static void main(String[] args){
		LinkedHashMap<Integer, String> test=new LinkedHashMap<Integer, String>();
		
		
		test.put(1,"1");
		test.put(2,"2");
		test.remove(1);
		test.put(1,"3");
		test.put(4,"4");
		test.put(5,"5");
		test.put(6,"6");
		test.put(7,"7");
		test.put(8,"8");
		
		System.out.println(test);
	}
			

}
