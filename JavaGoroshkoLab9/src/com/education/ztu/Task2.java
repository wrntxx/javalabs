package com.education.ztu;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        String employeesData = "ПІБ: Іванов Іван, Дата народження: 15.01.1990, Посада: розробник, Досвід: 5 років, Адреса: вул. Київська 123, Емайл: ivanov@gmail.com, Телефон: +380991234567\n"
                +
                "ПІБ: Петров Петро, Дата народження: 20.05.1995, Посада: менеджер, Досвід: 3 роки, Адреса: вул. Львівська 456, Емайл: petrov@gmail.com, Телефон: +380992345678\n"
                +
                "ПІБ: Сидорова Марія, Дата народження: 02.11.1993, Посада: аналітик, Досвід: 4 роки, Адреса: вул. Одеська 789, Емайл: sidorova@gmail.com, Телефон: +380993456789\n"
                +
                "ПІБ: Новак Олег, Дата народження: 12.07.1988, Посада: інженер, Досвід: 7 років, Адреса: вул. Харківська 234, Емайл: novak@gmail.com, Телефон: +380994567890\n"
                +
                "ПІБ: Ковальчук Анна, Дата народження: 30.03.1997, Посада: архітектор, Досвід: 2 роки, Адреса: вул. Дніпровська 567, Емайл: kovalchuk@gmail.com, Телефон: +380995678901\n";

        List<String> phoneNumbers = extractPhoneNumbers(employeesData);
        System.out.println("Номери телефонів:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }

        List<String> emails = extractEmails(employeesData);
        System.out.println("\nЕлектронні пошти:");
        for (String email : emails) {
            System.out.println(email);
        }

        String formattedData = formatBirthdates(employeesData);
        System.out.println("\nІнформація зі зміненими форматами відображення дат народження:");
        System.out.println(formattedData);

        String modifiedPositions = modifyPositions(employeesData);
        System.out.println("\nІнформація зі зміненими посадами:");
        System.out.println(modifiedPositions);
    }

    private static List<String> extractPhoneNumbers(String input) {
        List<String> phoneNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\+\\d{12}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }

        return phoneNumbers;
    }

    private static List<String> extractEmails(String input) {
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    private static String formatBirthdates(String input) {
        return input.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
    }

    private static String modifyPositions(String input) {
        return input.replaceAll("Посада: розробник", "Посада: Senior Developer");
    }
}
