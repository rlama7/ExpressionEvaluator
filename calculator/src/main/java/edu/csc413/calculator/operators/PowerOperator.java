/**
 * PowerOperator.java     --A program to represent power operator.
 * @author                  Ratna Lama
 * @version                 1.0
 * @since                   09/17/2018
 */
package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator{
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
        return 3;

    } // end priority()

    /**
     * Executes power operation on two operands
     * @param op1   operand one
     * @param op2   operand two
     * @return Operand  result of power operator on operand one and operand two
     */
    public Operand execute(Operand op1, Operand op2 ) {

        double result = Math.pow((double)op1.getValue(),(double)op2.getValue());
        return new Operand((int) result);
    } // end execute()
}
