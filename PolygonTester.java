/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 **********************************************************/

import java.util.Scanner;

public class PolygonTester {

	/**
	 * PolygonTester should enable a thorough testing of the polygon hierarchy.
	 * 
	 * It should provide an easy to read input-output recording of the test cases.
	 * 
	 * The student should also submit these recorded test results in TestIO.txt file
	 * as part of Assignment1.
	 * 
	 * @author Andy Mirzaian
	 */

	/**
	 * Main method tester.
	 * 
	 * To successfully run this main method, leave the tester you would like to
	 * utilize unchanged and comment out the other tester.
	 */
	public static void main(String[] args) {

		System.out.println("For Polygon Builder: Enter 1\n" + "For Simple Polygon Builder: Enter 2");

		Scanner sc = new Scanner(System.in);
		int response = sc.nextInt();
		if (response == 1) {
			PolyTester();
		} else if (response == 2) {
			SimplePolyTester();
		} else {
			System.out.print("Invalid response given. Run again.");
		}

	}

	/**
	 * PolyTester for main method.
	 * 
	 * To build and test simple, non-simple polygons, AND CONVEX POLYGONS, call this
	 * method in the tester main method.
	 */
	private static void PolyTester() {
		boolean hasNewPolyToEnter = true;
		while (hasNewPolyToEnter) {
			ConvexPolygon p = ConvexPolygon.getNewPoly();

			System.out.println();
			System.out.println(
					"================================================================================================================================================================");
			System.out.println("Polygon: " + p.toString());
			System.out.println();
			System.out.println("Is simple: " + p.isSimple());
			System.out.println("Perimeter: " + p.perimeter());
			try {
				System.out.println("Area: " + p.area());
			} catch (NonSimplePolygonException e) {
				System.out.println("Area: Cannot use this method to calculate " + "the area of non-simple polygons.");
			}

			System.out.println("Is convex: " + p.isConvex());

			System.out.println();
			System.out.println("Would you like to create another polygon? (Y/N)");
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
			if (response.toUpperCase().equals("N")) {
				hasNewPolyToEnter = false;
			} else {
				hasNewPolyToEnter = true;
			}
		}
	}

	/**
	 * SimplePolyTester for main method.
	 * 
	 * To build and test simple and non-simple polygons, call this method in the
	 * tester main method.
	 * 
	 * THIS METHOD IS NOT INTENDED FOR USE OFCHECKING FOR CONVEX PROPERTY OF
	 * USER-BUILT POLYGONs.
	 */
	private static void SimplePolyTester() {
		boolean hasNewPolyToEnter = true;
		while (hasNewPolyToEnter) {
			SimplePolygon p = SimplePolygon.getNewPoly();

			System.out.println();
			System.out.println(
					"================================================================================================================================================================");
			System.out.println("Polygon: " + p.toString());
			System.out.println();
			System.out.println("Is simple: " + p.isSimple());
			System.out.println("Perimeter: " + p.perimeter());
			try {
				System.out.println("Area: " + p.area());
			} catch (NonSimplePolygonException e) {
				System.out.println("Area: Cannot use this method to calculate " + "the area of non-simple polygons.");
			}

			System.out.println();
			System.out.println("Would you like to create another polygon? (Y/N)");
			Scanner sc = new Scanner(System.in);
			String response = sc.nextLine();
			if (response.toUpperCase().equals("N")) {
				hasNewPolyToEnter = false;
			} else {
				hasNewPolyToEnter = true;
			}
		}
	}
}