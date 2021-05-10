package com.taek.games.calculator;

import org.graalvm.compiler.graph.spi.Canonicalizable;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public enum OperatorType {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MUMTIPLY("*", (a, b) -> a * b);

    private String operator;
    private BinaryOperator<Double> binaryOperator;

    OperatorType(String operator, BinaryOperator<Double> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static boolean isValidOperator(String operator) {
        return findByOperatorOp(operator).isPresent();
    }

    public double calculate(double a, double b) {
        return binaryOperator.apply(a, b);
    }

    public static OperatorType findByOperator(String operator) {
        return findByOperatorOp(operator).get();
    }

    private static Optional<OperatorType> findByOperatorOp(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst();
    }
}
