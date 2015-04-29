package com.ArrayList;

import java.util.ArrayList;

public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ABC_FORLIST> list=new ArrayList<ABC_FORLIST>();
		ABC_FORLIST obj1=new ABC_FORLIST(1, "Ankit1", 1.0);
		list.add(obj1);
		ABC_FORLIST obj2=new ABC_FORLIST(2, "Ankit2", 2.0);
		list.add(obj2);
		ABC_FORLIST obj3=new ABC_FORLIST(3, "Ankit3", 3.0);
		list.add(obj3);
		ABC_FORLIST obj4=new ABC_FORLIST(4, "Ankit4", 4.0);
		list.add(obj4);
		
		ABC_FORLIST find=new ABC_FORLIST(3, "Ankit3", 3.0);
		
		if(list.contains(find))
			System.out.println("Found");
		else
			System.out.println("Not found");
		
		System.out.println(list.indexOf(find));


	}

}
