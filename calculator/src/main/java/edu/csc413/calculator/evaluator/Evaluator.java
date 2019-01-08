/**
 * Evaluator.java       --A program to evaluate an infix arithmetic expression.
 * @author              INST. Anthony Souza
 * @author              Ratna Lama
 * @version             1.0
 * @since               09/17/2018
 */

package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.LeftParenthesis;
import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/() ";

    // Constructor
    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    } // end Constructor

    /**
     * Evaluates the given infix expression
     * @param expression    an infix arithmetic expression to be evaluated
     * @return  the result of the expression to return
     */
    public int eval( String expression ) {
        String token;
        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators

        // while there are still tokens to be read in
        while ( this.tokenizer.hasMoreTokens() ) {

            // filter out space
            if (!(token = this.tokenizer.nextToken()).equals("")) {
                // if token is an operand push it to the operand stack
                if (Operand.check(token)) {
                    // if token is an operand push it to operandStack
                    operandStack.push(new Operand(token));

                    // check if token is an operator
                } else {

                    // if token is not an operator display invalid token message
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        throw new RuntimeException("*****invalid token******");

                    } else if (")".equals(token)) { // if token is ")"
                        while (operatorStack.peek().priority() != 0) {  // run following process until "(" is found
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                        // discard "("
                        operatorStack.pop();

                        // if token is "(" then push is to operator stack
                    } else if ("(".equals(token)) {
                        operatorStack.push(new LeftParenthesis());

                    } else {
                        Operator newOperator = Operator.getOperator(token);

                        if (!operatorStack.empty()) {
                            while ((operatorStack.peek().priority() >= newOperator.priority()) && (!operatorStack.isEmpty()) && (operandStack.size()>=2)) {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
                            }
                        }
                        operatorStack.push(newOperator);
                    } // end if-else
                } // end if-else
            } // end if
        } // end while loop

        // while the operator stack is not empty "process"
        while (!operatorStack.empty()) {
            Operator oldOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push(oldOpr.execute(op1, op2));
        } // end while loop

        return (operandStack.pop().getValue());

    } // end eval()

} // end Evaluator Class