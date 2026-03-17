package lab09_5;

public class Main2 {
    public static void main(String[] args) {
        //Создание списка с хвоста
        //1.Инициализация - список пуст
        Node head = null;
        Node tail = null;

        // 2. Добавляем элементы 0..9 в конец списка
        for (int i = 0; i <= 9; i++) {
            Node newNode = new Node(i); // новый узел

            if (head == null) { // если список пуст
                head = newNode; // новый узел становится и головой, и хвостом
                tail = newNode;
            } else {
                // Прицепили новый узел к хвосту
                tail.next = newNode;
                // Установили ссылку назад: новый узел ссылается на старый хвост
                newNode.prev = tail;
                // Обновили хвост — теперь это новый узел
                tail = newNode;
            }
        }

        // 3. Вывод списка с хвоста (в обратном порядке)
        System.out.print("Список (с хвоста): ");
        Node ref = tail; // начинаем с хвоста
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.prev; // двигаемся к предыдущему узлу
        }
        System.out.println();
    }
}
