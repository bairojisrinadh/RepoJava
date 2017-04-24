package com.highradius;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList(){
		this.size = 0;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public class Node{
		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev){
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

	public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("Deleted: "+tmp.element);
        return tmp.element;
    } 
    
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("Deleted Last: "+tmp.element);
        return tmp.element;
    }

	public void addFirst(E element) {
		Node tmp = new Node(element,head,null);
		if(head != null){
			head.prev = tmp;
		}
		head = tmp;
		if(tail == null){
			tail = tmp;
		}
		size++;
		System.out.println("Adding: "+element);

	}
	
	public void addLast(E element) {   
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        System.out.println("Adding Last: "+element);
    }

	public void iterateForward() {
		System.out.println("Iterating Forward...");
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.next;
		}

	}
	
	public void iterateBackward() {
		System.out.println("Iterating Backward...");
		Node tmp = tail;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
		/*d.addFirst(10);
		d.addFirst(34);*/
		d.addLast(33);
		d.addLast(76);
		/*d.removeFirst();
		d.removeLast();
		d.iterateForward();
		d.iterateBackward();*/
	}





}
