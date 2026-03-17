package lab09_5;

public class Main1 {
    public static void main(String[] args) {
        //Создание списка с головы
        //1. Начальное состояние
        Node head = null;
        
        //2. Добавил элементы 0..9 с головы, но чтобы получить порядок 0,1,2,..9 добавил с 9 до 0
        for(int i = 9; i>=0; i--){
            head = new Node(i,head); //новый узел, next - старая голова
        }
        System.out.print("Список (с головы): ");
        Node ref = head;
        while (ref != null){
            System.out.print(" " +ref.value);
            ref = ref.next;
        }
        System.out.println();
    }
}
