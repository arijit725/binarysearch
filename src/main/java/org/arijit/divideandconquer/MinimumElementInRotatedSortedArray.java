package org.arijit.divideandconquer;

public class MinimumElementInRotatedSortedArray {

	/**
	 * This approach is using ubiquitious apprach and it requires less comparison.
	 * So this is a better apprach.
	 * But this will not work when the array is not rotated and simply sorted.
	 * @param arr
	 */
	public static void findPivotIndex1(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while ((high - low) > 1) {
			mid = low + (high - low) / 2;
			// pivot will be on left side as rotation happens to the left side of the
			// element
			if (arr[mid] <= arr[high])
				high = mid;
			// pivot will be on right side of the mid element as rotation happend on the
			// right side.
			else if (arr[mid] > arr[high])
				low = mid;
		}
		int index = arr[low] > arr[high] ? low : high;

		System.out.println("[Ubiquitious approach] PivotIndex: " + index);
		if (index == -1)
			System.out.println("Array is not rotated. Perform normal binary search.");
		else
			System.out.println("Ubiquitious approach Minimum element: " + arr[index + 1]);
	}

	/**
	 * Pivor in a sorted and rotated array is the place where peak is present.
	 */
	public static int findPivotIndex(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (((mid - 1) > 0 && arr[mid - 1] < arr[mid]) && ((mid + 1) < arr.length && arr[mid] > arr[mid + 1])) {
				return mid;
			}
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5 };
//		int arr[] = {5,4,3,2,1};
		int pivotIndex = findPivotIndex(arr);
		System.out.println("PivotIndex: " + pivotIndex);
		if (pivotIndex == -1)
			System.out.println("Array is not rotated. Perform normal binary search.");
		else
			System.out.println("Minimum element: " + arr[pivotIndex + 1]);
		findPivotIndex1(arr);

	}
}
