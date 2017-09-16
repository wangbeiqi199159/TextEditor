package textgen;

import org.reactfx.util.LL;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException("Element cannot be null!");

		new LLNode<>(element, tail);
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		int i = index;
		while(i > 0){
			node = node.next;
			i--;
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}

		if (element == null)
			throw new NullPointerException("Element cannot be null!");

		LLNode<E> node = head;
		int i = index;
		while(i > 0){
			node = node.next;
			i--;
		}
		new LLNode<>(element, node);
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		int i = index;
		while(i > 0){
			node = node.next;
			i--;
		}
		LLNode<E> before = node.prev;
		LLNode<E> after = node.next;
		before.next = after;
		after.prev = before;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		int i = index;
		while(i > 0){
			node = node.next;
			i--;
		}
		E replaced = node.data;
		node.data = element;
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(E e, LLNode<E> next) {
		this(e);
		this.prev = next.prev;
		this.next = next;
		next.prev.next = this;
		next.prev = this;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
