import java.awt.*;

public class Fast_Enemy extends Enemy {

    int speed, health;

    public Fast_Enemy(int x, int y){
        super(x,y,4);
        health = 1;
        setPic("fast-enemy.PNG", Sprite.SOUTH);
    }



}
