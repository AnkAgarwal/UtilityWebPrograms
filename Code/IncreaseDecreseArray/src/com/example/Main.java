package com.example;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={-2,-1,0,1,14,18,22,26,30,24,21,12,9,4,2};
		int key=-1;
		
		int index = getIndexElement(arr,0,arr.length);
		
		int result=binarySearchInc(arr,0,index,key);
		if(result==-1){
			result=binarySearchDec(arr,index+1,arr.length-1,key);
		}
		
		System.out.println(key+" found at index "+result);
	}

	private static int binarySearchInc(int[] arr, int i, int j, int key) {
		// TODO Auto-generated method stub
		int mid=(i+j)/2;
		if(!(i==j && arr[mid]!=key)){
			if(arr[mid]==key)
				return mid;
			else if(key<arr[mid]){
				return binarySearchInc(arr, i, mid-1, key);
			}else if(key>arr[mid]){
				return binarySearchInc(arr, mid+1, j, key);
			}
		}
		return -1;
	}
	
	private static int binarySearchDec(int[] arr, int i, int j, int key) {
		// TODO Auto-generated method stub
		int mid=(i+j)/2;
		if(!(i==j && arr[mid]!=key)){
			if(arr[mid]==key)
				return mid;
			else if(key<arr[mid]){
				return binarySearchDec(arr, mid+1, j, key);
			}else if(key>arr[mid]){
				return binarySearchDec(arr, i, mid-1, key);
			}
		}
		return -1;
	}

	private static int getIndexElement(int[] arr, int i, int length) {
		// TODO Auto-generated method stub
		int minInd=i;
		int maxInd=length;
		
		int mid=(i+length)/2;
		
		if(mid!=0 && mid!=arr.length-1 ){
			if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
				return mid;
			}
			else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
				return getIndexElement(arr, mid+1, length);
			}else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
				return getIndexElement(arr, i, mid-1);
			}
			
		}
		return -1;
		
	}

}
