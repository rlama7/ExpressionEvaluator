/**
 * SubtractOperator.java     --A program to represent subtraction operator.
 * @author                      Ratna Lama
 * @version                     1.0
 * @since                       09/17/2018
 */

package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator{

    /**
     * Sets the priority of the operator
     * lower number corresponds to the lower priority.
     * 0-is the lowest priority
     * higher number corresponds to the higher priority
     * 4-is the highest priority
     *
     * @return   priority of an operator to be returned
     */
    public int priority() {
        return 1;

    } // end priority()

    /**
     * Executes subtraction operation on two operands
     * @param op1   operand one
     * @param op2   operand two
     * @return Operand  result of subtraction on operand two from operand two
     */
    public Operand execute(Operand op1, Operand op2 ) {
        return new Operand(op1.getValue() - op2.getValue());
    } // end execute()
}
