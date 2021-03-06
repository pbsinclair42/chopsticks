import java.util.Arrays;


class GameState {

    private int[][] playerFingers;
    private int playerTurn;

    GameState(){
        this.playerFingers = new int[][]{{1,1},{1,1}};
        this.playerTurn = 0;
    }

    GameState(int[][] playerFingers, int playerTurn){
        this.playerFingers = playerFingers;
        this.playerTurn = playerTurn;
    }

    void printPlayerFingers() {
        System.out.println(this.toString().substring(1,this.toString().length()-1));
    }

    int makeMove(int from, int to) throws IllegalMoveError {
        if (from < 0 || to < 0 || from > 1 || to > 1) {
            throw new IllegalMoveError("Hands must be either 1 or 2");
        } else if (this.playerFingers[playerTurn][from]==0){
            throw new IllegalMoveError("Cannot use a dead hand to move");
        } else if (this.playerFingers[1-playerTurn][to]==0){
            throw new IllegalMoveError("Cannot attack a dead hand");
        }
        this.playerFingers[1-playerTurn][to]+=this.playerFingers[playerTurn][from];
        this.playerFingers[1-playerTurn][to]%=5;
        nextTurn();
        return checkForWinner();
    }

    private void nextTurn() {
        this.playerTurn = 1 - playerTurn;
    }

    private int checkForWinner() {
        int[] loser = {0,0};
        if (Arrays.equals(playerFingers[0], loser)){
            return 1;
        } else if (Arrays.equals(playerFingers[1], loser)){
            return 0;
        }
        return -1;
    }

    public GameState copy() {
        return new GameState(this.playerFingers, this.playerTurn);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof GameState))return false;
        GameState castOther = (GameState)other;
        return Arrays.deepEquals(this.playerFingers, castOther.playerFingers) && playerTurn == castOther.playerTurn;
    }

    @Override
    public String toString(){
        return "<"+playerFingers[0][0] + " " + playerFingers[0][1] + " vs " +
                playerFingers[1][0] + " " + playerFingers[1][1] +
                ", Player " + (playerTurn + 1) + " to move>";
    }

    class IllegalMoveError extends Exception {
        private IllegalMoveError(String message) {
            super(message);
        }
    }
}
