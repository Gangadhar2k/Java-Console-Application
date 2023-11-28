package SchoolManagementSystem;

public class Student {
    private String name;
    private int id;
    private int grade;
    private int feesPaid;
    private int totalFees;
    private int pendingFees;

    public Student(String name, int id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.feesPaid= 0;
        this.totalFees=30000;

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(int feesPaid) {
        this.feesPaid += feesPaid;
        School.setMoneyEarned(feesPaid);
        System.out.println("updated");
    }

    public int getPendingFees() {
        pendingFees = totalFees-feesPaid;
        return pendingFees;
    }

    public String getName() {
        return name;
    }
}
