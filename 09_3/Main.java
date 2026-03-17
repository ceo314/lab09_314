package lab09_3;
import java.util.Scanner;

public class Main {
        
    public static void inputArray(int[] array, int index, Scanner scanner) {
        // Базовый случай: если индекс достиг длины массива, завершаем рекурсию
        if (index >= array.length) {
            return;
        }
        
        System.out.print("Введите элемент [" + index + "]: ");
        array[index] = scanner.nextInt();
        
        // Рекурсивный вызов для следующего индекса
        inputArray(array, index + 1, scanner);
    }
    
    static void outputArray(int[] array, int index) {
        // Базовый случай: если индекс достиг длины массива, завершаем рекурсию
        if (index >= array.length) {
            return;
        }
        
        System.out.print(array[index] + " ");
        
        // Рекурсивный вызов для следующего индекса
        outputArray(array, index + 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        
        System.out.println("Введите элементы массива:");
        inputArray(array, 0, scanner);
        
        System.out.println("Элементы массива:");
        outputArray(array, 0);
        System.out.println(); // Переход на новую строку
        
        scanner.close();
    }
}
