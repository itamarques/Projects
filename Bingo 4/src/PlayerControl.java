
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerControl implements PlayerADT {

    // LinkedHashMap to sort letters in order.
    LinkedHashMap<String, ArrayList<Integer>> playerBoard = new LinkedHashMap<>();
    // List of numbers that have been confirmed to be on board.
    // This list could possibly be obsolete as there is no reason for it.
    ArrayList<Integer> confirmedNumbers = new ArrayList<Integer>();

    public PlayerControl() {

    }

    public PlayerControl(LinkedHashMap<String, ArrayList<Integer>> playerBoard, ArrayList<Integer> confirmedNumbers) {
        super();
        this.playerBoard = playerBoard;
        this.confirmedNumbers = confirmedNumbers;
    }

    @Override
    public void generateBoard(int boardNumberLimit) {
        // TODO Auto-generated method stub

        // arraylist to check numbers are random and not duplicates
        ArrayList<Integer> numberCheck = new ArrayList<Integer>();

        // countForFreeSpot is used to insert a 0 in the free spot of the board.
        int countForFreeSpot = 2;

        // counts to make sure only 5 numbers go for each letter.
        int countForB = 0;
        int countForI = 0;
        int countForN = 0;
        int countForG = 0;
        int countForO = 0;

        // used to track generated random number
        int randomNum = 0;

        // Arraylists for every letter to populate with random integers.
        ArrayList<Integer> bList = new ArrayList<Integer>();
        ArrayList<Integer> iList = new ArrayList<Integer>();
        ArrayList<Integer> nList = new ArrayList<Integer>();
        ArrayList<Integer> gList = new ArrayList<Integer>();
        ArrayList<Integer> oList = new ArrayList<Integer>();

        // for loop to make fill boards with the chosen number limit. Example: 75
        // card will be filled with random numbers between 1-75
        // this method also checks that the numbers added aren't already added
        // so there are no duplicates in list
        for (int i = 1; i < boardNumberLimit + 1; i++) {
            boolean status = true;
            //generates random
            randomNum = ThreadLocalRandom.current().nextInt(1, boardNumberLimit + 1);

            while (status) {
                // if numCheck arrayList already contains randomNum then regenerate
                // will probably replace this while-loop with a do-while to reduce code use.
                if (numberCheck.contains(randomNum)) {
                    randomNum = ThreadLocalRandom.current().nextInt(1, boardNumberLimit + 1);
                } else {
                    // if random number doesnt exist, status is false so it can then add number
                    status = false;
                }
            }

            // add randomNum to numCheck arraylist so it can be used for further test
            // of future generated numbers
            numberCheck.add(randomNum);

            // random numbers are split to their respective letter categories depending on their range
            // 0-15 = B | 15-30 = I | 30-45 = N | 45-60 = G | 60-75 = O
            // keeps track of count of each letter to limit number to 5
            // in letter N count is used to input freeSpot
            if (randomNum < 16) {

                if (countForB != 5) {
                    bList.add(randomNum);
                    countForB++;
                }

            } else if (randomNum < 30) {
                if (countForI != 5) {
                    iList.add(randomNum);
                    countForI++;
                }
            } else if (randomNum < 45) {
                if (countForN == countForFreeSpot) {
                    nList.add(0);
                } else if (countForN < 5) {
                    nList.add(randomNum);
                }
                countForN++;
            } else if (randomNum < 60) {
                if (countForG != 5) {
                    gList.add(randomNum);
                    countForG++;
                }
            } else if (randomNum < 75) {
                if (countForO != 5) {
                    oList.add(randomNum);
                    countForO++;
                }
            }
        }

        // generated lists are placed into linkedhashmap 
        playerBoard.put("B", bList);
        playerBoard.put("I", iList);
        playerBoard.put("N", nList);
        playerBoard.put("G", gList);
        playerBoard.put("O", oList);

    }

    @Override
    public void confirmNumberOnBoard(int numberOnBoard) {
        // TODO Auto-generated method stub

        // checks if number is on players board
        // if it is on players board
        // it then adds a 0 where the number is located
        // then removed the number from the board
        // these checks go through every letter.
        if (playerBoard.get("B").contains(numberOnBoard)) {
            playerBoard.get("B").add(playerBoard.get("B").indexOf(numberOnBoard), 0);
            playerBoard.get("B").remove(playerBoard.get("B").indexOf(numberOnBoard));
            confirmedNumbers.add(numberOnBoard);
        } else if (playerBoard.get("I").contains(numberOnBoard)) {
            playerBoard.get("I").add(playerBoard.get("I").indexOf(numberOnBoard), 0);
            playerBoard.get("I").remove(playerBoard.get("I").indexOf(numberOnBoard));
            confirmedNumbers.add(numberOnBoard);
        } else if (playerBoard.get("N").contains(numberOnBoard)) {
            playerBoard.get("N").add(playerBoard.get("N").indexOf(numberOnBoard), 0);
            playerBoard.get("N").remove(playerBoard.get("N").indexOf(numberOnBoard));
            confirmedNumbers.add(numberOnBoard);
        } else if (playerBoard.get("G").contains(numberOnBoard)) {
            playerBoard.get("G").add(playerBoard.get("G").indexOf(numberOnBoard), 0);
            playerBoard.get("G").remove(playerBoard.get("G").indexOf(numberOnBoard));
            confirmedNumbers.add(numberOnBoard);
        } else if (playerBoard.get("O").contains(numberOnBoard)) {
            playerBoard.get("O").add(playerBoard.get("O").indexOf(numberOnBoard), 0);
            playerBoard.get("O").remove(playerBoard.get("O").indexOf(numberOnBoard));
            confirmedNumbers.add(numberOnBoard);
        }
    }

}
