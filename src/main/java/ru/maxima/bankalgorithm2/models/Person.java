package ru.maxima.bankalgorithm2.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Person {

    private String name;
    private BigDecimal wallet;
    private BigDecimal appendFromBank;

    @Override
    public String toString() {
        return name + " : " + wallet + " : " + appendFromBank;
    }
}
