public class FastEnemy extends Enemy{
    public FastEnemy(int level) {
        super(Main.WIDTH*3+Main.HWIDTH-16, -32, 4, 1, "fast-enemy.png", level);
    }

    @Override
    public String getName (){
        return "FastEnemy";
    }
}
