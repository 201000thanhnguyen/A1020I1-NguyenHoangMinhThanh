package thanh.code.tracking;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class Logger {
    @Pointcut(value = "execution(* thanh.code.controllers.ControllerCustomer.*(..))")
    public void logDisplayingEmployee() {
    }

    @After(value = "execution(* thanh.code.controllers.ControllerCustomer.showAll(..))")
    public void log(JoinPoint joinPoint) {
        System.err.println("start method name: " + joinPoint.getSignature().getName() + ", Time: " + LocalDate.now());
    }
}
