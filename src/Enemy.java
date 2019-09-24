public class Enemy extends Sprite {

    int speed, health;

    public Enemy(int x, int y){
        super(x,y, Sprite.SOUTH, 2);
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
