public class Enemy extends Sprite {

    int speed, health;

    public Enemy(){
        super(0,0, Sprite.SOUTH, 5);
        health=3;
        setPic("Circle.PNG", Sprite.SOUTH);
    }

}
