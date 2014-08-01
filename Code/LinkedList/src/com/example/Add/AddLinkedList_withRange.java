package com.example.Add;

import java.util.ArrayList;

import com.example.LinkedList.MyLinkedList;
import com.example.LinkedList.Node;


public class AddLinkedList_withRange {
	
	public static void main(String[] args){
		MyLinkedList list=new MyLinkedList();
		/*list.add(1);
		list.add(2);
		list.add(3);
		list.add(9);*/
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		
		
		list.print();
		MyLinkedList list1=new MyLinkedList();
		//list1.add(4);
		/*list1.add(1);
		list1.add(2);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(9);*/
		//list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		list1.add(9);
		
		list1.print();
		
		//list.print();
		list.reverseList();
		list1.reverseList();
		//list.print();
		int range=3;
		MyLinkedList result=addLinkeList(list.start, list1.start,range);
		result.reverseList();
		
		result.print();
		
	}
	
	private static MyLinkedList addLinkeList(Node node1, Node node2, int range) {
		MyLinkedList result=new MyLinkedList();
		int count=0;
		int carry=0;
		int tempResult=0;
		while(node1!=null && node2!=null){
			count++;
			tempResult=node1.data+node2.data+carry;
			if((node1.link==null && node2.link== null) || count%range==0){
				result.add(tempResult);
				carry=0;
			}
			else{
				result.add(tempResult%10);
				carry=tempResult/10;
			}
			
			node1=node1.link;
			node2=node2.link;
		}
		/*result.add(node1.data+node2.data);
		node1=node1.link;
		node2=node2.link;*/
		
		if(node1 !=null){
			while(node1!=null){
				count++;
				if(node1.link==null || count%range==0){
					result.add((node1.data+carry));
					carry=0;
				}
				else{
					result.add((node1.data+carry)%10);
					carry=(node1.data+carry)/10;
				}
				node1=node1.link;
			}
			//result.add(node1.data);
		}
		
		if(node2 !=null){
			while(node2!=null){
				count++;
				if(node2.link==null || count%range==0){
					result.add((node2.data+carry));
					carry=0;
				}
				else{
					result.add((node2.data+carry)%10);
					carry=(node2.data+carry)/10;
				}
				node2=node2.link;
			}
			
		}
		
		return result;
	}

	
	
}
