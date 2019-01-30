package dataStructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeQueueTest {

	@Test
	public void testEnqueueAndDequeue() {
		//Arrange
		Integer element1 = new Integer(15);
		Integer element2 = new Integer(16);
		Integer element3 = new Integer(12);
		
		//Act
		TreeQueue<Integer> queue = new TreeQueue<Integer>();
		queue.enqueue(element1);
		queue.enqueue(element2);
		queue.enqueue(element3);
		
		//Assert
		try {
			assertEquals(15, (int)queue.dequeue());
			assertEquals(16, (int)queue.dequeue());
			assertEquals(12, (int)queue.dequeue());
		} catch (Exception e) {
			fail("Queue was empty");
		}
	}
	
	@Test
	public void testDequeueWithEmpty() {
		//Arrange
		TreeQueue<Integer> queue = new TreeQueue<Integer>();
		
		//Assert
		try {
			Integer element = queue.dequeue();
			fail("Should throw an exception.");
		} catch (Exception e) {
			assertTrue(queue.isEmpty());
		}
	}
	
	@Test
	public void testEnqueueAndDequeueAlternating() {
		//Arrange
		Integer element1 = new Integer(15);
		Integer element2 = new Integer(16);
		Integer element3 = new Integer(12);
		
		//Act
		TreeQueue<Integer> queue = new TreeQueue<Integer>();
		queue.enqueue(element1);
		
		//Assert
		try {
			assertTrue(!queue.isEmpty());
			assertEquals(15, (int)queue.dequeue());
			assertTrue(queue.isEmpty());
		} catch (Exception e) {
			fail("Queue was empty");
		}
		
		queue.enqueue(element2);
		queue.enqueue(element3);
		
		//Assert
		try {
			assertEquals(16, (int)queue.dequeue());
			assertEquals(12, (int)queue.dequeue());
		} catch (Exception e) {
			fail("Queue was empty");
		}
	}
	
}
