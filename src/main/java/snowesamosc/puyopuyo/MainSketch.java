package snowesamosc.puyopuyo;

import processing.core.PApplet;
import snowesamosc.puyopuyo.field.FieldRenderer;
import snowesamosc.puyopuyo.field.PuyoField;

public class MainSketch extends PApplet {
    private PuyoField field1 = PuyoField.create(6, 12);
    private PuyoField field2 = PuyoField.create(6, 12);

    @Override
    public void settings() {
        size(1000, 600);

        {
            FieldRenderer renderer = field1.getRenderer();

            renderer.setX(100);
            renderer.setY(0);
            renderer.setOneGridSize(50);
        }

        {
            FieldRenderer renderer = field2.getRenderer();

            renderer.setX(600);
            renderer.setY(0);
            renderer.setOneGridSize(50);
        }
    }

    @Override
    public void draw() {
        background(0);

        field1.getRenderer().render(getGraphics());
        field2.getRenderer().render(getGraphics());
    }

    public static void main(String[] args) {
        PApplet.main("snowesamosc.puyopuyo.MainSketch");
    }
}
