import java.util.ArrayList;

public class JoueurCarte{
    private String nom;
    private String equipe;
    private ArrayList<Carte> deck;

    public JoueurCarte(String n){
	    this.nom = n;
    }

    public void setEquipe(String e){
	    this.equipe = e;
    }

    public String getNom(){
	    return this.nom;
    }

    public String getEquipe(){
	    return this.equipe;
    }

    public ArrayList<Carte> getDeck(){
	    return this.deck;
    }

    public void ajouterCarte(Carte c){
	    this.deck.add(c);
    }

    public boolean memeEquipe(JoueurCarte jc){
	    return this.equipe.equals(jc.equipe);
    }
}