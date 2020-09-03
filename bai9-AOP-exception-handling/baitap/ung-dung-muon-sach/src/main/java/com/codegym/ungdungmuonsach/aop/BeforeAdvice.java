package com.codegym.ungdungmuonsach.aop;


import com.codegym.ungdungmuonsach.exception.GiveBookBackException;
import com.codegym.ungdungmuonsach.exception.RentBookException;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@Aspect
@Component
public class BeforeAdvice {
    @After( "execution( * com.codegym.ungdungmuonsach.controller.BookController.rentBook(..)),")
    public void writeLog() {
        System.out.println("Hello");
    }

    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("errorGiveBookBack");
    }
    @ExceptionHandler(RentBookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error");
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
