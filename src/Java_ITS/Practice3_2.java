package Java_ITS;

public class Practice3_2 {
    public static double calculate(double t, int i) {
        if (t <= 0) {
            throw new IllegalArgumentException("t має бути > 0 (бо використовується ln)");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("i має бути > 0");
        }

        if (i == 1 || i == 2) {
            return Math.log(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Приклад i=1: " + calculate(2.0, 1));
            System.out.println("Приклад i=3: " + calculate(2.0, 3));
            System.out.println("Некоректний t: " + calculate(-1.0, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
