package com.ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<ABC> list=new TreeSet<ABC>();
		//List<ABC> list=new ArrayList<ABC>();
		ABC obj4=new ABC(4, "Ankit4", 4.0);
		list.add(obj4);
		ABC obj2=new ABC(2, "Ankit2", 2.0);
		list.add(obj2);
		ABC obj1=new ABC(1, "Ankit1", 1.0);
		
		list.add(obj1);
		
		ABC obj3=new ABC(3, "Ankit3", 3.0);
		list.add(obj3);
		
		
		System.out.println(list);
		
		ABC find=new ABC(3, "Ankit4", 4.0);
		
		if(list.equals(find))
			System.out.println("Found");
		else
			System.out.println("Not found");
		
		if(list.contains(find))
			System.out.println("Found");
		else
			System.out.println("Not found");


	}

}
