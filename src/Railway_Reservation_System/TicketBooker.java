package Railway_Reservation_System;

import java.util.*;

public class TicketBooker {
    static int availableLowerBerths = 1;
    static int availableMiddleBerths = 1;
    static int availableUpperBerths = 1;
    static int availableRAC = 1;
    static int availableWL = 1;


    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    static List<Integer> BookedList = new ArrayList<>();

    static List<Integer> AvailableLowerPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> AvailableMiddlePosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> AvailableUpperPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> AvailableRacPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> AvailableWaitingPosition = new ArrayList<>(Arrays.asList(1));

    static Map<Integer,Pasanger> passengers = new HashMap<>();



    public void ticketBooked (Pasanger p , int berth_No ,String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        BookedList.add(p.pnr);
        System.out.println("-------------------------------Ticket Booked Successfully");
    }

    public void toRAC(Pasanger p,int berth_No , String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        racList.add(p.pnr);
        System.out.println("-------------------------------Ticket Booked Added To RAC");
    }

    public void toWL(Pasanger p,int berth_No , String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        waitingList.add(p.pnr);
        System.out.println("-------------------------------Ticket Booked Added To Waiting List");
    }
}
