class TablePrinter {
    // synchronized method ensures one thread prints full table before the other
    synchronized void printTable(String threadName, int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " prints: " + num + " x " + i + " = " + (num * i));
            try {
                Thread.sleep(300); // delay for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---- " + threadName + " finished printing table ----\n");
    }
}

class TableThread extends Thread {
    private TablePrinter printer;
    private String threadName;
    private int number;

    TableThread(TablePrinter p, String name, int num) {
        printer = p;
        threadName = name;
        number = num;
    }

    public void run() {
        printer.printTable(threadName, number);
    }
}

public class SyncTableDemo {
    public static void main(String[] args) {
        TablePrinter printer = new TablePrinter();

        TableThread t1 = new TableThread(printer, "Thread-1", 5);
        TableThread t2 = new TableThread(printer, "Thread-2", 5);

        t1.start();
        t2.start();
    }
}

