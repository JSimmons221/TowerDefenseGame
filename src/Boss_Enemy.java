public class Boss_Enemy extends Enemy {

    int speed, health;

    public Boss_Enemy(int x, int y){
        super(x,y);
        health=1;
        setPic("boss-enemy.PNG", Sprite.SOUTH);
    }



}
