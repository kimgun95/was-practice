package org.example.calculator.domain;



import org.example.calculator.tobe.*;
import org.example.calculator.tobe.ArithmeticOperator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = Arrays.asList(new AdditionOperator(), new SubtractionOperator(), new DivisionOperator(), new MultiplicationOperator());

    public static int calculate(PositiveNumber num1, String operator, PositiveNumber num2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(num1, num2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}