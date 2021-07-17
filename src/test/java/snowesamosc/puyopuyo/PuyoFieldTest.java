package snowesamosc.puyopuyo;

import org.junit.jupiter.api.Test;
import snowesamosc.puyopuyo.field.PuyoField;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PuyoFieldTest {
    @Test
    void fieldInitializeTest() {
        PuyoField puyoField = PuyoField.create(20, 30);

        assertTrue(puyoField.getPuyo(9, 20).isEmpty());
        assertTrue(puyoField.getPuyo(0, 0).isEmpty());
        assertTrue(puyoField.getPuyo(19, 29).isEmpty());

        assertThrows(IllegalArgumentException.class, () -> puyoField.getPuyo(21, 32));
    }

    @Test
    void putPuyoTest() {
        PuyoField puyoField = PuyoField.create(6, 12);

        PuyoType puyoType = new PuyoType() {
            @Override
            public boolean isConnect(Puyo puyo) {
                return false;
            }
        };

        assertDoesNotThrow(
                () -> {
                    puyoField.putPuyo(0, 0, new Puyo(new PuyoImage(Collections.emptyList()), puyoType), true);
                    puyoField.putPuyo(3, 11, new Puyo(new PuyoImage(Collections.emptyList()), puyoType), true);
                }
        );

        assertEquals(puyoType, puyoField.getPuyo(0, 0).getPuyoType());
        assertEquals(puyoType, puyoField.getPuyo(3, 11).getPuyoType());

        assertTrue(puyoField.getPuyo(4, 11).isEmpty());

        assertThrows(IllegalArgumentException.class, () -> puyoField.putPuyo(6, 0, new Puyo(new PuyoImage(Collections.emptyList()), puyoType), true));

        assertThrows(IllegalArgumentException.class, () -> puyoField.putPuyo(0, 12, new Puyo(new PuyoImage(Collections.emptyList()), puyoType), true));
    }
}