package ru.maxima.bankalgorithm2.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Result {

//    @JacksonXmlProperty(localName = "Person")
    private List<Person> result;

//    @JacksonXmlProperty(localName = "Person")
    private List<Person> minimum;
}
