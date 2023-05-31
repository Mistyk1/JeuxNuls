import java.util.Random;

public class CarteInit {
    private static Random r = new Random();

    public static Carte glitchedCarte(){
        String n = "";
        String d = "";
        boolean ip;
        for (int i = 0; i < r.nextInt(20); i += 1){
            n += (char)(r.nextInt(256));
        }
        for (int i = 0; i < r.nextInt(50); i += 1){
            d += (char)(r.nextInt(256));
        }
        ip = (r.nextInt(1) == 1);
        return new Artefact(-99999, n, d, ip);
    }

    public static Carte init(int id){
        Carte c = null;
        if (id == 0){
            c = new Personnage(id, "Dio", "Vol de vie", 2, 5, 10, 1, 0);
        } else if (id == 1){
            c = new Personnage(id, "Alpha", "Régénère 1 PV par tour", 5, 1, 7, 1, 0);
        } else if (id == 1000){
            c = new Artefact(id, "The power of friendship", "Volez 2 points d'agilité à un ennemi", true);
        } else if (id == 1001){
            if (r.nextInt(10) == 10){
                c = new Artefact(id, "Armure en Scénarium", "Protège de tout les effets de toutes les cartes alliée ou ennemies, sauf les cartes de la série \"Scénario\"", true);
            }
        } else if (id == 1002){
            c = new Artefact(id, "Brise-monde", "L'effet du/des lieu est inactif", true);
        } else {
            c = glitchedCarte();
        }
        return c;
    }
}
