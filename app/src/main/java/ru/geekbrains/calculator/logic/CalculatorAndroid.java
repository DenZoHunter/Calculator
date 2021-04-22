package ru.geekbrains.calculator.logic;

public class CalculatorAndroid implements Calculator {

    @Override
    public double mainOperation(double agrOne, double argTwo, Operation operation) {
        switch (operation) {
            case ADD:
                return agrOne + argTwo;
            case SUB:
                return agrOne - argTwo;
            case DIV:
                if (agrOne != 0) {
                    return agrOne / argTwo;
                } else
                    return 0;
            case MULT:
                return agrOne * argTwo;
        }
        return 0;
    }
}
