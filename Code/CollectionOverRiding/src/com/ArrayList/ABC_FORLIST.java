package com.ArrayList;

public class ABC_FORLIST {
	
	int id;
	String name;
	double val;
	
	public ABC_FORLIST(int id,String name,double val){
		this.id=id;
		this.name=name;
		this.val=val;
				
	}
	/*@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null)
			return false;
		
		if(arg0 instanceof ABC_FORLIST){
			ABC_FORLIST obj=(ABC_FORLIST) arg0;
			
			if(this.id==obj.id && this.name==obj.name && this.val==obj.val)
				return true;
		}
		return false;
	}*/
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(val);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ABC_FORLIST other = (ABC_FORLIST) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(val) != Double.doubleToLongBits(other.val))
			return false;
		return true;
	}

}
