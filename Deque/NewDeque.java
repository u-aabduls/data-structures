
/********************************************************************************************
 * EECS011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 2
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 ********************************************************************************************/

import java.util.Stack;

/**
 * @author umaragraw
 * 
 *         Deque class constructed with use of only two stacks. A deque is a
 *         double-ended queue.
 */
public class NewDeque<E> {

	private Stack<E> queue; // queue stack for deque
	private Stack<E> temp; // temp stack for deque to facilitate reordering of deque

	/**
	 * default constructor for NewDeque. No parameter constructor initializes
	 * NewDeque with two empty Stacks: queue and temp.
	 */
	NewDeque() {
		queue = new Stack<E>();
		temp = new Stack<E>();
	}

	/**
	 * Method takes @param o and places it into the end of the deque.
	 */
	void addLast(E o) {
		queue.push(o); // O(1), constant time
	}

	/**
	 * Method takes @param o and places it into the front of the deque.
	 */
	void addFirst(E o) {
		while (!queue.isEmpty()) { // do as long as queue stack is not empty
			temp.push(queue.pop()); // simultaneously push top of queue to temp stack and pop queue stack
		}
		queue.push(o); // now place new item at the bottom (last) in the queue
		while (!temp.isEmpty()) { // do as long as temp stack is not empty
			queue.push(temp.pop()); // simultaneously push top of temp to queue stack and pop temp stack
		}
	}

	/**
	 * Method removes last element in the deque and
	 * 
	 * @returns it if deque is not empty, returns null otherwise.
	 */
	E removeLast() {
		if (isEmpty())
			return null; // O(1), constant time
		else
			return queue.pop(); // O(1), constant time
	}

	/**
	 * Method removes first element in the deque and
	 * 
	 * @returns it if deque is not empty, returns null otherwise.
	 */
	E removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			while (!queue.isEmpty()) { // do as long as queue stack is not empty
				temp.push(queue.pop()); // simultaneously push top of queue to temp stack and pop queue stack
			}
			E o = temp.pop(); // store top of the temp (previous last item of queue), remove it from temp and
								// return it later
			while (!temp.isEmpty()) { // do as long as temp stack is not empty
				queue.push(temp.pop()); // simultaneously push top of temp to queue stack and pop temp stack
			}
			return o;
		}
	}

	/**
	 * Method @returns last element in the deque if deque is not empty, returns null
	 * otherwise.
	 */
	E last() {
		if (isEmpty())
			return null; // O(1), constant time
		else
			return queue.peek(); // O(1), constant time
	}

	/**
	 * Method @returns first element in the deque if deque is not empty, returns
	 * null otherwise.
	 */
	E first() {
		if (isEmpty()) {
			return null;
		} else {
			while (!queue.isEmpty()) { // do as long as queue stack is not empty
				temp.push(queue.pop()); // simultaneously push top of queue to temp stack and pop queue stack
			}
			E o = temp.peek(); // store bottom of the queue to return it later
			while (!temp.isEmpty()) { // do as long as temp stack is not empty
				queue.push(temp.pop()); // simultaneously push top of temp to queue stack and pop temp stack
			}
			return o;
		}
	}

	/**
	 * Method @returns the current number of elements in the deque.
	 */
	int size() {
		return queue.size(); // O(1), constant time
	}

	/**
	 * Method @returns true if deque contains 0 elements, returns false otherwise.
	 */
	boolean isEmpty() {
		return queue.isEmpty(); // O(1), constant time
	}
}
