package lab09_8;

public class Main { // Узел списка
    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    private Node head; // голова
    private Node tail; // хвост

    // ====== А) ИТЕРАТИВНЫЕ МЕТОДЫ ======

    // createHead() – ввод с головы (массива значений) с помощью цикла
    public void createHead(int[] values) {
        head = null;
        tail = null;
        for (int v : values) {
            AddFirst(v);
        }
    }

    // createTail() – ввод с хвоста (массива значений) с помощью цикла
    public void createTail(int[] values) {
        head = null;
        tail = null;
        for (int v : values) {
            AddLast(v);
        }
    }

    // toString() – итеративный вывод
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) sb.append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }

    // AddFirst() – добавление в начало
    public void AddFirst(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    // AddLast() – добавление в конец
    public void AddLast(int value) {
        Node n = new Node(value);
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    /**
     * Insert(index, value) – вставка по номеру (0‑based).
     * index = 0  -> вставка в голову.
     * index > size -> можно бросать исключение или не делать ничего.
     */
    public void Insert(int index, int value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            AddFirst(value);
            return;
        }

        Node prev = head;
        int i = 0;
        while (prev != null && i < index - 1) {
            prev = prev.next;
            i++;
        }
        if (prev == null) {
            throw new IndexOutOfBoundsException();
        }

        Node n = new Node(value);
        n.next = prev.next;
        prev.next = n;
        if (prev == tail) {
            tail = n;
        }
    }

    // RemoveFirst() – удаление головы
    public void RemoveFirst() {
        if (head == null) return;
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // RemoveLast() – удаление хвоста
    public void RemoveLast() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
    }

    /**
     * Remove(index) – удаление по номеру (0‑based).
     */
    public void Remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (head == null) throw new IndexOutOfBoundsException();

        if (index == 0) {
            RemoveFirst();
            return;
        }

        Node prev = head;
        int i = 0;
        while (prev != null && i < index - 1) {
            prev = prev.next;
            i++;
        }
        if (prev == null || prev.next == null) {
            throw new IndexOutOfBoundsException();
        }

        Node toDelete = prev.next;
        prev.next = toDelete.next;
        if (toDelete == tail) {
            tail = prev;
        }
    }

    // ====== Б) РЕКУРСИВНЫЕ МЕТОДЫ ======

    // createHeadRec() – рекурсивный ввод с головы (из массива)
    public void createHeadRec(int[] values) {
        head = null;
        tail = null;
        createHeadRecHelper(values, 0);
    }

    private void createHeadRecHelper(int[] values, int idx) {
        if (idx == values.length) return;
        // сначала обрабатываем хвост массива, а потом вставляем текущий в голову
        createHeadRecHelper(values, idx + 1);
        AddFirst(values[idx]);
    }

    // createTailRec() – рекурсивный ввод с хвоста (из массива)
    public void createTailRec(int[] values) {
        head = null;
        tail = null;
        createTailRecHelper(values, 0);
    }

    private void createTailRecHelper(int[] values, int idx) {
        if (idx == values.length) return;
        AddLast(values[idx]);
        createTailRecHelper(values, idx + 1);
    }

    // toStringRec() – рекурсивный вывод
    public String toStringRec() {
        StringBuilder sb = new StringBuilder();
        toStringRecHelper(head, sb);
        return sb.toString();
    }

    private void toStringRecHelper(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.value);
        if (node.next != null) sb.append(" ");
        toStringRecHelper(node.next, sb);
    }

    // Пример использования
    public static void main(String[] args) {
        Main list = new Main();

        // итеративное создание с хвоста
        list.createTail(new int[]{1, 2, 3});
        System.out.println("Iter: " + list.toString()); // 1 2 3

        list.AddFirst(0);
        list.AddLast(4);
        list.Insert(2, 99); // 0 1 99 2 3 4
        System.out.println("After insert: " + list);

        list.RemoveFirst();   // 1 99 2 3 4
        list.RemoveLast();    // 1 99 2 3
        list.Remove(1);       // 1 2 3
        System.out.println("After removes: " + list);

        // рекурсивное создание с головы
        list.createHeadRec(new int[]{5, 6, 7});
        System.out.println("HeadRec: " + list.toStringRec()); // 7 6 5

        // рекурсивное создание с хвоста
        list.createTailRec(new int[]{8, 9, 10});
        System.out.println("TailRec: " + list.toStringRec()); // 8 9 10
    }
}
