package com.example.Add;

import java.util.ArrayList;

import com.example.LinkedList.MyLinkedList;
import com.example.LinkedList.Node;


public class AddLinkedListRec {
	
	static int carry=0;
	
	public static void main(String[] args){
		MyLinkedList list=new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(4);
		
		MyLinkedList list1=new MyLinkedList();
		list1.add(4);
		list1.add(5);
		list1.add(6);
		//ArrayList<Node> result=new ArrayList<Node>();
		Node result = addLinkeList(list.start,list1.start);
		
		while(result.link != null){
			System.out.print(result.data+"-->");
			result=result.link;
		}
		System.out.println(result.data);
		//result.print();
		
	}
	
	private static Node addLinkeList(Node node1, Node node2) {
		// TODO Auto-generated method stub
		Node nextNode=null;
		if(node1.link != null && node2.link !=null){
			nextNode = addLinkeList(node1.link, node2.link);
		}else if(node1.link != null && node2.link ==null){
			nextNode = addLinkeList(node1.link, node2);
		}else if(node1.link == null && node2.link !=null){
			nextNode = addLinkeList(node1, node2.link);
		}
		/*else if(node1.link == null || node2.link ==null){
			Node addNode=new Node(node1.data+node2.data);
			addNode.link=null;
			return addNode;
		}*/
		int result=node1.data+node2.data+carry;
		Node addNode=new Node(result%10);
		carry=result/10;
		addNode.link=nextNode;
		return addNode;
		
		
	}

	
	
}
