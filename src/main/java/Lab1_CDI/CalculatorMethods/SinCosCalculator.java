package Lab1_CDI.CalculatorMethods;

import Lab1_CDI.Annotation.SINE_COSINE;
import Lab1_CDI.CalculatorMethods.Parameter.TanParams;
import lombok.NoArgsConstructor;

import java.util.List;

@SINE_COSINE
@NoArgsConstructor
public class SinCosCalculator implements ITanCalculator {

    @Override
    public <T extends Number> double calculate(TanParams<T> parameters) {

        List<T> values = parameters.getValues();

        if (values.size() < 2) {
            throw new IllegalArgumentException("Ожидаются два значения: синус и косинус.");
        }

        return calculateTangent(values.get(0), values.get(1));
    }

    public <T extends Number> double calculateTangent(T sine, T cosine) {

        // Логирование
        System.out.println("Метод расчета по синусу и косинусу: ");

        // Преобразование синуса и косинуса в тип double для математических операций
        double sinValue = sine.doubleValue();
        double cosValue = cosine.doubleValue();

        // Если тангенс не определен
        if (cosValue == 0) {
            throw new ArithmeticException("Тангенс не определен, если косинус равен нулю");
        }

        // Вычисление тангенса
        return sinValue / cosValue;
    }
}