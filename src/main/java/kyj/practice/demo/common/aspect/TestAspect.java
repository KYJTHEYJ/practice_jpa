package kyj.practice.demo.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TestAspect {
    @Before("execution(* kyj.practice.demo.*.service.*.*(..))")
    public void testPrintText(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.info("AOP TEST : {}", signature.getName());
        Object[] objects = joinPoint.getArgs();
        log.info("AOP TEST2 : {}", objects);
        Object target = joinPoint.getTarget();
        log.info("AOP TEST3 : {}", target);
    }
}
