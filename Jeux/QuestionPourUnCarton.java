package jeux;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import hub.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class QuestionPourUnCarton {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public QuestionPourUnCarton(){
        QuestionPourUnCarton.main(null);
    }

    public static void clearScreen() {  
        try {  
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
        } catch (IOException | InterruptedException  e) {  
            System.out.println("Problème de rafraichissement du terminal :/");
        }
    }

    public static MediaPlayer sound(String filePath, int volume){ // Volume de x = x% du volume initial
        MediaPlayer mp = null;
        try {
            mp = new MediaPlayer(new Media(QuestionPourUnCarton.class.getResource(filePath).toExternalForm()));
            mp.setVolume(volume / 100.0);
        } catch (Exception e) {
            System.out.println(Color.RED + "Erreur de lecture du fichier audio (" + e.getMessage() + ")" + Color.RESET);
        }
        return mp;
    }
    // Ex:
    //
    // MediaPlayer vineBoom = sound("assets/questionPourUnCarton/vine_boom.wav", 20);
    // vineBoom.play()

    public static void main(String[] args) {
        com.sun.javafx.application.PlatformImpl.startup(() -> {});

        clearScreen();

        int vies = 3;
        System.out.print("Entrez votre nom svp: ");
        String nom = sc.next();

        clearScreen();

        System.out.println(Color.WHITE_BOLD + "Alors que vous vous approchez de la scène de tournage, vous entendez toute la scène parler entre eux, comme si ils était tous excités." + Color.RESET);
		sc.nextLine();
        System.out.println(Color.WHITE_BOLD + "\nEn même temps c'est normal, vous n'êtes pas sur n'importe quel plateau de tournage." + Color.RESET);
		sc.nextLine();
        System.out.println(Color.WHITE_BOLD + "Bienvenue dans l'expérience qui aura probablement le moins de sens dans votre vie..." + Color.RESET);
		sc.nextLine();
        System.out.println(Color.YELLOW + "Présentateur" + Color.RESET + ": " + Color.RED_BOLD + "Question pour un Carton!" + Color.RESET);
		sc.nextLine();
    }
}