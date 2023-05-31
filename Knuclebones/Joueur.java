class Joueur{
    String nom;
    int[][] tab;
    int[] colonnes;
    int score;

    Joueur(String nom){
        this.nom = nom;
        this.tab = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        this.colonnes = new int[]{0, 0, 0};
        this.score = 0;
    }
}
