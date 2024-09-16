package Lab1_CDI.CalculatorMethods.Parameter;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class SinCosParams<T extends Number> implements TanParams<T> {

    private final T sine;
    private final T cosine;

    public SinCosParams(T sine, T cosine) {
        // Проверка, что синус и косинус находятся в пределах от -1 до 1
        if (Math.abs(sine.doubleValue()) > 1 || Math.abs(cosine.doubleValue()) > 1) {
            throw new IllegalArgumentException("Синус и косинус должны быть в пределах от -1 до 1.");
            // Проверка, что косинус не равен нулю
        } else if (cosine.doubleValue() == 0) {
            throw new ArithmeticException("Тангенс не определен, если косинус равен нулю");
        }

        this.sine = sine;
        this.cosine = cosine;
    }

    @Override
    public List<T> getValues() {
        return Arrays.asList(sine, cosine);
    }
}
