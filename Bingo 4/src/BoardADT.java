
public interface BoardADT {

    public void generateNumbers(int boardNumberLimit);

    public int callNumbers();

    public boolean confirmWinner(PlayerControl player, int typeOfGame);

}
