package lab09_2;

import java.util.Scanner;

public class Main {
    
    public static void convertToBinary(int n) {
        // Базовый случай: если число равно 0 или 1, выводим его
        if (n <= 1) {
            System.out.print(n);
            return;
        }
        
        // Рекурсивный вызов для n / 2 (целая часть от деления)
        convertToBinary(n / 2);
        
        // После возврата из рекурсии выводим остаток от деления на 2
        System.out.print(n % 2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.print("-");
            convertToBinary(-number);
        } else if (number == 0) {
            System.out.print("0");
        } else {
            convertToBinary(number);
        }
        
        System.out.println();
        scanner.close();
    }
}
