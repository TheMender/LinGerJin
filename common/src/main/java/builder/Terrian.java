package builder;

public class Terrian {
    Wall wall;
    Mine mine;
    Fort fort;

    @Override
    public String toString() {
        return "Terrian{" +
                "wall=" + wall +
                ", mine=" + mine +
                ", fort=" + fort +
                '}';
    }
}

class Wall {
    int x = 1, y, w, h;

    public Wall(int x, int y, int w, int h) {
        this.x = x == 0 ? this.x : x;
        this.h = h;
        this.y = y;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}


class Fort {
    int x = 1, y, w, h;

    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.h = h;
        this.y = y;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Fort{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}

class Mine {
    int x = 1, y, w, h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.h = h;
        this.y = y;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}