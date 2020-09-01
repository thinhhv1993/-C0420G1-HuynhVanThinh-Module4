package com.codegym.ungdungmuonsach.aop;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class BeforeAdvice {
    @AfterThrowing(pointcut = "execution(public * com.codegym.ungdungmuonsach.controller.BookController.rentBook()),")
    public void writeLog() {
        System.out.println("Hello");
    }


//
//    @AfterThrowing(value = "execution(* com.codegym.demoaop.Hello.*())", throwing = "e")
//    public void AfterThrowingCallMethod(JoinPoint joinPoint, Exception e) throws Throwable{
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println(String.format("[Hệ Thống] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//    }
//
//    @Pointcut()
//    public void testPointCut(){}


}
