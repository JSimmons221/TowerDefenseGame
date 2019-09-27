public abstract class Enemy extends Sprite{

    private int health;
    boolean dead;
    public Enemy (int x, int y, int Speed, int health, String pic,int level){
        super(x,y,Sprite.SOUTH,Speed);
        setPic(pic, Sprite.SOUTH);
        this.health=health;
        levelUp(level);
        dead=false;
    }

    void looseHealth(int damage){
        health-=damage;
        if (health<=0)
            dead = true;
    }

    public void levelUp (int level){
        for (int i = 0; i < level-1; i++) {
            health+=health;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public String getName (){
        return "Enemy";
    }
}
