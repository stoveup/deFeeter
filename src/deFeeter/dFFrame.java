package deFeeter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//todo: allow for conversion of inches as well

public class dFFrame {
    JPanel panel;
    JFrame frame;
    JLabel infoLabel;
    JLabel outputLabel;
    JButton button;
    JTextField textField;
    public dFFrame() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Feet'Inches to Meters");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout(5, 5));


        Text();
        outputText();
        inputField();

    }
    private void Text() {
        panel = new JPanel();
        infoLabel = new JLabel("How to Use: Put feet'inches into text field in {feet.inches} format.");
        panel.add(infoLabel);
        panel.setBackground(Color.CYAN);
        frame.add(panel, BorderLayout.NORTH);
    }

    private void inputField() {
        textField = new JTextField(10);
        panel = new JPanel();
        panel.add(textField);

        button = new JButton("Enter");
        button.addActionListener(e -> {
            System.out.println("Button has been pressed- commence the defeeting!");
            String txt = textField.getText();
            double feets = numConvertor(txt);
            double mt = toMetres(feets);

            outText(mt);
        });
        panel.add(button);


        frame.add(panel, BorderLayout.CENTER);
    }

    private double numConvertor(String num) {
        System.out.println("Checking...String to Int Conversion OK!");
        double convertedNumber = 0;
        int intToAdd;
        int tenMultiplier = 1;
        char[] stringToChar = num.toCharArray();
        int arrayLength = stringToChar.length;
        for (int i = arrayLength-1; i >= 0; i--) {
            if (stringToChar[i] == 46) {
                //If the character encountered is a '.', this means that the characters before it are inches
                convertedNumber = convertedNumber / tenMultiplier;
                tenMultiplier = 1;
            }
            else {
                intToAdd = stringToChar[i] - 48;
                convertedNumber += intToAdd * tenMultiplier;
                tenMultiplier *= 10;
            }
        }
        return convertedNumber;
    }

    private double toMetres(double input) {
        double inches = input - (int) input;

        double feet = (int) input;
        double meter = inchesToMetres(inches) + feetToMetres(feet);
        meter = (double) Math.round(meter * 100) /100;
        System.out.println("Checking...Conversion Compete!");
        return meter;
    }

    private double feetToMetres(double feet) {
        double meter = feet * 0.3048;
        System.out.println("Checking...Feets converted to Meters");
        return meter;
    }
    //Note that inches are still in decimals (e.g. 1 inch = 0.1)
    private double toWholeNumInches(double inches) {
        //Note that there is an expectation that inches only range from 0-12; anything above should've been converted to feet.
        //There maybe future functionality where the inches have not been converted to feet for conversion to meters, but if anything goes wrong it
        //probably is because of that :)
        inches = inches * 10;
        int intChecker = (int) inches;
        if ((intChecker - inches) != 0) {
            inches = inches * 10;
        }
        System.out.println(inches + " inches have been set in integer format.");
        return inches;

    }
    //to fix
    private double inchesToMetres(double inches) {
        inches = toWholeNumInches(inches);
        double meter = inches * 0.0254;
        System.out.println("Checking...Inches converted to Meters");
        return meter;
    }

    private void outText(double meters) {
        System.out.println("Checking...Outputting..?");
        String output = String.valueOf(meters);
        outputLabel.setText(output + " metres");
        System.out.println("Checking..."+output+" has been outputted!");

    }

    private void outputText() {
        panel = new JPanel();
        outputLabel = new JLabel();
        panel.add(outputLabel);
        frame.add(panel, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }
}

