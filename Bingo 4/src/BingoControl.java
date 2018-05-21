
import java.util.ArrayList;
import java.util.Collections;

public class BingoControl implements BoardADT {

    ArrayList<Integer> gameNumberList = new ArrayList<>();
    ArrayList<Integer> calledNumberList = new ArrayList<>();
    int winningRow = 0;

    public BingoControl() {

    }

    public BingoControl(ArrayList<Integer> gameNumberList, ArrayList<Integer> calledNumberList, int winningRow) {
        super();
        this.gameNumberList = gameNumberList;
        this.calledNumberList = calledNumberList;
        this.winningRow = winningRow;
    }

    @Override
    public void generateNumbers(int boardNumberLimit) {
        // TODO Auto-generated method stub

        // fills gameNumberList array with numbers between 1 and 75
        for (int i = 1; i < boardNumberLimit + 1; i++) {
            gameNumberList.add(i);
        }
        // numbers are then shuffled so they are not called in order.
        Collections.shuffle(gameNumberList);
    }

    @Override
    public int callNumbers() {
        // TODO Auto-generated method stub

        // grabs next number in list
        int calledNumber = gameNumberList.get(0);

        // remove number from number list so no number gets called twice
        gameNumberList.remove(0);

        // returns called number
        return calledNumber;
    }

    @Override
    public boolean confirmWinner(PlayerControl player, int typeOfGame) {
        // TODO Auto-generated method stub
        boolean winnerFound = false;

        switch (typeOfGame) {
            case 0:
                // algorithm to win by getting numbers across the board spelling bingo
                // if it goes through all the letters, then there is a winner.
                // winner is found as well as winningrow is returned
                for (int i = 0; i < player.playerBoard.size(); i++) {
                    if (player.playerBoard.get("B").get(i) == 0) {
                        if (player.playerBoard.get("I").get(i) == 0) {
                            if (player.playerBoard.get("N").get(i) == 0) {
                                if (player.playerBoard.get("G").get(i) == 0) {
                                    if (player.playerBoard.get("O").get(i) == 0) {
                                        winnerFound = true;
                                        if (winnerFound == true) {
                                            System.out.println("Player : " + i);
                                            winningRow = i + 1;
                                            i = player.playerBoard.size();
                                            System.out.println("Winning row was: " + (winningRow));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }// end algorithm for regular bingo
                break;

            case 1:
                int x = 0;
                if (player.playerBoard.get("B").get(x) == 0 && player.playerBoard.get("B").get(x + 4) == 0) {
                    if (player.playerBoard.get("I").get(+1) == 0 && player.playerBoard.get("G").get(x + 3) == 0) {
                        if (player.playerBoard.get("N").get(x + 2) == 0 && player.playerBoard.get("G").get(x + 2) == 0) {
                            if (player.playerBoard.get("G").get(x + 3) == 0 && player.playerBoard.get("G").get(x + 1) == 0) {
                                if (player.playerBoard.get("O").get(x + 4) == 0 && player.playerBoard.get("G").get(x) == 0) {
                                    winnerFound = true;
                                }
                            }
                        }
                    }
                }

                break;
            case 2:
                int countRowsForWin = 0;

                for (int i = 0; i < player.playerBoard.size(); i++) {
                    if (player.playerBoard.get("B").get(i) == 0) {
                        if (player.playerBoard.get("I").get(i) == 0) {
                            if (player.playerBoard.get("N").get(i) == 0) {
                                if (player.playerBoard.get("G").get(i) == 0) {
                                    if (player.playerBoard.get("O").get(i) == 0) {
                                        countRowsForWin++;
                                    }
                                }
                            }
                        }
                    }
                    if (countRowsForWin == 5) {
                        winnerFound = true;
                    }
                }// end algorithm for regular bingo
                break;
        }
        return winnerFound;
    }

}
