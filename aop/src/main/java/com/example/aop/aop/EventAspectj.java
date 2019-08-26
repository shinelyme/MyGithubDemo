package com.example.aop.aop;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class EventAspectj {
    private static final String TAG = "aaaaa";

    @Pointcut("execution(@com.example.aop.aop.Event * *(..))")
    public void method() {
    }

    @Around("method()")
    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "jointPoint: ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Event annotation = signature.getMethod().getAnnotation(Event.class);

        Log.e(TAG, "jointPoint: " + "id " + annotation.eventId() + "  key : " + annotation.parameterKey() + "  value : " + annotation.parameterValue());

        SystemClock.sleep(2000);
        return joinPoint.proceed();
    }
}
