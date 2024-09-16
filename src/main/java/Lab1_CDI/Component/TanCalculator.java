package Lab1_CDI.Component;

import Lab1_CDI.Annotation.COSINE_ONLY;
import Lab1_CDI.CalculatorMethods.ITanCalculator;
import Lab1_CDI.CalculatorMethods.Parameter.TanParams;
import Lab1_CDI.Interceptors.ProfileInterceptor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(ProfileInterceptor.class) // Перехватчик
@NoArgsConstructor
public class TanCalculator {

    // Внедрение аннотации. Точка внедрения.
    @Inject @COSINE_ONLY
    private ITanCalculator calculator;

    public <T extends Number> double calculateTangent(TanParams<T> parameters) {
        return calculator.calculate(parameters);
    }

}
