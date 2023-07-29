import java.util.Scanner;
import java.util.Random;

public class numberguessinggame
{
    public static void main(String[] args) {
        Scanner = new Scanner(System.in);
        Random = new Random();

        int starting = 1;
        int ending = 100;
        int maxchance = 10;
        int Rounds = 0;
        int numchance = 0;

        boolean playAgain = true;

        while (playAgain) {
            Rounds++;
            int number = generateRandomNumber(starting, ending, random);
            System.out.println("== Round " + Rounds + " ==");

            int attempts = playGame(number, maxchance, scanner);
            numchance += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Total rounds played: " + Rounds);
        System.out.println("Total attempts taken: " + numchance);
        System.out.println("Average attempts per round: " + ((double) numchance / Rounds));
    }

    private static int generateRandomNumber(int start, int end, Random random) {
        return random.nextInt(end - start + 1) + start;
    }

    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            return getUserGuess(scanner);
        }
    }

    private static int playGame(int number, int maxchance, Scanner scanner) {
        int attempts = 0;

        while (attempts < maxchance) {
            int userGuess = getUserGuess(scanner);
            attempts++;

            String result = compareguess(number, userGuess);
            System.out.println(result);

            if (result.equals("Correct")) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + number + ".");
        return attempts;
    }

    private static String compareguess(int number, int userguess) {
        if (userguess == number) {
            return "Correct";
        } else if (userguess < number) {
            return "Too low";
        } else {
            return "Too high";
        }
    }
}

