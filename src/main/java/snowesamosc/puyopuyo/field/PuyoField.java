package snowesamosc.puyopuyo.field;

import processing.core.PImage;
import snowesamosc.puyopuyo.Puyo;

public class PuyoField {
    //grid[x][y]の様に指定。
    private final Puyo[][] grid;
    private FieldRenderer renderer = new FieldRenderer(this);

    public static PuyoField create(int width, int height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException();

        return new PuyoField(width, height);
    }

    private PuyoField(int width, int height) {
        grid = new Puyo[width][height];

        for (final Puyo[] column : grid) {
            for (int y = 0; y < getHeight(); y++) {
                column[y] = Puyo.EMPTY;
            }
        }
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }

    private void validCheckException(int x, int y) {
        if (x < 0 || getWidth() <= x || y < 0 || getHeight() <= y) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validCheckBoolean(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }

    public void putPuyo(int x, int y, Puyo puyo, boolean replace) {
        validCheckException(x, y);

        if (grid[x][y].isEmpty() || replace) {
            grid[x][y] = puyo;
        }
    }

    public Puyo getPuyo(int x, int y) {
        validCheckException(x, y);

        return grid[x][y];
    }

    public FieldRenderer getRenderer() {
        return renderer;
    }

    public PImage getPuyoImage(int x, int y) {
        validCheckException(x, y);

        Puyo puyo = grid[x][y];

        boolean upConnected = isConnect(puyo, x, y - 1);
        boolean downConnected = isConnect(puyo, x, y + 1);
        boolean leftConnected = isConnect(puyo, x - 1, y);
        boolean rightConnected = isConnect(puyo, x + 1, y);

        return puyo.getPuyoImage().getImage(upConnected, leftConnected, downConnected, rightConnected);
    }

    private boolean isConnect(Puyo puyo, int x, int y) {
        return validCheckBoolean(x, y) && puyo.isConnect(grid[x][y]);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                stringBuilder.append(getPuyo(x, y));
            }
        }

        return stringBuilder.toString();
    }
}
