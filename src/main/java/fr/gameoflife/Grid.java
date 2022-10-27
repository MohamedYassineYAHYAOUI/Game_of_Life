package fr.gameoflife;

public class Grid {

    private char[][] grid;

    private Grid(char[][] grid){
        this.grid = grid;
    }


    static public Grid GridFactory(int[][] gridStats){
        var grid = new char[gridStats[0][0]][];
        for (int i = 0; i < gridStats[0][0]; i++) {
            grid[i] = new char[gridStats[0][1]];
            for (int j = 0; j < gridStats[0][1]; j++) {
                grid[i][j] = ' ';
            }
        }
        for (int i = 1; i <gridStats.length ; i++) {
            grid[gridStats[i][0]][gridStats[i][1]] = '*';
        }
        return new Grid( grid);
    }

    private void drawBoard(StringBuilder strBuild){

        for (int j = 0; j < grid[0].length/4; j++) {
            strBuild.append(" ");
        }
        for (int j = 0; j < grid[0].length/2; j++) {
            strBuild.append("-");
        }
        strBuild.append("\n");
    }
    public void drawGrid(){
        var strBuild = new StringBuilder();
        drawBoard(strBuild);
        for (int i = 0; i < grid.length; i++) {
            strBuild.append("|");
            for (int j = 0; j < grid[i].length; j++) {
                strBuild.append(grid[i][j]);
            }
            strBuild.append("|").append("\n");
        }
        drawBoard(strBuild);
        System.out.println(strBuild);
    }
}
