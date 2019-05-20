package org.java.algorithms;

import org.java.model.Node;

public class SinglyLinkedList<T> {

	Node<T> head;

	public boolean insert(T element) {
		Node<T> node = new Node<>(element);
		Node<T> temp = head;

		while (true) {
			if (head == null) {
				head = node;
				return true;
			} else if (temp.next == null) {
				temp.next = node;
				return true;
			} else {
				temp = temp.next;
			}
		}
	}

	public void iterate() {
		Node<T> temp = head;

		while (temp != null) {
			Node<T> next = temp.next;
			System.out.print(next != null ? temp.data + " -> " : temp.data);
			temp = next;
		}

	}

	public void reverse() {
		Node<T> next = null;
		Node<T> current = head;
		Node<T> prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
	}

	private boolean isCyclic() {
		boolean isCyclic = false;

		Node<T> fast = head;
		Node<T> slow = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				isCyclic = true;
				break;
			}
		}

		return isCyclic;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> obj = new SinglyLinkedList<>();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		// obj.iterate();
		// obj.reverse();
		// System.out.println();
		// obj.iterate();

		// NOTE: Creating Cyclic Loop. Also, don't call iterate method as it
		// leads to recursive infinite loop.
		obj.head.next.next.next.next.next = obj.head;

		boolean isCyclic = obj.isCyclic();
		System.out.println("Contains Cyclic Loop? : " + isCyclic);

	}

}
