package core.java;



public class SinglyLinkedList<T> {
	
	Node<T> headNode;

	public static void main(String[] args) {
		SinglyLinkedList<String> sl = new SinglyLinkedList<>();
		sl.add("Srinadh");
		sl.add("Ashwini");
		sl.add("Ramya");
		sl.traverse();

	}

	public void add(T str) {
		Node<T> node = new Node<>();
		node.setValue(str);
		System.out.println("Adding Element: " + str);
		Node<T> tmp = headNode;
		while(true){
			if(tmp==null){
				headNode = node;
				break;
			}else if (tmp.getNextRef()==null){
				tmp.setNextRef(node);
				break;
			}else {
				tmp = tmp.getNextRef();
			}
		}
		
	}
	
	public void traverse(){

		Node<T> tmp = headNode;
		while(true){
			if(tmp == null){
				break;
			}
			System.out.print(tmp.getValue()+"\t");
			tmp = tmp.getNextRef();
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
	public int compareTo(T arg) {
		if(arg == this.value)
		return 0;
		else return 1;
	}
	
	
}
