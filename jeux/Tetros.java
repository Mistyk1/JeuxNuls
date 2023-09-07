package jeux;

import java.util.Random;
import java.util.Scanner;

import hub.Color;

public class Tetros{
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public Tetros(){
        Puissance4.main(null);
    }





    //---- Énumération Piece ----
    private static enum Piece{
        //Forme(#[][]{{y, x}}) ({0, 0} est le point en le plus en bas et le plus à gauche)
        I(new int[][]{{0, 0},         //    ■
                      {1, 0},         //    ■
                      {2, 0},         //    ■
                      {3, 0}}),       //    ■
        O(new int[][]{{0, 0},          //
                      {0, 1},          //   ■ ■
                      {1, 0},          //   ■ ■
                      {1, 1}}),        //
        T(new int[][]{{1, 0},         //
                      {1, 1},         //    ■ ■ ■
                      {1, 2},         //      ■
                      {0, 1}}),       //
        L(new int[][]{{0, 0},          //   ■
                      {0, 1},          //   ■
                      {1, 0},          //   ■ ■
                      {2, 0}}),        //
        J(new int[][]{{0, 0},         //      ■
                      {0, 1},         //      ■
                      {1, 1},         //    ■ ■
                      {2, 1}}),       //
        S(new int[][]{{0, 0},          //
                      {0, 1},          //     ■ ■
                      {1, 1},          //   ■ ■
                      {1, 2}}),        //
        Z(new int[][]{{1, 0},         //
                      {1, 1},         //    ■ ■
                      {0, 1},         //      ■ ■
                      {0, 2}});       //

        private int[][] formation;

        private Piece(int[][] formation){
            this.formation = formation;
        }

        public int[][] getFormation(){
            return formation;
        }

        public static Piece random(){
            switch (rand.nextInt(7)) {
                case 0:
                    return I;
                case 1:
                    return O;
                case 2:
                    return T;
                case 3:
                    return L;
                case 4:
                    return J;
                case 5:
                    return S;
                case 6:
                    return Z;
                default:
                    return I;
            }
        }
    }





    //---- Classe Plateau ----
    private static class Plateau{
        int[][] cases;
        private static final Piece[] tetriminos = new Piece[]{Piece.I, Piece.O, Piece.T, Piece.L, Piece.J, Piece.S, Piece.Z};
        private Piece actuel;
        private int[] pos;
        private Piece prochain;
        private Piece reserve;

        Plateau(){
            this.cases = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        }

        public String afficherPlateau(){
            String str = "";
            int caseP;
            for (int i = 0; i < 20; i += 1){
                for (int j = 0; j < 10; j += 1){
                    caseP = cases[i][j];
                    if (caseP == 0){
                        str += " * ";
                    } else{
                        if (caseP == 1){
                            str += Color.CYAN;
                        } else if (caseP == 2){
                            str += Color.BLUE;
                        } else if (caseP == 3){
                            str += Color.WHITE;
                        } else if (caseP == 4){
                            str += Color.YELLOW;
                        } else if (caseP == 5){
                            str += Color.GREEN;
                        } else if (caseP == 6){
                            str += Color.PURPLE;
                        } else if (caseP == 7){
                            str += Color.RED;
                        }
                        str += " \u25A0 " + Color.RESET;
                    }
                }
                str += "\n";
            }
            return str;
        }

        public void changementPiece(){
            if (prochain != null){
                actuel = prochain;
                prochain = Piece.random();
            } else {
                actuel = Piece.random();
                prochain = Piece.random();
            }
            pos = new int[]{0, 0};
        }

        public void reserverPiece(){
            if (reserve != null){
                Piece temp = reserve;
                reserve = actuel;
                actuel = temp;
                pos = new int[]{0, 0};
            } else {
                reserve = actuel;
                changementPiece();
            }
        }
    }
    //------------------------





    public static void regles(){
        System.out.println("--- Règles ---");
        System.out.println("[Insérer règles]");
        System.out.println("--------------");
        System.out.println("(Entrez une touche pour continuer)");
        sc.next();
    }

    public static void main(String[] args) {
        System.out.print("Bienvenue à Tetros!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
    }
}