package fr.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SeedParser {

    private static int[] lineParser(String line){
        String[] positions = line.split(" ");

        if(positions.length != 2){
            throw new IllegalArgumentException("invalid line");
        }
        var res = new int[positions.length];
        try{
            res[0] = Integer.parseInt(positions[0]);
            res[1] = Integer.parseInt(positions[1]);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("invalid line");
        }
        return res;
    }

    private static int[][] positionsParser(BufferedReader reader) throws IllegalArgumentException{
        var lines =  reader.lines().toList();
        int[][] points = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            points[i] = lineParser(lines.get(i));
        }
        return points;
    }

    public static int[][] ParseForSeed(String seedFileName){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var is = classloader.getResourceAsStream(seedFileName);
        if(is == null){
           throw new IllegalArgumentException("File missing");
        }
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        try(BufferedReader reader = new BufferedReader(streamReader)){
            int[] gridDimensions = lineParser( reader.readLine());
            int[][] positions = positionsParser(reader);
            int[][] gridStats = new int[positions.length+1][];
            gridStats[0] = gridDimensions;
            for (int i = 0; i < positions.length; i++) {
                gridStats[i+1] = positions[i];
            }
            return gridStats;
        } catch (IOException e) {
            throw new IllegalStateException("Error while Parsing File");
        }
    }
}
