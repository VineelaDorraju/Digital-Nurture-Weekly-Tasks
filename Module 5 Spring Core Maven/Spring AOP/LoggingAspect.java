import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ServiceClass.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println("[LOG] Method called: " + methodName);
    }
}