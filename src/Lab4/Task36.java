package Lab4;

public class Task36 {
    public static void main(String[] args) {
        int[][] testArrays = {
                {5, 8, 2, 9, 1},     // нормальний
                {7, 7, 7},           // усі рівні
                {1},                 // лише один елемент
                null,                // null
                {}                   // порожній
        };

        for (int[] arr : testArrays) {
            try {
                double result = geometricMeanOfIndexes(arr);
                System.out.println("Середнє геометричне індексів: " + result);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    public static double geometricMeanOfIndexes(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Масив не може бути null");
        if (arr.length < 2)
            throw new IllegalArgumentException("Масив повинен містити принаймні 2 елементи");

        int max = arr[0], min = arr[0];
        int indexMax = 0, indexMin = 0;
        int i = 0;

        for (int val : arr) { // for-each цикл
            if (val > max) {
                max = val;
                indexMax = i;
            }
            if (val < min) {
                min = val;
                indexMin = i;
            }
            i++;
        }

        return Math.sqrt(indexMax * indexMin);
    }
}
