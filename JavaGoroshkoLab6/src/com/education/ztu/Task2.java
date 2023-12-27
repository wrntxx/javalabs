package com.education.ztu;

class WrongLoginException extends Exception { }

class WrongPasswordException extends Exception { }

public class Task2 {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException();
            }
            
            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }

            return true;
        } 
        catch (WrongLoginException e) {
            System.out.println("Invalid login format");
            return false;
        }
        catch (WrongPasswordException e) {
            System.out.println("Invalid password format or passwords do not match");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        String validLogin = "user_123";
        String validPassword = "pass_123";

        String invalidLogin = "user@name";
        String invalidPassword = "pass@word";

        System.out.println(checkCredentials(validLogin, validPassword, validPassword) + System.lineSeparator());
        System.out.println(checkCredentials(invalidLogin, validPassword, validPassword)+ System.lineSeparator());
        System.out.println(checkCredentials(validLogin, invalidPassword, invalidPassword)+ System.lineSeparator());
    }
}