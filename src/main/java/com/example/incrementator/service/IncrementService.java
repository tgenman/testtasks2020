package com.example.incrementator.service;

import org.springframework.stereotype.Service;

@Service
public class IncrementService implements IIncrementService {

    @Override
    public String incrementValue(final String value) {
        final String[] strings = value.split(" ");
        StringBuilder result = new StringBuilder();

        for (String string : strings) {
            try {
                int newValue = Integer.parseInt(string) + 1;
                result.append(" ").append(newValue);

            } catch (NumberFormatException e) {
                throw new NotNumberValueException();
            }
        }

        return result.toString().trim();
    }
}
