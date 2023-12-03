package Railway_Reservation_System;

public class Pasanger {
    int pnr ;
    String name;
    String gender;
    int age;
    String preferred_berth;
    String allocated_berth;
    String seat_number;


    public Pasanger( String name, String gender, int age, String preferred_berth) {
        this.pnr = (int)(Math.random()*(9999999-1000000+1)+10000);
        this.name = name;
        this.gender = gender;
        this.age = age;
        allocated_berth = "";
        this.preferred_berth = preferred_berth;
        seat_number = "";
    }
}
