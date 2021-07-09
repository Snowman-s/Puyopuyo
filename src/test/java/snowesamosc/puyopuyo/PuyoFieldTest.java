package snowesamosc.puyopuyo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PuyoFieldTest {
    @Test
    void fieldInitializeTest() {
        PuyoField puyoField = PuyoField.create(20, 30);

        assertEquals(puyoField.getPuyo(9, 20), Puyo.EMPTY);
        assertEquals(puyoField.getPuyo(0, 0), Puyo.EMPTY);
        assertEquals(puyoField.getPuyo(19, 29), Puyo.EMPTY);

        assertThrows(IllegalArgumentException.class, () -> puyoField.getPuyo(21, 32));
    }
}