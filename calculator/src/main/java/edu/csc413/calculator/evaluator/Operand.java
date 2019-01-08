/**
 * Operand.java       --A program to represent an operand in a valid arithmetic expression.
 * @author              INST. Anthony Souza
 * @author              Ratna Lama
 * @version             1.0
 * @since               09/17/2018
 */

package edu.csc413.calculator.evaluator;

public class Operand {
    int operandVal;

    /**
     * Constructs operand from string token
     * @param token either an operand or operator or delimiter to be determined
     */
  public Operand( String token ) {
      operandVal = Integer.parseInt(token);
  }

    /**
     * Constructs operand from an integer
     * @param value operand value
     */
  public Operand( int value ) {
      operandVal = value;
  }
  /**
   * Returns value of operand
   * @operandVal    value of operand to return
   */
  public int getValue() {
    return operandVal;
  }

  /**
   * Check to see if given token is a valid operand.
   * @param token either an operand or operator or delimiter to be determined
   * @return    true if a token is an operand
   *            false otherwise
   */
  public static boolean check( String token ) {
      try {
          Integer.parseInt(token);
          return true; // return true only if the token is an integer
      } catch(NumberFormatException e) {
          return false;
      }
  } // end check()

} // end Operand class
