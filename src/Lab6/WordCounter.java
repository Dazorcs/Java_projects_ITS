package Lab6;

public class WordCounter {

    public static int countWords(String sentence) {
        // Перевірка на null
        if (sentence == null) {
            throw new NullPointerException("Аргумент не може бути null");
        }

        if (sentence.isEmpty()) {
            return 0;
        }

        int wordCount = 0;
        boolean inWord = false;

        for (char c : sentence.toCharArray()) {
            boolean isWordChar = (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9');

            if (isWordChar) {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        return wordCount;
    }


    public static int countWordsWithSplit(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Аргумент не може бути null");
        }

        if (sentence.isEmpty()) {
            return 0;
        }

        String[] words = sentence.split("[^a-zA-Z0-9]+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Тестування методу countWords ===\n");

        try {
            String test1 = "The user with the nickname koala757677 this month left 3 times more " +
                    "comments than the user with the nickname croco181dile181920 4 months ago";
            int result1 = countWords(test1);
            int result1Alt = countWordsWithSplit(test1);
            System.out.println("Тест 1 (приклад з завдання):");
            System.out.println("Речення: \"" + test1 + "\"");
            System.out.println("Результат (метод 1): " + result1);
            System.out.println("Результат (метод 2): " + result1Alt);
            System.out.println("Очікувалось: 19\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 1: " + e.getMessage() + "\n");
        }

        try {
            String test2 = "Hello world 123";
            int result2 = countWords(test2);
            System.out.println("Тест 2 (просте речення):");
            System.out.println("Речення: \"" + test2 + "\"");
            System.out.println("Результат: " + result2);
            System.out.println("Очікувалось: 3\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 2: " + e.getMessage() + "\n");
        }

        try {
            String test3 = "abc123 def456 789";
            int result3 = countWords(test3);
            System.out.println("Тест 3 (цифри та літери):");
            System.out.println("Речення: \"" + test3 + "\"");
            System.out.println("Результат: " + result3);
            System.out.println("Очікувалось: 3\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 3: " + e.getMessage() + "\n");
        }

        try {
            String test4 = "Hello,,,world!!!How...are###you???123";
            int result4 = countWords(test4);
            System.out.println("Тест 4 (багато розділових знаків):");
            System.out.println("Речення: \"" + test4 + "\"");
            System.out.println("Результат: " + result4);
            System.out.println("Очікувалось: 5\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 4: " + e.getMessage() + "\n");
        }

        try {
            String test5 = "";
            int result5 = countWords(test5);
            System.out.println("Тест 5 (порожній рядок):");
            System.out.println("Речення: \"\"");
            System.out.println("Результат: " + result5);
            System.out.println("Очікувалось: 0\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 5: " + e.getMessage() + "\n");
        }

        try {
            String test6 = "   !!!  ???  ...   ";
            int result6 = countWords(test6);
            System.out.println("Тест 6 (тільки розділові знаки):");
            System.out.println("Речення: \"" + test6 + "\"");
            System.out.println("Результат: " + result6);
            System.out.println("Очікувалось: 0\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 6: " + e.getMessage() + "\n");
        }

        try {
            String test7 = "HelloWorld123";
            int result7 = countWords(test7);
            System.out.println("Тест 7 (одне слово):");
            System.out.println("Речення: \"" + test7 + "\"");
            System.out.println("Результат: " + result7);
            System.out.println("Очікувалось: 1\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 7: " + e.getMessage() + "\n");
        }

        try {
            String test8 = null;
            int result8 = countWords(test8);
            System.out.println("Тест 8 (некоректний): null -> " + result8 + "\n");
        } catch (NullPointerException e) {
            System.out.println("Тест 8 (некоректний): null");
            System.out.println("Очікувана помилка: " + e.getMessage() + "\n");
        }

        try {
            String test9 = "123 456 789";
            int result9 = countWords(test9);
            System.out.println("Тест 9 (тільки цифри):");
            System.out.println("Речення: \"" + test9 + "\"");
            System.out.println("Результат: " + result9);
            System.out.println("Очікувалось: 3\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 9: " + e.getMessage() + "\n");
        }

        try {
            String test10 = "ABC def GHI123 jkl456MNO";
            int result10 = countWords(test10);
            System.out.println("Тест 10 (різні регістри):");
            System.out.println("Речення: \"" + test10 + "\"");
            System.out.println("Результат: " + result10);
            System.out.println("Очікувалось: 4\n");
        } catch (Exception e) {
            System.out.println("Помилка в тесті 10: " + e.getMessage() + "\n");
        }
    }
}