public class Boss_Enemy extends Sprite {

    int speed, health;

    public Boss_Enemy(){
        super(0,0, Sprite.SOUTH, 5);
        health=1;
        setPic("boss-enemy.PNG", Sprite.SOUTH);
    }



}
