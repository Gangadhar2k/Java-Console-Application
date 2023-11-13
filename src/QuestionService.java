import java.util.Scanner;

public class QuestionService {

    Question[] question = new Question[5];
    String[] answer = new String[5];

    public QuestionService() {
        question[0] = new Question(1,"what is my Age ","10","20","30","40","20");
        question[1] = new Question(2,"what is my Fav programing language ","C","C++","Java","Js","Js");
        question[2] = new Question(3,"what is my Fav Food","Briyani","Fried Rice","Meals","Capathi","Meals");
        question[3] = new Question(4,"what is Blood Group","O-ve","O+ve","A+ve","B-ve","O-ve");
        question[4] = new Question(5,"what is Phone Brand","Mi","OnePlus","Realme","Iphone","Realme");
    }

    public void display_Question(){
            int i = 0;
        for (Question q: question) {
            System.out.print(q.getId()+". ");
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            System.out.println("Enter Your Answer-------------");
            Scanner sc = new Scanner(System.in);
            answer[i++] = sc.next();
        }
    }

    public void Show_Mark(){

        int count = 0;
        for (int i = 0; i<5; i++) {
            if(answer[i].equals(question[i].getAnswer())){
                count++;
            }
        }
        System.out.println("You Have Scored -------"+count);
    }

}
