public class Terrain extends Carte{
    private static boolean noEffect = false;

    public Terrain(int id, String n, String d){
	    super(id, n, d);
    }

    public static boolean getNoEffect(){
        return noEffect;
    }

    public static void setNoEffect(boolean ne){
        Terrain.noEffect = ne;
    }

    @Override
    public boolean isTerrain(){
	    return true;
    }
}
