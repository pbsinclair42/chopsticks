import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameState game = new GameState();
        Scanner reader = new Scanner(System.in);
        while (true) {
            game.printPlayerFingers();
            System.out.println("Which hand are you using to attack? ");
            int from = reader.nextInt() - 1;
            System.out.println("Which hand are you attacking? ");
            int to = reader.nextInt() - 1;
            try {
                int winner = game.makeMove(from, to);
                if (winner >= 0) {
                    System.out.println("Player " + winner + " wins!");
                    System.exit(0);
                }
            } catch (GameState.IllegalMoveError e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
