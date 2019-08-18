package org.arijit.binarysearch;
/**
 * Find Celling and floor value of an element from an array
 * @author ARIJIT
 *
 */
public class CellingAndFloor {

	private static void findCellingFloor(int arr[],int k) {
		int low = 0;
		int high = arr.length;
		int celling=-1;
		int floor = -1;
		while(low<high) {
			int mid = (low+high)/2;
			if(arr[mid]==k) {
				celling = arr[mid];
				floor = arr[mid];
				break;
			}
			else if((mid-1)<0 && arr[mid]>k) {
				celling = arr[mid]; // where celling is present but not floor
				break;
			}
			else if((mid+1)>=arr.length && arr[mid]<k) {
				floor = arr[mid]; //when floor is present but not celling.
				break;
			}
			else if(arr[mid]<k && (mid+1<arr.length && arr[mid+1]>k))
			{
				 celling =arr[mid+1];
				 floor =arr[mid];
				 break;
			}
			else if(arr[mid]>k){
				high=mid;								
			}
			else low=mid;
		}
		
		System.out.println("Celling Value ="+celling+" Floor Value="+floor);
	}
	public static void main(String args[]) {
		int arr[] = {1,2,8,10,10,12,19};
		int k = 20;
		findCellingFloor(arr, k);
	}
}
