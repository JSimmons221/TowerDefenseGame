public class BasicEnemy extends Enemy{
    public BasicEnemy(int level){
        super(Main.WIDTH*3+Main.HWIDTH-11,-30,3,3,"basic-enemy.png", level);
    }

    @Override
    public String getName (){
        return "BasicEnemy";
    }
}
