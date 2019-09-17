public class Boss_Enemy extends Sprite {

    int speed, health;

    public Boss_Enemy(int x, int y){
        super(x,y, Sprite.SOUTH, 1);
        health=1;
        setPic("boss-enemy.PNG", Sprite.SOUTH);
    }



}
