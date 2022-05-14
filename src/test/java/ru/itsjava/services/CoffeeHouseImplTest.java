package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Класс CoffeeHouse")
class CoffeeHouseImplTest {

    @Configuration
    static class ConfigurationCoffeeHouse{

        @Bean
        public InputService inputService(){
            InputServiceImpl mockInputService = Mockito.mock(InputServiceImpl.class);
            final double price = 5.5;
            when(mockInputService.input()).thenReturn(String.valueOf(price));
            return mockInputService;
        }

        @Bean
        public CoffeeService coffeeService(){
            CoffeeServiceImpl coffeeService = Mockito.mock(CoffeeServiceImpl.class);
            when(coffeeService.getCoffeeByPrice(5.5)).thenReturn(new Coffee("Espresso"));
            return coffeeService;
        }

        @Bean
        public CoffeeHouse coffeeHouse(CoffeeService coffeeService, InputService inputService){
            return new CoffeeHouseImpl(coffeeService, inputService);
        }

    }

    @Autowired
    private CoffeeHouse coffeeHouse;

    @DisplayName(" корректный метод предоставления кофе")
    @Test
    void shouldHaveCorrectMethodGiveOutCoffeeAccordingToPriceList() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        coffeeHouse.giveOutCoffeeAccordingToPriceList();

        assertEquals("Привет!\r\n" +
                "Введите стоимость кофе: Espresso - 5.5, Americano - 7.2, Cappuccino - 8.8\r\n" +
                "Ваш кофе: Кофе{Espresso}\r\n", outputStream.toString());
    }
}