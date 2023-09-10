package jeux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import hub.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class QuestionPourUnCarton {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private static final String os = System.getProperty("os.name");
    private static final String presentateur = Color.YELLOW + "Présentateur" + Color.RESET;

    public QuestionPourUnCarton(){
        QuestionPourUnCarton.main(null);
    }





    //---- Énumération Question ----
    private static enum Question{
        Placeholder1("Placeholder1", 
                  "1", "2", "3", "4", "5",
                  "Br", "G", "N", "J", "V", "M", "Bu", "A",
                  "J1", "J2", "J3", "J4", "J5", 
                  "Presentateur", 3),
        Placeholder2("Placeholder2", 
                  "1", "2", "3", "4", "5",
                  "Br", "G", "N", "J", "V", "M", "Bu", "A",
                  "J1", "J2", "J3", "J4", "J5", 
                  "Presentateur", 3);

        private String intitule;
        private String[] choix;
        private String[] reponses;
        private String[] reponsesJoueur;
        private String reponsePresentateur;
        private int correct;
        private static String[] noms = new String[]{"Brigitte", "Gabriel", "Nicolas", "Jules", "V-43.7", "Mathéo", null, "bumba", "Albert"};

        private Question(String intitule,
                        String choix1, String choix2, String choix3, String choix4, String choix5,
                        String reponseBr, String reponseG, String reponseN, String reponseJ, String reponseV, String reponseM, String reponseBu, String reponseA,
                        String reponseJ1, String reponseJ2, String reponseJ3, String reponseJ4, String reponseJ5,
                        String reponsePresentateur, int correct){
            this.intitule = intitule;
            this.choix = new String[]{choix1, choix2, choix3, choix4, choix5};
            this.reponses = new String[]{reponseBr, reponseG, reponseN, reponseJ, reponseV, reponseM, randomText(), reponseBu, reponseA};
            this.reponsesJoueur = new String[]{reponseJ1, reponseJ2, reponseJ3, reponseJ4, reponseJ5};
            this.reponsePresentateur = reponsePresentateur;
            this.correct = correct;
        }

        public static List<Question> listeQuestions(){
            List<Question> liste = new ArrayList<>();
            for (Question q : Question.values()){
                liste.add(q);
            }
            Collections.shuffle(liste);
            return liste;
        }

        public String getIntitule(){
            return intitule;
        }

        public String getChoix(int xugfjudfgdfhjdfgdkifsllfjkih){
            return choix[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String getReponse(int xugfjudfgdfhjdfgdkifsllfjkih){
            return reponses[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String getReponseJoueur(int xugfjudfgdfhjdfgdkifsllfjkih){
            return reponsesJoueur[xugfjudfgdfhjdfgdkifsllfjkih];
        }

        public String getReponsePresentateur(){
            return reponsePresentateur;
        }

        public int getCorrect(){
            return correct;
        }
    }
    //-----------------------





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

    public static void ecrire(String txt, double sleepTime){
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.02);
        }
        System.out.println();
        sleep(sleepTime);
    }

    public static void ecrire(String txt){
        ecrire(txt, 0);
        sc.nextLine();
    }

    public static void ecrire(String personnage, String txt, double sleepTime){
        personnage += ": ";
        for (int i = 0; i < personnage.length(); i += 1){
            System.out.print(personnage.charAt(i));
            sleep(0.02);
        }
        ecrire(txt, sleepTime);
    }

    public static void ecrire(String personnage, String txt){
        ecrire(personnage, txt, 0);
        sc.nextLine();
    }

    public static void ecrireNoEnter(String txt, double sleepTime){
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.02);
        }
        System.out.println();
        sleep(sleepTime);
    }

    public static void ecrireNoEnter(String personnage, String txt, double sleepTime){
        personnage += ": ";
        for (int i = 0; i < personnage.length(); i += 1){
            System.out.print(personnage.charAt(i));
            sleep(0.02);
        }
        ecrireNoEnter(txt, sleepTime);
    }

    public static String randomText(){
        String randomText = Color.WHITE_BOLD.toString();
        for (int i = 0; i < (rand.nextInt(150)+50); i += 1){
            randomText += (char)(rand.nextInt(167)+33);
        }
        return randomText + Color.RESET;
    }

    public static void terminal(String txt, int waitCycle){
        for (int i = 0; i < waitCycle; i += 1){
            System.out.print("\b|");
            sleep(0.55);
            System.out.print("\b ");
            sleep(0.55);
        }
        for (int i = 0; i < txt.length(); i += 1){
            System.out.print(txt.charAt(i));
            sleep(0.095);
        }
        System.out.println();
    }
    

    public static void terminal(String txt){
        terminal(txt, 0);
    }

    public static int choixChemin(String... choix){
        for (int i = 0; i < choix.length; i += 1){
            System.out.print("[");
            sleep(0.02);
            System.out.print(i);
            sleep(0.02);
            System.out.print("] ");
            sleep(0.02);
            for (int j = 0; j < choix[i].length(); j += 1){
                System.out.print(choix[i].charAt(j));
                sleep(0.02);
            }
            System.out.println();
        }
        try {
            return sc.nextInt();
        } catch (InputMismatchException e){
            return 0;
        }
    }

    public static int poserQuestion(List<Question> questions, int vies, String nom){
        Question q = questions.remove(0);
        ecrireNoEnter(presentateur, q.getIntitule(), 0.5);
        for (int i = 0; i < 5; i += 1){
            ecrireNoEnter("["+(i+1)+"] "+q.getChoix(i), 0);
        }
        int choix;
        System.out.println();
        do {
            System.out.print("> ");
            try {
                choix = sc.nextInt();
            } catch (InputMismatchException e){
                choix = 0;
            }
        } while (!(choix >= 1 && choix <= 5));
        if (!(q.getCorrect() == choix)){
            vies -= 1;
        }
        for (int i = 0; i < 10; i += 1){
            if (i < 8){
                ecrireNoEnter(Question.noms[i], q.getReponse(i), 0.5);
            } else if (i == 8){
                ecrireNoEnter(nom, q.getReponseJoueur(choix), 0.5);
            } else {
                ecrireNoEnter(Question.noms[i-1], q.getReponse(i-1), 0.5);
            }
        }
        ecrire(presentateur, q.getReponsePresentateur());
        return vies;
    }

    public static void rappelVies(int vies){
        String v = "" + vies;
        if (vies == 5 || vies == 4){
            v = Color.GREEN_BOLD + v + Color.RESET;
        } else if (vies == 3 || vies == 2){
            v = Color.YELLOW_BOLD + v + Color.RESET;
        } else if (vies == 1){
            v = Color.RED_BOLD + v + Color.RESET;
        }
        ecrire(Color.WHITE_BOLD + "[Il vous reste " + v + " vies]" + Color.RESET);
    }

    public static boolean isFinished(int vies){
        if (vies > 0){
            rappelVies(vies);
            return false;
        }
        return true;
    }

    public static void finalSpeed(String nom){
        ecrire(presentateur, "Il se trouve que " + nom + " n'a plus de vies, il va donc devoir nous quitter...");
        ecrire(presentateur, "Dites lui tous adieu!");
        ecrire("Toute la scène", "ADIEUUUU!");
        ecrire(Color.WHITE_BOLD + "Alors que vous quitter le plateau de tournage, vous sentez le désespoir et la misère s'abattre immédiatement sur vous. Cet incroyable carton de 3 mètres cube vous est désormais inaccessible à jamais." + Color.RESET);
        ecrire(Color.RED_BOLD + "\nMAUVAISE FIN" + Color.RESET, 1);
    }

    public static void main(String[] args) {
        com.sun.javafx.application.PlatformImpl.startup(() -> {});

        clearScreen();

        System.out.print("Entrez votre nom svp: ");
        String nom = sc.nextLine();

        clearScreen();

        if (nom.equals("votre nom svp")){
            sleep(2);
            ecrire("Putain mais t'est super drôle toi");
            sleep(2);
            clearScreen();
            sleep(5);
            ecrire("ratio");
            sleep(1);
            nom = "Connard";
        } else if (nom.equals("Presentateur")){
            cheminPresentateur();
            return ;
        }
        
        int vies = 5;
        List<Question> questions = Question.listeQuestions();

        clearScreen();


        // Introduction


        ecrire(Color.WHITE_BOLD + "Alors que vous vous approchez de la scène de tournage, vous entendez toute la scène parler entre eux, comme si ils était tous excités." + Color.RESET);
        ecrire(Color.WHITE_BOLD + "En même temps c'est normal, vous n'êtes pas sur n'importe quel plateau de tournage." + Color.RESET);
        ecrire(Color.WHITE_BOLD + "Bienvenue dans l'expérience qui aura probablement le moins de sens dans votre vie..." + Color.RESET, 0.5);
        ecrire("\n" + presentateur, Color.BLUE_BOLD + "Question pour un Carton!" + Color.RESET);
        ecrire(presentateur, "Bienvenue tout le monde dans ce show aussi chaotique qu'imprévisible!");
        ecrire(presentateur, "Je vous en prie, asseyez vous. Tout nos participants sont présents!");
        ecrire(presentateur, "Ils sont au grand nombre de 10, sont aussi divers que variés et répondrons à de nombreuses questions sans intérêts ou logique thématique particulière afin de gagner ce magnifique carton de 3 mètres cube!");
        ecrire(presentateur, "Assez de blabla, laissont nos participants se présenter.");


        // Présentations


        String randomName = "";
        for (int i = 0; i < rand.nextInt(20)+10; i += 1){
            randomName += (char)(rand.nextInt(167)+33);
        }
        Question.noms[6] = randomName;

        ecrire("Brigitte", "Bonjour je m'apelle Brigitte, j'ai 74 ans et ce carton est à mes yeux une nécéssité absolue. Voyez-vous, j'ai 35 chats dans mon appartement et ils adorerais s'amuser avec ce carton.");
        ecrire("Gabriel", "Mes frères, mes soeurs. Nous sommes réunis en ce lieu afin de me faire gagner en intellect et, bien évidemment, me faire gagner cette boite cartonnée.");
		ecrire("Nicolas", "Bonjour, Nicolas, 26 ans, étudiant en infor-\n", 0);
        ecrire("Jules", "oe euuuuuuh moi jai bsoin de cet boit pour la mettr dan mon appart");
        ecrire("V-43.7", Color.WHITE_BOLD + "*bruits incompréhensibles de robot*" + Color.RESET);
        System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire("Mathéo", Color.WHITE_BOLD + "*est confus par rapport aux autres participants*" + Color.RESET); sc.nextLine();
		ecrire(randomName, randomText());
        ecrire("bumba", "ooga booga" + Color.WHITE_BOLD + " *se cogne plusieurs fois la tête avec une masse en bois*" + Color.RESET);
        ecrire("Albert", "Je ne peut m'imaginer sans ce carton. Je dois le gagner, ou alors mon existance ne serait qu'un ab\u00EEme sans sens. Ce carton est pour moi l'objectif de ma vie, le sens m\u00EAme de ma destin\u00E9e, le fil rouge de mon existence. J'ai r\u00EAv\u00E9 jours et nuits de ce carton depuis mes 2 ans. Je ne fait qu'envoyer des lettres d'inscriptions \u00E0 ce show depuis mes 3 ans dans l'unique but de pouvoir vivre avec ce carton. J'ai pass\u00E9 30 ans de ma vie \u00E0 m'entrainer, de minuit \u00E0 23 heures 50, chaque jours de chaque semaines de chaque mois de chaque ann\u00E9es. Ma vie tourne autour de ce carton, je me dois donc aujourd'hui de marquer une nouvelle phase de ma vie et de gagner ce carton.");


        ecrire(presentateur, "Mais voici donc des participants motivés!");
        ecrire(presentateur, "Ne tardons donc pas avec notre première question!");


        // Question 1

        ecrireNoEnter(Color.WHITE_BOLD + "Question 1\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);

        if (isFinished(vies)){
            finalSpeed(nom);
            return ;
        }

        // Transition 1


        ecrire(presentateur, "Ne tardons donc pas avec notre première question!");
    }

    public static void cheminPresentateur(){
        clearScreen();

        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde l'heure*" + Color.RESET);
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde à nouveau l'heure*" + Color.RESET);
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, "Mais ou est-il?");
        ecrire(presentateur, "Il est sensé être là, et le show aurait même déjà commencé!");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde encore l'heure*" + Color.RESET);
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, "...");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde une dernière fois l'heure*" + Color.RESET);
        ecrire(presentateur, "Bon, je vais essayer quelque chose.\n", 2);
        System.out.print(Color.RED + "DEBUG MODE INITIALISED\n\n" + Color.RESET);
        terminal("public class CheckJoueur{\n\tpublic static void main(String[] args){\n\t\tJoueur j = QuestionPourUnCarton.getJoueur();\n\t\tif (j == null){\n\t\t\tSystem.out.println(\"Il n'y a aucun joueur\");\n\t\t} else {\n\t\t\tSystem.out.println(\"IL Y A UN JOUEUR! YIPPEEEEEEE\");\n\t\t}\n\t}\n}", 2);
        sleep(1);
        System.out.print("\nPS C:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton> ");
        sleep(1.5);
        System.out.println(Color.CYAN + "c:; cd 'c:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton'; " + Color.RESET + "&" + Color.CYAN + " 'C:\\Program Files\\Java\\jdk1.8.0_321\\bin\\java.exe' '-cp' 'C:\\Users\\presentateur\\AppData\\Roaming\\Code\\User\\workspaceStorage\\4c1f9d31f4b103fa083ee66fd6b94ca1\\redhat.java\\jdt_ws\\CheckJoueur_9d1e0b84\\bin' 'CheckJoueur' " + Color.RESET);
        sleep(0.2);
        clearScreen();
        System.out.println("Il n'y a aucun joueur\n");
        sleep(2);
        ecrire(presentateur, "Ah ._.");
        ecrire(presentateur, "euuuuuuh");
        ecrire(presentateur, "ok euuuh je fait quoi\n", 0);
        boolean correct = false;
        while (!correct){
            switch (choixChemin("Créer un nouveau joueur", "Ne rien faire")) {
                case 0:
                    correct = true;
                    ecrire(presentateur, "Ok je pourrais essayer de créer un nouveau joueur.");
                    ecrire(presentateur, Color.WHITE_BOLD + "*met des lunettes de soleil*" + Color.RESET);
                    ecrire(presentateur, "C'est parti.");
                    terminal("public class CreateJoueur extends QuestionPourUnCarton{\n\tpublic static Joueur createNewJoueur(){\n\t\tJoueur j = new Joueur();\n\t\tj.name(\"Joueur\");\n\t\tj.setVies(5);\n\t\treturn j;\n\t}\n\n\tpublic static void main(String[] args){\n\t\tJoueur j = createNewJoueur();\n\t\tsuper.main(new String[j.toString()]);\n\t}\n}", 1);
                    sleep(1);
                    System.out.print("\nPS C:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton> ");
                    sleep(1.5);
                    System.out.println(Color.CYAN + "c:; cd 'c:\\Users\\presentateur\\Desktop\\QuestionPourUnCarton'; " + Color.RESET + "&" + Color.CYAN + " 'C:\\Program Files\\Java\\jdk1.8.0_321\\bin\\java.exe' '-cp' 'C:\\Users\\presentateur\\AppData\\Roaming\\Code\\User\\workspaceStorage\\4c1f9d31f4b103fa083ee66fd6b94ca1\\redhat.java\\jdt_ws\\CreateJoueur_9d1e0b84\\bin' 'CreateJoueur' " + Color.RESET);
                    sleep(0.2);
                    clearScreen();
                    sleep(1.5);
                    ecrire(presentateur, "ça fonctionne...");
                    ecrire(presentateur, "ÇA FONCTIO", 0);
                    System.out.println("Exception in thread \"main\" exceptions.CorruptedPlayerException: Player data corrupted\n\tat CreateJoueur.main(CreateJoueur.java:8)\n\tat QuestionPourUnCarton.main(QuestionPourUnCarton.java:202)");
                    return ;
                case 1:
                    correct = true;
                    ecrire(presentateur, "bon");
                    ecrire(presentateur, "J'ai plus aucun choix");
                    ecrire(presentateur, "Je n'ai qu'à attendre ici jusqu'à ce que cet endroit ne cesse d'exister.");
                    while (true){
                        int r = rand.nextInt(100);
                        if (r < 10){
                            ecrire(presentateur, "...");
                        } else if (r < 20){
                            ecrire(presentateur, ":|");
                        }
                        sc.nextLine();
                    }
                default:
                    break;
            }
        }
    }
}