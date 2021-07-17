package snowesamosc.puyopuyo;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import snowesamosc.puyopuyo.resource.TextureLoader;

import java.util.*;

public class PuyoFactory {
    private EnumMap<FactoryPuyoType, List<PGraphics>> graphicMap = new EnumMap<>(FactoryPuyoType.class);

    public void loadImages(PApplet applet) {
        Arrays.stream(FactoryPuyoType.values())
                .forEach(factoryPuyoType -> graphicMap.put(factoryPuyoType, factoryPuyoType.asImage(applet)));
    }

    public Puyo createPuyo(FactoryPuyoType factoryPuyoType) {
        return new Puyo(new PuyoImage(graphicMap.getOrDefault(factoryPuyoType, Collections.emptyList())), factoryPuyoType);
    }

    public enum FactoryPuyoType implements PuyoType {
        RED {
            @Override
            PImageInfo getImage(int index) {
                int x = index % 4;
                int y = index / 4;
                float size = 1 / 4F;

                return new PImageInfo("red_puyo", x * size, y * size, size, size);
            }
        },
        GREEN {
            @Override
            PImageInfo getImage(int index) {
                int x = index % 4;
                int y = index / 4;
                float size = 1 / 4F;

                return new PImageInfo("green_puyo", x * size, y * size, size, size);
            }
        },
        BLUE {
            @Override
            PImageInfo getImage(int index) {
                int x = index % 4;
                int y = index / 4;
                float size = 1 / 4F;

                return new PImageInfo("blue_puyo", x * size, y * size, size, size);
            }
        },
        YELLOW {
            @Override
            PImageInfo getImage(int index) {
                int x = index % 4;
                int y = index / 4;
                float size = 1 / 4F;

                return new PImageInfo("yellow_puyo", x * size, y * size, size, size);
            }
        };

        abstract PImageInfo getImage(int index);

        private List<PGraphics> asImage(PApplet applet) {
            List<PGraphics> graphics = new ArrayList<>();

            for (int i = 0; i < 16; i++) {
                PImageInfo imageInfo = getImage(i);

                PImage image = TextureLoader.getTexture(applet, imageInfo.getFileId());

                PGraphics graphic = applet.createGraphics(
                        (int) (imageInfo.getWidth() * image.width),
                        (int) (imageInfo.getHeight() * image.height)
                );

                graphic.beginDraw();

                graphic.image(image,
                        (int) (-imageInfo.getX() * image.width),
                        (int) (-imageInfo.getY() * image.height)
                );

                graphic.endDraw();

                graphics.add(graphic);
            }

            return graphics;
        }

        @Override
        public boolean isConnect(Puyo puyo) {
            return this == puyo.getPuyoType();
        }
    }
}
