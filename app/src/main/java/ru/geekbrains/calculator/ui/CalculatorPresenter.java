package ru.geekbrains.calculator.ui;


import ru.geekbrains.calculator.logic.Calculator;
import ru.geekbrains.calculator.logic.Operation;

public class CalculatorPresenter {

    private CalculatorView view;

    private Calculator calculator;

    private double firstOperand;
    private double secondOperand;

    private boolean plusCalc, minusCalc, multCalc, divCalc;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onButtonOneClick() {
        view.showResult("1");
    }

    public void onButtonTwoClick() {
        view.showResult("2");
    }

    public void onButtonThreeClick() {
        view.showResult("3");
    }

    public void onButtonFourClick() {
        view.showResult("4");
    }

    public void onButtonFiveClick() {
        view.showResult("5");
    }

    public void onButtonSixClick() {
        view.showResult("6");
    }

    public void onButtonSevenClick() {
        view.showResult("7");
    }

    public void onButtonEightClick() {
        view.showResult("8");
    }

    public void onButtonNineClick() {
        view.showResult("9");
    }

    public void onButtonZeroClick() {
        view.showResult("0");
    }

    public void onButtonDotClick() {
        view.showResult(".");
    }

    public void onButtonPlusClick() {
        plusCalc = true;
    }

    public void onButtonMinusClick() {
        minusCalc = true;
    }

    public void onButtonMultiplyClick() {
        multCalc = true;
    }

    public void onButtonDivClick() {
        divCalc = true;
    }


    public void onButtonEqualClick() {

        if (plusCalc) {
            double result = calculator.mainOperation(firstOperand, secondOperand, Operation.ADD);
            view.showResult(result + "");
            plusCalc = false;
        } else

        if (minusCalc) {
            double result = calculator.mainOperation(firstOperand, secondOperand, Operation.SUB);
            view.showResult(result + "");
            minusCalc = false;
        } else
        if (multCalc) {
            double result = calculator.mainOperation(firstOperand, secondOperand, Operation.MULT);
            view.showResult(result + "");
            multCalc = false;
        } else
        if (divCalc) {
            double result = calculator.mainOperation(firstOperand, secondOperand, Operation.DIV);
            view.showResult(result + "");
            divCalc = false;
        } else {
            view.showResult("");
        }

    }


    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }
}


