class Printer {
    synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(500); // slow down for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    Printer printer;
    String threadName;

    MyThread(Printer p, String name) {
        printer = p;
        threadName = name;
    }

    public void run() {
        printer.printNumbers(threadName);
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        Printer p = new Printer(); // shared Printer object
        MyThread t1 = new MyThread(p, "Thread-1");
        MyThread t2 = new MyThread(p, "Thread-2");
        t1.start();
        t2.start();
    }
}

