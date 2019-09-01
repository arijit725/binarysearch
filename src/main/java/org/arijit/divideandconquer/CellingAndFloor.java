package org.arijit.divideandconquer;

/**
 * Find Celling and floor value of an element from an array
 * 
 * @author ARIJIT
 *
 */
public class CellingAndFloor {

	/**
	 * Here we are using UbiquitiousBinarySearch algorithm trick. In this trick we
	 * are not checking for celling and floor within while loop. But here we are
	 * actually defining the range bewteen which this value can be present and when
	 * (high-low)==1 at that time we know the value must be present with in this two
	 * index. so this two index becomes its celling and floor value if not matched
	 * exactly.
	 * 
	 * @param arr
	 * @param k
	 */
	private static void findCellingFoorWithUbiquitiousBinarySearch(int arr[], int k) {

		int low = 0;
		int high = arr.length - 1;
		while ((high - low) > 1) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < k)
				low = mid;
			else
				high = mid;
		}

		int fIndex = -1;
		int cIndex = -1;
		if (arr[low] == k)
			fIndex = cIndex = low;
		else if (arr[high] == k)
			fIndex = cIndex = high;
		else {
			fIndex = low;
			cIndex = high;
		}
		System.out.println("Celling: " + arr[cIndex] + " Floor: " + arr[fIndex]);
	}

	/**
	 * This is a normal binary search based implementation. Here comparison is much higher than UbiquitiousBinarySearch based algorithm
	 * 
	 * @param arr
	 * @param k
	 */
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
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int k = 20;
		findCellingFloor(arr, k);
		findCellingFoorWithUbiquitiousBinarySearch(arr, k);
	}
}
