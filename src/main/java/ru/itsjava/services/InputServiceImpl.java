package ru.itsjava.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class InputServiceImpl implements InputService {
    private final BufferedReader reader;

    public InputServiceImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SneakyThrows
    @Override
    public String input() {
        return reader.readLine();
    }
}
