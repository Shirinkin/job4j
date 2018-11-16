package ru.job4j.calculator;
/**
 * Calculator
 *
 * @author Mikhail Shirinkin (misha.shirinkin@gmail.com)
 */
public class Calculator {

    private double result;

    /**
     * Метод реализует сложение
     * @param first первое число
     * @param second второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод реализует вычитание
     * @param first первое число
     * @param second второе число
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод реализует умножение
     * @param first первое число
     * @param second второе число
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод реализует деление
     * @param first первое число
     * @param second второе число
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Результирующий метод
     * @return результат проведения одного из методов (сложение, вычитание, деление, умножение)
     */
    public double getResult() {
        return this.result;
    }

}
