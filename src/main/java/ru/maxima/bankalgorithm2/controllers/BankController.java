package ru.maxima.bankalgorithm2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.bankalgorithm2.models.Bank;
import ru.maxima.bankalgorithm2.models.Person;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE, path = "/bank")
    public ResponseEntity<HttpStatus> toDistribute(@RequestBody Bank bank) {

        Double allMoney = bank.getWallet();
        List<Person> allPerson = bank.getPersons();


        return ResponseEntity.ok(HttpStatus.OK);
    }
}
