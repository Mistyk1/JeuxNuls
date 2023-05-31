public class Personnage extends Carte{
  protected int[] stats = new int[5];
  protected int immune;

  public Personnage(int id, String n, String d, int de, int a, int p, int b, int i){
    super(id, n, d);
    this.stats[0] = de;
    this.stats[1] = a;
    this.stats[2] = p;
    this.stats[3] = b;
    this.stats[4] = 0;
    this.immune = i;
  }

  public int[] getStats(){
    return stats;
  }

  public int getImmune(){
    return immune;
  }

  public void setImmune(int i){
    this.immune = i;
  }

  public boolean isDead(){
    return stats[2] <= 0;
  }

  @Override
  public boolean isPersonnage(){
    return true;
  }

  @Override
  public String toString(){
    return "[" + nom + "|" + stats[0] + "|" + stats[1] + "|" + stats[2] + "|" + stats[3] + "|" + description + "]";
  }
}
