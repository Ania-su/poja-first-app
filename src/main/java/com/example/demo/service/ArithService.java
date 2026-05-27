package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArithService {
    private void validateInputs(Double a, Double b) {
        List<String> errors = new ArrayList<>();
        if (a == null || b == null) {
            throw new IllegalArgumentException("a and b cannot be null");
        }
        if (a < 0 || b < 0) {
            errors.add("a and b cannot be negative");
        }
        if (b == 0) {
            errors.add("nonsense to provide b as 0");
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }
    }
    private void validateDivision(Double a, Double b) {
        List<String> errors = new ArrayList<>();

        if (a == null || b == null) {
            throw new IllegalArgumentException("a and b cannot be null");
        }
        if (a < 0 || b < 0) {
            errors.add("a and b cannot be negative");
        }
        if (b == 0) {
            errors.add("Cannot divide by 0");
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }
    }
    public Double add(Double a, Double b) {
        validateInputs(a, b);
        return a+b;
    }

    public Double sub(Double a, Double b) {
        validateInputs(a, b);
        return a-b;
    }

    public Double multiply(Double a, Double b) {
        validateInputs(a, b);
        return a*b;
    }

    public Double divide(Double a, Double b) {
        validateDivision(a, b);
        return a/b;
    }
}
