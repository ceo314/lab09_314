package lab09_7;

import java.util.LinkedList;
import java.util.List;

public class Mainlink {
    public static int solveWithLinkedList(int n) {
        List<Integer> people = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {      // Заполняем список номерами людей от 1 до N
            people.add(i);
        }
        
        int currentIndex = 0;
        while (people.size() > 1) {         // Пока остаётся больше одного человека
            currentIndex = (currentIndex + 1) % people.size();// Вычисляем индекс следующего человека для удаления
            people.remove(currentIndex);// Удаляем человека по текущему индексу
        }
        return people.get(0); // Возвращаем номер оставшегося человека
    }
    
    public static void main(String[] args) {
        int n = 10000; // Примерное количество людей
        long startTime = System.nanoTime();
        int result = solveWithLinkedList(n);
        long endTime = System.nanoTime();
        
        System.out.println("С LinkedList: остался человек №" + result);
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }
}
