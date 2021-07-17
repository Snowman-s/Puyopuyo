package snowesamosc.puyopuyo;

import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PuyoImage {
    public List<PGraphics> graphicsList;

    public PuyoImage(List<PGraphics> graphicsList) {
        Objects.requireNonNull(graphicsList);

        this.graphicsList = new ArrayList<>(graphicsList);
    }

    //imageListにおいて、この引数の順番で1111の様に並べたindexから取得。
    public PImage getImage(boolean upConnected, boolean leftConnected,
                           boolean downConnected, boolean rightConnected) {

        int index = (upConnected ? 0b1000 : 0) |
                (leftConnected ? 0b0100 : 0) |
                (downConnected ? 0b0010 : 0) |
                (rightConnected ? 0b0001 : 0);

        if (graphicsList.size() <= index) {
            return new PImage();
        }

        return graphicsList.get(index);
    }
}
