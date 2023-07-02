package com.heaps;

public class MaxHeap {

	private int[] heap;
	private int size; 
	
	public MaxHeap(int n) {
		this.heap = new int[n];
		this.size = 0;
	}

	public boolean insert(int element) {
		if(this.size == heap.length) return false;
		this.heap[this.size] = element;
		int child = this.size;
		int parent = (child - 1)/2;
		while(this.heap[parent] < this.heap[child]) {
			int temp = this.heap[parent];
			this.heap[parent] = this.heap[child];
			this.heap[child] = temp;
			child = parent;
			parent = (child - 1)/2;
		}
		this.size++;
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public int extractMax() {
		if(this.size == 0) return -1;
		int num = this.heap[0];
		this.heap[0] = this.heap[--this.size];
		int idx = 0;
		int swapWith = 2 * idx + 1;
		while(swapWith < this.size) {
			if(swapWith + 1 < this.size) swapWith = this.heap[swapWith] > this.heap[swapWith+1] ? swapWith : swapWith+1;
			if(this.heap[idx] < this.heap[swapWith]) {
				int temp = this.heap[idx];
				this.heap[idx] = this.heap[swapWith];
				this.heap[swapWith] = temp;
				idx = swapWith;
				swapWith = 2 * idx + 1;
			} else 
				break;
		}
		return num;
	}
	
	public void print() {
		if(this.size > 0) {
			for(int i=0;i<this.size;i++) System.out.print(this.heap[i] + "=>");
			System.out.println();
			return;
		}
		System.out.println("Heap is Empty");
	}
}
