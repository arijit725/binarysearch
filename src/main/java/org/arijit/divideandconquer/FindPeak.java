package org.arijit.divideandconquer;
/**
 * Find Peak in an array where numbers first increases and then decreases
 * @author ARIJIT
 *
 */
public class FindPeak {

	public static int findPeak(int arr[]) {
		int low = 0;
		int high = arr.length;
		while(low<high) {
			int mid=(low+high)/2;
			if(((mid-1)>=0 && arr[mid-1]<arr[mid])&&(mid+1<arr.length && arr[mid+1]<arr[mid])) {
				//peak found
				return arr[mid];
			}
			else if((mid-1)>=0 && arr[mid-1]<arr[mid] && mid+1<arr.length && arr[mid]<arr[mid+1]){
				// this part is increasing sequence. So peak will be on right
				low = mid+1;				
			}
			else if((mid-1)>=0 && arr[mid-1]>arr[mid] && mid+1<arr.length && arr[mid]>arr[mid+1]){
				// this part is decreasing sequence. so peak will be left.
				high = mid-1;
			}
		}
		return -1;
		
	}
	public static void main(String args[]) {
		int arr[] = {8,10,20,80,100,400,500,3,2,1};
		int peak = findPeak(arr);
		System.out.println("Peak: "+peak);
	}
}
