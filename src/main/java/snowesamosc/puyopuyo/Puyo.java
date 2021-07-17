package snowesamosc.puyopuyo;

import java.util.Collections;

public class Puyo {
    private final PuyoImage puyoImage;
    private PuyoType puyoType;

    public Puyo(PuyoImage puyoImage, PuyoType puyoType) {
        this.puyoImage = puyoImage;
        this.puyoType = puyoType;
    }

    public boolean isEmpty() {
        return false;
    }

    public PuyoType getPuyoType() {
        return puyoType;
    }

    public PuyoImage getPuyoImage() {
        return puyoImage;
    }

    public boolean isConnect(Puyo puyo) {
        return puyoType.isConnect(puyo);
    }

    //仮
    public static final Puyo EMPTY = new Puyo(new PuyoImage(Collections.emptyList()), PuyoType.PURE) {
        @Override
        public boolean isEmpty() {
            return true;
        }
    };
}
