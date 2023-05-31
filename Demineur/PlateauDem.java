class PlateauDem{
    int[][] mines;
    boolean[][] trouve;

    PlateauDem(int largeur, int longueur){
        this.mines = new int[largeur][longueur];
        this.trouve = new boolean[largeur][longueur];
    }
}