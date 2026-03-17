package lab09_6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Заполняем HashMap 10 объектами <Integer, String>
      HashMap<Integer, String> map = new HashMap<>();
      map.put(0, "Привет");
      map.put(1, "Мир");
      map.put(2, "Java");
      map.put(3, "Программирование");
      map.put(4, "Код");
      map.put(5, "Алгоритм");
      map.put(6, "Структура данных");
      map.put(7, "Коллекция");
      map.put(8, "HashMap");
      map.put(9, "Задание");

      System.out.println("Исходный HashMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        // 2. Найти строки, у которых ключ > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        System.out.println();

        // 3. Если ключ = 0, вывести строки через запятую
        System.out.print("Строки с ключом = 0 (через запятую): ");
        boolean first = true;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(entry.getValue());
                first = false;
            }
        }
        if (first) { // если не нашли ни одной строки с ключом 0
            System.out.print("нет элементов с ключом 0");
        }
        System.out.println();
        System.out.println();

        // 4. Перемножить все ключи, где длина строки > 5
        long product = 1;
        boolean found = false; // флаг, чтобы проверить, были ли ключи с длиной строки > 5

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }
        if (found) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("Нет ключей с длиной строки > 5, произведение не определено.");
        }
    }
}
