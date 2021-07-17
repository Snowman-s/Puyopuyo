package snowesamosc.puyopuyo.field;

import processing.core.PGraphics;
import snowesamosc.puyopuyo.PRenderer;

public class FieldRenderer implements PRenderer {
    private final PuyoField puyoField;
    private float x;
    private float y;
    private float oneGridSize;

    public FieldRenderer(PuyoField puyoField) {
        this.puyoField = puyoField;
    }

    public void render(PGraphics graphics) {
        int width = puyoField.getWidth();
        int height = puyoField.getHeight();

        graphics.pushStyle();

        graphics.stroke(255);
        graphics.fill(0, 50);

        //grids
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                graphics.rect(
                        this.x + oneGridSize * x, this.y + oneGridSize * y,
                        oneGridSize, oneGridSize);
            }
        }

        //puyo
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                graphics.image(puyoField.getPuyoImage(x, y),
                        this.x + oneGridSize * x, this.y + oneGridSize * y,
                        oneGridSize, oneGridSize);
            }
        }


        graphics.popStyle();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getOneGridSize() {
        return oneGridSize;
    }

    public void setOneGridSize(float oneGridSize) {
        this.oneGridSize = oneGridSize;
    }
}
