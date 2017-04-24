package com.highradius;

public class SinglyLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public static void main(String... args){
		SinglyLinkedList<Integer> s = new SinglyLinkedList<>();
		s.add(12);
		s.add(11);
		s.add(43);
		/*s.addAfter(23,11);
		s.traverse();*/
		s.reverse();
		s.traverse();
	}

	public void reverse() {
		
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		
		while(current != null){
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void deleteAfter(T after) {
		Node<T> tmp = head;
		Node<T> ref = null;
		
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.compareTo(after)== 0){
				ref = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if(ref != null){
			tmp = ref.getNextRef();
			ref.setNextRef(tmp.getNextRef());
			if(ref.getNextRef() == null){
				tail = ref;
			}
			System.out.println("Deleted: "+tmp.getValue());
		}else{
			System.out.println("Unable to find element");
		}
		
	}

	public void deleteFront() {
		Node<T> tmp = head;
		head = tmp.getNextRef();
		if(head == null){
			tail = null;
		}
		System.out.println("Deleted: "+ tmp.getValue());
	}

	public void traverse() {
		Node<T> tmp = head;
		while(true){
			if(tmp != null){
				System.out.println(tmp.getValue());
				tmp = tmp.getNextRef();
			}else{
				System.out.println("No More elements in List...");
				break;
			}
		}
		
	}

	public void addAfter(T element, T after) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes...");
		while(true){
			if(tmp == null){
				break;
			}else if(tmp.compareTo(after) == 0){
				refNode = tmp;
				break;
			}else{
				tmp = tmp.getNextRef();
			}
		}
		
		if(refNode != null){
			Node<T> nd = new Node<>();
			nd.setValue(element);
			nd.setNextRef(tmp.getNextRef());
			if(tmp == tail){
				tail = nd;
			}
			tmp.setNextRef(nd);
		}else{
			System.out.println("Unable to find the given element...");
		}
		
	}

	public void add(T element) {
		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding Element: "+element);
		if(head == null){
			head = nd;
			tail = nd;
		}else {
			tail.setNextRef(nd);
			tail = nd;
		}
	}

}


class Node<T> implements Comparable<T>{
	private T value;
	private Node<T> nextRef;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<T> nextRef) {
		this.nextRef = nextRef;
	}

	@Override
	public int compareTo(T o) {
		if(o == this.value)
			return 0;
		else
			return 1;
	}
	
}
