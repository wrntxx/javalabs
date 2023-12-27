package com.education.ztu;
public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(int i, int j, int k, int l) {
        return calculator.add(i, j) + calculator.subtract(k, l);
    }
}
