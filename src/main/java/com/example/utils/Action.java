package com.example.utils;

import java.lang.annotation.*;

/**
 * @author youngoo
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String value();
}
