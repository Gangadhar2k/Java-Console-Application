package SchoolManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Student> stu = new ArrayList<>();
        ArrayList<Teacher> teach = new ArrayList<>();
        School sc = new School(stu,teach);


        boolean condition = true;
        while(condition){
            System.out.println("----------------Welcome to School Management System-----------------------");
            System.out.println("1.Get Student List\n2.Get Teachers List\n3.Add Student\n4.Add Teacher\n5.Pay Fee\n6.Show Pending Fee Of Student\n7.Total Money Earned By School\n8.Exit");
            System.out.println("Enter Your Option(Number)----------");
            int option = in.nextInt();
            switch (option){
                case 1:{
                    System.out.println("--------------Student List of Your School-----------------");
                    sc.getStudents();
                    break;
                }
                case 2:{
                    System.out.println("--------------Teacher List of Your School-----------------");
                    sc.getTeachers();
                    break;

                }
                case 3:{
                    System.out.println("Enter Student Details-----------");
                    System.out.println("Name----------");
                    String name = in.next();
                    System.out.println("Enter The Grade------------");
                    int grade = in.nextInt();
                    int id = (int)(Math.random()*(9999-1000+1)+1000);
                    Student student = new Student(name,id,grade);
                    stu.add(student);
                    sc.setStudents(stu);
                    System.out.println("Student unique Id---------->"+id);
                    System.out.println("----------------Student Added SuccessFully------------------");
                    break;

                }
                case 4:{
                    System.out.println("Enter Teacher Details-----------");
                    System.out.println("Name----------");
                    String name = in.next();
                    System.out.println("Enter The Salary------------");
                    int grade = in.nextInt();
                    int id = (int)(Math.random()*(9999-1000+1)+1000);
                    Teacher teacher = new Teacher(name,id,grade);
                    teach.add(teacher);
                    sc.setTeachers(teach);
                    System.out.println("Teacher unique Id---------->"+id);
                    System.out.println("----------------Teacher Added SuccessFully------------------");
                    break;

                }
                case 5:{
                    System.out.println("--------------- Wellcome to Fees Section---------------");
                    System.out.println("Enter Student Name--------------");
                    String name = in.next();
                    System.out.println("Enter student Id----------------");
                    int id = in.nextInt();
                    System.out.println("Enter a student grade------------");
                    int grade= in.nextInt();
                    break;
                }
                case 6:{
                }
                case 7:{
                    System.out.println("--------------Total Money Earned By School--------------------");
                    System.out.println(School.getMoneyEarned());
                    break;

                }
                default:{
                    System.out.println("-----------Thank You Visit Again--------------");
                    condition = false;
                    break;
                }
            }
        }
    }
}
