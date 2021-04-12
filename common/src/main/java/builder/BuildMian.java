package builder;

public class BuildMian {
    public static void main(String[] args) {
        TerrianBuilder terrianBuilder = new SimpleTerrianBuilder();
        Terrian terrian = terrianBuilder.buildMine().buildWall().buildFort().build();
        System.out.println(terrian.toString());
    }
}
