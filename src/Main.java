import java.util.*;
public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        State st = new State();
        Player player = new Player();
        int seed = 0;
        int score = 0;
        int maxQuestions;
        String question = "";
        ArrayList<String> states = new ArrayList<>();//all the states
        ArrayList<String> capitals = new ArrayList<>(); // all the capitals
        ArrayList<String> questions = new ArrayList<>();//all the questions
        ArrayList<String> answerCapitals = new ArrayList<>();
        ArrayList<Character> answerCharacters = new ArrayList<>(); // all thecharacters that matched the right anser;
        Map<String, String> question_and_answer;
        try {
            states = st.getAllExpressionInstance("//state");//store all states
            capitals = st.getAllExpressionInstance("//capital");// store all capitals
            if (states.size() == capitals.size()) //ensure that you have same number of item in state and capital
                seed = states.size();
            else {
                seed = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        answerCharacters = quiz.getCorrectAnswerChar(); //get all the correct answer
        for (int i = 0; i < seed; i++) {
            question = quiz.generateQuestion(states, capitals, i);
            questions.add(question);
            String correctCapital = quiz.getCorrectCapital();
            answerCapitals.add(correctCapital);
        }
        Scanner scanner = new Scanner(System.in);
        maxQuestions = 9;
        String userInput = "";
        int questionIndex = 0;
        boolean isCorrect = false;
        ArrayList<Integer> wrongAnswers = new ArrayList<>();
        System.out.println("----WELCOME------");
        quiz.askQuizQuestions(quiz, score, userInput, questionIndex, questions, scanner, isCorrect, answerCharacters, wrongAnswers, answerCapitals);
    }
    public static int[] generateRandom(int peak) {
        int[] choice = new int[peak];
        Random random = new Random();
        //obtain from 0 - peak
        ;
        for (int i = 0; i < peak; i++) {
            //c
            for (int j = 0; j < i; j++) {
                choice[i] = random.nextInt(peak);
                if (choice[i] == choice[j]) {
                    choice[i] = random.nextInt(peak);
                }
            }
        }
        return choice;
    }
}
