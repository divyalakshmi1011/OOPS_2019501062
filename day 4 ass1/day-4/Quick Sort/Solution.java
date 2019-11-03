import java.util.Random;


class Solution {
	public static int[] quickSort(int[] arr) {
		// fill you code Here
        shuffle(arr);
		sort(arr,0,arr.length-1);
		return arr;
	}
	private static int[] shuffle(int[] arr) {
		Random rnd = new Random();
		for(int i = arr.length-1; i > 0; i--) {
			int index = rnd.nextInt(i+1);
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
		return arr;
	}
	private static int partition(final int[] arr, final int low, final int high) {
		int i = low;
		int j = high + 1;
		while(true) {
			while(arr[++i] < arr[low]) {
				if(i == high) {
					break;
				}
			}
			while(arr[low] < arr[--j]) {
				if(j == low) {
					break;
				}
			}
			if(i >= j) {
				break;
			}
			swap(arr, i, j);
		}
		swap(arr, low, j);
		return j;
	}
	/**
	 * Exchanges the values in the given index.
	 * @param arr array elements
	 * @param i
	 * @param j
	 * @return integer array after swaping
	 */
	public static int[] swap(final int[] arr, final int i, final int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	private static void sort(final int[] arr, final int low, final int high) {
		if(high <= low) {
			return;
		}
		int mid = partition(arr, low, high);
		sort(arr, low, mid-1);
		sort(arr, mid + 1, high);
	}
}
