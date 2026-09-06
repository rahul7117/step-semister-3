import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5, wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 1; i <= rounds; i++) {
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine();
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(i + " | " + playerMove + " | " + computerMove + " | " + result);
        }

        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        sc.close();
    }
}
