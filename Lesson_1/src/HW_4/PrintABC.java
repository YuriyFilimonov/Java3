package HW_4;

public class PrintABC {
    public static void main(String[] args) {
        ThreadABC threadABC = new ThreadABC();
        Thread t1 = new Thread(threadABC::symbolA);
        Thread t2 = new Thread(threadABC::symbolB);
        Thread t3 = new Thread(threadABC::symbolC);
        t1.start();
        t2.start();
        t3.start();
    }
}
