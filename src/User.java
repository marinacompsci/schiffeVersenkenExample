import java.util.ArrayList;

public class User {
    private int points;
    private final Board board;

    public User(Board board) {
        this.board = board;
        points = board.getShips().get(0).getLength() * board.getShips().size();
    }

    public int getPoints() {
        return points;
    }

    public void losePoint() {
        points = points-1;
    }

    public ArrayList<Ship> getShips() {
        return board.getShips();
    }

    public void attack(User enemy, int xPosition, int yPosition) {
        if (enemy.board.checkAttack(xPosition, yPosition)) {
            enemy.losePoint();
        }


    }
}
