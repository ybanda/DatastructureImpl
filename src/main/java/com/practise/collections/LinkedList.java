package com.practise.collections;

/**
 * 
 * @author Yashwanth
 *
 * @param <T>
 */
public class LinkedList<T>
{
	Node<T> head;

	Node<T> tail;

	/**
	 * 
	 * @param nodeElement
	 */
	public void addNode(T nodeElement)
	{
		Node<T> newNode = new Node<T>();

		newNode.setElement(nodeElement);

		if(head==null)
		{
			head = newNode;

			tail= newNode;
		}
		else
		{

			tail.setNext(newNode);

			tail = newNode;


		}
	}

	/**
	 * 
	 * @param element
	 */
	public void deleteNode(T element)
	{
/*
		Node<T> headClone = new Node<T>();
		if(element!=null)
		{
			Node<T> temp = head;

			while(temp!=null)
			{
				if(temp.getElement()!=element)
				{
					headClone = temp;
					headClone.setNext(headClone);
				}

				temp=temp.getNext();
			}
		}
		
		head=headClone;
	*/
		 if(head == null){
	            System.out.println("Underflow...");
	        }
	        Node<T> tmp = head;
	        head = tmp.getNext();
	        if(head == null){
	            tail = null;
	        }
	        System.out.println("Deleted: "+tmp.getElement());
	}

	/**
	 * 
	 */
	public void traverse()
	{
		Node<T> node = head;
		
		while(node!=null)
		{
			System.out.println(node.getElement());
		
			node = node.getNext();
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{

		LinkedList<Integer> sl = new LinkedList<Integer>();

		sl.addNode(3);

		sl.addNode(32);

		sl.addNode(54);

		sl.traverse();
		
		//sl.deleteNode(54);
		
		System.out.println("Traverse");
		
		sl.traverse();
	}
}


/**
 * 
 * @author Yashwanth
 *
 * @param <T>
 */
class Node<T> implements Comparable<T>
{
	T element;

	Node<T> next;
	/**
	 * @return the element
	 */
	public T getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}


	@Override
	public int compareTo(T arg0) {
		if(arg0==element)
			return 0;
		else 
			return 1;
	}

}