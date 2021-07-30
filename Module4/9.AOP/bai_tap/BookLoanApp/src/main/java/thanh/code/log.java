package thanh.code;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class log {
    @Pointcut("execution(* thanh.code.BookController.*(..))")
    private void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("method: "+joinPoint.getSignature().getName()+ " Time: "+ LocalDate.now());
    }

//    @AfterReturning("allMethodPointCut()")
//    public void afterReturningMethod(JoinPoint joinPoint){
//        System.out.println("After returning method: "+joinPoint.getSignature().getName()+ " Time: "+ LocalDate.now());
//    }
}
