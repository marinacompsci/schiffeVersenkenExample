import java.util.ArrayList;

public class Board {

    private ArrayList<Ship> ships;
    private int width;
    private int height;

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public Board(ArrayList<Ship> ships, int width, int height) {
        this.ships = ships;
        this.width = width;
        this.height = height;
    }

    public boolean checkAttack(int x, int y) {
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            // starts(0,0) ends(0,1)
            for (int j = 0; j < ships.get(i).getLength(); j++ ) {
                if ((ship.getXPosition() == x) && (ship.getYPosition() == y + j)) {
                    reduceShipsHealth(ship);
                    return true;
                }
            }
        }
        return false;
    }

    private void reduceShipsHealth(Ship ship) {
        ship.reduceHealth();
        if (ship.getLength() == 0) {
            remove(ship);
        }
    }

    private void remove(Ship ship) {
        for (int i = 0; i < ships.size(); i++) {
            Ship cShip = ships.get(i);
            if (ship.equals(cShip)) {
                ships.remove(ship);
            }
        }
    }


}
