/********************************************************************************************
 * EECTemp011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 2
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 ********************************************************************************************/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NewDequeUnitTests {

	@Test
	public void test_01_constructor() {
		NewDeque<?> nD = new NewDeque<Object>();
		assertTrue(nD.isEmpty());
		assertEquals(nD.size(), 0);
		assertTrue(nD.isEmpty());
		assertEquals(nD.size(), 0);
	}

	@Test
	public void test_01_queuePush() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.removeLast(), o);
	}


	@Test
	public void test_01_tempPush() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.removeLast(), o);
	}

	@Test
	public void test_01_queuePop() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.removeLast(), o);
	}

	@Test
	public void test_01_tempPop() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.removeLast(), o);
	}

	@Test
	public void test_01_queuePeek() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.last(), o);
	}

	@Test
	public void test_01_tempPeek() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		nD.addFirst(o);
		assertEquals(nD.last(), o);
	}

	@Test
	public void test_01_queueSize() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		assertEquals(nD.size(), 0);
		nD.addFirst(o);
		assertEquals(nD.size(), 1);
	}

	@Test
	public void test_02_queueSize() {
		NewDeque<Object> nD = new NewDeque<Object>();
		assertEquals(nD.size(), 0);
		int size = (int) (Math.random() * 100);
		Object[] os = new Object[size];
		for (int i = 0; i < size; i++) {
			os[i] = new Object();
		}
		for (int i = 0; i < size; i++) {
			nD.addFirst(os[i]);
		}
		assertTrue(nD.size() == size);
	}

	@Test
	public void test_01_tempSize() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o = new Object();
		assertEquals(nD.size(), 0);
		nD.addFirst(o);
		assertEquals(nD.size(), 1);
	}


	@Test
	public void test_01_queueIsEmpty() {
		NewDeque<Object> nD = new NewDeque<Object>();
		assertTrue(nD.isEmpty());
		Object o = new Object();
		nD.addFirst(o);
		assertFalse(nD.isEmpty());
	}


	@Test
	public void test_01_addFirst() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addFirst(o1);
		assertEquals(nD.first(), o1);
	}

	@Test
	public void test_01_addLast() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addLast(o1);
		assertEquals(nD.last(), o1);
	}

	@Test
	public void test_01_size() {
		NewDeque<?> nD = new NewDeque<Object>();
		assertEquals(nD.size(), 0);
		assertEquals(nD.size(), 0);
		assertEquals(nD.size(), 0);
		assertEquals(nD.size(), nD.size(), nD.size());
	}

	@Test
	public void test_01_removeFirst() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addFirst(o1);
		assertEquals(nD.removeFirst(), o1);
	}

	@Test
	public void test_02_removeFirst() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		assertEquals(nD.size(), 0);
		nD.addFirst(o1);
		assertEquals(nD.size(), 1);
		nD.addFirst(o2);
		assertEquals(nD.size(), 2);
		nD.addFirst(o3);
		assertEquals(nD.size(), 3);
		assertEquals(nD.removeFirst(), o3);
		assertEquals(nD.removeFirst(), o2);
		assertEquals(nD.removeFirst(), o1);
	}

	@Test
	public void test_01_removeLast() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addLast(o1);
		assertEquals(nD.removeLast(), o1);
	}

	@Test
	public void test_02_removeLast() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		assertEquals(nD.size(), 0);
		nD.addFirst(o1);
		assertEquals(nD.size(), 1);
		nD.addFirst(o2);
		assertEquals(nD.size(), 2);
		nD.addFirst(o3);
		assertEquals(nD.size(), 3);
		assertEquals(nD.removeLast(), o1);
		assertEquals(nD.removeLast(), o2);
		assertEquals(nD.removeLast(), o3);
	}

	@Test
	public void test_01_first() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addFirst(o1);
		assertEquals(nD.last(), o1);
		assertEquals(nD.first(), o1);
	}

	@Test
	public void test_02_first() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		nD.addFirst(o1);
		nD.addFirst(o2);
		nD.addFirst(o3);
		assertEquals(nD.last(), o1);
		assertEquals(nD.first(), o3);
	}

	@Test
	public void test_03_first() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		Object o5 = new Object();
		nD.addFirst(o1);
		nD.addLast(o2);
		nD.addFirst(o3);
		nD.addLast(o4);
		nD.addFirst(o5);
		assertEquals(nD.last(), o4);
		assertEquals(nD.first(), o5);
	}

	@Test
	public void test_01_last() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		nD.addFirst(o1);
		assertEquals(nD.last(), o1);
	}

	@Test
	public void test_02_last() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		nD.addFirst(o1);
		nD.addFirst(o2);
		nD.addFirst(o3);
		assertEquals(nD.last(), o1);
	}

	@Test
	public void test_04_first() {
		NewDeque<Object> nD = new NewDeque<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		Object o5 = new Object();
		nD.addFirst(o1);
		nD.addLast(o2);
		nD.addFirst(o3);
		nD.addLast(o4);
		nD.addFirst(o5);
		assertEquals(nD.last(), o4);
	}

	@Test
	public void test_01_isEmpty() {
		NewDeque<?> nD = new NewDeque<Object>();
		assertTrue(nD.isEmpty());
		assertTrue(nD.isEmpty());
		assertTrue(nD.isEmpty());
	}



}
