package Lab4;

public class Task66 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};

        try {
            int[] C = mergeArrays(A, B);
            System.out.print("Об’єднаний масив C: ");
            for (int x : C) {
                System.out.print(x + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }


        try {
            mergeArrays(null, new int[]{1, 2});
        } catch (Exception e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
    }

    public static int[] mergeArrays(int[] A, int[] B) {
        if (A == null || B == null)
            throw new NullPointerException("Масиви не можуть бути null");

        int n = A.length;
        int m = B.length;
        int[] C = new int[n + m];

        for (int i = 0; i < n; i++) {
            C[i] = A[i];
        }

        for (int i = 0; i < m; i++) {
            C[n + i] = B[i];
        }

        return C;
    }
}

