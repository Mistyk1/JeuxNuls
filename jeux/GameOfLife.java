package jeux;

import util.Window;
import util.Window.WindowLife;

public class GameOfLife{
    public GameOfLife(){
        GameOfLife.main(null);
    }





    //---- Classe Plateau ----
    public static class LifePlateau{
        private boolean[][] plateau;
        private static LifePlateau instance;

        LifePlateau(int rows, int cols){
            if (instance == null){
                this.plateau = new boolean[rows][cols];
                for (int i = 0; i < rows; i++){
                    for (int j = 0; j < cols; j++){
                        this.plateau[i][j] = false;
                    }
                }
                instance = this;
            }
        }

        public static LifePlateau plateauToWindow(){
            return instance;
        }

        public boolean getCell(int row, int col){
            return this.plateau[row][col];
        }

        public int getNbRows(){
            return this.plateau.length;
        }

        public int getNbCols(){
            return this.plateau[0].length;
        }

        public void changeState(int row, int col){
            this.plateau[row][col] = !this.plateau[row][col];
        }

        public void tick(){
            boolean[][] newPlateau = new boolean[this.plateau.length][this.plateau[0].length];
            for (int i = 0; i < this.plateau.length; i++){
                for (int j = 0; j < this.plateau[0].length; j++){
                    newPlateau[i][j] = this.plateau[i][j];
                }
            }
            // TODO
            this.plateau = newPlateau;
        }
    }
    //------------------------




    
    public static void main(String[] args) {
        LifePlateau plateau = new LifePlateau(50, 50);
        Window.main(new String[]{"gameoflife"});
        while (WindowLife.exists()){
            if (!WindowLife.getPause()){
                plateau.tick();
                try {
                    Thread.sleep(WindowLife.getSpeed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
