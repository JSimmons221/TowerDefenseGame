public class ThickEnemy extends Enemy {
    public ThickEnemy(int level){
        super(Main.WIDTH*3+Main.HWIDTH-18, -32, 2, 10, "thicc-enemy.png", level);
    }

    @Override
    public String getName (){
        return "ThickEnemy";
    }
}
