class MessageSender {
    // synchronized method to avoid message mixing
    synchronized void sendMessage(String msg) {
        System.out.print("[Sending: ");
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg + "]");
    }
}

class MessageThread extends Thread {
    private MessageSender sender;
    private String message;

    MessageThread(MessageSender s, String msg) {
        sender = s;
        message = msg;
    }

    public void run() {
        sender.sendMessage(message);
    }
}

public class Third {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        MessageThread t1 = new MessageThread(sender, "Hello from Thread-1");
        MessageThread t2 = new MessageThread(sender, "Greetings from Thread-2");

        t1.start();
        t2.start();
    }
}

