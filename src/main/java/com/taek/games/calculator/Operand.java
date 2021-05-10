package com.taek.games.calculator;

public class Operand {

    public static String[] splitInput(String input) {
        checkIfEmpty(input);
        String[] inputs = StringUtils.trimAll(input).split("");
        checkIfInputIsValidSize(inputs);
        checkIfInputIsNumberAndOperator(inputs);
        return inputs;
    }

    private static void checkIfEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(CalculatorErrorMessage.INPUT_NULL);
        }
    }

    private static void checkIfInputIsValidSize(String[] inputs) {
        if (inputs.length % 2 == 0) {
            throw new IllegalArgumentException(CalculatorErrorMessage.INVALID_INPUT);
        }
    }

    private static void checkIfInputIsNumberAndOperator(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            if (isEvenOrder(i) && !StringUtils.isNumeric(inputs[i])) {
                throw new IllegalArgumentException(CalculatorErrorMessage.NOT_NUMERIC);
            }
            if (isOddOrder(i) && !OperatorType.isValidOperator(inputs[i])) {
                throw new IllegalArgumentException(CalculatorErrorMessage.INVALID_OPERATOR);
            }
        }
    }

    private static boolean isEvenOrder(int i) {
        return i % 2 == 0;
    }

    private static boolean isOddOrder(int i) {
        return i % 2 == 1;
    }
}
