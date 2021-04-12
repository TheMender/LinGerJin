package builder;

public class ComplexTerrianBuilder implements TerrianBuilder {
    Terrian terrian = new Terrian();

    @Override
    public TerrianBuilder buildWall() {
        terrian.wall = new Wall(1, 2, 3, 4);
        return this;
    }

    @Override
    public TerrianBuilder buildMine() {
        terrian.mine = new Mine(1, 2, 3, 4);
        return this;
    }

    @Override
    public TerrianBuilder buildFort() {
        terrian.fort = new Fort(1, 2, 3, 4);
        return this;
    }

    @Override
    public Terrian build() {
        return this.terrian;
    }
}
