/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 **********************************************************/

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Scanner;

public class SimplePolygon implements Polygon {

	/********* protected fields ************************/

	protected int n; // number of vertices of the polygon
	protected Point2D.Double[] vertices; // vertices[0..n-1] around the polygon boundary
	protected int vcounter;

	/********* protected constructors ******************/

	/**
	 * constructor used in the static factory method getNewPoly()
	 * 
	 * @param size number of edges (also vertices) of the polygon
	 */
	protected SimplePolygon(int size) {
		this.n = size;
		this.vertices = new Point2D.Double[size];
		this.vcounter = 0;
	}

	/** default no-parameter constructor */
	protected SimplePolygon() {
		this.n = 3;
		this.vertices = new Point2D.Double[3];
		this.vcounter = 0;
	}

	/********* public getters & toString ***************/

	/**
	 * static factory method constructs and returns an unverified simple-polygon,
	 * initialized according to user provided input data. Runs in O(n) time.
	 * 
	 * @return an unverified simple-polygon instance
	 */
	public static SimplePolygon getNewPoly() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("How many sides in the polygon?");
		int size = sc.nextInt();
		while (size <= 2) {
			System.out.println("Your polygon must have at least 3 vertices. " + "Please try again.");
			System.out.println("How many sides in the polygon?");
			size = sc.nextInt();
		}
		ConvexPolygon p = new ConvexPolygon(size);
		double[] dx = new double[size];
		double[] dy = new double[size];
		int dxc = 0, dyc = 0;
		for (int i = 0; i < (2 * size); i++) {
			if (i % 2 == 0) {
				if (i == 0) {
					System.out.println(
							"Enter the vertex coordinates beginning with the x-coordinate for the first vertex: ");
					dx[dxc] = sc.nextDouble();
					dxc++;
				} else {
					System.out.println("Enter x-coordinate: ");
					dx[dxc] = sc.nextDouble();
					dxc++;
				}
			} else {
				System.out.println("Enter y-coordinate: ");
				dy[dyc] = sc.nextDouble();
				dyc++;
			}
		}
		for (int i = 0; i < size; i++) {
			p.vertices[i] = new Point2D.Double(dx[i], dy[i]);
			p.vcounter++;
		}
		return p;
	}

	/**
	 * 
	 * @return n, the number of edges (equivalently, vertices) of the polygon.
	 */
	public int getSize() {
		return this.n;
	}

	/**
	 * 
	 * @param i index of the vertex.
	 * @return the i-th vertex of the polygon.
	 * @throws IndexOutOfBoundsException if {@code i < 0 || i >= n }.
	 */
	public Point2D.Double getVertex(int i) throws IndexOutOfBoundsException {
		try {
			return vertices[i];
		} catch (Exception e) {
			if (i < 0) {
				throw new IndexOutOfBoundsException("Index cannot be less than 0.");
			} else if (i > this.n) {
				throw new IndexOutOfBoundsException("Index cannot be greater " + this.n + ".");
			}
		}
		return null;
	}

	/**
	 * @return a String representation of the polygon in O(n) time.
	 */
	@Override
	public String toString() {
		String co = "";
		for (int i = 0; i < this.n; i++) {
			co += "(" + this.vertices[i].x + ", " + this.vertices[i].y + ") ";
		}
		return this.n + " " + co;
	}

	/**
	 * @param p, Point2D.Double instance to be added to this instance's array of
	 *        vertices Method use is strictly for JUnit Test case purposes.
	 */
	protected void addVertex(Point2D.Double p) {
		this.vertices[this.vcounter] = p;
		this.vcounter++;
	}

	/**
	 * Custom equals method for equality by attributes for polygons. This method
	 * only verifies that two vertices are equal if they have the same x- and
	 * y-coordinates.
	 * 
	 * This method is strictly for JUnit test case purposes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimplePolygon other = (SimplePolygon) obj;
		if (n != other.n)
			return false;
		if (vcounter != other.vcounter)
			return false;
		if (!Arrays.equals(vertices, other.vertices))
			return false;
		return true;
	}

	/************** utilities *********************/

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c three input points.
	 * @return twice the signed area of the oriented triangle (a,b,c). Runs in O(1)
	 *         time.
	 */
	public static double delta(Point2D.Double a, Point2D.Double b, Point2D.Double c) {

		/* 3x3 matrix determinant */

		double r1 = a.x * ((b.y) - (c.y));
		double r2 = -(b.x) * ((a.y) - (c.y));
		double r3 = c.x * ((a.y) - (b.y));

		return r1 + r2 + r3;
	}

	/**
	 * Helper method to determine orientation from delta
	 * 
	 * @param delta, from delta method
	 * @return 0 if result of delta is 0, 1 if result of delta is CCw (+ve), -1 if
	 *         result of delta is CW (-ve)
	 * 
	 */
	protected static int deltav(double delta) {
		if (delta == 0) {
			return 0;
		} else if (delta > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * @param a
	 * @param b end points of line-segment (a,b).
	 * @param c
	 * @param d end points of line-segment (c,d).
	 * @return true if closed line-segments (a,b) and (c,d) are disjoint. Runs in
	 *         O(1) time.
	 */
	public static boolean disjointSegments(Point2D.Double a, Point2D.Double b, Point2D.Double c, Point2D.Double d) {

		double abc = deltav(delta(a, b, c));
		double abd = deltav(delta(a, b, d));
		double cda = deltav(delta(c, d, a));
		double cdb = deltav(delta(c, d, b));

		if (abc != abd && cda != cdb) {
			return false;
		} else if ((abc == 0) && (abd == 0) && (cda == 0) && (cdb == 0)) {
			if ((a.x != c.x) && (a.x != d.x) && (b.x != c.x) && (b.x != d.x)) {
				return true;
			} else if ((a.y != c.y) && (a.y != d.y) && (b.y != c.y) && (b.y != d.y)) {
				return true;
			}
			return false;
		}
		return true;
	}

	/**
	 * @param i
	 * @param j indices of two edges of the polygon.
	 * @return true if the i-th and j-th edges of the polygon are disjoint. Runs in
	 *         O(1) time.
	 * @throws IndexOutOfBoundsException if i or j are outside the index range
	 *                                   [0..n-1].
	 */
	public boolean disjointEdges(int i, int j) throws IndexOutOfBoundsException {
		try {
			return disjointSegments(this.vertices[i], this.vertices[(i + 1) % this.n], this.vertices[j],
					this.vertices[(j + 1) % this.n]);

		} catch (Exception e) {
			if (i < 0) {
				throw new IndexOutOfBoundsException("Index i cannot be less than 0.");
			} else if (j < 0) {
				throw new IndexOutOfBoundsException("Index j cannot be less than 0.");
			} else if (i > this.n - 1) {
				throw new IndexOutOfBoundsException("Index i cannot be greater " + this.n + ".");
			} else if (j > this.n - 1) {
				throw new IndexOutOfBoundsException("Index j cannot be greater " + this.n + ".");
			}
		}
		return false;
	}

	/**
	 * This method verifies whether the claimed "simple-polygon" is indeed simple.
	 * 
	 * @return true if the polygon is simple. Runs in O(n^2) time.
	 */
	public boolean isSimple() {
		boolean isSimple = true;
		for (int i = 0; i < this.n && isSimple; i++) {
			for (int j = i + 2; j < this.n && isSimple; j++) {
				if (i == ((j + 1) % this.n)) {
					break;
				} else {
					isSimple = isSimple && this.disjointEdges(i, j);
				}
			}
		}
		return isSimple;
	}

	/************ perimeter & area ***************/

	/**
	 * 
	 * @return the sum of the edge lengths of the polygon. Runs in O(n) time.
	 */
	public double perimeter() {
		double perimeter = 0.0, x = 0.0, y = 0.0;
		for (int i = 0; i < this.vertices.length - 1; i++) {
			x = this.vertices[i + 1].x - this.vertices[i].x;
			y = vertices[i + 1].y - vertices[i].y;
			perimeter += Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}
		x = this.vertices[this.vertices.length - 1].x - this.vertices[0].x;
		y = this.vertices[this.vertices.length - 1].y - this.vertices[0].y;
		double pi = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		perimeter += pi;
		double roundedPerimeter = perimeter;
		String val = String.format("%1.2f", roundedPerimeter);
		roundedPerimeter = Double.valueOf(val);
		return roundedPerimeter;
	}

	/**
	 * 
	 * @return area of the polygon interior. Runs in O(n) time not counting the
	 *         simplicity test.
	 * @throws NonSimplePolygonException if the polygon is non-simple.
	 */
	public double area() throws NonSimplePolygonException {
		boolean isSimple = this.isSimple();
		if (!isSimple) {
			throw new NonSimplePolygonException("Cannot use this method to calculate the area of non-simple polygons.");
		} else {
			double area = 0.0;
			Point2D.Double o = new Point2D.Double(0, 0);
			for (int i = 0; i < this.n; i++) {
				area += delta(o, this.vertices[i], this.vertices[(i + 1) % this.n]);
			}
			area = (Math.abs(area)) / 2.0;
			double roundedArea = area;
			String val = String.format("%1.2f", roundedArea);
			roundedArea = Double.valueOf(val);
			return roundedArea;
		}
	}

	/**
	 * @param p subject point p, subject of check.
	 * @return true iff point p is within or on the boundary of a SimplePolygon.
	 * 
	 *         See PolyUnitTests.java for unit test cases for this method.
	 * 
	 *         Note: convexContains has not been implemented in ConvexPolygon class.
	 *         convexContains has not been attempted.
	 */
	public boolean simpleContains(Point2D.Double p) {
		boolean intersects = false;
		int intersectCounter = 0;
		Point2D.Double o = new Point2D.Double((Math.random() * 1000), Math.random() * 1000);
		for (int i = 0; i < this.n; i++) {
			intersects = SimplePolygon.disjointSegments(o, p, this.vertices[i % n], this.vertices[(i + 1) % n]);
			if (intersects) {
				intersectCounter++;
			}
		}
		boolean contains = false;
		if (intersectCounter % 2 == 0) {
			contains = false;
		} else {
			contains = true;
		}
		return contains;
	}
}
