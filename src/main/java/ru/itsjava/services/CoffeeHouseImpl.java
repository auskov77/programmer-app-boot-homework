package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("coffeeHouse")
@RequiredArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;
    private final InputService inputService;

//    public CoffeeHouseImpl(CoffeeService coffeeService, InputService inputService) {
//        this.coffeeService = coffeeService;
//        this.inputService = inputService;
//    }

    @Override
    public void giveOutCoffeeAccordingToPriceList() {
        System.out.println("Привет!");
        System.out.println("Введите стоимость кофе: Espresso - 5.5, Americano - 7.2, Cappuccino - 8.8");
        double price = Double.parseDouble(inputService.input());
        System.out.println("Ваш кофе: " + coffeeService.getCoffeeByPrice(price));
    }
}

