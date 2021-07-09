package snowesamosc.puyopuyo.field;

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

    private void validCheck(int x, int y) {
        if (x < 0 || getWidth() < x || y < 0 || getHeight() < y) {
            throw new IllegalArgumentException();
        }
    }

    public Puyo getPuyo(int x, int y) {
        validCheck(x, y);

        return grid[x][y];
    }

    public FieldRenderer getRenderer() {
        return renderer;
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
