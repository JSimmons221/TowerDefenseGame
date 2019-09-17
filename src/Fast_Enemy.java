import java.awt.*;

public class Fast_Enemy extends Sprite {

    int speed, health;

    public Fast_Enemy(int x, int y){
        super(0,0, Sprite.SOUTH, 5);
        health = 1;
        setPic("fast-enemy.PNG", Sprite.SOUTH);
    }



}
