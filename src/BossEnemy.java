public class BossEnemy extends Enemy{
    public BossEnemy(int level){
        super(Main.WIDTH*3+Main.HWIDTH-23, -50, 1, 50, "boss-enemy.png", level);
    }

    @Override
    public String getName (){
        return "BossEnemy";
    }
}
