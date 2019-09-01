package org.arijit.divideandconquer;

public class MinimumElementInRotatedSortedArray {

	/**
	 * Pivor in a sorted and rotated array is the place where peak is present.
	 */
	public static int findPivotIndex(int arr[]) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while(low<=high) {
			mid = low+(high-low)/2;			
			if(((mid-1)>0 && arr[mid-1]<arr[mid])
					&& ((mid+1)<arr.length && arr[mid]>arr[mid+1])) {
				return mid;
			}
			if(arr[mid]>arr[high]) {
				low = mid+1;
			}
			else 
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		int arr[] = {6,7,8,9,10,11,12,1,2,3,4,5};
//		int arr[] = {5,4,3,2,1};
		int pivotIndex = findPivotIndex(arr);
		System.out.println("PivotIndex: "+pivotIndex);
		if(pivotIndex==-1)
			System.out.println("Array is not rotated. Perform normal binary search.");
		else
			System.out.println("Minimum element: "+arr[pivotIndex+1]);
				
	}
}
