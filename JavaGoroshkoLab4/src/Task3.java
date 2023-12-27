public class Task3 {
    public static void main(String[] args) throws Exception {
        int num1 = 4;
        int num2 = 36;

        StringBuilder result = new StringBuilder();
        result.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(result);

        result = new StringBuilder();
        result.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(result);

        result = new StringBuilder();
        result.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(result);

        StringBuilder replacedEquals1 = new StringBuilder(result);
        replacedEquals1.insert(result.indexOf("="), "equals");
        replacedEquals1.deleteCharAt(replacedEquals1.indexOf("="));
        System.out.println(replacedEquals1);

        StringBuilder replacedEquals2 = new StringBuilder(result.toString());
        int index = replacedEquals2.indexOf("=");
        replacedEquals2.replace(index, index + 1, "equals");
        System.out.println(replacedEquals2);

        result.reverse();
        System.out.println(result);

        System.out.println("Length of the string: " + result.length());
        System.out.println("Capacity of the string: " + result.capacity());
    }
}
