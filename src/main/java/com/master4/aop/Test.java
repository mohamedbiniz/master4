package com.master4.aop;


import com.master4.controllers.ArticleController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;

//@Aspect
//@Component
public class Test {
    @Autowired
    private ArticleController articleController;


    @Around("execution(* com.master4.controllers.ArticleController.home(..))")
    public String hello(ProceedingJoinPoint jp) throws Throwable {
        Object[] args=jp.getArgs();
        System.err.println(args);
        if(true) {
            Object r = jp.proceed(args);
            return r.toString();

        }else{
            return articleController.redirect("");
        }

    }



}
