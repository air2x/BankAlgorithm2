package ru.maxima.bankalgorithm2.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Result {

    private List<Person> result;
    private List<Person> minimum;
}
