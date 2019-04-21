
/********************************************************************************************
 * EECtemp011: Fundamentals of Data Structures,  Winter 2019
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

	/**
	 * NewDeque main method tester. Method tests methods for NewDeque functionality.
	 * Methods tested include: addFirst(), addLast(), removeFirst(), removeLast(),
	 * first(), last(), size(), and isEmpty().
	 */
	public static void main(String[] args) {

		System.out.println(
				"/****************************************** Test 1 ******************************************/");
		NewDeque<Object> nD1 = new NewDeque<Object>();
		System.out.println("NewDeque<Object> nD1 = new NewDeque<Object>();");
		System.out.println("nD1.size(): " + nD1.size());
		System.out.println("nD1.isEmpty(): " + nD1.isEmpty());
		System.out.println("nD1.first(): " + nD1.first());
		System.out.println("nD1.last(): " + nD1.last());
		System.out.println("nD1.removeFirst(): " + nD1.removeFirst());
		System.out.println("nD1.removeLast(): " + nD1.removeLast());
		String print1 = "";
		while (!nD1.queue.isEmpty()) {
			nD1.temp.push(nD1.queue.pop());
		}
		while (!nD1.temp.isEmpty()) {
			print1 += nD1.temp.pop();
		}
		System.out.println("Queue: [ " + print1 + " ]\n\n\n\n\n");
		System.out.println(
				"/****************************************** Test 2 ******************************************/");
		NewDeque<String> nD2 = new NewDeque<String>();
		System.out.println("NewDeque<String> nD2 = new NewDeque<String>();");
		System.out.println("nD2.size(): " + nD2.size());
		System.out.println("nD2.isEmpty(): " + nD2.isEmpty());
		String A = "A";
		nD2.addFirst(A);
		System.out.println("String A = \"A\";");
		System.out.println("nD2.addFirst(A);");
		System.out.println("nD2.first(): " + nD2.first());
		System.out.println("nD2.last(): " + nD2.last());
		System.out.println("nD2.size(): " + nD2.size());
		System.out.println("nD2.isEmpty(): " + nD2.isEmpty());
		String print2 = "";
		while (!nD2.queue.isEmpty()) {
			nD2.temp.push(nD2.queue.pop());
		}
		while (!nD2.temp.isEmpty()) {
			print2 += nD2.temp.pop();
		}
		System.out.println("Queue: [ " + print2 + " ]\n\n\n\n\n");
		System.out.println(
				"/****************************************** Test 3 ******************************************/");
		NewDeque<String> nD3 = new NewDeque<String>();
		System.out.println("NewDeque<String> nD3 = new NewDeque<String>();");
		System.out.println("nD3.size(): " + nD3.size());
		System.out.println("nD3.isEmpty(): " + nD3.isEmpty());
		String B = "B";
		String C = "C";
		nD3.addFirst(B);
		nD3.addLast(C);
		System.out.println("String B = \"B\";");
		System.out.println("String C = \"C\";");
		System.out.println("nD3.addFirst(B);");
		System.out.println("nD3.addLast(C);");
		System.out.println("nD3.first(): " + nD3.first());
		System.out.println("nD3.last(): " + nD3.last());
		System.out.println("nD3.size(): " + nD3.size());
		System.out.println("nD3.isEmpty(): " + nD3.isEmpty());
		String print3 = "";
		while (!nD3.queue.isEmpty()) {
			nD3.temp.push(nD3.queue.pop());
		}
		while (!nD3.temp.isEmpty()) {
			print3 += " " + nD3.temp.pop();
		}
		System.out.println("Queue: [" + print3 + " ]\n\n\n\n\n");
		System.out.println(
				"/****************************************** Test 4 ******************************************/");
		NewDeque<String> nD4 = new NewDeque<String>();
		System.out.println("NewDeque<String> nD4 = new NewDeque<String>();");
		System.out.println("nD4.size(): " + nD4.size());
		System.out.println("nD4.isEmpty(): " + nD4.isEmpty());
		String D = "D";
		String E = "E";
		String F = "F";
		String G = "G";
		nD4.addFirst(D);
		nD4.addLast(E);
		nD4.addFirst(F);
		nD4.addLast(G);
		System.out.println("String D = \"D\";");
		System.out.println("String E = \"E\";");
		System.out.println("String F = \"F\";");
		System.out.println("String G = \"G\";");
		System.out.println("nD4.addFirst(D);");
		System.out.println("nD4.addLast(E);");
		System.out.println("nD4.addFirst(F);");
		System.out.println("nD4.addLast(G);");
		System.out.println("nD4.first(): " + nD4.first());
		System.out.println("nD4.last(): " + nD4.last());
		System.out.println("nD4.size(): " + nD4.size());
		System.out.println("nD4.isEmpty(): " + nD4.isEmpty());
		String print4 = "";
		while (!nD4.queue.isEmpty()) {
			nD4.temp.push(nD4.queue.pop());
		}
		while (!nD4.temp.isEmpty()) {
			print4 += " " + nD4.temp.pop();
		}
		System.out.println("Queue: [" + print4 + " ]\n\n\n\n\n");
		System.out.println(
				"/****************************************** Test 5 ******************************************/");
		NewDeque<String> nD5 = new NewDeque<String>();
		System.out.println("NewDeque<String> nD5 = new NewDeque<String>();");
		System.out.println("nD5.size(): " + nD5.size());
		System.out.println("nD5.isEmpty(): " + nD5.isEmpty());
		String H = "H";
		String I = "I";
		String J = "J";
		String K = "K";
		nD5.addFirst(H);
		nD5.addLast(I);
		nD5.addFirst(J);
		nD5.addLast(K);
		System.out.println("String H = \"H\";");
		System.out.println("String I = \"I\";");
		System.out.println("String J = \"J\";");
		System.out.println("String K = \"K\";");
		System.out.println("nD5.addFirst(H);");
		System.out.println("nD5.addLast(I);");
		System.out.println("nD5.addFirst(J);");
		System.out.println("nD5.addLast(K);");
		System.out.println("nD5.first(): " + nD5.first());
		System.out.println("nD5.last(): " + nD5.last());
		System.out.println("nD5.size(): " + nD5.size());
		System.out.println("nD5.isEmpty(): " + nD5.isEmpty());
		nD5.removeFirst();
		nD5.removeLast();
		System.out.println("nD5.removeFirst();");
		System.out.println("nD5.removeLast();");
		System.out.println("nD5.first(): " + nD5.first());
		System.out.println("nD5.last(): " + nD5.last());
		System.out.println("nD5.size(): " + nD5.size());
		System.out.println("nD5.isEmpty(): " + nD5.isEmpty());
		nD5.removeFirst();
		nD5.removeLast();
		System.out.println("nD5.removeFirst();");
		System.out.println("nD5.removeLast();");
		System.out.println("nD5.size(): " + nD5.size());
		System.out.println("nD5.isEmpty(): " + nD5.isEmpty());
		String print5 = "";
		while (!nD5.queue.isEmpty()) {
			nD5.temp.push(nD5.queue.pop());
		}
		while (!nD5.temp.isEmpty()) {
			print5 += " " + nD5.temp.pop();
		}
		System.out.println("Queue: [" + print5 + " ]\n\n\n\n\n");
		System.out.println(
				"/****************************************** Test 6 ******************************************/");
		NewDeque<String> nD6 = new NewDeque<String>();
		System.out.println("NewDeque<String> nD6 = new NewDeque<String>();");
		System.out.println("nD6.size(): " + nD6.size());
		System.out.println("nD6.isEmpty(): " + nD6.isEmpty());
		nD6.addFirst(A);
		nD6.addFirst(B);
		nD6.addFirst(C);
		nD6.addFirst(D);
		nD6.addFirst(E);
		nD6.addLast(F);
		nD6.addLast(G);
		nD6.addLast(H);
		nD6.addLast(I);
		nD6.addLast(J);
		nD6.addLast(K);
		System.out.println("nD6.addFirst(A);");
		System.out.println("nD6.addFirst(B);");
		System.out.println("nD6.addFirst(C);");
		System.out.println("nD6.addFirst(D);");
		System.out.println("nD6.addFirst(E);");
		System.out.println("nD6.addLast(F);");
		System.out.println("nD6.addLast(G);");
		System.out.println("nD6.addLast(H);");
		System.out.println("nD6.addLast(I);");
		System.out.println("nD6.addLast(J);");
		System.out.println("nD6.addLast(K);");
		System.out.println("nD6.first(): " + nD6.first());
		System.out.println("nD6.last(): " + nD6.last());
		System.out.println("nD6.size(): " + nD6.size());
		System.out.println("nD6.isEmpty(): " + nD6.isEmpty());
		String print6 = "";
		while (!nD6.queue.isEmpty()) {
			nD6.temp.push(nD6.queue.pop());
		}
		while (!nD6.temp.isEmpty()) {
			print6 += " " + nD6.temp.pop();
		}
		System.out.println("Queue: [" + print6 + " ]");
	}
}
