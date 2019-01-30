package dataStructures;

import java.util.ArrayList;
import java.util.List;

/*
 * Queue: first in, first out, last in, last out
 */
public class TreeQueue<E> {

	List<E> queue;
	
	public void enqueue(E element) {
		if (queue == null) {
			queue = new ArrayList<E>();
		}
		queue.add(element);		
	}
	
	public E dequeue() throws Exception {
		if (queue == null || queue.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		E element = queue.get(0);
		queue.remove(0);
		return element;
	}
	
	public boolean isEmpty() {
		return queue == null || queue.isEmpty();
	}
	
}
