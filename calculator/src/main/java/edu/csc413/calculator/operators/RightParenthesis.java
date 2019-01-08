/**
 * RightParenthesis.java     --A program to represent right parenthesis operator.
 * @author                  Ratna Lama
 * @version                 1.0
 * @since                   09/17/2018
 */
package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class RightParenthesis extends Operator{
    /**
     * Sets the priority of the operator
     * lower number corresponds to lower priority.
     * 0-is the lowest priority
     * higher number corresponds to higher priority
     * 4-is the highest priority
     *
     * @return   priority of an operator to be returned
     */
    public int priority() {
        return 4;   // highest priority

    } // end priority()

    /**
     * Executes RightParenthesis operation
     * @param op1   operand one
     * @param op2   operand two
     * @return null
     */
    public Operand execute(Operand op1, Operand op2 ) {
        return null;
    } // end execute()
}
