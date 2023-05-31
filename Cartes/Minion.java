public class Minion extends Personnage{
    public Minion(int id, String n, String d, int de, int a, int p, int b, int im){
	    super(id, n, d, de, a, p, b, im);
        for (int i = 0; i < stats.length; i += 1){
            if (stats[i] > 5){
                stats[i] = 5;
            }
        }
    }

    @Override
    public boolean isMinion(){
	    return true;
    }
}
