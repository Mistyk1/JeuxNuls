import java.util.Scanner;

public class JeuCartes{
    private static final Scanner sc = new Scanner(System.in);
    
    public String nomJoueur(int j){
        System.out.println("Quel est le nom du joueur " + j + "? > ");
        return sc.next();
    }

    public static void main(String[] args){
	    System.out.println("Test jeu de cartes");
    }
}
