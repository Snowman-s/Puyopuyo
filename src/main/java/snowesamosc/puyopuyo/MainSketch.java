package snowesamosc.puyopuyo;

import processing.core.PApplet;

public class MainSketch extends PApplet {
    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void draw() {
        background(0);

        rect(0, 0, 200, 300);
    }

    public static void main(String[] args) {
        PApplet.main("snowesamosc.puyopuyo.MainSketch");
    }
}
