package fr.gameoflife;

import java.util.Objects;

public class Generations {


    private int generationNumber;
    private Grid grid;
    public Generations(Grid grid){
        generationNumber = 0;
        this.grid= grid;
    }


    public void draw() {
        grid.drawGrid();
    }




    public void update() {


        generationNumber+=1;
    }
}
