package org.sri.javaPrograms;

public class SinglyLinkedList<T> {

	private Node<T> head;
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> s = new SinglyLinkedList<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.traverse();
		s.reverese();
		s.traverse();
	}
	
	public void add(T element){
		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding: "+element);
		Node<T> tmp = head;
		while(true){
			if(tmp == null){
				head= nd;
				break;
			}
			else if(tmp.getNextRef() == null){
				tmp.setNextRef(nd);
				break;
			}else {
				tmp = tmp.getNextRef();
			}
		}
	}
	
	public void traverse(){
		Node<T> tmp = head;
		while(true){
			if(tmp == null){
				break;
			}else{
				System.out.println(tmp.getValue()+ "\t");
				tmp= tmp.getNextRef();
			}
		}
	}
	
	public void reverese(){
		System.out.println("Reversing Singly Linked List");
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		while(current !=null){
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}
	
class Node<T> implements Comparable<T>{
	public T value;
	public Node<T> nextRef;
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
		if(o == this.value){
		return 0;
		}else{
			return 1;	
		}
	}
	
}

}
