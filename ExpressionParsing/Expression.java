
/********************************************************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 2
 * Section: M
 * Student Name: Umar Abdulselam
 * Student EECS account: uaabduls
 * Student ID number: 215995616
 ********************************************************************************************/

import java.util.Stack;

public class Expression {

	Stack<String> expr; // holder of expressions
	Stack<Character> ops; // holder of operators

	/**
	 * Default constructor instantiates stack of Strings for expressions, and stack
	 * of Characters for operators.
	 */
	Expression() {
		expr = new Stack<String>();
		ops = new Stack<Character>();
	}

	/**
	 * Helper method builds expression using current top two elements of expression
	 * stack and current peek of operator stack in the form '( exp op exp )'.
	 * 
	 * @returns String representation of a String
	 */
	String FPIEExpressionBuilder() {
		StringBuilder sB = new StringBuilder();
		String secondExpr = expr.pop();
		String firstExpr = expr.pop();
		char op = ops.pop();
		sB.append("(" + firstExpr + op + secondExpr + ")");
		return sB.toString();
	}

	/**
	 * Helper method builds expression using current top two elements of expression
	 * stack and current peek of operator stack in the form 'exp exp op'.
	 * 
	 * @returns String representation of a String
	 */
	String UPPEExpressionBuilder() {
		StringBuilder sB = new StringBuilder();
		String secondExpr = expr.pop();
		String firstExpr = expr.pop();
		char op = ops.pop();
		sB.append(firstExpr + " " + secondExpr + " " + op);
		return sB.toString();
	}

	/**
	 * Helper method takes @param str and checks if it contains any blank spaces.
	 * 
	 * @returns true if no blank space is identified, returns false otherwise.
	 */
	boolean isBlank(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				return false;
		}
		return true;
	}

	/**
	 * Helper method takes @param c and checks if it is an arithmeic operator.
	 * 
	 * @returns true if @param c is an arithmetic operator, returns false otherwise.
	 */
	boolean isOp(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/') ? true : false;
	}

	/**
	 * Method takes @param RPIE, a Right Parenthesized Infix Expression,
	 * and @returns its Fully Parenthesized Infix Expression equivalent if it is a
	 * valid RPIE; returns an error message otherwise.
	 */
	String convertToFPIE(String RPIE) {
		StringBuilder sB = new StringBuilder(); // initialize StringBuilder()
		char iC = ' ';
		for (int i = 0; i < RPIE.length(); i++) { // iterate through every character in the expression
			iC = RPIE.charAt(i); // iC is the current character being read
			if (isOp(iC)) { // check if current character is an operator
				if (!(sB.toString().isEmpty()) && !(isBlank(sB.toString()))) { // if sB is not empty and is not blank,
																				// enter, push current expression onto
																				// expr
																				// stack and reset sB
					expr.push(sB.toString());
					sB = new StringBuilder();
				}
				ops.push(iC); // push iC (which is an operator) to the operator stack
			} else if (iC == ')') { // if iC is a right bracket
				if (!(sB.toString().isEmpty()) && !(isBlank(sB.toString()))) { // if sB is not empty and is not blank,
																				// enter, push expression onto expr
																				// stack and reset sB
					expr.push(sB.toString());
					sB = new StringBuilder();
				}
				sB = new StringBuilder(); // reset string sB
				if (expr.size() < 2 || ops.size() < 1) { // this is true if a ) is read before 2 expressions
															// are pushed onto the expression or operand stack
					return "Input is not a valid RPIE"; // return invalid RPIE as a result
				}
				String newExp = FPIEExpressionBuilder(); // build expression in the form '( exp op exp )' and return it
															// to
															// be
															// pushed
				expr.push(newExp); // push it onto expression stack
				sB = new StringBuilder(); // reset string sB

			} else {
				sB.append(iC); // if none of the above conditions are met, continue to build the current
								// expression string up
			}
		}

		String result = expr.pop(); // pop the simplified expression
		if (!expr.isEmpty() || !ops.isEmpty() || RPIE.contains("(")) { // checks for error cases in the RPIE that was
																		// entered
			return "Input is not a valid RPIE";
		}
		return result; // returns FPIE
	}

	/**
	 * Method takes @param RPIE, a Right Parenthesized Infix Expression,
	 * and @returns its Un-Parenthesized Postfix Expression equivalent if it is a
	 * valid RPIE; returns an error message otherwise.
	 */
	String convertToUPPE(String RPIE) {
		StringBuilder sB = new StringBuilder(); // initialize StringBuilder()
		char iC = ' ';
		for (int i = 0; i < RPIE.length(); i++) { // iterate through every character in the expression
			iC = RPIE.charAt(i); // iC is the current character being read
			if (isOp(iC)) { // check if current character is an operator
				if (!(sB.toString().isEmpty()) && !(isBlank(sB.toString()))) { // if sB is not empty and is not blank,
																				// enter, push current expression onto
																				// expr
																				// stack and reset sB
					expr.push(sB.toString());
					sB = new StringBuilder();
				}
				ops.push(iC); // push iC (which is an operator) to the operator stack
			} else if (iC == ')') { // if iC is a right bracket
				if (!(sB.toString().isEmpty()) && !(isBlank(sB.toString()))) { // if sB is not empty and is not blank,
																				// enter, push expression onto expr
																				// stack and reset sB
					expr.push(sB.toString());
					sB = new StringBuilder();
				}
				sB = new StringBuilder(); // reset string sB
				if (expr.size() < 2 || ops.size() < 1) { // this is true if a ) is read before 2 expressions
															// are pushed onto the expression or operand stack
					return "Input is not a valid RPIE"; // return invalid RPIE as a result
				}
				String newExp = UPPEExpressionBuilder(); // build expression in the form 'exp exp op' and return it to
															// be
															// pushed
				expr.push(newExp); // push it onto expression stack
				sB = new StringBuilder(); // reset string sB

			} else {
				sB.append(iC); // if none of the above conditions are met, continue to build the current
								// expression string up
			}
		}

		String result = expr.pop(); // pop the simplified expression
		if (!expr.isEmpty() || !ops.isEmpty() || RPIE.contains("(")) { // checks for error cases in the RPIE that was
																		// entered
			return "Input is not a valid RPIE";
		}
		return result; // returns UPPE
	}

	/**
	 * Expression main method tester. Method tests methods: convertToFPIE(String
	 * RPIE) and convertToUPPE(String UPPE).
	 */
	public static void main(String[] args) {

		Expression eP1 = new Expression();
		Expression eP2 = new Expression();
		Expression eP3 = new Expression();
		Expression eP4 = new Expression();
		Expression eP5 = new Expression();
		Expression eP6 = new Expression();
		Expression eP7 = new Expression();
		Expression eP8 = new Expression();
		Expression eP9 = new Expression();
		Expression eP10 = new Expression();

		System.out.println(
				"/****************************************** Test 1 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr1 = "a+b)+c)+d)+e)+f)+g)+h)+i)+j)+k)+l)+m)+n)";
		System.out.println("Input RPIE: \t" + expr1);
		System.out.println("Output FPIE: \t" + eP1.convertToFPIE(expr1));
		System.out.println("Output UPPE: \t" + eP1.convertToUPPE(expr1));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 2 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr2 = "a+b)*c+d)";
		System.out.println("Input RPIE: \t" + expr2);
		System.out.println("Output FPIE: \t" + eP2.convertToFPIE(expr2));
		System.out.println("Output UPPE: \t" + eP2.convertToUPPE(expr2));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 3 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr3 = "a+b)*c+d))";
		System.out.println("Input RPIE: \t" + expr3);
		System.out.println("Output FPIE: \t" + eP3.convertToFPIE(expr3));
		System.out.println("Output UPPE: \t" + eP3.convertToUPPE(expr3));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 4 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr4 = "a +b)* c+ d))";
		System.out.println("Input RPIE: \t" + expr4);
		System.out.println("Output FPIE: \t" + eP4.convertToFPIE(expr4));
		System.out.println("Output UPPE: \t" + eP4.convertToUPPE(expr4));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 5 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr5 = "5-7)*15*32)/3+5)))*8-3))";
		System.out.println("Input RPIE: \t" + expr5);
		System.out.println("Output FPIE: \t" + eP5.convertToFPIE(expr5));
		System.out.println("Output UPPE: \t" + eP5.convertToUPPE(expr5));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 6 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr6 = "a + 20) / b - c) * 53.4 - d)))";
		System.out.println("Input RPIE: \t" + expr6);
		System.out.println("Output FPIE: \t" + eP6.convertToFPIE(expr6));
		System.out.println("Output UPPE: \t" + eP6.convertToUPPE(expr6));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 7 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr7 = "3x + 7 ) * c - d ) )";
		System.out.println("Input RPIE: \t" + expr7);
		System.out.println("Output FPIE: \t" + eP7.convertToFPIE(expr7));
		System.out.println("Output UPPE: \t" + eP7.convertToUPPE(expr7));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 8 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr8 = "544562x+2)/742.46*7))";
		System.out.println("Input RPIE: \t" + expr8);
		System.out.println("Output FPIE: \t" + eP8.convertToFPIE(expr8));
		System.out.println("Output UPPE: \t" + eP8.convertToUPPE(expr8));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 9 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr9 = "5 ))";
		System.out.println("Input RPIE: \t" + expr9);
		System.out.println("Output FPIE: \t" + eP9.convertToFPIE(expr9));
		System.out.println("Output UPPE: \t" + eP9.convertToUPPE(expr9));

		System.out.println("\n\n\n\n\n");

		System.out.println(
				"/****************************************** Test 10 ******************************************/");
		System.out.println("Enter a valid RPIE:");
		String expr10 = "a+b)*c)+7)*8)";
		System.out.println("Input RPIE: \t" + expr10);
		System.out.println("Output FPIE: \t" + eP10.convertToFPIE(expr10));
		System.out.println("Output UPPE: \t" + eP10.convertToUPPE(expr10));

	}
}
