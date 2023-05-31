public class Artefact extends Carte{
    private boolean passive;
    private boolean inUse;

    public Artefact(int id, String n, String d, boolean p){
	    super(id, n, d);
        this.passive = p;
        this.inUse = false;
    }
    
    @Override
    public boolean isArtefact(){
	    return true;
    }

    public boolean isPassive(){
        return passive;
    }

    public void effect(Personnage assoc, Personnage ennem){
        if (!inUse){
            if (id == 1000){
                assoc.getStats()[1] += 2;
                ennem.getStats()[1] -= 2;
            } else if (id == 1001){
                assoc.setImmune(-1);
            } else if (id == 1002){
                Terrain.setNoEffect(true);
            }
            inUse = true;
        }
    }
}