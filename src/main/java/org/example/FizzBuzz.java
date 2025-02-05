package org.example;

public class FizzBuzz {
    public String execute(Integer i) {
        String res = null;

        try {
            Integer.valueOf(i);
        } catch (NullPointerException e) {
            throw new NullPointerException("Invalid number");
        }


        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return res;
    }
}
