package com.mydataStructures;

public class IntQueue {

	private int[] q;
	private int size;
	private int total;
	private int front;
	private int rear;

	public IntQueue(){
		this.size = 50;
		this.total = 0;
		this.front = 0;
		this.rear = 0;
		q = new int[this.size];
	}

	public IntQueue(int size){
		this.size = size;
		this.total = 0;
		this.front = 0;
		this.rear = 0;
		q = new int[this.size];
	}

	public boolean enQueue(int item){
		if(!isFull()){
			total++;
			q[rear] = item;
			rear = (rear + 1)% size;
			return true;
		}else
			return false;

	}

	public int deQueue(){
		int item = q[front];
		total--;
		front = (front + 1) % size;
		return item;

	}

	public boolean isFull(){
		if(size == total)
			return true;
		else 
			return false;
	}
	
	public void showAll(){
		int f = front;
		if(total!=0){
			for(int i=0; i<total; i++){
				System.out.println(" "+ q[f]);
				f = (f+1)%size;
			}
		}
		
	}

}
