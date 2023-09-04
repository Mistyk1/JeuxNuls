package jeux;

import hub.Color;

public class Tetros{
    public Tetros(){
        Puissance4.main(null);
    }





    //---- Énumération Piece ----
    private static enum Piece{
        //Forme(#[][]{{y, x}}) ({0, 0} est le point en le plus en bas et le plus à gauche)
        I(new int[][]{{0, 0},           //    ■
                      {1, 0},           //    ■
                      {2, 0},           //    ■
                      {3, 0}}, 1),   //    ■
        O(new int[][]{{0, 0},            //
                      {0, 1},            //   ■ ■
                      {1, 0},            //   ■ ■
                      {1, 1}}, 2),    //
        T(new int[][]{{1, 0},           //
                      {1, 1},           //    ■ ■ ■
                      {1, 2},           //      ■
                      {0, 1}}, 3),   //
        L(new int[][]{{0, 0},            //   ■
                      {0, 1},            //   ■
                      {1, 0},            //   ■ ■
                      {2, 0}}, 4),    //
        J(new int[][]{{0, 0},           //      ■
                      {0, 1},           //      ■
                      {1, 1},           //    ■ ■
                      {2, 1}}, 5),   //
        S(new int[][]{{0, 0},            //
                      {0, 1},            //     ■ ■
                      {1, 1},            //   ■ ■
                      {1, 2}}, 6),    //
        Z(new int[][]{{1, 0},           //
                      {1, 1},           //    ■ ■
                      {0, 1},           //      ■ ■
                      {0, 2}}, 7);   //

        private int[][] formation;
        private int id;

        private Piece(int[][] formation, int id){
            this.formation = formation;
            this.id = id;
        }
    }





    //---- Classe Plateau ----
    private static class Plateau{
        int[][] cases;
        private static final Piece[] tetriminos = new Piece[]{};

        Plateau(){
            this.cases = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // Ces lignes ne seront pas affichées
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //
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
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        }

        public String afficherPlateau(){
            String str = "";
            int caseP;
            for (int i = 0; i < 24; i += 1){
                if (i >= 4){
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
                }
                str += "\n";
            }
            return str;
        }
    }
    //------------------------





    public static void main(String[] args) {
        //
    }
}