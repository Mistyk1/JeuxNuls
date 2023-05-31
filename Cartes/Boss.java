public class Boss extends Personnage{
    public Boss(int id, String n, String d, int de, int a, int p, int b, int i){
	    super(id, n, d, de, a, p, b, i);
    }

    @Override
    public boolean isBoss(){
	    return true;
    }
}
