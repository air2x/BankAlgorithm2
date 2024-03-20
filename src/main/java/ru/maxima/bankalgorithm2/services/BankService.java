package ru.maxima.bankalgorithm2.services;

import org.springframework.stereotype.Service;
import ru.maxima.bankalgorithm2.models.Person;
import ru.maxima.bankalgorithm2.models.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BankService {

    public Result toDistribute(BigDecimal allMoney, List<Person> allPersons) {
        Result result = new Result();
        allPersons.sort(Comparator.comparing(Person::getWallet));

        BigDecimal maxWallet = allPersons.get(allPersons.size() - 1).getWallet();
        for (Person p : allPersons) {
            p.setAppendFromBank(BigDecimal.ZERO);
            if (p.getWallet().compareTo(maxWallet) > 0) {
                BigDecimal difference = maxWallet.subtract(p.getWallet());
                p.setWallet(p.getWallet().add(difference));
                p.setAppendFromBank(p.getAppendFromBank().add(difference));
                allMoney = allMoney.subtract(difference);
            }
        }
        BigDecimal size = BigDecimal.valueOf(allPersons.size());
        BigDecimal addToEachPerson = allMoney.divide(size, 2, RoundingMode.HALF_UP);
        for (Person p : allPersons) {
            if (allMoney.compareTo(addToEachPerson) <= 0) {
                addToEachPerson = allMoney;
            }
            p.setWallet(p.getWallet().add(addToEachPerson));
            p.setAppendFromBank(p.getAppendFromBank().add(addToEachPerson));
            allMoney = allMoney.subtract(addToEachPerson);
        }

        result.setResult(allPersons);
        allPersons.sort(Comparator.comparing(Person::getAppendFromBank));
        List<Person> min = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            min.add(allPersons.get(i));
        }
        result.setMinimum(min);
        return result;
    }
}
