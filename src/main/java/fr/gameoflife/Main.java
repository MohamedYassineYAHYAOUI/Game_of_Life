package fr.gameoflife;

public class Main {

    public static void main(String[] args) {
        var firstGeneration = new Generations( Grid.GridFactory(SeedParser.ParseForSeed("seed.txt")));
        var gol = new GameOfLife(firstGeneration);
        gol.start();
    }
}
