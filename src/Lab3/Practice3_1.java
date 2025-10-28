package Lab3;

public class Practice3_1 {
    public static double calculate(int m, int k) {
        if (k <= 0 || k > 30) {
            throw new IllegalArgumentException("k має бути від 1 до 30");
        }
        double sum = 0;
        for (int i = 1; i <= k; i++) {
            double value = m * (1.0 / i) * Math.sin(m * i);
            if (value < 0) {
                throw new IllegalArgumentException("Підкореневий вираз від’ємний при i=" + i);
            }
            sum += Math.sqrt(value);
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Правильний приклад: " + calculate(2, 5));
            System.out.println("Ще приклад: " + calculate(3, 10));
            System.out.println("Некоректний k: " + calculate(2, 40));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
