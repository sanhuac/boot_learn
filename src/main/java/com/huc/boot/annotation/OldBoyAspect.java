package com.huc.boot.annotation;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 * @Auther: 胡丛
 * @Date: 2018/8/3 15:16
 * @Description:
 */
@Component
@Aspect
public class OldBoyAspect {

    @Pointcut("@annotation(com.huc.boot.annotation.OldBoy)")
    private void oldboy() { }

    /**
     * 定制一个环绕通知
     * @param joinPoint
     */
    @Around("oldboy()")
    public void advice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Begin");
        joinPoint.proceed();//执行到这里开始走进来的方法体（必须声明）
        System.out.println("执行业务");
        System.out.println("Around End");
    }

    //当想获得注解里面的属性，可以直接注入改注解
    //方法可以带参数，可以同时设置多个方法用&&
    @Before("oldboy()")
    public void record(JoinPoint joinPoint) {
        System.out.println("Before");
    }

    @After("oldboy()")
    public void after() {
        System.out.println("After");
    }

}
