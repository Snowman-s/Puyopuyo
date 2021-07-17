package snowesamosc.puyopuyo;

import java.util.Objects;

public class PImageInfo {
    private final String fileId;

    private final float x, y, width, height;

    public PImageInfo(String fileId, float x, float y, float width, float height) {
        Objects.requireNonNull(fileId);

        this.fileId = fileId;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getFileId() {
        return fileId;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
