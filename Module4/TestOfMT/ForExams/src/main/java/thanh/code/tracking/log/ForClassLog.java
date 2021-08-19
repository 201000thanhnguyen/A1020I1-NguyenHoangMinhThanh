package thanh.code.tracking.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class ForClassLog {

    @Pointcut("execution(* thanh.code.controllers.ForClassController.*(..))")
    private void allMethodForClassController(){}

    @AfterThrowing("allMethodForClassController()")
    private void afterThrowing(JoinPoint joinPoint){
        System.err.println("error method : " + joinPoint.getSignature().getName() + " ,time : " + LocalDateTime.now());
        String stringNameClass = joinPoint.getSignature().getDeclaringTypeName();
        int dotNameClass = joinPoint.getSignature().getDeclaringTypeName().lastIndexOf(".");
        String nameClass = stringNameClass.substring(dotNameClass+1);
//        System.out.println("2 : " + nameClass);
    }

}
