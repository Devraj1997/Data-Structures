package com.heaps;

public class HeapUtil {

	public static void maxHeapify(int[] arr) {
		if (arr == null)
			return;
		int size = arr.length;
		int i = (int) Math.ceil(size / 2) - 1;
		while (i >= 0) {
			int h = i;
			int swapWith = 2 * h + 1;
			while (swapWith < size) {
				if (swapWith + 1 < size) {
					swapWith = arr[swapWith] > arr[swapWith + 1] ? swapWith : swapWith + 1;
				}
				if (arr[swapWith] > arr[h]) {
					int temp = arr[swapWith];
					arr[swapWith] = arr[h];
					arr[h] = temp;
					h = swapWith;
					swapWith = 2 * h + 1;
				} else
					break;
			}
			i--;
		}
	}

	public static void minHeapify(int[] arr) {
		if (arr == null)
			return;
		int size = arr.length;
		int i = ((size + 1) >> 1) - 1;
		while (i >= 0) {
			int h = i;
			int swapWith = 2 * h + 1;
			while (swapWith < size) {
				if (swapWith + 1 < size) {
					swapWith = arr[swapWith] < arr[swapWith + 1] ? swapWith : swapWith + 1;
				}
				if (arr[swapWith] < arr[h]) {
					int temp = arr[swapWith];
					arr[swapWith] = arr[h];
					arr[h] = temp;
					h = swapWith;
					swapWith = 2 * h + 1;
				} else
					break;
			}
			i--;
		}
	}

	public static void print(int[] arr) {
		if (arr == null)
			System.out.println("Heap is Null");
		for (int ele : arr)
			System.out.print(ele + "=>");
		System.out.println();
	}
}
