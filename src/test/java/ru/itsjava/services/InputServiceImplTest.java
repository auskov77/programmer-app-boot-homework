package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Класс InputService")
class InputServiceImplTest {

    @Configuration
    static class ConfigurationInputServiceImpl{
        public static final String PRIVET = "privet";
        private final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(PRIVET.getBytes());

        @Bean
        public InputService inputService(){
            return new InputServiceImpl(byteArrayInputStream);
        }
    }

    @Autowired
    private InputService inputService;

    @DisplayName(" корректно работает метод input")
    @Test
    public void shouldHaveCorrectInput() {
        assertEquals(ConfigurationInputServiceImpl.PRIVET, inputService.input());
    }
}