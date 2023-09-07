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
    private static final String os = System.getProperty("os.name");

    public QuestionPourUnCarton(){
        QuestionPourUnCarton.main(null);
    }

    public static void clearScreen() {  
        try {
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
            }
        } catch (IOException | InterruptedException  e) {  
            System.out.println(Color.RED + "Problème de rafraichissement du terminal :/" + Color.RESET);
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

    public static void sleep(double s){
        try {
            Thread.sleep((int)(s*1000));
        } catch (InterruptedException e){
            System.out.print("");
        }
    }

    public static void ecrire(String txt){
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.02);
        }
        System.out.println();
    }

    public static void passer(){
        sc.nextLine();
    }

    public static void main(String[] args) {
        com.sun.javafx.application.PlatformImpl.startup(() -> {});

        clearScreen();

        int vies = 3;
        System.out.print("Entrez votre nom svp: ");
        String nom = sc.nextLine();

        clearScreen();

        if (nom.equals("votre nom svp")){
            sleep(2);
            ecrire("Putain mais t'est super drôle toi");
            passer();
            clearScreen();
            sleep(5);
            ecrire("ratio");
            sleep(1);
        }

        clearScreen();

        ecrire(Color.WHITE_BOLD + "Alors que vous vous approchez de la scène de tournage, vous entendez toute la scène parler entre eux, comme si ils était tous excités." + Color.RESET);
		passer();
        ecrire(Color.WHITE_BOLD + "En même temps c'est normal, vous n'êtes pas sur n'importe quel plateau de tournage." + Color.RESET);
		passer();
        ecrire(Color.WHITE_BOLD + "Bienvenue dans l'expérience qui aura probablement le moins de sens dans votre vie..." + Color.RESET);
        sleep(0.5);
        ecrire(Color.YELLOW + "\nPrésentateur" + Color.RESET + ": " + Color.BLUE_BOLD + "Question pour un Carton!" + Color.RESET);
		passer();
    }
}