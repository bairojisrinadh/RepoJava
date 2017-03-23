package org.sri.javaInterview;

public class ReverseSinglyLinkedList<T> {

	private Node<T> head;
	
	public static void main(String[] args) {
		ReverseSinglyLinkedList<Integer> sl = new ReverseSinglyLinkedList<>();
		sl.add(3);
		sl.add(1);
        sl.add(12);
        sl.add(9);
        System.out.println();
        sl.traverse();
        System.out.println();
        sl.reverse();
        sl.traverse();

	}

	
	public void add(T element) {
		Node<T> nd = new Node<>();
		nd.setValue(element);
		System.out.println("Adding Element: "+element);
		Node<T> tmp = head;
		while(true){
			if(tmp == null){
		//Since there is only one element, both head and tail points to same object.
			head = nd;
			break;
		}else if(tmp.getNextRef()==null){
			tmp.setNextRef(nd);
			break;
		}else{
			tmp = tmp.getNextRef();
		}
	
		}
	}
	
	public void traverse(){
        
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.print(tmp.getValue()+"\t");
            tmp = tmp.getNextRef();
        }
    }
	
	 public void reverse(){
         
	        System.out.println("\nReversing the linked list\n");
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
		public int compareTo(T arg) {
			if(arg == this.value){
			return 0;
		}else{
			return 1;
		}
		}
}

