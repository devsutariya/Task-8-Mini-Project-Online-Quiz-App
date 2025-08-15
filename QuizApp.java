import java.util.*;

public class QuizApp {

    // Inner class to hold Question details
    static class Question {
        String question;
        List<String> options;
        int correctOption; 

        Question(String question, List<String> options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        int score = 0;

        // Adding questions
        questions.add(new Question(
                "What are Java loops?",
                Arrays.asList("Control statements", "Data types", "Variables", "Classes"),
                1
        ));
        questions.add(new Question(
                "What is enhanced for-loop?",
                Arrays.asList("Loop for arrays/collections", "Loop for numbers", "Loop for methods", "None"),
                1
        ));
        questions.add(new Question(
                "What is ArrayList?",
                Arrays.asList("Resizable array", "Fixed array", "Database", "Loop type"),
                1
        ));

        System.out.println("===== Welcome to Java Quiz App =====");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ". " + q.question);

            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ") " + q.options.get(j));
            }

            int userAnswer = 0;
            boolean validInput = false;

            // Handle invalid inputs
            while (!validInput) {
                try {
                    System.out.print("Enter your choice (1-" + q.options.size() + "): ");
                    userAnswer = Integer.parseInt(scanner.nextLine().trim());

                    if (userAnswer >= 1 && userAnswer <= q.options.size()) {
                        validInput = true;
                    } else {
                        throw new IllegalArgumentException("Choice out of range.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (userAnswer == q.correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctOption + ") " + q.options.get(q.correctOption - 1));
            }
        }

        System.out.println("\n===== Quiz Over =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        scanner.close();
    }
}
