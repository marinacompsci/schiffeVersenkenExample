import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testGame {
    User jane;
    User joe;

    @Before
    public void setup() {
        Ship shipA = new ShipImpl(0, 0);
        Ship shipB = new ShipImpl(1, 1);
        Ship shipC = new ShipImpl(2, 1);

        ArrayList<Ship> janesShips = new ArrayList<>();
        janesShips.add(shipA);
        janesShips.add(shipB);
        janesShips.add(shipC);
        Board janesBoard = new Board(janesShips, 3, 2);
        jane = new User(janesBoard);

        Ship shipD = new ShipImpl(0, 2);
        Ship shipE = new ShipImpl(1, 1);
        Ship shipF = new ShipImpl(1, 1);

        ArrayList<Ship> joesShips = new ArrayList<>();
        joesShips.add(shipD);
        joesShips.add(shipE);
        joesShips.add(shipF);
        Board joesBoard = new Board(joesShips, 3, 2);
        joe = new User(joesBoard);
    }

    @Test
    public void userASuccessfulSingleAttackShouldReduceUserBPointsByOne() {
        int joePoints = joe.getPoints();
        jane.attack(joe, joe.getShips().get(0).getXPosition(), joe.getShips().get(0).getYPosition());
        Assert.assertEquals(joe.getPoints(),  joePoints - 1);
    }

    @Test
    public void userBUnsuccessfulSingleAttackShouldNotReduceUserBPoints() {
        int joePoints = joe.getPoints();
        jane.attack(joe, 3, 1);
        Assert.assertEquals(joePoints, joe.getPoints());
    }

    @Test
    public void userASuccessfulComboAttackShouldDrownOneOfUserBShips() {
        int joePoints = joe.getPoints();
        jane.attack(joe, joe.getShips().get(1).getXPosition(), joe.getShips().get(1).getYPosition());
        jane.attack(joe, joe.getShips().get(2).getXPosition(), joe.getShips().get(2).getYPosition());
        Assert.assertEquals(joePoints - 2, joe.getPoints());
    }

}
