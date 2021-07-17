package snowesamosc.puyopuyo.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourceLoader {
    public InputStream getInputStream(String s) throws IOException {
        Class<?> thisClass;
        try {
            thisClass = Class.forName("snowesamosc.puyopuyo.resource.ResourceLoader");
        } catch (ClassNotFoundException classNotFoundException) {
            throw new IOException(classNotFoundException.getMessage());
        }
        return thisClass.getResourceAsStream("/" + s);
    }

    public URL getURL(String s) throws IOException {
        Class<?> thisClass;
        try {
            thisClass = Class.forName("snowesamosc.puyopuyo.resource.ResourceLoader");
        } catch (ClassNotFoundException classNotFoundException) {
            throw new IOException(classNotFoundException.getMessage());
        }
        return thisClass.getResource("/" + s);
    }
}