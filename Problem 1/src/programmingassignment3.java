import java.security.SecureRandom;
import java.util.Scanner;

public class programmingassignment3 {
    private static int first = 0;
    private static int second = 0;
    private static int Type = 0;

    private static int Difficulty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter difficulty level. 1: 1 digit numbers, 2: 2 digit numbers, 3: 3 digit numbers, 4: 4 digit numbers.");
        return scan.nextInt();
    }

    private static int Type() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a problem type. 1: addition, 2: multiplication, 3: subtraction, 4: division, 5: a mix of all problems.");
        return scan.nextInt();
    }

    private static String Question(int level) {
        SecureRandom random = new SecureRandom();
        boolean solvable = false;
        if (Type == 5) {
            Type = random.nextInt(3) + 1;
        }

        while (!solvable) {
            if (level == 1) {
                first = random.nextInt(9) + 1;
                second = random.nextInt(9) + 1;
            }
            else if (level == 2) {
                first = random.nextInt(99) + 1;
                second = random.nextInt(99) + 1;
            }
            else if (level == 3) {
                first = random.nextInt(999) + 1;
                second = random.nextInt(999) + 1;
            }
            else if (level == 4) {
                first = random.nextInt(9999) + 1;
                second = random.nextInt(9999) + 1;
            }
            solvable = true;
            if ((Type == 4) && (first % second != 0)) {
                solvable = false;
            }
            else if ((Type == 3) && (first < second)) {
                solvable = false;
            }
        }

        if (Type == 1) {
            return String.format("How much is %d plus %d?", first, second);
        } else if (Type == 2) {
            return String.format("How much is %d times %d?", first, second);
        } else if (Type == 3) {
            return String.format("How much is %d minus %d?", first, second);
        } else  {
            return String.format("How much is %d divided by %d?", first, second);
        }
    }

    private static boolean answer(double input) {
        if (Type == 1) {
            return Double.compare(input,(first + second)) == 0;
        } else if (Type == 2) {
            return Double.compare(input,(first * second)) == 0;
        } else if (Type == 3) {
            return Double.compare(input,(first - second)) == 0;
        } else {
            return Double.compare(input, ((double) first / (double) second)) == 0;
        }
    }

    private static String right() {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(3) + 1;
        String response;

        switch (randomNumber) {
            case 1:
                response = "Very good!";
                break;
            case 2:
                response = "Excellent!";
                break;
            case 3:
                response = "Nice work!";
                break;
            default:
                response = "Keep up the good work!";
                break;
        }
        return response;
    }

    private static String wrong() {
        SecureRandom random = new SecureRandom();
        int randomNumber = random.nextInt(3) + 1;
        String response;
        switch (randomNumber) {
            case 1:
                response = "That is incorrect.";
                break;
            case 2:
                response = "Wrong. Better luck next time.";
                break;
            case 3:
                response = "No, but don’t give up!";
                break;
            default:
                response = "No. Try another question.";
                break;
        }
        return response;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int right = 0;
        int difficulty;
        double input;
        String question;
        boolean quit = false;

        while (!quit) {
            difficulty = Difficulty();
            System.out.println();
            Type = Type();
            for (int i = 1; i <=10; i++) {
                question = Question(difficulty);
                System.out.println(question);

                input = scan.nextDouble();

                if (answer(input)) {
                    System.out.println(right());
                    right++;
                } else {
                    System.out.println(wrong());
                }
                System.out.println();
            }

            System.out.println("Correct answers: " + right);
            System.out.println("Wrong answers: " + (10 - right));
            if (right <= 7) {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            System.out.println();
            right = 0;

            System.out.println("Would you like to start a new session?");
            System.out.println("Enter '1' to continue or '0' to quit.");
            if (scan.next().charAt(0) == '0') {
                quit = true;
            }
        }
    }

}
