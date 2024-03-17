package ru.maxima.bankalgorithm2.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String name;
    private Double wallet;
}
