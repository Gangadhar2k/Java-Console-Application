package SchoolManagementSystem;
import java.util.ArrayList;
public class School {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private static int moneyEarned;
    private static int moneySpend;

    public School(ArrayList<Student> students, ArrayList<Teacher> teachers) {
        this.students = students;
        this.teachers = teachers;
        this.moneyEarned=0;
        this.moneySpend=0;
    }

    public School(){};
    public void getStudents() {
        System.out.println("Students name:");
        for (Student stu:students) {
            System.out.println(stu.getName());
        }
    }

    public void getTeachers() {
        System.out.println("Teacher Names:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName());
        }
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {

        this.teachers = teachers;
    }

    public static int getMoneyEarned() {
        return moneyEarned;
    }

    public static void setMoneyEarned(int moneyEarned) {
        School.moneyEarned = moneyEarned;
        System.out.println("school earn update");
    }

    public static int getMoneySpend() {
        return moneySpend;
    }

    public static void setMoneySpend(int moneySpend) {
        School.moneySpend = moneySpend;
    }
}
