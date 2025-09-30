package Java_ITS;

public class Practice3_3 {

    public static double calculate(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("ε має бути > 0");
        }

        double sum = 0;
        int i = 1;
        while (true) {
            double term = Math.pow(-1, i) / factorial(i);
            if (Math.abs(term) < epsilon) {
                break;
            }
            sum += term;
            i++;
        }
        return sum;
    }

    private static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Факторіал від’ємного числа");
        long fact = 1;
        for (int j = 2; j <= n; j++) {
            fact *= j;
        }
        return fact;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Приклад ε=0.001: " + calculate(0.001));
            System.out.println("Приклад ε=1e-6: " + calculate(1e-6));
            System.out.println("Некоректний ε: " + calculate(0));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
