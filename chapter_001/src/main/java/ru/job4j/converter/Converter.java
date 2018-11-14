package ru.job4j.converter;


/**
 * Конкертер валюты
 */
public class Converter {


    private int resultConv;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли
     * @return Евро
     */
    public int rubleToEuro(int value) {
        this.resultConv = value / 70;
        return resultConv;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        this.resultConv = value / 60;
        return resultConv;
    }

    /**
     * Конвертируем доллары в рубли
     * @param value доллары
     * @return Рубли
     */
    public int dollarToRub(int value) {
        this.resultConv = value * 60;
        return resultConv;
    }

    /**
     * Конвертируем euro в рубли
     * @param value euro
     * @return Рубли
     */
    public int euroToRub(int value) {
        this.resultConv = value * 70;
        return resultConv;
    }
}
