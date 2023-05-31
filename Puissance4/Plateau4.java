package Puissance4;
class Plateau4{
    int[][] cases;
    boolean tour;
    int gagnant;

    Plateau4(){
        this.cases = new int[][]{{0, 0, 0, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 0, 0, 0}};
        this.tour = true;
    }
}
