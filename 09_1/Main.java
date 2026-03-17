package lab09_1;

public class Main {
    //пример 1. Рекурсивный обход с выводом до рекурсивного вызова
    public static void example1() {
        System.out.println("=== Пример 1 ===");
        m1(1);
        System.out.println();
    } 

    private static void m1(int x){
        System.out.println("x= " + x);
        if ((2*x+1)<20){ 
            m1(2*x+1);
        }
    }
    //Пример 2. Рекурсивный обход с выводом после рекурсивного вызова
    public static void example2() { //метод сначала рекурсивно вызывает себя с (2*х+1), пока возможно, а затем выводит текущее х
        System.out.println("=== Пример 2 ===");
        m2(1);
        System.out.println(); //вывод в обратнном порядке  
    } 

    private static void m2(int x){
        if ((2*x+1)<20){ 
            m1(2*x+1);
        }
        System.out.println("x= " + x);
    }
    //Пример 3. Демонстрация входа и выхода с отступами
    private static int step = 0; //счетчик глубины рекурсии для отступов

     public static void example3() { //Метод показывает момент входа в рекурсию и выхода из нее
        System.out.println("=== Пример 3 ===");
        step = 0; //сброс глубины
        m3(1);
        System.out.println();
    } 
    private static void m3(int x){
        space();
        System.out.println(x + "->");
        step ++;
        if ((2*x+1)<20){
            m3(2*x+1);
        }
        step --;
        space();
        System.out.println(x + "<-");
    }
    private static void space(){
        for (int i = 0; i < step; i++){
            System.out.print (" ");
        }
    }
//Пример 4. Рекурсивное вычисление факториала
    public static void example4() { //Метод показывает момент входа в рекурсию и выхода из нее
        System.out.println("=== Пример 4 ===");
        int n = 5;
        int result = factorial(n);
        System.out.println("fact(" + n + ") =" + result);
        System.out.println();
    }
    
    private static int factorial(int n){
        if (n == 1){
            return 1;
        } else{
            return factorial(n - 1)* n;
        }
    }

    //Пример 5. Рекурсивное вычисление чисел Фиббоначи с доп. выводом дерева вызовов.
    //рекурс.выч. для n=5, помимо результат выводится полное дерево рекурс. вызовов с отступами

    public static void example5(){
        System.out.println("=== Пример 5 ===");
        int n = 5;
        step = 0;//использую тот же счетчик для отступов, что и в 3
        int result = fibonacciWithTrace(n);
        System.out.println("fib("+ n +") = " + result);
        System.out.println();
    }

    private static int fibonacciWithTrace(int n) {
        space();
        System.out.println("fib(" + n + ") ->");
        step++;

        int res;
        switch (n) {
            case 0:
                res = 0;
                break;
            case 1:
                res = 1;
                break;
            default:
                //сначала вычисляем fib(n-2), затем fib(n-1)
                int f1 = fibonacciWithTrace(n-2);
                int f2 = fibonacciWithTrace(n-1);
                res = f1 + f2;
                break;
        }
        step--;
        space();
        System.out.println("fib(" + n + ") <- =" + res);
        return res;
    }

    //Запуск всех примеров

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }
}
