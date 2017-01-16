import java.util.HashSet;
import java.util.LinkedList;

public class Analyser {
    private HashSet<GameState> player1Wins = new HashSet<>();
    private HashSet<GameState> player2Wins = new HashSet<>();
    private GameState[] analysing;
    private LinkedList<GameState> toAnalyse = new LinkedList<>();

    private Analyser(){
        // save every state where each player has already won
        for (int i = 0; i<5; i++){
            for (int j = 0; j<5; j++){
                if (i!=0 || j!=0){
                    player1Wins.add(new GameState(new int[][]{{i,j},{0,0}}, 0));
                    player1Wins.add(new GameState(new int[][]{{i,j},{0,0}}, 1));
                    player2Wins.add(new GameState(new int[][]{{0,0},{i,j}}, 0));
                    player2Wins.add(new GameState(new int[][]{{0,0},{i,j}}, 1));
                }
            }
        }
        toAnalyse.add(new GameState());
        analyse();
    }

    private void analyse(){
        //TODO
    }

    public static void main(String[] args) {
        Analyser analyser = new Analyser();
        System.out.println(analyser.player1Wins);
        System.out.println(analyser.player2Wins);
    }

}
