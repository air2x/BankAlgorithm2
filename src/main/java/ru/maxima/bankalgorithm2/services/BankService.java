package ru.maxima.bankalgorithm2.services;

import org.springframework.stereotype.Service;
import ru.maxima.bankalgorithm2.models.Person;
import ru.maxima.bankalgorithm2.models.Result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BankService {

    public Result toDistribute(Double allMoney, List<Person> allPersons) {
        Result result = new Result();
        allPersons.sort(Comparator.comparing(Person::getWallet));

        double maxWallet = allPersons.get(allPersons.size() - 1).getWallet();
        for (Person p : allPersons) {
            p.setAppendFromBank(0.0);
            if (p.getWallet() < maxWallet) {
                double difference = maxWallet - p.getWallet();
                p.setWallet(p.getWallet() + difference);
                p.setAppendFromBank(p.getAppendFromBank() + difference);
                allMoney -= difference;
            }
        }

        double addToEachPerson = allMoney / allPersons.size();
        for (Person p : allPersons) {
            if (allMoney <= addToEachPerson) {
                addToEachPerson = allMoney;
            }
            p.setWallet(p.getWallet() + addToEachPerson);
            p.setAppendFromBank(p.getAppendFromBank() + addToEachPerson);
            allMoney -= addToEachPerson;
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
