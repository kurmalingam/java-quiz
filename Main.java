import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;
    String feedback;

    public Question(String questionText, String[] options, int correctAnswer, String feedback) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.feedback = feedback;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        for (Question q : questions) {
            System.out.println(q.questionText);
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i + 1) + ". " + q.options[i]);
            }
            System.out.println("Please choose an option:");
            int answer = sc.nextInt();
            if (answer == q.correctAnswer) {
                score++;
                System.out.println("Correct! " + q.feedback);
            } else {
                System.out.println("Incorrect. " + q.feedback);
            }
        }
        System.out.println("Your score: " + score);
        if (score == questions.size()) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Better luck next time");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the online quiz!");
        System.out.println("Please enter 'go' to start the quiz:");
        String st = sc.next();

        if (st.equalsIgnoreCase("go")) {
            Quiz quiz = new Quiz();
            quiz.addQuestion(new Question(
                    "Java is based on which concept?",
                    new String[]{"Object-oriented programming", "Procedural programming", "Both", "None"},
                    1,
                    "Java is based on object-oriented programming."
            ));
            quiz.addQuestion(new Question(
                    "Which class is used to take input from the users?",
                    new String[]{"Scanner", "Util", "String", "Import"},
                    1,
                    "The Scanner class is used to take input from users."
            ));
            quiz.addQuestion(new Question(
                    "Which keyword is used for creating an object for a given class?",
                    new String[]{"Static", "System", "Scanner", "Public"},
                    4,
                    "The 'new' keyword is used to create an object of a class, but here, 'public' is required for class access."
            ));
            quiz.addQuestion(new Question(
                    "Which keyword is used when a child class inherits the properties from their parent class?",
                    new String[]{"This", "Extends", "Throw", "Catch"},
                    2,
                    "The 'extends' keyword allows a child class to inherit properties from a parent class."
            ));
            quiz.addQuestion(new Question(
                    "Which keyword returns the value from a class?",
                    new String[]{"Return", "Called", "Throw", "Catch"},
                    1,
                    "The 'return' keyword is used to return a value from a method."
            ));
            quiz.addQuestion(new Question(
                    "Which data type is used to represent true or false?",
                    new String[]{"Integer", "Boolean", "Float", "Character"},
                    2,
                    "The 'boolean' data type is used to represent true or false values."
            ));
            quiz.addQuestion(new Question(
                    "Which data structure follows LIFO (Last In, First Out)?",
                    new String[]{"Queue", "LinkedList", "Stack", "Trees"},
                    3,
                    "The 'stack' data structure follows the Last In, First Out (LIFO) principle."
            ));
            quiz.start();
        } else {
            System.out.println("Please enter the word 'go' to start the quiz");
        }
    }
}
