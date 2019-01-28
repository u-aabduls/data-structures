/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 **********************************************************/

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Test;

public class PolyUnitTests {

	@Test
	public void test_defaultConst() {
		SimplePolygon p = new SimplePolygon();
		assertEquals(p.getSize(), 3);
		assertEquals(p.vertices.length, 3);
		assertEquals(p.vcounter, 0);
	}

	@Test
	public void test_sizeConst() {
		int size = (int) (Math.random() * 100);
		SimplePolygon p = new SimplePolygon(size);
		assertEquals(p.getSize(), size);
		assertEquals(p.vertices.length, size);
		assertEquals(p.vcounter, 0);
	}

	@Test
	public void test_01_addVertex() {
		int size = (int) ((Math.random() * 100) + 3);
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		Point2D.Double v1 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		Point2D.Double v2 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		p.addVertex(v0);
		p.addVertex(v1);
		p.addVertex(v2);
		assertEquals(p.vertices[0], v0);
		assertEquals(p.vertices[1], v1);
		assertEquals(p.vertices[2], v2);
	}

	@Test
	public void test_02_addVertex() {
		int size = (int) (Math.random() * 100);
		SimplePolygon p = new SimplePolygon(size);
		/*
		 * traversing through vertices array while adding new created vertex
		 */
		for (int i = 0; i < size; i++) {
			Point2D.Double v = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
			p.addVertex(v);
		}
		assertEquals(p.vertices.length, size);
	}

	@Test
	public void test_getSize() {
		int size = (int) (Math.random() * 100);
		SimplePolygon p = new SimplePolygon(size);
		assertEquals(p.getSize(), size);
	}

	@Test
	public void test_getVertex() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		Point2D.Double v1 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		Point2D.Double v2 = new Point2D.Double((Math.random() * 100), (Math.random() * 100));
		p.addVertex(v0);
		p.addVertex(v1);
		p.addVertex(v2);
		assertEquals(p.getVertex(0), v0);
		assertEquals(p.getVertex(1), v1);
		assertEquals(p.getVertex(2), v2);
		assertTrue(p.getVertex(3) == null);
		assertTrue(p.getVertex(4) == null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_01_getVertexIOOBE() {
		int size = (int) (Math.random() * 100);
		SimplePolygon p = new SimplePolygon(size);
		p.getVertex((size - size) - 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_02_getVertexIOOBE() {
		int size = (int) (Math.random() * 100);
		SimplePolygon p = new SimplePolygon(size);
		p.getVertex(size + 1);
	}

	@Test
	public void test_01_delta() {
		double x0 = 34.8;
		double x1 = 14.8;
		double x2 = 78.3;
		double y0 = 12.3;
		double y1 = 2.0;
		double y2 = 19.5;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		assertTrue(SimplePolygon.delta(v0, v1, v2) == 304.05);
	}

	@Test
	public void test_02_delta() {
		double x0 = -52.6;
		double x1 = 23.8;
		double x2 = 33.9;
		double y0 = 5.9;
		double y1 = -17.4;
		double y2 = -98.3;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		assertTrue(SimplePolygon.delta(v0, v1, v2) == -5945.43);
	}

	@Test
	public void test_03_delta() {
		double x0 = 160.7;
		double x1 = -6.9;
		double x2 = 230.2;
		double y0 = -43.2;
		double y1 = -170.4;
		double y2 = -7.5;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		double d = SimplePolygon.delta(v0, v1, v2);
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertTrue(d == 2857.08);
	}

	@Test
	public void test_04_delta() {
		double x0 = -7.0;
		double x1 = 3.0;
		double x2 = 6.0;
		double y0 = 0.0;
		double y1 = 0.0;
		double y2 = 0.0;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		assertTrue(SimplePolygon.delta(v0, v1, v2) == 0);
	}

	@Test
	public void test_01_deltav() {
		double x0 = -52.6;
		double x1 = 23.8;
		double x2 = 33.9;
		double y0 = 5.9;
		double y1 = -17.4;
		double y2 = -98.3;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		assertTrue(SimplePolygon.delta(v0, v1, v2) == -5945.43);
		double delta = SimplePolygon.delta(v0, v1, v2);
		assertTrue(SimplePolygon.deltav(delta) == -1);
	}

	@Test
	public void test_02_deltav() {
		double x0 = 160.7;
		double x1 = -6.9;
		double x2 = 230.2;
		double y0 = -43.2;
		double y1 = -170.4;
		double y2 = -7.5;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		double d = SimplePolygon.delta(v0, v1, v2);
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertTrue(d == 2857.08);
		assertTrue(SimplePolygon.deltav(d) == 1);
	}

	@Test
	public void test_03_deltav() {
		double x0 = -7.0;
		double x1 = 3.0;
		double x2 = 6.0;
		double y0 = 0.0;
		double y1 = 0.0;
		double y2 = 0.0;
		Point2D.Double v0 = new Point2D.Double(x0, y0);
		Point2D.Double v1 = new Point2D.Double(x1, y1);
		Point2D.Double v2 = new Point2D.Double(x2, y2);
		assertTrue(SimplePolygon.delta(v0, v1, v2) == 0);
		double delta = SimplePolygon.delta(v0, v1, v2);
		assertTrue(SimplePolygon.deltav(delta) == 0);
	}

	@Test
	public void test_01_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(2, 2);
		Point2D.Double v3 = new Point2D.Double(2, 0);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_02_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(3, 2);
		Point2D.Double v3 = new Point2D.Double(3, 7);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_03_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(5, 0);
		Point2D.Double v2 = new Point2D.Double(3, 0);
		Point2D.Double v3 = new Point2D.Double(3, 7);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_04_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(5, 0);
		Point2D.Double v2 = new Point2D.Double(3, -6);
		Point2D.Double v3 = new Point2D.Double(3, 7);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_05_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-5, 5);
		Point2D.Double v1 = new Point2D.Double(5, -5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(-5, -5);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_06_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-5, 5);
		Point2D.Double v1 = new Point2D.Double(5, 5);
		Point2D.Double v2 = new Point2D.Double(0, 0);
		Point2D.Double v3 = new Point2D.Double(0, 4);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_07_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-5, 5);
		Point2D.Double v1 = new Point2D.Double(5, 5);
		Point2D.Double v2 = new Point2D.Double(0, 0);
		Point2D.Double v3 = new Point2D.Double(0, 5);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_08_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-3, 1);
		Point2D.Double v1 = new Point2D.Double(5, 3);
		Point2D.Double v2 = new Point2D.Double(-2, -2);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_09_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-3, 1);
		Point2D.Double v1 = new Point2D.Double(5, 3);
		Point2D.Double v2 = new Point2D.Double(-2, -10);
		Point2D.Double v3 = new Point2D.Double(2, 0);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_10_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-4, 1);
		Point2D.Double v1 = new Point2D.Double(-1, 5);
		Point2D.Double v2 = new Point2D.Double(-2, 4);
		Point2D.Double v3 = new Point2D.Double(2, 8);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_11_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(-3, -5);
		Point2D.Double v1 = new Point2D.Double(0.5, -1.5);
		Point2D.Double v2 = new Point2D.Double(3, 0.25);
		Point2D.Double v3 = new Point2D.Double(6, 4.5);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_12_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(3, 0);
		Point2D.Double v2 = new Point2D.Double(6, 0);
		Point2D.Double v3 = new Point2D.Double(9, 0);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_13_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(0, 6);
		Point2D.Double v3 = new Point2D.Double(0, 12);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_14_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 2);
		Point2D.Double v1 = new Point2D.Double(2, 2);
		Point2D.Double v2 = new Point2D.Double(0, 2);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_15_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(2, 2);
		Point2D.Double v2 = new Point2D.Double(2, 0);
		Point2D.Double v3 = new Point2D.Double(4, 2);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_16_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0.5, 3);
		Point2D.Double v1 = new Point2D.Double(4, 4);
		Point2D.Double v2 = new Point2D.Double(4.5, 3.5);
		Point2D.Double v3 = new Point2D.Double(7, 1.5);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_17_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 4);
		Point2D.Double v1 = new Point2D.Double(4, 4);
		Point2D.Double v2 = new Point2D.Double(2, 2);
		Point2D.Double v3 = new Point2D.Double(7, -4.5);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_18_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(4, 4);
		Point2D.Double v2 = new Point2D.Double(6, 6);
		Point2D.Double v3 = new Point2D.Double(10, 10);
		assertTrue(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}
	
	@Test
	public void test_19_disjointSegments() {
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(-4, 3);
		Point2D.Double v2 = new Point2D.Double(0, 0);
		Point2D.Double v3 = new Point2D.Double(-2, 10);
		assertFalse(SimplePolygon.disjointSegments(v0, v1, v2, v3));
	}

	@Test
	public void test_01_disjointEdges() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(1, 4);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double v4 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < vs.length; i++) {
			p.addVertex(vs[i]);
		}
		assertFalse(p.disjointEdges(0, 1));
		assertTrue(p.disjointEdges(0, 2));
		assertTrue(p.disjointEdges(0, 3));
		assertFalse(p.disjointEdges(0, 4));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_02_disjointEdges() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(1, 4);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double v4 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < vs.length; i++) {
			p.addVertex(vs[i]);
		}
		p.disjointEdges(-1, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_03_disjointEdges() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(1, 4);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double v4 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < vs.length; i++) {
			p.addVertex(vs[i]);
		}
		p.disjointEdges(5, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_04_disjointEdges() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(1, 4);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double v4 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < vs.length; i++) {
			p.addVertex(vs[i]);
		}
		p.disjointEdges(0, -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_05_disjointEdges() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(1, 4);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double v4 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < vs.length; i++) {
			p.addVertex(vs[i]);
		}
		p.disjointEdges(0, 5);
	}

	@Test()
	public void test_01_isSimple() {
		int size = 3;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(7, 0);
		Point2D.Double[] vs = { v0, v1, v2 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_02_isSimple() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_03_isSimple() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(2.5, 7.5);
		Point2D.Double v3 = new Point2D.Double(5, 5);
		Point2D.Double v4 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_04_isSimple() {
		int size = 6;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(-2, 0);
		Point2D.Double v1 = new Point2D.Double(2, 0);
		Point2D.Double v2 = new Point2D.Double(4, 2);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double v4 = new Point2D.Double(-2, 4);
		Point2D.Double v5 = new Point2D.Double(-4, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_05_isSimple() {
		int size = 8;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(-2, 0);
		Point2D.Double v1 = new Point2D.Double(0, -2);
		Point2D.Double v2 = new Point2D.Double(2, 0);
		Point2D.Double v3 = new Point2D.Double(4, 2);
		Point2D.Double v4 = new Point2D.Double(2, 4);
		Point2D.Double v5 = new Point2D.Double(0, 6);
		Point2D.Double v6 = new Point2D.Double(-2, 4);
		Point2D.Double v7 = new Point2D.Double(-4, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_06_isSimple() {
		int size = 8;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(2, 2);
		Point2D.Double v2 = new Point2D.Double(0, 2);
		Point2D.Double v3 = new Point2D.Double(2, 0);
		Point2D.Double v4 = new Point2D.Double(0, 0);
		Point2D.Double v5 = new Point2D.Double(2, 2);
		Point2D.Double v6 = new Point2D.Double(0, 0);
		Point2D.Double v7 = new Point2D.Double(2, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	@Test()
	public void test_07_isSimple() {
		int size = 6;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(1, 0);
		Point2D.Double v1 = new Point2D.Double(4, 2);
		Point2D.Double v2 = new Point2D.Double(3.75, 0);
		Point2D.Double v3 = new Point2D.Double(2.75, 3);
		Point2D.Double v4 = new Point2D.Double(4, 4.75);
		Point2D.Double v5 = new Point2D.Double(1.5, -2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	@Test()
	public void test_08_isSimple() {
		int size = 6;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(2, 0.25);
		Point2D.Double v1 = new Point2D.Double(2, 3.45);
		Point2D.Double v2 = new Point2D.Double(3.75, 5);
		Point2D.Double v3 = new Point2D.Double(2.36, 5);
		Point2D.Double v4 = new Point2D.Double(4.33, 3.65);
		Point2D.Double v5 = new Point2D.Double(4.33, 0.56);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	@Test()
	public void test_09_isSimple() {
		int size = 10;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(-2, 0);
		Point2D.Double v1 = new Point2D.Double(2, 0);
		Point2D.Double v2 = new Point2D.Double(4, 2);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double v4 = new Point2D.Double(-2, 4);
		Point2D.Double v5 = new Point2D.Double(-4, 2);
		Point2D.Double v6 = new Point2D.Double(-2, 0);
		Point2D.Double v7 = new Point2D.Double(2, 4);
		Point2D.Double v8 = new Point2D.Double(-2, 4);
		Point2D.Double v9 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	@Test()
	public void test_10_isSimple() {
		int size = 7;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(1, 3);
		Point2D.Double v1 = new Point2D.Double(9, 5.43);
		Point2D.Double v2 = new Point2D.Double(6, 7.2);
		Point2D.Double v3 = new Point2D.Double(6.13, 2.67);
		Point2D.Double v4 = new Point2D.Double(2, 6);
		Point2D.Double v5 = new Point2D.Double(1.88, 0.79);
		Point2D.Double v6 = new Point2D.Double(0.92, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	@Test()
	public void test_11_isSimple() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(2, 0);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	// Polygon 1 - isSimple
	@Test()
	public void test_12_isSimple() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(8.9, 21.8);
		Point2D.Double v1 = new Point2D.Double(29.1, 8.8);
		Point2D.Double v2 = new Point2D.Double(39.2, 20.3);
		Point2D.Double v3 = new Point2D.Double(14, 11);
		Point2D.Double v4 = new Point2D.Double(28, 25);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	// Polygon 2 - isSimple
	@Test()
	public void test_13_isSimple() {
		int size = 7;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(28, 2);
		Point2D.Double v1 = new Point2D.Double(31, 5);
		Point2D.Double v2 = new Point2D.Double(28, 10);
		Point2D.Double v3 = new Point2D.Double(14, 14);
		Point2D.Double v4 = new Point2D.Double(5, 10);
		Point2D.Double v5 = new Point2D.Double(8, 4);
		Point2D.Double v6 = new Point2D.Double(18, 1);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	// Polygon 3 - isSimple
	@Test()
	public void test_14_isSimple() {
		int size = 9;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 10);
		Point2D.Double v1 = new Point2D.Double(20, 3);
		Point2D.Double v2 = new Point2D.Double(23, 3);
		Point2D.Double v3 = new Point2D.Double(23, 8);
		Point2D.Double v4 = new Point2D.Double(27, 3);
		Point2D.Double v5 = new Point2D.Double(30, 3);
		Point2D.Double v6 = new Point2D.Double(20, 15);
		Point2D.Double v7 = new Point2D.Double(16, 5);
		Point2D.Double v8 = new Point2D.Double(20, 14);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	// Polygon 4 - isSimple
	@Test()
	public void test_15_isSimple() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(16, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	// Polygon 5 - isSimple
	@Test()
	public void test_16_isSimple() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(18, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	// Polygon 6 - isSimple
	@Test()
	public void test_17_isSimple() {
		int size = 22;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(14, 7);
		Point2D.Double v1 = new Point2D.Double(15, 8);
		Point2D.Double v2 = new Point2D.Double(17, 7);
		Point2D.Double v3 = new Point2D.Double(17, 5);
		Point2D.Double v4 = new Point2D.Double(15, 6);
		Point2D.Double v5 = new Point2D.Double(14, 4);
		Point2D.Double v6 = new Point2D.Double(12, 6);
		Point2D.Double v7 = new Point2D.Double(11, 9);
		Point2D.Double v8 = new Point2D.Double(15, 11);
		Point2D.Double v9 = new Point2D.Double(7, 12);
		Point2D.Double v10 = new Point2D.Double(8, 11);
		Point2D.Double v11 = new Point2D.Double(7, 9);
		Point2D.Double v12 = new Point2D.Double(10, 11);
		Point2D.Double v13 = new Point2D.Double(8, 6);
		Point2D.Double v14 = new Point2D.Double(10, 5);
		Point2D.Double v15 = new Point2D.Double(11, 3);
		Point2D.Double v16 = new Point2D.Double(16, 3);
		Point2D.Double v17 = new Point2D.Double(18, 4);
		Point2D.Double v18 = new Point2D.Double(19, 8);
		Point2D.Double v19 = new Point2D.Double(16, 9);
		Point2D.Double v20 = new Point2D.Double(14, 9);
		Point2D.Double v21 = new Point2D.Double(13, 8);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	// Polygon 7 - isSimple
	@Test()
	public void test_18_isSimple() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 1);
		Point2D.Double v1 = new Point2D.Double(9, 5);
		Point2D.Double v2 = new Point2D.Double(5, 8);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}

	@Test()
	public void test_19_isSimple() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(2, 2);
		Point2D.Double v3 = new Point2D.Double(2, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), true);
	}
	
	@Test()
	public void test_20_isSimple() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 2);
		Point2D.Double v2 = new Point2D.Double(2, 0);
		Point2D.Double v3 = new Point2D.Double(2, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isSimple(), false);
	}

	// Polygon 1 - perimeter
	@Test()
	public void test_01_perimeter() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(8.9, 21.8);
		Point2D.Double v1 = new Point2D.Double(29.1, 8.8);
		Point2D.Double v2 = new Point2D.Double(39.2, 20.3);
		Point2D.Double v3 = new Point2D.Double(14, 11);
		Point2D.Double v4 = new Point2D.Double(28, 25);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertTrue(d == 105.35);
	}

	// Polygon 2 - perimeter
	@Test()
	public void test_02_perimeter() {
		int size = 7;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(28, 2);
		Point2D.Double v1 = new Point2D.Double(31, 5);
		Point2D.Double v2 = new Point2D.Double(28, 10);
		Point2D.Double v3 = new Point2D.Double(14, 14);
		Point2D.Double v4 = new Point2D.Double(5, 10);
		Point2D.Double v5 = new Point2D.Double(8, 4);
		Point2D.Double v6 = new Point2D.Double(18, 1);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertTrue(d == 61.68);
	}

	// Polygon 3 - perimeter
	@Test()
	public void test_03_perimeter() {
		int size = 9;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 10);
		Point2D.Double v1 = new Point2D.Double(20, 3);
		Point2D.Double v2 = new Point2D.Double(23, 3);
		Point2D.Double v3 = new Point2D.Double(23, 8);
		Point2D.Double v4 = new Point2D.Double(27, 3);
		Point2D.Double v5 = new Point2D.Double(30, 3);
		Point2D.Double v6 = new Point2D.Double(20, 15);
		Point2D.Double v7 = new Point2D.Double(16, 5);
		Point2D.Double v8 = new Point2D.Double(20, 14);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertTrue(d == 83.86);
	}

	// Polygon 4 - perimeter
	@Test()
	public void test_04_perimeter() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(16, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertEquals(d, 95.68, 0.0);
	}

	// Polygon 5 - perimeter
	@Test()
	public void test_05_perimeter() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(18, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertEquals(d, 95.11, 0.0);
	}

	// Polygon 6 - perimeter
	@Test()
	public void test_06_perimeter() {
		int size = 22;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(14, 7);
		Point2D.Double v1 = new Point2D.Double(15, 8);
		Point2D.Double v2 = new Point2D.Double(17, 7);
		Point2D.Double v3 = new Point2D.Double(17, 5);
		Point2D.Double v4 = new Point2D.Double(15, 6);
		Point2D.Double v5 = new Point2D.Double(14, 4);
		Point2D.Double v6 = new Point2D.Double(12, 6);
		Point2D.Double v7 = new Point2D.Double(11, 9);
		Point2D.Double v8 = new Point2D.Double(15, 11);
		Point2D.Double v9 = new Point2D.Double(7, 12);
		Point2D.Double v10 = new Point2D.Double(8, 11);
		Point2D.Double v11 = new Point2D.Double(7, 9);
		Point2D.Double v12 = new Point2D.Double(10, 11);
		Point2D.Double v13 = new Point2D.Double(8, 6);
		Point2D.Double v14 = new Point2D.Double(10, 5);
		Point2D.Double v15 = new Point2D.Double(11, 3);
		Point2D.Double v16 = new Point2D.Double(16, 3);
		Point2D.Double v17 = new Point2D.Double(18, 4);
		Point2D.Double v18 = new Point2D.Double(19, 8);
		Point2D.Double v19 = new Point2D.Double(16, 9);
		Point2D.Double v20 = new Point2D.Double(14, 9);
		Point2D.Double v21 = new Point2D.Double(13, 8);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertEquals(d, 65.11, 0.0);
	}

	// Polygon 7 - perimeter
	@Test()
	public void test_07_perimeter() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 1);
		Point2D.Double v1 = new Point2D.Double(9, 5);
		Point2D.Double v2 = new Point2D.Double(5, 8);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		double d = p.perimeter();
		String val = String.format("%1.2f", d);
		d = Double.valueOf(val);
		assertEquals(d, 20, 0.0);
	}

	// Polygon 1 - area
	@Test()
	public void test_01_area() {
		int size = 5;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(8.9, 21.8);
		Point2D.Double v1 = new Point2D.Double(29.1, 8.8);
		Point2D.Double v2 = new Point2D.Double(39.2, 20.3);
		Point2D.Double v3 = new Point2D.Double(14, 11);
		Point2D.Double v4 = new Point2D.Double(28, 25);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 133.31, 0.2);
		} catch (Exception e) {

		}
	}

	// Polygon 2 - area
	@Test()
	public void test_02_area() {
		int size = 7;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(28, 2);
		Point2D.Double v1 = new Point2D.Double(31, 5);
		Point2D.Double v2 = new Point2D.Double(28, 10);
		Point2D.Double v3 = new Point2D.Double(14, 14);
		Point2D.Double v4 = new Point2D.Double(5, 10);
		Point2D.Double v5 = new Point2D.Double(8, 4);
		Point2D.Double v6 = new Point2D.Double(18, 1);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 227.0, 0.0);
		} catch (NonSimplePolygonException e) {
			e.printStackTrace();
		}
	}

	// Polygon 3 - area
	@Test()
	public void test_03_area() {
		int size = 9;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 10);
		Point2D.Double v1 = new Point2D.Double(20, 3);
		Point2D.Double v2 = new Point2D.Double(23, 3);
		Point2D.Double v3 = new Point2D.Double(23, 8);
		Point2D.Double v4 = new Point2D.Double(27, 3);
		Point2D.Double v5 = new Point2D.Double(30, 3);
		Point2D.Double v6 = new Point2D.Double(20, 15);
		Point2D.Double v7 = new Point2D.Double(16, 5);
		Point2D.Double v8 = new Point2D.Double(20, 14);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 129.0, 0.0);
		} catch (NonSimplePolygonException e) {

		}
	}

	// Polygon 4 - area
	@Test()
	public void test_04_area() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(16, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 75.0, 0.0);
		} catch (NonSimplePolygonException e) {

		}
	}

	// Polygon 5 - area
	@Test()
	public void test_05_area() {
		int size = 13;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(18, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 82.0, 0.0);
		} catch (NonSimplePolygonException e) {
			e.printStackTrace();
		}
	}

	// Polygon 6 - area
	@Test()
	public void test_06_area() {
		int size = 22;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(14, 7);
		Point2D.Double v1 = new Point2D.Double(15, 8);
		Point2D.Double v2 = new Point2D.Double(17, 7);
		Point2D.Double v3 = new Point2D.Double(17, 5);
		Point2D.Double v4 = new Point2D.Double(15, 6);
		Point2D.Double v5 = new Point2D.Double(14, 4);
		Point2D.Double v6 = new Point2D.Double(12, 6);
		Point2D.Double v7 = new Point2D.Double(11, 9);
		Point2D.Double v8 = new Point2D.Double(15, 11);
		Point2D.Double v9 = new Point2D.Double(7, 12);
		Point2D.Double v10 = new Point2D.Double(8, 11);
		Point2D.Double v11 = new Point2D.Double(7, 9);
		Point2D.Double v12 = new Point2D.Double(10, 11);
		Point2D.Double v13 = new Point2D.Double(8, 6);
		Point2D.Double v14 = new Point2D.Double(10, 5);
		Point2D.Double v15 = new Point2D.Double(11, 3);
		Point2D.Double v16 = new Point2D.Double(16, 3);
		Point2D.Double v17 = new Point2D.Double(18, 4);
		Point2D.Double v18 = new Point2D.Double(19, 8);
		Point2D.Double v19 = new Point2D.Double(16, 9);
		Point2D.Double v20 = new Point2D.Double(14, 9);
		Point2D.Double v21 = new Point2D.Double(13, 8);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 50.0, 0.0);
		} catch (NonSimplePolygonException e) {
			e.printStackTrace();
		}
	}

	// Polygon 7 - area
	@Test()
	public void test_07_area() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 1);
		Point2D.Double v1 = new Point2D.Double(9, 5);
		Point2D.Double v2 = new Point2D.Double(5, 8);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		try {
			assertEquals(p.area(), 25.0, 0.0);
		} catch (NonSimplePolygonException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void test_01_lowestPointHelper() {
		int size = 3;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 1);
		Point2D.Double v1 = new Point2D.Double(9, 5);
		Point2D.Double v2 = new Point2D.Double(5, 8);
		Point2D.Double[] vs = { v0, v1, v2 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertTrue(p.lowestPointHelper().getX() == v0.getX());
		assertTrue(p.lowestPointHelper().getY() == v0.getY());
	}

	@Test()
	public void test_02_lowestPointHelper() {
		int size = 8;
		ConvexPolygon p = new ConvexPolygon(size);		
		Point2D.Double v0 = new Point2D.Double(-2, 0);
		Point2D.Double v1 = new Point2D.Double(0, -2);
		Point2D.Double v2 = new Point2D.Double(2, 0);
		Point2D.Double v3 = new Point2D.Double(4, 2);
		Point2D.Double v4 = new Point2D.Double(2, 4);
		Point2D.Double v5 = new Point2D.Double(0, 6);
		Point2D.Double v6 = new Point2D.Double(-2, 4);
		Point2D.Double v7 = new Point2D.Double(-4, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertTrue(p.lowestPointHelper().getX() == v1.getX());
		assertTrue(p.lowestPointHelper().getY() == v1.getY());
	}

	@Test()
	public void test_03_lowestPointHelper() {
		int size = 7;
		ConvexPolygon p = new ConvexPolygon(size);		
		Point2D.Double v0 = new Point2D.Double(1, 3);
		Point2D.Double v1 = new Point2D.Double(9, 5.43);
		Point2D.Double v2 = new Point2D.Double(6, 7.2);
		Point2D.Double v3 = new Point2D.Double(6.13, 2.67);
		Point2D.Double v4 = new Point2D.Double(2, 6);
		Point2D.Double v5 = new Point2D.Double(1.88, 0.79);
		Point2D.Double v6 = new Point2D.Double(0.92, 2);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertTrue(p.lowestPointHelper().getX() == v5.getX());
		assertTrue(p.lowestPointHelper().getY() == v5.getY());
	}

	@Test()
	public void test_04_lowestPointHelper() {
		int size = 22;
		ConvexPolygon p = new ConvexPolygon(size);		
		Point2D.Double v0 = new Point2D.Double(14, 7);
		Point2D.Double v1 = new Point2D.Double(15, 8);
		Point2D.Double v2 = new Point2D.Double(17, 7);
		Point2D.Double v3 = new Point2D.Double(17, 5);
		Point2D.Double v4 = new Point2D.Double(15, 6);
		Point2D.Double v5 = new Point2D.Double(14, 4);
		Point2D.Double v6 = new Point2D.Double(12, 6);
		Point2D.Double v7 = new Point2D.Double(11, 9);
		Point2D.Double v8 = new Point2D.Double(15, 11);
		Point2D.Double v9 = new Point2D.Double(7, 12);
		Point2D.Double v10 = new Point2D.Double(8, 11);
		Point2D.Double v11 = new Point2D.Double(7, 9);
		Point2D.Double v12 = new Point2D.Double(10, 11);
		Point2D.Double v13 = new Point2D.Double(8, 6);
		Point2D.Double v14 = new Point2D.Double(10, 5);
		Point2D.Double v15 = new Point2D.Double(11, 3);
		Point2D.Double v16 = new Point2D.Double(16, 3);
		Point2D.Double v17 = new Point2D.Double(18, 4);
		Point2D.Double v18 = new Point2D.Double(19, 8);
		Point2D.Double v19 = new Point2D.Double(16, 9);
		Point2D.Double v20 = new Point2D.Double(14, 9);
		Point2D.Double v21 = new Point2D.Double(13, 8);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertTrue(p.lowestPointHelper().getX() == v15.getX());
		assertTrue(p.lowestPointHelper().getY() == v15.getY());		
	}

	@Test()
	public void test_05_lowestPointHelper() {
		int size = 13;
		ConvexPolygon p = new ConvexPolygon(size);		
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(16, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertTrue(p.lowestPointHelper().getX() == v1.getX());
		assertTrue(p.lowestPointHelper().getY() == v1.getY());
	}

	// Polygon 1 - isConvex
	@Test()
	public void test_01_isConvex() {
		int size = 5;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(8.9, 21.8);
		Point2D.Double v1 = new Point2D.Double(29.1, 8.8);
		Point2D.Double v2 = new Point2D.Double(39.2, 20.3);
		Point2D.Double v3 = new Point2D.Double(14, 11);
		Point2D.Double v4 = new Point2D.Double(28, 25);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	// Polygon 2 - isConvex
	@Test()
	public void test_02_isConvex() {
		int size = 7;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(28, 2);
		Point2D.Double v1 = new Point2D.Double(31, 5);
		Point2D.Double v2 = new Point2D.Double(28, 10);
		Point2D.Double v3 = new Point2D.Double(14, 14);
		Point2D.Double v4 = new Point2D.Double(5, 10);
		Point2D.Double v5 = new Point2D.Double(8, 4);
		Point2D.Double v6 = new Point2D.Double(18, 1);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), true);
	}

	// Polygon 3 - isConvex
	@Test()
	public void test_03_isConvex() {
		int size = 9;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 10);
		Point2D.Double v1 = new Point2D.Double(20, 3);
		Point2D.Double v2 = new Point2D.Double(23, 3);
		Point2D.Double v3 = new Point2D.Double(23, 8);
		Point2D.Double v4 = new Point2D.Double(27, 3);
		Point2D.Double v5 = new Point2D.Double(30, 3);
		Point2D.Double v6 = new Point2D.Double(20, 15);
		Point2D.Double v7 = new Point2D.Double(16, 5);
		Point2D.Double v8 = new Point2D.Double(20, 14);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	// Polygon 4 - isConvex
	@Test()
	public void test_04_isConvex() {
		int size = 13;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(16, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	// Polygon 5 - isConvex
	@Test()
	public void test_05_isConvex() {
		int size = 13;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(5, 6);
		Point2D.Double v1 = new Point2D.Double(13, 2);
		Point2D.Double v2 = new Point2D.Double(12, 6);
		Point2D.Double v3 = new Point2D.Double(20, 2);
		Point2D.Double v4 = new Point2D.Double(18, 12);
		Point2D.Double v5 = new Point2D.Double(17, 11);
		Point2D.Double v6 = new Point2D.Double(19, 5);
		Point2D.Double v7 = new Point2D.Double(13, 11);
		Point2D.Double v8 = new Point2D.Double(19, 15);
		Point2D.Double v9 = new Point2D.Double(8, 12);
		Point2D.Double v10 = new Point2D.Double(14, 7);
		Point2D.Double v11 = new Point2D.Double(5, 11);
		Point2D.Double v12 = new Point2D.Double(9, 6);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	// Polygon 6 - isConvex
	@Test()
	public void test_06_isConvex() {
		int size = 22;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(14, 7);
		Point2D.Double v1 = new Point2D.Double(15, 8);
		Point2D.Double v2 = new Point2D.Double(17, 7);
		Point2D.Double v3 = new Point2D.Double(17, 5);
		Point2D.Double v4 = new Point2D.Double(15, 6);
		Point2D.Double v5 = new Point2D.Double(14, 4);
		Point2D.Double v6 = new Point2D.Double(12, 6);
		Point2D.Double v7 = new Point2D.Double(11, 9);
		Point2D.Double v8 = new Point2D.Double(15, 11);
		Point2D.Double v9 = new Point2D.Double(7, 12);
		Point2D.Double v10 = new Point2D.Double(8, 11);
		Point2D.Double v11 = new Point2D.Double(7, 9);
		Point2D.Double v12 = new Point2D.Double(10, 11);
		Point2D.Double v13 = new Point2D.Double(8, 6);
		Point2D.Double v14 = new Point2D.Double(10, 5);
		Point2D.Double v15 = new Point2D.Double(11, 3);
		Point2D.Double v16 = new Point2D.Double(16, 3);
		Point2D.Double v17 = new Point2D.Double(18, 4);
		Point2D.Double v18 = new Point2D.Double(19, 8);
		Point2D.Double v19 = new Point2D.Double(16, 9);
		Point2D.Double v20 = new Point2D.Double(14, 9);
		Point2D.Double v21 = new Point2D.Double(13, 8);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	// Polygon 7 - isConvex
	@Test()
	public void test_07_isConvex() {
		int size = 4;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(6, 1);
		Point2D.Double v1 = new Point2D.Double(9, 5);
		Point2D.Double v2 = new Point2D.Double(5, 8);
		Point2D.Double v3 = new Point2D.Double(2, 4);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), true);
	}

	@Test()
	public void test_08_isConvex() {
		int size = 4;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), true);
	}

	@Test()
	public void test_09_isConvex() {
		int size = 5;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(2, 4);
		Point2D.Double v3 = new Point2D.Double(5, 5);
		Point2D.Double v4 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	@Test()
	public void test_10_isConvex() {
		int size = 6;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(2, 7);
		Point2D.Double v3 = new Point2D.Double(5, 5);
		Point2D.Double v4 = new Point2D.Double(5, 0);
		Point2D.Double v5 = new Point2D.Double(2, 3);
		Point2D.Double[] vs = { v0, v1, v2, v3, v4, v5 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}

	@Test()
	public void test_11_isConvex() {
		int size = 4;
		ConvexPolygon p = new ConvexPolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 0);
		Point2D.Double v3 = new Point2D.Double(5, 5);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		assertEquals(p.isConvex(), false);
	}
	
	@Test()
	public void test_01_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(2.5, 2.5);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_02_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(7, 7);
		assertEquals(p.simpleContains(q), false);
	}
	
	@Test()
	public void test_03_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(0, 0);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_04_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(8, 10);
		assertEquals(p.simpleContains(q), false);
	}
	
	@Test()
	public void test_05_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(4, -1);
		assertEquals(p.simpleContains(q), false);
	}
	
	@Test()
	public void test_06_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(1, 2);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_07_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(4, 3);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_08_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(3, 5);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_09_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(5, 1);
		assertEquals(p.simpleContains(q), true);
	}
	
	@Test()
	public void test_10_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(0, -1);
		assertEquals(p.simpleContains(q), false);
	}
	
	@Test()
	public void test_11_simpleContains() {
		int size = 4;
		SimplePolygon p = new SimplePolygon(size);
		Point2D.Double v0 = new Point2D.Double(0, 0);
		Point2D.Double v1 = new Point2D.Double(0, 5);
		Point2D.Double v2 = new Point2D.Double(5, 5);
		Point2D.Double v3 = new Point2D.Double(5, 0);
		Point2D.Double[] vs = { v0, v1, v2, v3 };
		for (int i = 0; i < size; i++) {
			p.addVertex(vs[i]);
		}
		Point2D.Double q = new Point2D.Double(5, 6);
		assertEquals(p.simpleContains(q), false);
	}

}
