package snowesamosc.puyopuyo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PuyoFactoryTest {
    @Test
    void puyoConnectTest() {
        PuyoFactory factory = new PuyoFactory();

        Puyo puyo1 = factory.createPuyo(PuyoFactory.FactoryPuyoType.RED);
        Puyo puyo2 = factory.createPuyo(PuyoFactory.FactoryPuyoType.RED);

        assertTrue(puyo1.isConnect(puyo2));
    }
}