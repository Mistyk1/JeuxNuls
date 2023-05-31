public abstract class Carte{
    protected int id;
    protected String nom;
    protected String description;

    public Carte(int id, String n, String d){
        this.id = id;
	    this.nom = n;
        this.description = d;
    }

    public boolean isPersonnage(){
	    return false;
    }
    
    public boolean isMinion(){
        return false;
    } 

    public boolean isBoss(){
        return false;
    }
    
    public boolean isArtefact(){
        return false;
    }

    public boolean isTerrain(){
        return false;
    }

    public String toString(){
        return "[" + nom + "|" + description + "]";
    }
}
