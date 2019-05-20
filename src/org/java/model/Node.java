package org.java.model;

public class Node<T> {

	public T data;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=");
		builder.append(data);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}
	
}
