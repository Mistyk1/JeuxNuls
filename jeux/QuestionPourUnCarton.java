package jeux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import util.Color;
import util.MultiThreading;

public class QuestionPourUnCarton {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in, "UTF-8");
    private static final String os = System.getProperty("os.name");
    private static final String presentateur = Color.YELLOW + "Présentateur" + Color.RESET;
    private static String nom;

    public QuestionPourUnCarton(){
        QuestionPourUnCarton.main(null);
    }





    //---- Énumération Question ----
    private static enum Question{
        PrenomPresentateur("Comment est ce que je m'appelle?", 
                  "Bernard", "Pr\u00E9sentateur", "Nicolas", "Gilgamesh le destructeur de réalités", "Je n'ai pas de pr\u00E9nom",
                  "Pr\\u00E9sentateur!", "C'est simple, pr\\u00E9sentateur.", "Pr\\u00E9sentateur?", "euuuuh bernard", "RÉPONSE N°3", "Je ne sais pas?", "ooga", "Gilgamesh le destructeur de r\u00E9alit\u00E9s",
                  "Bernard!", "Pr\\u00E9sentateur!", "Nicolas!", "Gilgamesh le destructeur de r\u00E9alit\u00E9s!", "Vous n'avez pas de pr\\u00E9nom!", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 
                  "Il se trouve que je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)", 2),
        TroisPlusTrois("Combien font 3 + 3?", 
                  "6", "12", "-493,45", "Pr\u00E9sentateur", "Les mathématiques sont un mensonge",
                  "6", "12", "-493,45! Non non non attendez-", "euuuuuuuuuuh", Color.WHITE_BOLD + "*bruit forts de calculs*" + Color.RESET, "6?", Color.WHITE_BOLD + "*est confus*" + Color.RESET, "Pr\\u00E9sentateur",
                  "6", "12", "-493,45", "Pr\\u00E9sentateur", "Les math\u00E9matiques ne sont pas réelles et sont un concept imaginé par notre cerveau pour contextualiser et rationnaliser l'univers nous environant.", 
                  "Oui, c'est 6!", 
                  "12?", 
                  "-493,45?! Comment en êtes vous venu à ce résultat?!", 
                  "Quoi, mais... C'est la r\u00E9ponse \u00E0 la une autre question...", 
                  "Vous venez littéralement de répondre avec un nombre", 1),
        ComposantFer("Quel est le composant principal du fer?", 
                  "L'élément atomique n°26", "De la mystérieuse poudre blanche (de la farine)", "Votre m\u00E8re", "Le néant absolu", "N'importe quoi sauf du fer",
                  "Oulah...", "Mais aucune de ces réponses ne font sens!", "Du fer.", "eh ta daronne mdr", "ÉLÉMENT ATOMIQUE N°26", "Le néant", "Votre progénitrice.", "DE LA COCAÏNE" + Color.WHITE_BOLD + "*sniffe un maximum de drogues dures*" + Color.RESET,
                  "L'\\u00E9l\\u00E9ment atomique n\\u00B026", "De la farine?", "Votre mère! >:D", "Rien.", "Absolument tout sauf du fer.", 
                  "Nicolas, c'est si dur à dire \"Élément atomique n°26\"?!", 
                  Color.WHITE_BOLD + "*le présentateur vous regarde suspicieusement*" + Color.RESET, 
                  "Si vous continuez comme ça vous allez vite dégager.", 
                  "Comment ça rien?!", 
                  "Il n'y a pas de fer dans du fer? Est-ce que vous r\u00E9fl\u00E9chissez?", 1),
        Femme("Pourquoi ma femme m'a quitt\u00E9?", 
                  "Car je suis parti achet\u00E9 du lait", "Car je suis un mari extr\u00EAmement infid\u00E8le", "Car je ne fesais rien pour faire avancer le mariage", "Car j'ai jet\u00E9 le chat par la fen\u00EAtre", "Toute les r\u00E9ponses du dessus",
                  "...", "???", "Vous êtes infidèle?", "t'es juste un ▉▉▉▉▉▉ toi en fait", Color.WHITE_BOLD + "*de la fumée commence à sortir de V-43.7*" + Color.RESET, "Vous...", "", "...",
                  "Vous êtes... parti acheter du lait?", "Vous \u00EAtes... infidèle?", "Vous \u00EAtes... un paresseux?", "Vous \u00EAtes... un homme extrêmement cruel?", "Vous \u00EAtes... la pire ordure n'ayant jamais existé?", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "Personne n'a bon.", 
                  "o)_o)'", 5),
        Cheval("Quelle est la couleur du cheval blanc d'Henry IV?", 
                  "Vert", "Blanc", "Marron-Rouge-Bleu", "Gris", "Transparent",
                  "Gris?", "Il doit forcément être blanc.", "Bah blanc", "euuuuuuu gri", Color.WHITE_BOLD + "*bruits incompréhensibles de robot*" + Color.RESET, "Transparent!", "ooga ooga", "Vert.",
                  "Vert", "Blanc", "Marron-Rouge-Bleu", "Gris", "Transparent", 
                  "Il est radioactif ce cheval?", 
                  "Non :)", 
                  "C'est quel genre de couleur ça?", 
                  "Non, il n'y a pas de poussière sur le cheval.", 
                  "Il est vrai que j'aime bien faire des chevaux en verre lors de mes heures perdues...", 5),
        Oui("Oui?", 
                  "je sais pas haha", "stiti", "fi", "Oui", "Non",
                  "De quoi oui?", "Bien évidemment.", "Mais ce n'est même pas une question...", "tg", "TRUE", "-STITI HAHAHAHA CHUI TROP DROLE", "booga", "Non. Pas le moins du monde. Aucunement. Absolument pas. Que nenni. 0%. Jamais.",
                  "je euh je je euh je je je euh je euh euh", "-stiti haha :)", "-fi haha :)", "Oui.", "Non.", 
                  "-_-", 
                  ":|", 
                  ":|", 
                  ":)", 
                  "-bril", 4),
        Robot("Suis-je un robot?", 
                  "Probablement", "Oui", "Non", "Je ne sais pas", "Ananas",
                  "Oui?", "Machine?", "Vous? Un robot? C'est trop complexe à faire un robot de votre envergure.", "euuhh jsp", Color.WHITE_BOLD + "*émet des bruits étranges*" + Color.RESET, "Un robot? Non?", "ooga booga", "Les robots n'existent pas.",
                  "Probablement je pense", "J'en suis sûr.", "Impossible.", "Alors là, bonne question", "Un ananas", 
                  "Comment ", 
                  "Vous êtes vraiment sûr?", 
                  "Ah, c'est probable.", 
                  "Je ne sais pas du tout si j'en suis un! :D", 
                  "mmmmh miam", 4),
        PommeMasseSoleil("Pierre a 6 pommes. Il en donne 2 à Quentin et 3 à Marc. Quelle est la masse du soleil?", 
                  "1,98892×10^30 kilogrammes", "1 pomme", "2,98468×10^29 kilogrammes", "1,98892×10^33 kilogrammes", "6 grammes",
                  "Euuuh...", "Pardon? Vous insinuez que la Terre tourne autour du soleil?", "1,98892×10^30 kilogrammes", "euuuuh chépa 6 grames?", "ERREUR DE CALCUL", "O_O", "ooga oog booga", "Pierre a 1 pomme.",
                  "1,98892×10^30 kilogrammes évidemment!", "Pierre a 1 pomme.", "2,98468×10^29 kilogrammes évidemment!", "1,98892×10^33 kilogrammes évidemment!", "6 grammes évidemment!", 
                  "Eeet " + nom + ", Nicolas et bumba ont raison!", 
                  "En effet Pierre a 1 pomme à la fin mais ce n'est pas la question posée.", 
                  "Eeet Nicolas et bumba ont raison!", 
                  "Eeet Nicolas et bumba ont raison!", 
                  "Vous vous rendez compte du danger dans lequel nous serions si le soleil fesait 6 grammes?!", 1),
        Truc5("#", 
                  "#", "#", "#", "#", "#",
                  "#", "#", "#", "#", "#", "#", "#", "#",
                  "#", "#", "#", "#", "#", 
                  "#", 
                  "#", 
                  "#", 
                  "#", 
                  "#", 5),
        Polynome("Nous savons tous que les polyn\u00F4mes de Tchebychev de seconde esp\u00E8ce sont d\u00E9finis par cette relation de r\u00E9currence:\n" + //
                "U[n+1] = 2XU[n] - U[n-1], Pour tout n >= 1 avec U[0] = 1 et U[1] = 2X\n" + //
                "Quel polyn\u00F4me de Tchebychev de seconde esp\u00E8ce correspond \u00E0 la 7\u00E8me occurence?", 
                  "U[7] = 16X\u2074-12X\u00B2+1", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 64X\u2077-112X\u2075+56X\u00B3-7X", "U[7] = 256X\u2078-448X\u2076+240X\u2074-40X\u00B2+1", "Aucune des r\u00E9ponses du dessus",
                  "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "PARDON?????", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X",
                  "U[7] = 16X\u2074-12X\u00B2+1", "U[7] = 128X\u2077-192X\u2075+80X\u00B3-8X", "U[7] = 64X\u2077-112X\u2075+56X\u00B3-7X", "U[7] = 256X\u2078-448X\u2076+240X\u2074-40X\u00B2+1", "Aucune de ces réponses ne sont bonnes", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 
                  "Eeeet il se trouve que seul Albert et " + nom + " n'a pas trouvé la réponse, bien que ce soit une connaissance basique.", 2);

        private String intitule;
        private String[] choix;
        private String[] reponses;
        private String[] reponsesJoueur;
        private String[] reponsesPresentateur;
        private int correct;
        private static String[] noms = new String[]{"Brigitte", "Gabriel", "Nicolas", "Jules", "V-43.7", "Mathéo", null, "bumba", "Albert"};

        private Question(String intitule,
                        String choix1, String choix2, String choix3, String choix4, String choix5,
                        String reponseBrigitte, String reponseGabriel, String reponseNicolas, String reponseJules, String reponseV437, String reponseMatheo, String reponseBumba, String reponseAlbert,
                        String reponseJ1, String reponseJ2, String reponseJ3, String reponseJ4, String reponseJ5,
                        String reponseP1, String reponseP2, String reponseP3, String reponseP4, String reponseP5, int correct){
            this.intitule = intitule;
            this.choix = new String[]{choix1, choix2, choix3, choix4, choix5};
            this.reponses = new String[]{reponseBrigitte, reponseGabriel, reponseNicolas, reponseJules, reponseV437, reponseMatheo, randomText(), reponseBumba, reponseAlbert};
            this.reponsesJoueur = new String[]{reponseJ1, reponseJ2, reponseJ3, reponseJ4, reponseJ5};
            this.reponsesPresentateur = new String[]{reponseP1, reponseP2, reponseP3, reponseP4, reponseP5};
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

        public String[] getReponsesPresentateur(){
            return reponsesPresentateur;
        }

        public int getCorrect(){
            return correct;
        }
    }
    //-----------------------





    //---- Classe Window ----- (à spécialiser)
    public static class Window extends Application{
        @Override
        public void start(final Stage primaryStage) {
            Label label = new Label("120.0");

            Button button = new Button();
            button.setText("Open a New Window");

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Label secondLabel = new Label("I'm a Label on new Window");

                    StackPane secondaryLayout = new StackPane();
                    secondaryLayout.getChildren().add(secondLabel);

                    Scene secondScene = new Scene(secondaryLayout, 230, 100);

                    // New window (Stage)
                    Stage newWindow = new Stage();
                    newWindow.setTitle("Second Stage");
                    newWindow.setScene(secondScene);

                    // Set position of second window, related to primary window.
                    newWindow.setX(primaryStage.getX() + 200);
                    newWindow.setY(primaryStage.getY() + 100);

                    newWindow.show();
                }
            });

            StackPane root = new StackPane();
            root.getChildren().add(label);

            Scene scene = new Scene(root, 450, 250);

            primaryStage.setTitle("JavaFX Open a new Window (o7planning.org)");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main() {
            launch();
        }
    }
    //---------------------------------





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
                ecrireNoEnter(nom, q.getReponseJoueur(choix-1), 0.5);
            } else {
                ecrireNoEnter(Question.noms[i-1], q.getReponse(i-1), 0.5);
            }
        }
        ecrire(presentateur, q.getReponsesPresentateur()[choix-1]);
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

    public static void finalSpeech(String nom){
        ecrire(presentateur, "Il se trouve que " + nom + " n'a plus de vies, il va donc devoir nous quitter...");
        ecrire(presentateur, "Dites lui tous adieu!");
        ecrire("Toute la scène", "ADIEUUUU!");
        ecrire(Color.WHITE_BOLD + "Alors que vous quitter le plateau de tournage, vous sentez le désespoir et la misère s'abattre immédiatement sur vous. Cet incroyable carton de 3 mètres cube vous est désormais inaccessible à jamais." + Color.RESET);
        ecrire(Color.RED_BOLD + "\nMAUVAISE FIN" + Color.RESET, 1);
    }





    //----------------------------------------------------------------------------------------------------------





    public static void main(String[] args) {
        com.sun.javafx.application.PlatformImpl.startup(() -> {});

        clearScreen();

        MultiThreading.execute(e -> Window.main());

        System.out.print("Entrez votre nom svp: ");
        nom = sc.nextLine();

        clearScreen();

        if (nom.equals("votre nom svp")){
            sleep(2);
            ecrire("Putain mais t'est super drôle toi");
            sleep(2);
            clearScreen();
            sleep(5);
            ecrire("ratio");
            sleep(1);
            nom = "Catin";
        } else if (nom.equals("Presentateur")){
            cheminPresentateur();
            return ;
        } else if (nom.equals("amogus") || nom.equals("among us")){
            cheminSus();
            return ;
        }
        
        int vies = 5;
        List<Question> questions = Question.listeQuestions();

        clearScreen();

        ecrireNoEnter("Pour des raisons qui devrait se comprendrent, les gros mots sont censuré ▉▉▉▉▉▉ SA MÈRE LA GROSSE ▉▉▉▉ SA RACE DE ▉▉▉▉▉ ok ça fonctionne", 3);

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


        ecrire(presentateur, "Que de magnifiques présentations! \u00C7a devrait impressioner les spectateur tout en donnant de la prestance au participants! (sauf Nicolas)");
        ecrire(presentateur, "Ne tardons donc pas avec notre première question!");


        // Question 1


        ecrireNoEnter(Color.WHITE_BOLD + "Question 1\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Que d'engouement de la part du public pour cette première question! Je peut sentir leur exitation à travers leurs cris!");
		ecrire(presentateur, "Alalah, je sens que ce show va vraiment être incroy-");
		ecrire("Nicolas", "Excusez moi monsieur Présentateur? Je me demandais pourquoi-");
		ecrire(presentateur, "Selon le contrat d'inscription que vous avez signé mon cher Nicolas, vous n'êtes pas autorisé à poser de question. Ici c'est moi qui les pose.");
		ecrire("Nicolas", "Autant pour moi...");
		ecrire(presentateur, "Je suis même autorisé à retirer une vie dans ce cas précis, ce que je vais faire de suite :)");
		ecrire("Nicolas", ":(");
		ecrire(presentateur, "Bref, passons de suite à la question suivante!");


        // Question 2


        ecrireNoEnter(Color.WHITE_BOLD + "Question 2\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Après cette question d'une complexité exceptionnellement grande, laissez moi vous raconter une anecdote de ma vie.");
        ecrire(presentateur, "C'était il y a 35 ans, j'était à l'école primaire avec mon meilleur ami: Chanteur.");


        // Flashback 1


		ecrireNoEnter(Color.WHITE_BOLD + "Il y a 35 ans..." + Color.RESET, 0.5);
        ecrire(Color.YELLOW + "Présentateur (enfant)" + Color.RESET, "Bonjour toi. Tu fait quoi?");
        ecrire("Chanteur (enfant)", "Je donne un super concert à tout ces cailloux!");
        ecrire(Color.YELLOW + "Présentateur (enfant)" + Color.RESET, "Waaa, c'est trop bien! Je peux jouer avec toi?");
        ecrire("Chanteur (enfant)", "Désolé, mais tout les tickets sont pris. Tu peut te mettre dans la poubelle si tu veut.");
        ecrire(Color.YELLOW + "Présentateur (enfant)" + Color.RESET, "Trop bien! " + Color.WHITE_BOLD + "*plonge dans la poubelle et regarde Chanteur donner un concert*" + Color.RESET);
        ecrireNoEnter(Color.WHITE_BOLD + "15 minutes plus tard..." + Color.RESET, 0.75);
        ecrire("Chanteur (enfant)", "Alors, qu'est ce que tu en dit?");
        ecrire(Color.YELLOW + "Présentateur (enfant)" + Color.RESET, "Tu a chanté les deux mêmes notes en boucle pendant 15 minutes mais sinon j'ai adoré! :D");
        ecrire("Chanteur (enfant)", "Dit, tu veut devenir mon copain?");
        ecrire(Color.YELLOW + "Présentateur (enfant)" + Color.RESET, "OUIIIIIIIIIII *O*");
        ecrireNoEnter(Color.WHITE_BOLD + "Et nous sommes de retour au présent." + Color.RESET, 0.5);


        // Fin du flashback


        ecrire(presentateur, "Et c'est ainsi que je suis fait mon tout premier ami.");
        ecrire(presentateur, "J'espère que vous avez aimés cette anecdote, car elle n'a strictement rien à voir avec le show.");
        ecrire(presentateur, "Sur toute cette émotion, la troisième question!");


        // Question 3


        ecrireNoEnter(Color.WHITE_BOLD + "Question 3\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Passons. J'ai une petite faim d'un coup, pas vous?");
        ecrireNoEnter("Nicolas", "Ah tiens, moi au-", 0);
        ecrire(presentateur, "Non.");
        ecrire(presentateur, "Et vous " + nom + ", vous avez faim?");
		System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire(presentateur, "Il faut que je vous avoue quelque chose " + nom + ". La vérité est que je ne vous ait pas écouté.");
        ecrire(presentateur, "Sur ce, je vais aller me chercher un Twix™. " + Color.WHITE_BOLD + "*Se lève de sa chaise et va chercher un Twix*" + Color.RESET);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, "Mmmh, ce Twix fut étonnamment bon.");
        ecrire(presentateur, "Alors, la quatrième question...");
        ecrire(presentateur, "Oh zut, j'ai fait tomber mon deuxième Twix™ dessus!");
        ecrire(presentateur, "Tant pis, je vais faire ma propre quatrième question.");
        ecrire(presentateur, "Donc...");


        // Question 4


        ecrireNoEnter(Color.WHITE_BOLD + "Question 4\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "Oh regardez, une superbe INTERLUDE SPÉCIALE!");

		
		// Interlude spéciale 1

		
		ecrireNoEnter(Color.WHITE_BOLD + "INTERLUDE SPÉCIALE" + Color.RESET, 0.5);
        ecrire(presentateur, "Durant cette interlude spéciale vous avez tous une chance de regagner une vie!");
        ecrire(presentateur, "Mais pour cela vous devez répondre à une question...");
        ecrire(presentateur, "De quelle couleur est ma cravate?\n> ");
        ecrire("Brigitte", "Bleu?");
        ecrire("Gabriel", "Vert!");
        ecrire("Nicolas n'a pas trouvé la réponse.");
        ecrire("Jules", "rouj");
        ecrire("V-43.7", "#AO37DF");
        System.out.print(nom + ": "); sc.next(); System.out.println();
        ecrire("Mathéo", "Mathéo n'a pas trouvé la réponse.");
        ecrire(randomName, randomText());
        ecrire("bumba", "ooga ooga");
        ecrire("Albert", "Toute les couleurs du spectre en même temps!");
        ecrire(presentateur, "Et bien il se trouve que vous avez tous faux. Je n'ai pas de cravate.");
        ecrireNoEnter(Color.WHITE_BOLD + "FIN DE L'INTERLUDE SPÉCIALE" + Color.RESET, 0.5);


        // Transition

        
        ecrire(presentateur, "Quel dommage que personne n'ait réussi à regagner de vies!");
        ecrireNoEnter(presentateur, "...", 1);
        ecrire(presentateur, "Quelque chose ne va pas...");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde sa montre*" + Color.RESET);
        ecrire(presentateur, "Oh non!");
        ecrire(presentateur, "Le jour est arrivé!");
        ecrireNoEnter(presentateur, "Je vais mourir d'un arrêt cardiaque d'ici 3...", 1);
        ecrireNoEnter(presentateur, "2...", 1);
        ecrireNoEnter(presentateur, "1...", 1);
        ecrire(presentateur, Color.WHITE_BOLD + "*attend*" + Color.RESET);
        ecrire(presentateur, Color.WHITE_BOLD + "*se questionne*" + Color.RESET);
        ecrire(presentateur, Color.WHITE_BOLD + "*sort un calendrier et le regarde*" + Color.RESET);
        ecrire(presentateur, "Autant pour moi, ce jour arrivera la semaine prochaine.");
        ecrire(presentateur, "Désormais, la question 5!");


        // Question 5


        ecrireNoEnter(Color.WHITE_BOLD + "Question 5\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "ATTENDEZ UNE MINUTE!");
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, "Quelqu'un arrive...");
        ecrire("Chanteur", "BONSOIR TOUT LE MONDE!!!");
        ecrire(presentateur, "Chanteur!");
        ecrire(Color.WHITE_BOLD + "*Toute la foule se met à crier*" + Color.RESET);
        ecrire("Chanteur", Color.WHITE_BOLD + "*Prend une guitare*" + Color.RESET);
        ecrire(Color.WHITE_BOLD + "*Toute la foule se tait*" + Color.RESET);
        ecrireNoEnter("...", 1);
        //MediaPlayer soloEpique = sound("assets/questionPourUnCarton/solo_épique.wav", 20);
        //soloEpique.play()
        ecrireNoEnter("Chanteur", Color.WHITE_BOLD + "*SOLO DE GUITARE EPIQUE*" + Color.RESET, 5);
        ecrire(presentateur, "Viens ici espèce de ▉▉▉▉▉▉▉▉!");
        ecrire(Color.WHITE_BOLD + "*Grosse poignée de main bien virile*" + Color.RESET);
        ecrire("Chanteur", "Alors tu devient quoi vieux ▉▉▉▉▉▉?");
        ecrire(presentateur, "Pas grand chose, j'ai percé à la télé et maintenant je fait un show télévisé.");
        ecrire("Chanteur", "▉▉▉▉▉▉, pas mal.");
        ecrire(presentateur, "Par contre fait gaffe aux ▉▉▉▉▉▉ que tu dit, ce show est Family Friendly.");
        ecrire("Chanteur", "▉▉▉▉▉ désolé.");
        ecrire(presentateur, "Bon on a peut être pas le temps pour les retrouvailles, il faut continuer le show.");
        ecrire("Chanteur", "Ok pas de soucis.");
        ecrire(presentateur, "Du coup euuuuuh... On en était ou déjà...");
        ecrire(presentateur, "Oui c'est vrai question 6!");


        // Question 6


        ecrireNoEnter(Color.WHITE_BOLD + "Question 6\n" + Color.RESET, 0.5);
        vies = poserQuestion(questions, vies, nom);
        if (isFinished(vies)){
            finalSpeech(nom);
            return ;
        }


        // Transition


        ecrire(presentateur, "");

        if (choixChemin("Rester sur le plateau", "Sortir du plateau") == 1){
            cheminDehors();
            return ;
        }
        
        ecrire(presentateur, "");
    }





    //----------------------------------------------------------------------------------------------------------





    public static void cheminPresentateur(){
        clearScreen();

        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde l'heure*" + Color.RESET);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde à nouveau l'heure*" + Color.RESET);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrire(presentateur, "Mais ou est-il?");
        ecrire(presentateur, "Il est sensé être là, et le show aurait même déjà commencé!");
        ecrire(presentateur, Color.WHITE_BOLD + "*regarde encore l'heure*" + Color.RESET);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
        ecrireNoEnter("...", 1);
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

    public static void cheminSus(){
        clearScreen();

        ecrire(presentateur, "SUS");
        ecrire(presentateur, "SUS SUS AMONGUS");
        ecrire(presentateur, "SUSSY SUS AMONG US");

        return ;
    }
    
    public static void cheminDehors(){
        //
    }
}