package Lab1_CDI.CalculatorMethods.Parameter;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CosOnlyParams<T extends Number> implements TanParams<T> {

    private final T cosine;

    public CosOnlyParams(T cosine) {
        // Проверка, что косинус находится в пределах от -1 до 1
        if (cosine.doubleValue() < -1 || cosine.doubleValue() > 1) {
            throw new IllegalArgumentException("Косинус должен быть в пределах от -1 до 1.");
            // Проверка, что косинус не равен нулю
        } else if (cosine.doubleValue() == 0) {
            throw new ArithmeticException("Тангенс не определен, если косинус равен нулю");
        }

        this.cosine = cosine;
    }

    @Override
    public List<T> getValues() {
        return Collections.singletonList(cosine);
    }
}
