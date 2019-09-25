public class Enemy extends Sprite {

    int health;

    public Enemy(int x, int y, int speed){
        super(x,y, Sprite.SOUTH, speed);
        health=10;
        setPic("basic-enemy.PNG", Sprite.SOUTH);
    }

    boolean healthSubtract(int damage){
        health -= damage;
        if (health <= 0)
            return true;
        return false;
    }

}
