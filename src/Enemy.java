public class Enemy extends Sprite {

    int speed, health;

    public Enemy(int x, int y){
        super(x,y, Sprite.SOUTH, 2);
        health=3;
        setPic("basic-enemy.PNG", Sprite.SOUTH);
    }

}
