package com.mydataStructures;

public class QueueImpl {

	public static void main(String[] args) {
		IntQueue q = new IntQueue();
		q.enQueue(4);
		q.enQueue(3);
		q.enQueue(6);
		q.enQueue(1);
		
		q.showAll();
	}

}
