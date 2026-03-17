package lab09_4;

public class Main {
    //внутренний класс, представляющий узел списка
    static class Node {
        int value; //данные узла
        Node next; //ссылка на следующий узел
        
        Node(int value){
            this.value = value;
            }
    }
    public static void main(String[] args) {
        //1. Создание отдельных узлов
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        //2. Построение связей (каждый узел ссылается на следующий)
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        //node3.next уже по умолчанию имеет значение null

        //3. Вывод значений путем обхода списка
        System.out.println("Значения элементов списка: ");
        Node current = node0; //начало с первого узла
        while (current != null){
            System.out.println("value = " + current.value);
            current = current.next; //переход к следующему узлу
        }
    }
}
