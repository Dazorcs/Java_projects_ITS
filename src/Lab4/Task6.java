package Lab4;

public class Task6 {
    public static void main(String[] args) {
        int[][] testArrays = {
                {10, 3, 25, 7, 5},      // є кратні 5
                {6, 11, 13, 17},        // немає кратних 5
                {},                     // порожній масив
                null
        };

        for (int[] arr : testArrays) {
            try {
                int result = findMinMultipleOfFive(arr);
                System.out.println("Мінімальний елемент кратний 5: " + result);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    public static int findMinMultipleOfFive(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Масив не може бути null");
        if (arr.length == 0)
            throw new IllegalArgumentException("Масив порожній");

        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                found = true;
                if (arr[i] < min)
                    min = arr[i];
            }
        }

        if (!found)
            throw new IllegalArgumentException("Немає елементів, кратних 5");

        return min;
    }
}
