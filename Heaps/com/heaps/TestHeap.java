package com.heaps;

import java.util.Scanner;

public class TestHeap {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Size of MaxHeap: ");
		int n = scn.nextInt();
		MaxHeap maxHeap = new MaxHeap(n);
		do {
			System.out.println("Menu");
			System.out.println("1.Insert");
			System.out.println("2.Size");
			System.out.println("3.Extract Max");
			System.out.println("4.Print");
			System.out.println("5.Exit");
			int choice = scn.nextInt();
			switch(choice) {
			case 1: System.out.println("Element Element:");
					if(maxHeap.insert(scn.nextInt())) System.out.println("Element Inserted Successfully");
					else System.out.println("Insertion Unsuccessful");
					break;
			case 2: System.out.println("Size of MaxHeap is: " + maxHeap.size());
			        break;
			case 3: int element = maxHeap.extractMax();
					if(element!=-1) System.out.println("Max is: " + element);
					else System.out.println("Max Heap is Empty");
					break;
			case 4: maxHeap.print();
					break;
			case 5: System.exit(0);
			}
			System.out.println("Do you want to try again? 1-Yes");
		} while(1==scn.nextInt());
		scn.close();
	}
}
