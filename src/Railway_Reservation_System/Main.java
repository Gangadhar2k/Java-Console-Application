package Railway_Reservation_System;


import java.util.Scanner;

public class Main {


    public static void bookTicket(Pasanger p){

        TicketBooker booker = new TicketBooker();

        if(booker.availableWL == 0){
            System.out.println("Ticket Not Available!!!");
            return;
        }
        System.out.println(p.preferred_berth);
        if(p.preferred_berth.equals("U") && booker.availableUpperBerths > 0 ||
                p.preferred_berth.equals("L") && booker.availableLowerBerths > 0 ||
                p.preferred_berth.equals("M") && booker.availableMiddleBerths > 0 )
        {

                    if(p.preferred_berth.equals("L")){
                        System.out.println("Lower Berth is Given");
                        booker.ticketBooked(p,booker.AvailableLowerPosition.get(0),"L");
                        booker.AvailableLowerPosition.remove(0);
                        booker.availableLowerBerths--;
                    }
                    else if (p.preferred_berth.equals("M")) {
                        System.out.println("Middle Berth is Given");
                        booker.ticketBooked(p,booker.AvailableMiddlePosition.get(0),"M");
                        booker.AvailableMiddlePosition.remove(0);
                        booker.availableMiddleBerths--;
                    }
                    else if (p.preferred_berth.equals("U")) {
                        System.out.println("Upper Berth is Given");
                        booker.ticketBooked(p,booker.AvailableUpperPosition.get(0),"U");
                        booker.AvailableUpperPosition.remove(0);
                        booker.availableUpperBerths--;
                    }

        }
        //                preferred is Not Available Book Available

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
            booker.availableRAC--;
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


    public static void cancelTicket(int pnr){

        TicketBooker booker = new TicketBooker();

        if( !(booker.BookedList.contains(pnr) || booker.racList.contains(pnr) || booker.waitingList.contains(pnr))){
            System.out.println("-------------Invalid PNR Number!!!------------------------");
            return;
        }
        else{
            Pasanger repasanger = booker.passengers.get(pnr);
            if(booker.BookedList.contains(pnr)){
                booker.BookedList.remove(""+pnr);
                String allBerth = repasanger.allocated_berth;
                if(allBerth.equals("U")){
                    booker.availableUpperBerths++;
                    String seat_Num =repasanger.seat_number;
                    booker.AvailableUpperPosition.add(seat_Num);

                } else if (allBerth.equals("L")) {
                    booker.availableLowerBerths++;
                    String seat_Num =repasanger.seat_number;
                    booker.AvailableLowerPosition.add(seat_Num);
                } else if (allBerth.equals("M")) {
                    booker.availableMiddleBerths++;
                    String seat_Num =repasanger.seat_number;
                    booker.AvailableMiddlePosition.add(seat_Num);
                }

            }
            else if(booker.racList.contains(pnr)){
                booker.racList.remove(""+pnr);
                booker.availableRAC++;
                String seat_Num =repasanger.seat_number;
                booker.AvailableRacPosition.add(seat_Num);
            }
            else if(booker.waitingList.contains(pnr)){
                booker.waitingList.remove(""+pnr) ;
                booker.availableWL++;
                String seat_Num =repasanger.seat_number;
                booker.AvailableWaitingPosition.add(seat_Num);
            }
            booker.passengers.remove(pnr);
            booker.reArrangeAfterCancel();
        }


    }



    public static void showAvailableTickets(){
        TicketBooker booker = new TicketBooker();
        System.out.println("*************************************************************************");
        System.out.println("              Available Upper Berths   :"+booker.availableUpperBerths);
        System.out.println("              Available Middle Berths  :"+booker.availableMiddleBerths);
        System.out.println("              Available Lower Berths   :"+booker.availableLowerBerths);
        System.out.println("              Available RAC            :"+booker.availableRAC);
        System.out.println("              Available Waiting list   :"+booker.availableWL);
        System.out.println("*************************************************************************");
    }
    
    


    public static void main(String[] args) {
        boolean condition = true;
        Scanner in = new Scanner(System.in);
        while (condition){
            System.out.println("--------------Welcome To Railway Reservation System--------------------");
            System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.Print Available Ticket\n4.Print Booked Ticket\n5.Exit");
            System.out.print("Enter option------------------------->");
            int option = in.nextInt();

            switch (option){
                case 1:{
                    System.out.println("------------------Enter Details To Book Ticket-----------------");
                    System.out.print("Name---------------->");
                    String name = in.next();
                    System.out.print("Gender-------------->");
                    String gender =in.next();
                    System.out.print("Age----------------->");
                    int age = in.nextInt();
                    System.out.print("Berth Preference(U, M, L)------------->");
                    String berthPreference = in.next();

                    Pasanger p = new Pasanger(name,gender,age,berthPreference.toUpperCase());
                    bookTicket(p);
                    break;
                }
                case 2:{
                    System.out.println("----------------cancel Ticket---------------");
                    System.out.print("Enter your PNR: ");
                    int cancelPnr = in.nextInt();
                    cancelTicket(cancelPnr);
                    break;
                }
                case 3:{
                    System.out.println("---------------------Available Ticket---------------------");
                    showAvailableTickets();
                    break;
                }
                case 4:{
                    System.out.println("---------------------Booked Ticket------------------------");
                    TicketBooker booker = new TicketBooker();
                    booker.showBookedTickets();
                    break;
                }
                default:{
                    System.out.println("-------------ThankYou Visit Again----------------------");
                    condition = false;
                    break;
                }
            }
        }
    }
}
