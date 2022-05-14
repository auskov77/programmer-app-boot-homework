package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Класс CoffeeService")
class CoffeeServiceImplTest {

    @Configuration
    static class ConfigurationCoffeeServiceImpl{

        @Bean
        public CoffeeService coffeeService(){
            return new CoffeeServiceImpl();
        }

    }

    @Autowired
    private CoffeeServiceImpl coffeeService;

    @Test
    @DisplayName(" должен корректно давать кофе")
    public void shouldHaveCorrectMethodGetCoffeeByPrice() {
        double price = 5.5;
        Coffee coffee = coffeeService.getCoffeeByPrice(price);
        Assertions.assertEquals(coffee.toString(), "Кофе{Espresso}");
    }
}