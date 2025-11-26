package Lab6;

public class octStringToInt {

    public static int octStringToInt(String s) {
        if (s == null) {
            throw new NullPointerException("Аргумент не може бути null");
        }

        if (s.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім");
        }

        for (char c : s.toCharArray()) {
            if (c < '0' || c > '7') {
                throw new IllegalArgumentException(
                        "Рядок містить недопустимі символи для вісімкової системи: '" + c + "'"
                );
            }
        }

        int result = 0;
        int power = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            result += digit * Math.pow(8, power);
            power++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Тестування методу octStringToInt ===\n");

        try {
            String test1 = "777";
            int result1 = octStringToInt(test1);
            System.out.println("Тест 1 (коректний): \"" + test1 + "\" -> " + result1);
            System.out.println("Очікувалось: 511\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 1: " + e.getMessage() + "\n");
        }

        try {
            String test2 = "100";
            int result2 = octStringToInt(test2);
            System.out.println("Тест 2 (коректний): \"" + test2 + "\" -> " + result2);
            System.out.println("Очікувалось: 64\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 2: " + e.getMessage() + "\n");
        }

        try {
            String test3 = "7";
            int result3 = octStringToInt(test3);
            System.out.println("Тест 3 (коректний): \"" + test3 + "\" -> " + result3);
            System.out.println("Очікувалось: 7\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 3: " + e.getMessage() + "\n");
        }

        try {
            String test4 = "0";
            int result4 = octStringToInt(test4);
            System.out.println("Тест 4 (коректний): \"" + test4 + "\" -> " + result4);
            System.out.println("Очікувалось: 0\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 4: " + e.getMessage() + "\n");
        }

        try {
            String test5 = "888";
            int result5 = octStringToInt(test5);
            System.out.println("Тест 5 (некоректний): \"" + test5 + "\" -> " + result5 + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 5 (некоректний): \"888\"");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }

        try {
            String test6 = "129";
            int result6 = octStringToInt(test6);
            System.out.println("Тест 6 (некоректний): \"" + test6 + "\" -> " + result6 + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 6 (некоректний): \"129\"");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }

        try {
            String test7 = "";
            int result7 = octStringToInt(test7);
            System.out.println("Тест 7 (некоректний): \"\" -> " + result7 + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 7 (некоректний): порожній рядок");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }

        try {
            String test8 = null;
            int result8 = octStringToInt(test8);
            System.out.println("Тест 8 (некоректний): null -> " + result8 + "\n");
        } catch (NullPointerException e) {
            System.out.println("Тест 8 (некоректний): null");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }

        try {
            String test9 = "7A3";
            int result9 = octStringToInt(test9);
            System.out.println("Тест 9 (некоректний): \"" + test9 + "\" -> " + result9 + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Тест 9 (некоректний): \"7A3\"");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }
    }
}

