package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.Coffee;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public Coffee getCoffeeByPrice(double price) {
        if ((price == 5.5)) {
            return new Coffee("Espresso");
        } else if ((price == 7.2)) {
            return new Coffee("Americano");
        } else if ((price == 8.8)) {
            return new Coffee("Cappuccino");
        }
        return new Coffee("Не верная оплата за кофе");
    }
}
