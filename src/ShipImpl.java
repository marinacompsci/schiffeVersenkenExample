public class ShipImpl implements Ship {
    private final int xPosition;
    private final int yPosition;
    private int length = 2;

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void reduceHealth() {
        --length;
    }

    @Override
    public int getXPosition() {
        return xPosition;
    }

    @Override
    public int getYPosition() {
        return yPosition;
    }

    public ShipImpl(int startX, int startY) {
        this.xPosition = startX;
        this.yPosition = startY;
    }


}
