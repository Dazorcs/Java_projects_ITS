package Lab5;

import java.util.Random;
import java.util.Scanner;

public class Practice5 {

    // Сортування вставкою
    public static void insertionSortDescending(byte[] array) {
        for (int i = 1; i < array.length; i++) {
            byte key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Сортування бульбашкою
    public static void bubbleSortDescending(byte[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    byte temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(byte[] array) {
        for (byte value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static byte[] generateRandomArray(int size) {
        Random rand = new Random();
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) rand.nextInt(100); // випадкові числа 0–99
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Оберіть спосіб створення масиву:");
        System.out.println("1 - Ввести вручну");
        System.out.println("2 - Згенерувати випадково");
        System.out.print("Ваш вибір: ");
        int choice = sc.nextInt();

        byte[] array;

        if (choice == 1) {
            System.out.print("Введіть розмір масиву: ");
            int n = sc.nextInt();
            array = new byte[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Елемент " + (i + 1) + ": ");
                array[i] = sc.nextByte();
            }
        } else {
            System.out.print("Введіть розмір масиву: ");
            int n = sc.nextInt();
            array = generateRandomArray(n);
            System.out.println("Згенерований масив:");
        }

        printArray(array);

        byte[] arrayCopy = array.clone();

        insertionSortDescending(array);
        System.out.println("\nПісля Insertion Sort:");
        printArray(array);

        bubbleSortDescending(arrayCopy);
        System.out.println("\nПісля Bubble Sort:");
        printArray(arrayCopy);

        sc.close();
    }
}
