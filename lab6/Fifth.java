class Counter {
    private int count = 0;

    // synchronized method ensures atomic increment
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;

    CounterThread(Counter c) {
        counter = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Fifth {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join(); // wait for t1 to finish
            t2.join(); // wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}

