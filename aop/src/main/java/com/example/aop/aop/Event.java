package com.example.aop.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Event {
    /**
     * 事件id
     *
     * @return
     */
    String eventId();

    /**
     * 事件参数 key
     *
     * @return
     */
    String parameterKey();

    /**
     * 事件参数  value
     *
     * @return
     */
    String parameterValue();
}
