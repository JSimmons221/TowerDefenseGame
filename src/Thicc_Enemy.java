public class Thicc_Enemy extends Sprite {

    int speed, health;

    public Thicc_Enemy(int x, int y){
        super(x,y, Sprite.SOUTH, 1);
        health=1;
        setPic("thicc-enemy.PNG", Sprite.SOUTH);
    }



}