/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 **********************************************************/

public class NonSimplePolygonException extends Exception {
	
	/**
	 * compiler generated serialVersionUID
	 */
	private static final long serialVersionUID = -6499398129928918406L;

	/** no-message constructor */
	public NonSimplePolygonException() {
	}

	/** detailed message constructor */
	public NonSimplePolygonException(String msg) {
		super(msg); }
}
