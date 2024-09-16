import Lab1_CDI.CalculatorMethods.Parameter.CosOnlyParams;
import Lab1_CDI.CalculatorMethods.Parameter.TanParams;
import Lab1_CDI.Component.TanCalculator;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@NoArgsConstructor
public class Lab1Start {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            TanCalculator tangentCalculator = container.select(TanCalculator.class).get();

            TanParams<Double> parameters = new CosOnlyParams<Double>(0.4);
//            TangentParameters<Double> parameters = new SineCosineParameters<>(0.4, 0.5);

            double tangent = tangentCalculator.calculateTangent(parameters);
            System.out.println("Тангенс равен: " + tangent);

        } finally {
            weld.shutdown();
        }
    }
}
