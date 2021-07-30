package thanh.code.tracking.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.time.LocalDate;

@Aspect
@Component
public class EmployeeLog {

    @Pointcut("execution(* thanh.code.controllers.EmployeeController.*(..))")
    private void allMethodEmployeeController(){}

    @AfterThrowing("allMethodEmployeeController()")
    private void afterThrowing(JoinPoint joinPoint){
        System.err.println("error method : " + joinPoint.getSignature().getName() + " ,time : " + LocalDate.now());
        String stringNameClass = joinPoint.getSignature().getDeclaringTypeName();
        int dotNameClass = joinPoint.getSignature().getDeclaringTypeName().lastIndexOf(".");
        String nameClass = stringNameClass.substring(dotNameClass+1);
        System.out.println("2 : " + nameClass);
    }

}
