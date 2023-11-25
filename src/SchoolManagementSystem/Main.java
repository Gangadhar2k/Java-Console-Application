package SchoolManagementSystem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Student aravind = new Student("Aravind",1,5);
        Student ganga = new Student("Gangadhar",2,12);
        Student stive = new Student("stive",3,7);
        ArrayList<Student> stu = new ArrayList<>();
        stu.add(ganga);
        stu.add(aravind);
        stu.add(stive);

        aravind.setFeesPaid(2000);
        System.out.println("pending fee :"+aravind.getPendingFees());
        Teacher arun = new Teacher("arun",1,2000);
        ArrayList<Teacher> teach = new ArrayList<>();
        teach.add(arun);
        School sc = new School(stu,teach);
        sc.getTeachers();
        sc.getStudents();
        System.out.println("Total Money Earned:"+ School.getMoneyEarned());

    }
}
