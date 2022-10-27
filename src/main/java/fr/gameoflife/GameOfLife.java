package fr.gameoflife;

import java.util.Objects;
import java.util.Scanner;

public class GameOfLife {

    private Generations currentGeneration;

    public GameOfLife(Generations firstGeneration){
        this.currentGeneration = Objects.requireNonNull(firstGeneration);
    }

    public void start(){
        try(Scanner myObj = new Scanner(System.in)){
            var choice = myObj.nextLine();
            currentGeneration.draw();
            while(choice != null && choice.isEmpty()){
                currentGeneration.update();
                currentGeneration.draw();

                choice = myObj.nextLine();
            }
        }


//        while (true) {
//
//            createNextGeneration();
//        }
    }

    public void createNextGeneration() {
    }


    public void killUnderPopulatedCells(){

    }
}
