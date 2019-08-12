package com.example.aop.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class EventAspectj {
    private static final String TAG = "aaaaa";

    @Pointcut("execution(@com.example.aop.aop.TraceEvent * *(..))")
    public void method() {
    }

    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "jointPoint: ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Event annotation = signature.getMethod().getAnnotation(Event.class);

        Log.e(TAG, "jointPoint: " + "id " + annotation.eventId() + "  key : " + annotation.parameterKey() + "  value : " + annotation.parameterValue());

        return joinPoint.proceed();
    }
}
