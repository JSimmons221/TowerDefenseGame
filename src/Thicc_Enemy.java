public class Thicc_Enemy extends Enemy {

    int speed, health;

    public Thicc_Enemy(int x, int y){
        super(x,y);
        health=1;
        setPic("thicc-enemy.PNG", Sprite.SOUTH);
    }



}