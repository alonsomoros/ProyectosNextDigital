package org.example.kata_fizzbuzz_test;

import org.example.kata_fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
    @Test
    public void returnFizzIfMultipleOfThree() {
        FizzBuzz app = new FizzBuzz();
        String result = app.execute(3);
        assertEquals("Fizz", result);
    }

    @Test
    public void returnBuzzIfMultipleOfFive() {
        FizzBuzz app = new FizzBuzz();
        String result = app.execute(5);
        assertEquals("Buzz", result);
    }

    @Test
    public void returnBuzzFizzIfMultipleOfThreeAndFive() {
        FizzBuzz app = new FizzBuzz();
        String result = app.execute(15);
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void returnExceptionIfNull() {
        FizzBuzz app = new FizzBuzz();
        assertThrows(NullPointerException.class, () -> app.execute(null));

    }
}
