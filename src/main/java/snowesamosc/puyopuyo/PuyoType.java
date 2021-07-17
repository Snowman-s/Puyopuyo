package snowesamosc.puyopuyo;

public interface PuyoType {
    boolean isConnect(Puyo puyo);

    PuyoType PURE = new PuyoType() {
        @Override
        public boolean isConnect(Puyo obj) {
            return false;
        }
    };
}
