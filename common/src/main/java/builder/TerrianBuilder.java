package builder;

public interface TerrianBuilder {
    TerrianBuilder buildWall();

    TerrianBuilder buildMine();

    TerrianBuilder buildFort();

    Terrian build();
}
