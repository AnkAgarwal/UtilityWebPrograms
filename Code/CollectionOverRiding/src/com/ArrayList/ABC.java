package com.ArrayList;

public class ABC implements Comparable<ABC>{
	
	int id;
	String name;
	double val;
	
	public ABC(int id,String name,double val){
		this.id=id;
		this.name=name;
		this.val=val;
				
	}
	/*@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null)
			return false;
		
		if(arg0 instanceof ABC){
			ABC obj=(ABC) arg0;
			
			if(this.id==obj.id && this.name==obj.name && this.val==obj.val)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode();
	}*/
	@Override
	public int compareTo(ABC o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+":"+name+":"+val;
	}
}
