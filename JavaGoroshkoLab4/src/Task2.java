public class Task2 {
    public static void main(String[] args) throws Exception {
        String inputString = "I learn Java!!!";

        char lastChar = inputString.charAt(inputString.length() - 1);
        System.out.println("Last character of the string: " + lastChar);

        boolean endsWithExclamation = inputString.endsWith("!!!");
        System.out.println("Ends with '!!!': " + endsWithExclamation);

        boolean startsWithILearn = inputString.startsWith("I learn ");
        System.out.println("Starts with 'I learn ': " + startsWithILearn);

        boolean containsJava = inputString.contains("Java");
        System.out.println("Contains 'Java': " + containsJava);

        int javaIndex = inputString.indexOf("Java");
        System.out.println("Position of 'Java': " + javaIndex);

        String replacedString = inputString.replace('a', 'o');
        System.out.println("After replacing 'a' with 'o': " + replacedString);

        String upperCaseString = inputString.toUpperCase();
        System.out.println("Uppercase: " + upperCaseString);

        String lowerCaseString = inputString.toLowerCase();
        System.out.println("Lowercase: " + lowerCaseString);

        String trimmedString = inputString.replace("Java", "");
        System.out.println("After trimming 'Java': " + trimmedString);
    }
}

