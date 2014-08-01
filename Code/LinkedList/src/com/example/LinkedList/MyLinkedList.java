package com.example.LinkedList;

public class MyLinkedList {

	public Node start;
	Node last;
	
	public MyLinkedList(){
		this.start=null;
		this.last=null;
	}
	
	public boolean isEmpty(){
		return this.start==null;
	}
	
	public Node getItem(int index){
		Node temp=this.start;
		int count=0;
		while(temp.link != null && count<index){
			count++;
			System.out.print(temp.data+"-->");
			temp=temp.link;
		}
		if(count==index){
			return temp;
		}else
			return null;
	}
	
	public void add(int data){
		Node newNode=new Node(data);
		if(this.start==null){
			newNode.link=null;
			this.start=newNode;
			this.last=newNode;
		}else{
			this.last.link=newNode;
			newNode.link=null;
			this.last=newNode;
		}
	}
	
	
	public void reverseList(){
		
		MyLinkedList newList=new MyLinkedList();
		//Node temp=this.start;
		Node prevNode=null;
		Node nextNode=null;
		boolean flag=true;
		prevNode=this.start;
		nextNode=this.start;
		this.start=this.start.link;
		while(this.start!=null){
			nextNode=this.start;
			this.start=nextNode.link;
			
			if (flag){
				prevNode.link=null;
				flag=false;
			}
			nextNode.link=prevNode;
			prevNode=nextNode;
		}
		this.start=prevNode;
		
		/*while(this.start.link != null){
			//prevNode=this.start;
			this.start=this.start.link;
			//nextNode=this.start.link;
			nextNode=this.start;
			
			if (flag){
				prevNode.link=null;
				flag=false;
			}
			
			nextNode.link=prevNode;
			prevNode=this.start;

			
			if(nextNode !=null){
				prevNode=this.start;
				//this.start=nextNode;
			}
			else
				break;
		}
		//prevNode=this.start;
		//this.start=this.start.link;
		//nextNode=this.start.link;
		
		this.start.link=prevNode;
		//prevNode=this.start;
		//this.start=nextNode;
		
		//return newList;
*/	}
	
	public Node delete(){
		Node itemToDelete=this.start;
		this.start=this.start.link;
		itemToDelete.link=null;
		return itemToDelete;
	}
	
	public Node delete(int index){
		int counter=0;
		Node prevNodeitemToDelete=this.start;
		Node itemToDelete=prevNodeitemToDelete.link;
		
		
		if(index==0){
			itemToDelete=this.start;
			this.start=this.start.link;

		}else{			
			while(counter<index-1 ){
				if(itemToDelete.link!=null){
					prevNodeitemToDelete=prevNodeitemToDelete.link;
					itemToDelete=prevNodeitemToDelete.link;
				}
				else{
					System.out.println("Invalid Index");
					return null;
				}
				counter++;
			}
		}
		prevNodeitemToDelete.link=itemToDelete.link;
		itemToDelete.link=null;
		return itemToDelete;
	}
	
	public void print(){
		Node temp=this.start;
		while(temp.link != null){
			System.out.print(temp.data+"-->");
			temp=temp.link;
		}
		System.out.println(temp.data);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList list=new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.print();
		list.delete(1);
		list.print();
		
		/*MyLinkedList list1=new MyLinkedList();
		
		list1.add(4);
		list1.add(5);
		list1.add(6);
		
		list1.print();*/
	}

}
