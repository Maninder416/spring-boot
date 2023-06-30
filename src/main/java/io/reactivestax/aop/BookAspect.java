package io.reactivestax.aop;

import io.reactivestax.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class BookAspect {

    Instant start = Instant.now();
    Instant stop = Instant.now();

    @Before(value = "execution(* io.reactivestax.controller.BookController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("Calling the "+joinPoint.getSignature()+ " method");
        start= Instant.now();
        log.info("***** Starting time is : {} *****: ",start);


    }

    @After(value = "execution(* io.reactivestax.controller.BookController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        stop= Instant.now();
        log.info("***** Stopping time is : {} *****: ",stop);
        log.info("Getting "+joinPoint.getSignature()+" call over: ms : {}",
                Duration.between(start,stop).toMillis());

    }

    @AfterReturning(value = "execution(* io.reactivestax.controller.BookController.saveBook(..))",returning = "book")
    public void afterReturning(JoinPoint joinPoint, Book book){
        log.info("Book is added successfully with id :{} ",book.getId());
    }

    @AfterThrowing(value = "execution(* io.reactivestax.controller.BookController.saveBook(..))",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        log.info("While trying to save book getting error : {}",exception.getMessage());
    }

    @Around(value = "execution(* io.reactivestax.controller.BookController.findBook(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        log.info("proceeding join point is: "+joinPoint);
        Book book = null;
        try{
             book = (Book) joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("response is: "+book);
        if(book.getName().length()>5){
            throw new RuntimeException("Size is more than 5");
        }


    }
}
