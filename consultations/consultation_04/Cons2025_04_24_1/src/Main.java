public class Main {
    public static void main(String[] args) {
        m(10);

        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));

        System.out.println(factorial(5));
    }

    public static void m(int i) {
        System.out.println("start " + i);

        if (i == 0) {
            System.out.println("    -------------- finish -----------");
            return;
        }

        m(i - 1);

        System.out.println("finish " + i);
    }

    public static void m2(int i) {
        m(i);
    }

    public static long factorial (long i) {
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

//    факториал - 5! = 5 * 4 * 3 * 2 * 1 = 5 * 4!
//                4! = 4 * 3 * 2 * 1 = 4 * 3!
//                 1! = 1 - базовый случай
}