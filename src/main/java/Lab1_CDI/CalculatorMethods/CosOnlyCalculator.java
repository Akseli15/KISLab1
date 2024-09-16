package Lab1_CDI.CalculatorMethods;

import Lab1_CDI.Annotation.COSINE_ONLY;
import Lab1_CDI.CalculatorMethods.Parameter.TanParams;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;
import java.util.List;

@Default
@COSINE_ONLY
@NoArgsConstructor
public class CosOnlyCalculator implements ITanCalculator {

    @Override
    public <T extends Number> double calculate(TanParams<T> parameters) {

        List<T> values = parameters.getValues();

        return calculateTangent(values.get(0));
    }

    public <T extends Number> double calculateTangent(T cosine) {

        // Логирование
        System.out.println("Метод расчета тангенса только по косинусу: ");

        // Преобразование косинуса в тип double для математических операций
        double cosValue = cosine.doubleValue();

        // sin = sqrt(1 - cos^2)
        double sinValue = Math.sqrt(1 - cosValue * cosValue);

        // Вычисление тангенса
        return sinValue / cosValue;
    }
}