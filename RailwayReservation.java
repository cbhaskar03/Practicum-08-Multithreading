class TicketBooking {
    String passengerName;

    TicketBooking(String name) {
        passengerName = name;
    }

    void book() {
        System.out.println("Passenger: " + passengerName);
        System.out.println("Booking Status: Confirmed");
        System.out.println("Thread: "
                + Thread.currentThread().getName());
        System.out.println();
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    BookingThread(TicketBooking b) {
        booking = b;
    }

    public void run() {
        booking.book();
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;

    BookingRunnable(TicketBooking b) {
        booking = b;
    }

    public void run() {
        booking.book();
    }
}

public class RailwayReservation {
    public static void main(String[] args)
            throws InterruptedException {

        BookingThread t1 = new BookingThread(
            new TicketBooking("Rahul"));

        Thread t2 = new Thread(
            new BookingRunnable(
                new TicketBooking("Priya")));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
            "All booking requests processed.");
    }
}
