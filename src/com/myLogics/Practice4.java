package com.myLogics;

import java.util.Vector;

/*
 * Producer Consumer Design Pattern using wait() and notifyAll() methods of Thread. Producing numbers and consuming it, using single vector of size 4;
 * 
 */
public class Practice4 {

	public static void main(String[] args) {
		Vector<Integer> sharedQueue = new Vector<>();
		int size = 4;
		Thread prodThread = new Thread(new Producer(sharedQueue,size),"Producer");
		Thread consThread = new Thread(new Consumer(sharedQueue,size),"Consumer");
		prodThread.start();
		consThread.start();
	}

}

class Producer implements Runnable{
	
	private final Vector<Integer> sharedQueue;
	private final int SIZE;
	
	public Producer(Vector<Integer> sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
		for(int i = 0; i < 7; i++){
			System.out.println("Produced: "+i);
			try{
				produce(i);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException{
		while(sharedQueue.size() == SIZE){
			synchronized(sharedQueue){
				System.out.println("Queue is full "+Thread.currentThread().getName()
						+ " is waiting, size: "+sharedQueue.size());
				sharedQueue.wait();
			}	
		}
		
		synchronized(sharedQueue){
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
		
	}
	
}

class Consumer implements Runnable{

	private final Vector<Integer> sharedQueue;
	private final int SIZE;
	
	public Consumer(Vector<Integer> sharedQueue, int size){
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				System.out.println("Consumed: "+ consume());
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}

	private int consume() throws InterruptedException {
		while(sharedQueue.isEmpty()){
			synchronized(sharedQueue){
				System.out.println("Queue is Empty "+ Thread.currentThread().getName()
						+ " is waiting, size: "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		
		synchronized(sharedQueue){
			sharedQueue.notifyAll();
			return sharedQueue.remove(0);
		}
	}
	
}