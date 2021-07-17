package snowesamosc.puyopuyo.resource;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextureLoader {
    private TextureLoader() {

    }

    private static final Map<String, PImage> images = new HashMap<>();

    public static PImage getTexture(PApplet applet, String fileId) {
        ResourceLoader loader = new ResourceLoader();

        if (images.containsKey(fileId)) {
            return images.get(fileId);
        }

        if (applet == null) return new PImage();

        try {
            URL imageURL = loader.getURL("img/" + fileId + ".png");

            PImage image = applet.loadImage(Path.of(imageURL.toURI()).toString());
            images.put(fileId, image);

            return image;
        } catch (Exception e) {
            return new PImage();
        }
    }
}