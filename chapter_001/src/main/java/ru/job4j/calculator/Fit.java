package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {

    private double weight;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        weight = (height - 100) * 1.15;
        return weight;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        weight = (height - 110) * 1.15;
        return weight;
    }
}