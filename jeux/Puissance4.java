package jeux;

import java.util.Scanner;

public class Puissance4{
    private static final Scanner sc = new Scanner(System.in);

    public Puissance4(){
        Puissance4.main(null);
    }





    //---- Classe Plateau ----
    private static class Plateau{
        int[][] cases;
        boolean tour;
        int gagnant;

        Plateau(){
            this.cases = new int[][]{{0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0}};
            this.tour = true;
        }

        public String afficherPlateau(){
            String str = "";
            int caseP;
            for (int i = 0; i < 6; i += 1){
                for (int j = 0; j < 7; j += 1){
                    caseP = cases[i][j];
                    if (caseP == 0){
                        //print(" . ");
                        str += " " + caseP + " ";
                    } else if (caseP == 1){
                        //print("\033[0;31m" + " O " + "\033[0m");
                        str += "\033[0;31m" + " " + caseP + " " + "\033[0m";
                    } else if (caseP == 2){
                        //print("\033[0;33m" + " O " + "\033[0m");
                        str += "\033[0;33m" + " " + caseP + " " + "\033[0m";
                    } else if (caseP == 3){
                        //print("\033[0;32m" + " O " + "\033[0m");
                        str += "\033[0;32m" + " " + caseP + " " + "\033[0m";
                    }
                }
                str += "\n";
            }
            return str;
        }

        public String afficherPlateau(String j1, String j2){
            String str = "\nTour de ";
            if (tour){
                str += j1 + "\n\n";
            } else {
                str += j2 + "\n\n";
            }
            str += afficherPlateau();
            return str;
        }

        public void placerPion(){
            boolean verif = false;
            int col = 0;
            System.out.print("Choisissez une colonne ");
            while (!verif){
                System.out.print("> ");
                col = sc.nextInt() - 1;
                verif = (col >= 0 && col <= 6 && !colonnePleine(col));
            }
            verif = false;
            int cpt = 5;
            while (!verif){
                if (cases[cpt][col] == 0){
                    verif = true;
                } else {
                    cpt -= 1;
                }
            }
            if (tour){
                cases[cpt][col] = 1;
            } else {
                cases[cpt][col] = 2;
            }
        }

        public boolean colonnePleine(int col){
            int plein = 0;
            for (int i = 0; i < 6; i += 1){
                if (cases[i][col] != 0){
                    plein += 1;
                }
            }
            return plein == 6;
        }

        public boolean plateauPlein(){
            int verif = 0;
            for (int i = 0; i < 7; i += 1){
                if (colonnePleine(i)){
                    verif += 1;
                }
            }
            return verif == 7;
        }

        public boolean puissance4(){
            boolean verif = false;
            int cpti = 0;
            int cptj;
            while (!verif && cpti < 6){
                cptj = 0;
                while (!verif && cptj < 7){
                    if (!verif && cpti < 3 && cases[cpti][cptj] != 0){ //Détection vers le bas
                        for (int i = 0; i < 3; i += 1){
                            verif = (cases[cpti+i][cptj] == cases[cpti+i+1][cptj]) && !verif;
                        }
                        if (verif){
                            gagnant = cases[cpti][cptj];
                            for (int i = 0; i < 4; i += 1){
                                cases[cpti+i][cptj] = 3;
                            }
                        }
                    }
                    if (!verif && cptj < 5 && cases[cpti][cptj] != 0){ //Détection vers la droite
                        for (int j = 0; j < 3; j += 1){
                            verif = (cases[cpti][cptj+j] == cases[cpti][cptj+j+1]) && !verif;
                        }
                        if (verif){
                            gagnant = cases[cpti][cptj];
                            for (int j = 0; j < 4; j += 1){
                                cases[cptj][cptj+j] = 3;
                            }
                        }
                    }
                    /*if (!verif && cpti < 4 && cases[cpti][cptj] != 0){ //Détection vers le bas-gauche
                        verif = ((cases[cpti][cptj] == cases[cpti+1][cptj]) == (cases[cpti+2][cptj] == cases[cpti+3][cptj]));
                        if (verif){
                            gagnant = cases[cpti][cptj];
                            cases[cpti][cptj] = 3;
                            cases[cpti+1][cptj] = 3;
                            cases[cpti+2][cptj] = 3;
                            cases[cpti+3][cptj] = 3;
                        }
                    }
                    if (!verif && cpti < 4 && cases[cpti][cptj] != 0){ //Détection vers le bas-droite
                        verif = ((cases[cpti][cptj] == cases[cpti+1][cptj]) == (cases[cpti+2][cptj] == cases[cpti+3][cptj]));
                        if (verif){
                            gagnant = cases[cpti][cptj];
                            cases[cpti][cptj] = 3;
                            cases[cpti+1][cptj] = 3;
                            cases[cpti+2][cptj] = 3;
                            cases[cpti+3][cptj] = 3;
                        }
                    }*/
                    cptj += 1;
                }
                cpti += 1;
            }
            return verif;
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
        System.out.print("Bienvenue au Puissance 4!\nSouhaitez-vous connaitre les règles? (y/n) > ");
        char rep = sc.next().charAt(0);
        if (rep == 'y' || rep == 'Y'){
            regles();
        }
        System.out.print("Comment s'appelle le joueur 1? > ");
        String j1 = sc.next();
        System.out.print("Comment s'appelle le joueur 2? > ");
        String j2 = sc.next();
        Plateau p = new Plateau();
        boolean fin = false;
        while (!fin){
            System.out.println(p.afficherPlateau(j1, j2));
            p.placerPion();
            p.tour = !p.tour;
            fin = p.plateauPlein() || p.puissance4();
        }
        System.out.println();
        System.out.println(p.afficherPlateau());
        System.out.println();
        if (p.gagnant == 0){
            System.out.println("Égalité!");
        } else if (p.gagnant == 1){
            System.out.println(j1 + " a fait un puissance 4!");
        } else if (p.gagnant == 2){
            System.out.println(j2 + " a fait un puissance 4!");
        }
    }
}
