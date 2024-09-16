package Lab1_CDI.Interceptors;

import lombok.NoArgsConstructor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@NoArgsConstructor
public class ProfileInterceptor {

    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
        long initTime = System.currentTimeMillis();
        Object result;

        try {
            Thread.sleep(100); // Задержка в 100 миллисекунд
            result = ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime - 100;
            System.out.println(ic.getMethod() + " занял " + diffTime + " миллисекунд");
        }

        return result;
    }
}
