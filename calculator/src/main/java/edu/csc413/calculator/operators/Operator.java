/**
 * Operator.java       --A program to represent an operator in a valid arithmetic expression.
 * @author              INST. Anthony Souza
 * @author              Ratna Lama
 * @version             1.0
 * @since               09/17/2018
 */

package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;


public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    // HashMap must have private access modifier
    private static HashMap<String, Operator> ops;

    static {
        ops = new HashMap<>();
        ops.put("+", new AddOperator());
        ops.put("-", new SubtractOperator());
        ops.put("*", new MultiplyOperator());
        ops.put("/", new DivideOperator());
        ops.put("^", new PowerOperator());
        ops.put("(", new LeftParenthesis());
        ops.put(")", new RightParenthesis());
    }

    public abstract int priority();
    public abstract Operand execute(Operand op1, Operand op2 );

    /**
     * Checks if a given token is a valid operator.
     * @param token either an operand or operator or delimiter to be determined
     * @return true if the hashMap contains a mapping for token
     */
    public static boolean check( String token ) {
        // returns true if the hashMap contains a mapping for token
        return ops.containsKey(token);
    }

    /**
     * Checks and returns the value to which the specified key is mapped
     * @param token either an operand or operator or delimiter to be determined
     * @return the value to which the specified key is mapped
     *          or null if this map contains no mapping for the key
     */
    public static Operator getOperator(String token) {
        // returns the value to which the specified key is mapped,
        // or null if this map contains no mapping for the key
        return ops.get(token);
    } // end getOps()
}
