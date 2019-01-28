/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 **********************************************************/

import java.awt.geom.Point2D;
import java.util.Scanner;

public class ConvexPolygon extends SimplePolygon {

	/**
	 * The class ConvexPolygon extends SimplePolygon.
	 * 
	 * @author Andy Mirzaian
	 */

	protected ConvexPolygon() {
		super();
	}

	protected ConvexPolygon(int size) {
		super(size);
	}

	public static ConvexPolygon getNewPoly() {
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
	 * Helper method to identify the lowest point in a context object polygon, p.
	 * 
	 * @pre polygon p must be Simple
	 * 
	 */
	protected Point2D.Double lowestPointHelper() {
		Point2D.Double lowest = null;
		double smallestY = this.vertices[0].y;
		int loopCounter = 0;
		for (int i = 1; i < this.n; i++) {
			if (smallestY > this.vertices[i].y) {
				smallestY = this.vertices[i].y;
				lowest = this.vertices[i];
				loopCounter++;
			}
		}
		if (loopCounter == 0) {
			lowest = this.vertices[0];
		}
		return lowest;
	}

	/**
	 * @return returns true iff all vertices of the polygon are traversed with delta
	 *         and deltav helper, and all return values of deltav are the same (i.e.
	 *         all have the same orientation).
	 */
	public boolean isConvex() {
		boolean isConvex = true;
		int prevResult = 0;
		int result = 0;
		for (int i = 0; i < this.n && isConvex; i++) {
			if (i == 0) {
				result = deltav(delta(vertices[i], vertices[(i + 1) % n], vertices[(i + 2) % n]));
				prevResult = result;
			} else {
				result = deltav(delta(vertices[i], vertices[(i + 1) % n], vertices[(i + 2) % n]));
				if (result != prevResult) {
					return false;
				} else {
					isConvex = true;
				}
			}
		}
		return isConvex;
	}
}
