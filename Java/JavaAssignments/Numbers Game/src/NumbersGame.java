import java.util.Random;

public class NumbersGame {
    public static void main(String[] args) {
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int counter = 0;
        int answer = new Random().nextInt(0, 10);
        while (true) {
            String guess = System.console().readLine();
            if (guess.equals("q")) {
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }
            if (guess.matches("[a-zA-z]+")) {
                System.out.println("You can only enter a number or q to stop");
            } else if (Integer.parseInt(guess) > 10 || Integer.parseInt(guess) < 0) {
                System.out.println("you can only guess number between 0 and 10");
            } else if (Integer.parseInt(guess) == answer) {
                System.out.println("Lucky guess! But can you do it again?");
                break;
            } else {
                counter++;
                System.out.println("Swing and a miss! Keep trying...");
            }
            if (counter == 3) {
                System.out.println("you tried 3 times and failed you lost");
                System.out.println("want to play again? y/n");
                while (!guess.equalsIgnoreCase("y") && !guess.equalsIgnoreCase("n")) {
                    guess = System.console().readLine();
                    if (!guess.equalsIgnoreCase("y") && !guess.equalsIgnoreCase("n")) {
                        System.out.println("You can only type either 'y' or 'n'.");
                    }
                    if (guess.equalsIgnoreCase("n")) {
                        break;
                    } else {
                        counter = 0;
                        answer = new Random().nextInt(0, 10);
                        System.out.println("a new game has begun");
                        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
                    }
                }

            }
        }
        System.out.println("Game over. Shutting down...");
    }
}