package Railway_Reservation_System;

public class Pasanger {
    int pnr ;
    String name;
    String gender;
    int age;
    String prefered_berth;
    String allocated_berth;
    int seat_number;


    public Pasanger( String name, String gender, int age, String prefered_berth) {
        this.pnr = (int)(Math.random()*(9999999-1000000+1)+10000);;
        this.name = name;
        this.gender = gender;
        this.age = age;
        allocated_berth = "";
        this.prefered_berth = prefered_berth;
        seat_number = -1;
    }
}
