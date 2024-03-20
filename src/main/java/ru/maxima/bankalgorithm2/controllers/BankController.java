package ru.maxima.bankalgorithm2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.bankalgorithm2.models.Bank;
import ru.maxima.bankalgorithm2.models.Person;
import ru.maxima.bankalgorithm2.models.Result;
import ru.maxima.bankalgorithm2.services.BankService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE, path = "/bank")
    public ResponseEntity<Result> toDistribute(@RequestBody Bank bank) {
        BigDecimal allMoney = bank.getWallet();
        List<Person> allPersons = bank.getPersons();
        return ResponseEntity.ok(bankService.toDistribute(allMoney, allPersons));
    }
}
