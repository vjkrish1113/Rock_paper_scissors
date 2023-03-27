import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.println("Enter your move (rock, paper, or scissors):");
            String playerMove = scanner.nextLine().toLowerCase();

            // Check for valid input
            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
                continue;
            }

            int computerMove = random.nextInt(3); // Generate a random move for the computer

            System.out.println("Computer played " + getMoveName(computerMove));

            // Determine the winner of the round
            int result = getResult(playerMove, computerMove);

            if (result == 0) {
                System.out.println("Tie!");
            } else if (result == 1) {
                System.out.println("You win!");
                playerScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }

            // Display the current score
            System.out.println("Score: You " + playerScore + ", Computer " + computerScore);

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes or no)");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display the final score
        System.out.println("Final score: You " + playerScore + ", Computer " + computerScore);
    }

    // Helper method to convert a move number to a move name
    private static String getMoveName(int move) {
        switch (move) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return null;
        }
    }

    // Helper method to determine the result of a round
    private static int getResult(String playerMove, int computerMove) {
        if (playerMove.equals("rock")) {
            if (computerMove == 0) {
                return 0;
            } else if (computerMove == 1) {
                return -1;
            } else {
                return 1;
            }
        } else if (playerMove.equals("paper")) {
            if (computerMove == 0) {
                return 1;
            } else if (computerMove == 1) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (computerMove == 0) {
                return -1;
            } else if (computerMove == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
