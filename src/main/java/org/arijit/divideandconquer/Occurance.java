package org.arijit.divideandconquer;
/**
 * Find occurance of a repitative element in sorted array.
 * @author ARIJIT
 *
 */
public class Occurance {

	/**
	 * Here  we are using ubiquitious binary search algorithm
	 * @param arr
	 * @param low
	 * @param high
	 * @param num
	 */
	private static void occurance(int arr[], int low, int high, int num) {
		
		while((high-low)>1) {
			int mid = low+(high-low)/2;
			if((mid-1)>=0 && arr[mid-1]==num)
				high = mid-1;
			else if(arr[mid]<=num)
				low = mid;
			else if(arr[mid]>num) {
				high = mid;
			}
			
		}
	 int firstOcuurance = -1;
	 if(arr[low]==num)
		 firstOcuurance = low;
	 else if(arr[high]==num)
		 firstOcuurance = high;
	 System.out.println(firstOcuurance);
	 
	 low = firstOcuurance+1;
	 high = arr.length-1;
	 while((high-low)>1) {
			int mid = low+(high-low)/2;
			if((mid+1)<arr.length && arr[mid+1]==num)
				low = mid+1;
			else if(arr[mid]<=num)
				low = mid;
			else if(arr[mid]>num) {
				high = mid;
			}
			
		}
	 int lastOccurnance = -1;
	 if(arr[low]==num)
		 lastOccurnance = low;
	 else if(arr[high]==num)
		 lastOccurnance = high;
	 
	 System.out.println(lastOccurnance);
	 
	}
	private static int findFirst(int arr[],int low, int high,int num) {	
		
		while(low<high) {
			
			int mid = (low+high)/2;
			if((mid-1)<0 && arr[mid]== num) {
				//edge case: when number starts from the begining.
				return mid;
			}
			else if((mid+1)>=arr.length && arr[mid]==num) {
				// edge case: when number and the end is the last occurance of the number
				return mid;
			}
			else if(num<arr[mid]) {
				high = mid-1;
			}
			else if(num>arr[mid]){
				low = mid +1;
			}
			else if(arr[mid]==num) {
				if((mid-1)>=0 &&  arr[mid-1]<arr[mid]) {
					return mid;
				}
					high = mid-1;	
				}
					
			}			
		// there are chances where low=high and arr[low]=num
		if(arr[low]==num)
			// edge case when the array starts with num
			return low;
		return -1;
	}
	
	private static int findLast(int arr[],int low, int high,int num) {	
		while(low<high) {
			int mid = (low+high)/2;
			if((mid-1)<0 && arr[mid]== num) {
				//edge case: when number starts from the begining.
				return mid;
			}
			else if((mid+1)>=arr.length && arr[mid]==num) {
				// edge case: when number and the end is the last occurance of the number
				return mid;
			}
			else if(num<arr[mid]) {
				high = mid-1;
			}
			else if(num>arr[mid]){
				low = mid +1;
			}
			else if(num==arr[mid]) {
				if((mid+1)<arr.length && arr[mid]<arr[mid+1]) {
					return mid;
				}
				else {
					low = mid+1;
				}
			}
			
		}
		// there are chances where low=high and arr[high]=num
		if(arr[high]==num)
			// edge case when the array starts with num
			return low;
		return -1;
	}
	
	private static void occurance(int arr[],int num) {
		int firstOccurance = findFirst(arr, 0, arr.length, num);
		System.out.println("FirstOccurance: "+firstOccurance);
		int lastOccurance = findLast(arr, firstOccurance, arr.length, num);
		System.out.println("lastOccurance: "+lastOccurance);
		System.out.println("Total Occurance: "+(1+lastOccurance-firstOccurance));
	}
	public static void main(String args[]) {
		int arr[] = {1,2,3,3,3,3,3,4,4,5,6};
//		occurance(arr, 2);
		occurance(arr, 0, arr.length-1, 3);
	}
}
