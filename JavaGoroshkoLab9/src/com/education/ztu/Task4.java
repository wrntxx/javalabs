package com.education.ztu;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String value() default "Default Value";

    int number() default 42;
}

class MyClass {
    @CustomAnnotation(value = "Custom Value", number = 99)
    public void myAnnotatedMethod() {
        System.out.println("Hello World!!!");
    }
}

public class Task4 {
    public static void main(String[] args) throws Exception {
        Method method = MyClass.class.getMethod("myAnnotatedMethod");

        CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);

        if (customAnnotation != null) {
            System.out.println("Value: " + customAnnotation.value());
            System.out.println("Number: " + customAnnotation.number());
        } else {
            System.out.println("Annotation not present on the method.");
        }
    }
}
