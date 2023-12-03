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


    static List<String> AvailableLowerPosition = new ArrayList<>(Arrays.asList("L1","L2","L3"));
    static List<String> AvailableMiddlePosition = new ArrayList<>(Arrays.asList("M1","M2","M3"));
    static List<String> AvailableUpperPosition = new ArrayList<>(Arrays.asList("U1","U2","U3"));
    static List<String> AvailableRacPosition = new ArrayList<>(Arrays.asList("RAC1","RAC2","RAC3"));
    static List<String> AvailableWaitingPosition = new ArrayList<>(Arrays.asList("WL1","WL2","WL3"));

    static Map<Integer,Pasanger> passengers = new HashMap<>();



    public void ticketBooked (Pasanger p , String berth_No ,String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        BookedList.add(p.pnr);
        System.out.println("-----------Your PNR Number :"+p.pnr+"--------------------");
        System.out.println("-------------------------------Ticket Booked Successfully");
    }

    public void toRAC(Pasanger p,String berth_No , String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        racList.add(p.pnr);
        System.out.println("-----------Your PNR Number :"+p.pnr+"--------------------");
        System.out.println("-------------------------------Ticket Booked Added To RAC");
    }

    public void toWL(Pasanger p,String berth_No , String allocated_berth){
        p.seat_number = berth_No;
        p.allocated_berth = allocated_berth;
        passengers.put(p.pnr,p);
        waitingList.add(p.pnr);
        System.out.println("-----------------Your PNR Number :"+p.pnr+"-----------------------");
        System.out.println("-------------------------------Ticket Booked Added To Waiting List");
    }


    public static void reArrangeAfterCancel(){

        if(availableLowerBerths > 0 || availableMiddleBerths > 0 || availableUpperBerths > 0){
          if(!racList.isEmpty())
          {
              int firstRAC = racList.poll();
              if(availableWL == 0){
                  availableWL++;
              }
              Pasanger pasanger = passengers.get(firstRAC);
              String name = pasanger.name;
              String gender = pasanger.gender;
              int age = pasanger.age;
              String berthPreference = pasanger.preferred_berth;
              passengers.remove(pasanger.pnr);
              Pasanger p = new Pasanger(name, gender, age, berthPreference.toUpperCase());
              Main main = new Main();
              main.bookTicket(p);
              moveToRac();
          }
        }
        else if(availableRAC > 0){
            moveToRac();
        }

    }

    public static void moveToRac(){
        if(!waitingList.isEmpty())
        {
            int firstWl = waitingList.poll();
            Pasanger pasanger = passengers.get(firstWl);
            String name = pasanger.name;
            String gender = pasanger.gender;
            int age = pasanger.age;
            String berthPreference = pasanger.preferred_berth;
            passengers.remove(pasanger.pnr);
            Pasanger p = new Pasanger(name, gender, age, berthPreference.toUpperCase());
            Main main = new Main();
            main.bookTicket(p);
        }
    }

    public static void showBookedTickets(){
            if(passengers.isEmpty())
            {
                System.out.println("No details of passengers");
                return;
            }

        for (Pasanger  pas: passengers.values()) {
            System.out.println("****************************************************************");
            System.out.println("                    Name   : "+pas.name);
            System.out.println("                    Gender : "+pas.gender);
            System.out.println("                    Age    : "+pas.age);
            System.out.println("                    PNR    : "+pas.pnr);
            System.out.println("                    Seat No: "+pas.seat_number);
            System.out.println("                    Berth  : "+pas.allocated_berth);
            System.out.println("****************************************************************");

        }
//        System.out.println(passengers.values());
    }
}
