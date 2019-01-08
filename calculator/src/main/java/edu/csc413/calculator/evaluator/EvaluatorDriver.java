/**
 * Evaluator.java       --A driver class that uses Evaluator class to evaluate an infix arithmetic expression.
 * @author              INST. Anthony Souza
 * @author              Ratna Lama
 * @version             1.0
 * @since               09/17/2018
 */
package edu.csc413.calculator.evaluator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvaluatorDriver {
    /**
     * Driver class that uses Evaluator to evaluate expressions.
     * The expressions can either be given as a command line argument
     * OR typed in at the keyboard. If you wish to type in expressions
     * give NO command line arguments. Otherwise you may give a list of
     * strings as a command line argument and the driver will run all strings
     * in that list.
     *
     * @param args command line arguments.
     *
     * Algorithm:
     *
     * 1.	While there are still tokens to be read in,
     * A.	Get the next token
     * B.	If the token is
     * i.	An operand then push it onto the operand stack
     * ii.	An operator then push it onto the operator stack
     * iii.	A left parenthesis then push it onto the operator stack
     * iv.	A right parenthesis:
     * 1.	While the thing on top of the operator stack is not a left parenthesis
     * I.	Pop the operator from operator stack
     * II.	Pop the operand twice from the operand stack because all our operators are
     *      binary and need two operands to operate on.
     * III.	Apply the operator to the operands in the correct order
     * IV.	Push the result onto the operand stack
     * 2.	Pop the left parenthesis from the operator stack, and discard it.
     * v.	An operator call newOperator
     * 1.	While the operator stack is not empty, and the top thing on the operator stack
     *      has the same or greater precedence as newOperator
     * I.	Pop the operator from operator stack
     * II.	Pop the operand twice from the operand stack because all our operators are binary
     *      and need two operands to operate on.
     * III.	Apply the operator to the operands in the correct order
     * IV.	Push the result onto the operand stack
     * 2.	Push newOperator onto the operator stack
     * 2.	While the operator stack is not empty
     * I.	Pop the operator from operator stack
     * II.	Pop the operand twice from the operand stack because all our operators are binary
     *      and need two operands to operate on.
     * III.	Apply the operator to the operands in the correct order
     * IV.	Push the result onto the operand stack
     * 3.	At this point the operator stack should be empty, and the operand stack should have
     *      only one operand in it.
     *      We pop the last operand ante return it as the final result of the infix expression*
     */

    public static void main(String... args){
        BufferedReader input;
        String exp;
        int res;

        Evaluator ev = new Evaluator();
        if(args.length == 0){
            try {
                input = new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    System.out.print("Enter an Expression: ");
                    exp = input.readLine();
                    res = ev.eval(exp);
                    System.out.printf("Expression : %s , Result %6d\n", exp, res);
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }else{
            for(String ex : args) {
                res = ev.eval(ex);
                System.out.printf("Expression : %s , Result: %-6d\n", ex, res);
            }

        }
    }
}
