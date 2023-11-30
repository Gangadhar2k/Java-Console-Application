package Railway_Reservation_System;


import java.util.Scanner;

public class Main {


    public static void bookTicket(Pasanger p){

        TicketBooker booker = new TicketBooker();

        if(booker.availableWL == 0){
            System.out.println("Ticket Not Available!!!");
            return;
        }
        System.out.println(p.prefered_berth);
        if(p.prefered_berth.equals("U") && booker.availableUpperBerths > 0 ||
                p.prefered_berth.equals("L") && booker.availableLowerBerths > 0 ||
                p.prefered_berth.equals("M") && booker.availableMiddleBerths > 0 )
        {

                    if(p.prefered_berth.equals("L")){
                        System.out.println("Lower Berth is Given");
                        booker.ticketBooked(p,booker.AvailableLowerPosition.get(0),"L");
                        booker.AvailableLowerPosition.remove(0);
                        booker.availableLowerBerths--;
                    }
                    else if (p.prefered_berth.equals("M")) {
                        System.out.println("Middle Berth is Given");
                        booker.ticketBooked(p,booker.AvailableMiddlePosition.get(0),"M");
                        booker.AvailableMiddlePosition.remove(0);
                        booker.availableMiddleBerths--;
                    }
                    else if (p.prefered_berth.equals("U")) {
                        System.out.println("Upper Berth is Given");
                        booker.ticketBooked(p,booker.AvailableUpperPosition.get(0),"U");
                        booker.AvailableUpperPosition.remove(0);
                        booker.availableUpperBerths--;
                    }

        }
        //                    prefered is Not Available Book Avalable

        else if(booker.availableLowerBerths > 0)
        {
            System.out.println("Lower Berth is Given");
            booker.ticketBooked(p,booker.AvailableLowerPosition.get(0),"L");
            booker.AvailableLowerPosition.remove(0);
            booker.availableLowerBerths--;
        }
        else if (booker.availableMiddleBerths > 0)
        {
            System.out.println("Middle Berth is Given");
            booker.ticketBooked(p,booker.AvailableMiddlePosition.get(0),"M");
            booker.AvailableMiddlePosition.remove(0);
            booker.availableMiddleBerths--;
        }
        else if (booker.availableUpperBerths > 0)
        {
            System.out.println("Upper Berth is Given");
            booker.ticketBooked(p,booker.AvailableUpperPosition.get(0),"U");
            booker.AvailableUpperPosition.remove(0);
            booker.availableUpperBerths--;
        }
//                    seats Not Available Move to Rac
        else if (booker.availableRAC > 0)
        {
            System.out.println("RAC is Given");
            booker.toRAC(p,booker.AvailableRacPosition.get(0),"RAC");
            booker.AvailableRacPosition.remove(0);
            booker.availableWL--;
        }

//                    move to Waiting List
        else if (booker.availableWL > 0)
        {
            System.out.println("Added To Waiting List");
            booker.toWL(p,booker.AvailableWaitingPosition.get(0),"WL");
            booker.AvailableWaitingPosition.remove(0);
            booker.availableWL--;
        }

    }



    public static void showAvailableTickets(){
        TicketBooker booker = new TicketBooker();
        System.out.println("Available Upper Berths  :"+booker.availableUpperBerths);
        System.out.println("Available Middle Berths :"+booker.availableMiddleBerths);
        System.out.println("Available Lower Berths  :"+booker.availableLowerBerths);
        System.out.println("Available RAC           :"+booker.availableRAC);
        System.out.println("Available Waitinglist   :"+booker.availableWL);
    }

    public static void main(String[] args) {
        boolean condition = true;
        Scanner in = new Scanner(System.in);
        while (condition){
            System.out.println("--------------Wellcome To Railway Reservaition System--------------------");
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Print Available Ticket\n4.Print Booked Ticket\n5.Exit");
            System.out.print("Enter option------------------------->");
            int option = in.nextInt();

            switch (option){
                case 1:{
                    System.out.println("------------------Enter Details To Book Ticket-----------------");
                    System.out.print("Name------------->");
                    String name = in.next();
                    System.out.print("Gender-------------->");
                    String gender =in.next();
                    System.out.print("Age--------------->");
                    int age = in.nextInt();
                    System.out.print("Berth Preference(U, M, L)------------->");
                    String berthPrefernce = in.next();

                    Pasanger p = new Pasanger(name,gender,age,berthPrefernce.toUpperCase());
                    bookTicket(p);
                    break;
                }
                case 2:{
                    System.out.println("cancel Ticket");
                    break;
                }
                case 3:{
                    System.out.println("---------------------Available Ticket---------------------");
                    showAvailableTickets();
                    break;
                }
                case 4:{
                    System.out.println("Print Booked Ticket");
                    break;
                }
                default:{
                    System.out.println("-------------ThankYou Visit Again----------------------");
                    break;
                }
            }
        }
    }
}
