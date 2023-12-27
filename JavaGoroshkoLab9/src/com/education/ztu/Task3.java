package com.education.ztu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class CustomClass {
    private int privateField;
    public String publicField;

    public CustomClass() {
    }

    public CustomClass(String publicField) {
        this.publicField = publicField;
    }

    private CustomClass(int privateField) {
        this.privateField = privateField;
    }

    public void publicMethod() {
        System.out.println("Calling publicMethod");
    }

    private void privateMethod(int value) {
        System.out.println("Calling privateMethod with argument: " + value);
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}

public class Task3 {
    public static void main(String[] args) throws Exception {
        Class<?> customClass1 = CustomClass.class;
        Class<?> customClass2 = new CustomClass().getClass();
        Class<?> customClass3 = Class.forName("com.education.ztu.CustomClass");

        System.out.println("Class Fields:");
        printFields(customClass1.getDeclaredFields());

        System.out.println("\nClass Methods:");
        printMethods(customClass1.getDeclaredMethods());

        System.out.println("\nClass Constructors:");
        printConstructors(customClass1.getDeclaredConstructors());

        CustomClass instance = (CustomClass) customClass1.getDeclaredConstructor().newInstance();

        Method publicMethod = customClass1.getDeclaredMethod("publicMethod");
        publicMethod.invoke(instance);

        Field privateField = customClass1.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.setInt(instance, 42);
        System.out.println("\nValue of the private field: " + privateField.getInt(instance));
    }

    private static void printFields(Field[] fields) {
        for (Field field : fields) {
            System.out.println("Name: " + field.getName() + ", Type: " + field.getType());
        }
    }

    private static void printMethods(Method[] methods) {
        for (Method method : methods) {
            System.out.println("Name: " + method.getName() +
                    ", Return Type: " + method.getReturnType() +
                    ", Parameters: " + Arrays.toString(method.getParameterTypes()));
        }
    }

    private static void printConstructors(Constructor<?>[] constructors) {
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor Parameters: " + Arrays.toString(constructor.getParameterTypes()));
        }
    }
}