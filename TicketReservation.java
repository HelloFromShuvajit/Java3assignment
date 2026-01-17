import java.util.ArrayList;
import java.util.List;


public class TicketReservation {
    public static void main(String[] args) 
    {   
                TicketRepository ticketRepo = new TicketRepository();
        ticketRepo.setList();
        TicketBooking booking = new TicketBooking();
        Thread thread1 = new Thread(() -> {
            try {
                booking.ticketbooking(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                booking.ticketbooking(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                booking.ticketbooking(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                booking.ticketbooking(87);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Ticket{
    private int seatNo;
    private boolean seatbooked;
    
    public void ticketSet(int seatNo, boolean seatbooked){
        this.seatNo = seatNo;
        this.seatbooked = seatbooked;
    }
    public void setSeatNo(int i){
        this.seatNo = i;
    }
    public int getSeatNo() {
        return this.seatNo;
    }
    
    public boolean getSeatBooked() {
        return this.seatbooked;    
    }
    public void Setseatbooked(boolean booking){
        this.seatbooked = booking;
    }
    
}
class TicketRepository{
    static List<Ticket> seats = new ArrayList<>();
    public void setList(){
        for(int i=1; i<101;i++){
            Ticket ticket = new Ticket();
            ticket.setSeatNo(i);
            ticket.Setseatbooked(false);
            seats.add(ticket);
        }
    }
    public List<Ticket> getSeatList(){
        return seats;
    }
}
class TicketBooking{
    public synchronized void ticketbooking(int seatNo) throws InterruptedException{
        Thread.sleep(2000);
        boolean flag =false;
        TicketRepository ticketRepo = new TicketRepository();
        List<Ticket> seats = ticketRepo.getSeatList();
        if (seats.isEmpty()) {
            System.out.println("Empty list.");
        }try{

            for (Ticket seat : seats){
                
                int tSeatNo= seat.getSeatNo();
                boolean seatbooked = seat.getSeatBooked();
                if (seatbooked != true && tSeatNo == seatNo) {
                    seat.Setseatbooked(true);
                    flag = true;
                    System.out.println("The seat "+ seatNo+" is booked"); 
                }
            }   
            if (!flag) {
                System.out.println("The seat "+seatNo+" is already booked.");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
