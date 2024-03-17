package ru.maxima.bankalgorithm2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String name;
    private Double wallet;
    private Double appendFromBank;

    @Override
    public String toString() {
        return name + " : " + wallet + " : " + appendFromBank;
    }
}
