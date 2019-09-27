import java.awt.*;

public class Tile {

    private boolean path;
    private boolean filled;
    private boolean selected;
    private int x,y, towerNum;

    public Tile (int x,int y, boolean path){
        this.path=path;
        this.x=x;
        this.y=y;
        selected=false;
        filled=false;
    }

    public void draw(Graphics2D g2){
        if (path){
            g2.setColor(new Color(169,169,169));
            g2.fillRect(x*Main.WIDTH,y*Main.WIDTH,Main.WIDTH,Main.WIDTH);
        }else{
            if (selected){
                g2.setColor(Color.GREEN);
                g2.fillRect(x*Main.WIDTH,y*Main.WIDTH,Main.WIDTH,Main.WIDTH);
            }else{
                g2.setColor(new Color(105,105,105));
                g2.fillRect(x*Main.WIDTH,y*Main.WIDTH,Main.WIDTH,Main.WIDTH);
            }
        }
    }

    public boolean isFilled() {
        return filled;
    }
    public boolean isSelected() {
        return selected;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public int getTowerNum() {
        return towerNum;
    }
    public void setTowerNum(int towerNum) {
        this.towerNum = towerNum;
    }
    public boolean isPath() {
        return path;
    }
}
