/**
 * EvaluatorUI.java     --A GUI program to evaluate an infix arithmetic expression.
 * @author              INST. Anthony Souza
 * @author              Ratna Lama
 * @version             1.0
 * @since               09/17/2018
 */

package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    Evaluator evaluateInfixExp = new Evaluator();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {

        EvaluatorUI calc = new EvaluatorUI();
    }

    // Constructor
    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        //Object[] button = null;

        // Check if the button is not "=", "C", or "CE"
        if (!arg0.getSource().equals( buttons[14]) && !arg0.getSource().equals(buttons[18]) && !arg0.getSource().equals(buttons[19])) {
            int buttonCount = 0;
            while (buttonCount < 20) {
                if (arg0.getSource().equals(buttons[buttonCount])) {
                    txField.setText(txField.getText() + bText[buttonCount]);
                    System.out.println(txField.getText());
                }
                buttonCount++;
            }

        // check if buttons[14] is "=" then evaluate the expression
        } else if (arg0.getSource().equals(buttons[14])) {
            int solution = evaluateInfixExp.eval((txField.getText()));
            txField.setText(Integer.toString(solution));

        // check if buttons[18] is "C" then clear the entire expression
        } else if (arg0.getSource().equals(buttons[18])) {
            txField.setText("");    // clear

        // check if buttons[19] is "CE" then clears the last entry until the last operator
        } else if (arg0.getSource().equals(buttons[19])) {
            String emptyStr = txField.getText();
            // if not empty
            if (!emptyStr.equals("")) {
                txField.setText(emptyStr.substring(0,emptyStr.length()-1));
            }

        } // end if-else
    }
}
