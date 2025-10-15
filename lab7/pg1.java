import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Create producer and consumer threads
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Start the threads
        producer.start();
        consumer.start();
    }
}

class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private final int MAX_SIZE = 5;

    // Method to produce items
    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            wait();  // Buffer is full, producer must wait
        }

        buffer.add(item);  // Add the item to the buffer
        System.out.println("Produced: " + item);
        notifyAll();  // Notify the consumer that there is an item available
    }

    // Method to consume items
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();  // Buffer is empty, consumer must wait
        }

        int item = buffer.poll();  // Consume an item from the buffer
        System.out.println("Consumed: " + item);
        notifyAll();  // Notify the producer that there is space available in the buffer
        return item;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);  // Produce 10 items
                Thread.sleep(1000);  // Simulate some time between producing items
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();  // Consume 10 items
                Thread.sleep(1500);  // Simulate some time between consuming items
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
