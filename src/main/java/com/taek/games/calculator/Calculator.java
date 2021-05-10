package com.taek.games.calculator;

public class Calculator {

    // TODO: 사칙연산 순서에 맞게 계산하도록 수정해야 함.
    public double calculate(String input) {
        String[] inputs = Operand.splitInput(input);

        double result = Double.parseDouble(inputs[0]);
        for (int i = 1; i < inputs.length; i+=2) {
            System.out.println(inputs[i + 1]);
            result = OperatorType.findByOperator(inputs[i])
                    .calculate(result, Double.parseDouble(inputs[i + 1]));
        }
        return result;
    }
}
