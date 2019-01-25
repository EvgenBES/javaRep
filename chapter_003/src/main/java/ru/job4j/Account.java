package ru.job4j;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 30.08.2018
 */

public class Account {

    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValues(double values) {
        this.values = values;
    }

}