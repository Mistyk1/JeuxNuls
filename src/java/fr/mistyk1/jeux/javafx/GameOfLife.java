package fr.mistyk1.jeux.javafx;

import java.util.Scanner;

import fr.mistyk1.util.MultiThreading;
import fr.mistyk1.util.Terminal;
import fr.mistyk1.util.javafx.Window;
import fr.mistyk1.windows.WindowLife;

public class GameOfLife{
    private static final Scanner sc = new Scanner(System.in);
    
    public GameOfLife(){
        main(null);
    }





    //---- Classe Plateau ----
    public static class LifePlateau{
        private boolean[][] plateau;
        private static LifePlateau instance;
        private static WindowLife window;

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

        public static LifePlateau plateauToWindow(WindowLife wl){
            window = wl;
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

        public int adjacentTo(int x, int y){
            int adj = 0;
            int row, col;
            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i != 0|| j != 0){
                        row = x + i;
                        col = y + j;
                        if (row > this.plateau.length - 1){
                            row = 0;
                        } else if (row < 0){
                            row = this.plateau.length - 1;
                        }
                        if (col > this.plateau[0].length - 1){
                            col = 0;
                        } else if (col < 0){
                            col = this.plateau[0].length - 1;
                        }
                        if (this.plateau[row][col]){
                            adj += 1;
                        }
                    }
                }
            }
            return adj;
        }

        public void clear(){
            for (int i = 0; i < this.plateau.length; i++){
                for (int j = 0; j < this.plateau[0].length; j++){
                    this.plateau[i][j] = false;
                }
            }
        }

        public void tick(){
            if (!WindowLife.getPause()){
                boolean[][] newPlateau = new boolean[this.plateau.length][this.plateau[0].length];
                for (int i = 0; i < this.plateau.length; i++){
                    for (int j = 0; j < this.plateau[0].length; j++){
                        newPlateau[i][j] = (adjacentTo(i, j) == 3) || (adjacentTo(i, j) == 2 && this.plateau[i][j]);
                    }
                }
                this.plateau = newPlateau;
                window.refresh();
            }
        }
    }
    //------------------------




    
    public static void loop(LifePlateau plateau){
        while (!WindowLife.exists()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (WindowLife.exists()){
            plateau.tick();
            try {
                Thread.sleep(WindowLife.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        System.out.print("Bienvenue au Jeu de la vie!\nQuelle taille de carré souhaitez-vous? (entre 10 et 60) ");
        int taille = -1;
        while (taille < 10 || taille > 60){
            System.out.print("> ");
            taille = sc.nextInt();
        }
        Terminal.clearScreen();
        LifePlateau plateau = new LifePlateau(taille, taille);
        MultiThreading.execute(e -> loop(plateau));
        Window.main(new String[]{"gameoflife"});
    }
}
