class TicketBooking {
    private int tickets = 5; // total tickets available

    // synchronized method ensures only one thread can book at a time
    public synchronized void bookTicket(String user, int numTickets) {
        if (tickets >= numTickets) {
            System.out.println(user + " is trying to book " + numTickets + " ticket(s)...");
            try {
                Thread.sleep(500); // simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets -= numTickets;
            System.out.println(user + " successfully booked " + numTickets + " ticket(s).");
            System.out.println("Tickets left: " + tickets + "\n");
        } else {
            System.out.println(user + " tried to book " + numTickets + " ticket(s), but only " + tickets + " left!\n");
        }
    }
}

class UserThread extends Thread {
    private TicketBooking booking;
    private String user;
    private int numTickets;

    UserThread(TicketBooking booking, String user, int numTickets) {
        this.booking = booking;
        this.user = user;
        this.numTickets = numTickets;
    }

    public void run() {
        booking.bookTicket(user, numTickets);
    }
}

public class Fourth {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        // Multiple users trying to book tickets
        UserThread u1 = new UserThread(bookingSystem, "Alice", 2);
        UserThread u2 = new UserThread(bookingSystem, "Bob", 2);
        UserThread u3 = new UserThread(bookingSystem, "Charlie", 2);

        u1.start();
        u2.start();
        u3.start();
    }
}

