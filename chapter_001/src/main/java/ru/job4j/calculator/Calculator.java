package ru.job4j.calculator;
/**
 * Calculator
 *
 * @author Mikhail Shirinkin (misha.shirinkin@gmail.com)
 */
public class Calculator {

    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void substract(double first, double second) {
        this.result = first - second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public double getResult() {
        return this.result;
    }

}
