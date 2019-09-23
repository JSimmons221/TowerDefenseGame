import java.awt.*;

public class Fast_Enemy extends Sprite {

    int speed, health;

    public Fast_Enemy(int x, int y){
        super(x,y, Sprite.SOUTH, 5);
        health = 1;
        setPic("fast-enemy.PNG", Sprite.SOUTH);
    }



}
