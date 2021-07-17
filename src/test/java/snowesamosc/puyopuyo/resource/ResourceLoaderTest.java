package snowesamosc.puyopuyo.resource;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class ResourceLoaderTest {
    @Test
    void findURLTest() {
        ResourceLoader loader = new ResourceLoader();

        try {
            URL url = loader.getURL("test_texture.png");

            assertNotNull(url);
        } catch (Exception e) {
            fail(e);
        }
    }
}