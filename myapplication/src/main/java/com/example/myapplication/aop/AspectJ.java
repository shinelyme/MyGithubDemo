package com.example.myapplication.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author Administrator
 * @createTime 2019/8/19 12:10
 */
@Aspect
public class AspectJ {
    private static final String TAG = "aaaa";

    @Pointcut("execution(@com.example.myapplication.aop.Event * * (..))")
    public void method() {

    }

    @Around("method()")
    public Object aspect(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Event annotation = signature.getMethod().getAnnotation(Event.class);
        String key = annotation.key();
        String value = annotation.value();
        String id = annotation.id();
        Log.e(TAG, "aspect: key:" + key + "  value:" + value + "  id:" + id);
        return joinPoint.proceed();
    }
}
