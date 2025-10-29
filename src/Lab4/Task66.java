package Lab4;

import java.util.Random;
import java.util.Scanner;

public class Task66 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Оберіть спосіб створення масивів:");
        System.out.println("1 - Ввести вручну");
        System.out.println("2 - Згенерувати випадково");
        System.out.print("Ваш вибір: ");
        int choice = sc.nextInt();

        int[] A;
        int[] B;

        if (choice == 1) {
            System.out.print("Введіть розмір масивів A та B: ");
            int n = sc.nextInt();

            A = new int[n];
            B = new int[n];

            System.out.println("Введіть елементи масиву A:");
            for (int i = 0; i < n; i++) {
                System.out.print("A[" + i + "] = ");
                A[i] = sc.nextInt();
            }

            System.out.println("Введіть елементи масиву B:");
            for (int i = 0; i < n; i++) {
                System.out.print("B[" + i + "] = ");
                B[i] = sc.nextInt();
            }

        } else if (choice == 2) {
            System.out.print("Введіть розмір масивів: ");
            int n = sc.nextInt();

            A = generateRandomArray(n);
            B = generateRandomArray(n);

            System.out.println("Згенерований масив A:");
            printArray(A);
            System.out.println("Згенерований масив B:");
            printArray(B);
        } else {
            System.out.println("Невірний вибір. Завершення програми.");
            sc.close();
            return;
        }

        try {
            int[] C = mergeArrays(A, B);
            System.out.println("\nОб’єднаний масив C:");
            printArray(C);
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

    }

    public static int[] mergeArrays(int[] A, int[] B) {
        if (A == null || B == null)
            throw new NullPointerException("Масиви не можуть бути null");

        if (A.length != B.length)
            throw new IllegalArgumentException("Масиви повинні мати однакову довжину");

        int n = A.length;
        int[] C = new int[n * 2];

        for (int i = 0; i < n; i++) {
            C[i] = A[i];
            C[n + i] = B[i];
        }

        return C;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

