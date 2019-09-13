public class Thicc_Enemy extends Sprite {

    int speed, health;

    public Thicc_Enemy(){
        super(0,0, Sprite.SOUTH, 5);
        health=1;
        setPic("thicc-enemy.PNG", Sprite.SOUTH);
    }



}