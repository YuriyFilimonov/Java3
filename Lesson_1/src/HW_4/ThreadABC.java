package HW_4;

public class ThreadABC extends Thread {
    private volatile char currentLetter = 'A';

    public synchronized void symbolA() {
        try {
            for (int i = 0; i < 3; i++) {
                while (currentLetter != 'A') {
                    wait();
                }
                System.out.println("A");
                currentLetter = 'B';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void symbolB() {
        try {
            for (int i = 0; i < 3; i++) {
                while (currentLetter != 'B') {
                    wait();
                }
                System.out.println("B");
                currentLetter = 'C';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void symbolC() {
        try {
            for (int i = 0; i < 3; i++) {
                while (currentLetter != 'C') {
                    wait();
                }
                System.out.println("C");
                currentLetter = 'A';
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
