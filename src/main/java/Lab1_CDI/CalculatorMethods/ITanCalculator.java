package Lab1_CDI.CalculatorMethods;

import Lab1_CDI.CalculatorMethods.Parameter.TanParams;

public interface ITanCalculator {
    <T extends Number> double calculate(TanParams<T> parameters);
}
