import java.awt.*;
import java.util.ArrayList;

public class Tower {

    private boolean selected;
    private int x,y,dps,range,timer,upgradeCost,timerMax; //dps=damage per shot not second

    public Tower (int x,int y){
        this.x=x;
        this.y=y;
        timer=0;
        dps=2;
        range=Main.WIDTH*5;
        upgradeCost=50;
        timerMax=60;
    }


    void draw(Graphics2D g2){
        if (selected){
            g2.setColor(new Color(0,255,0,100));
            g2.fillOval(x*Main.WIDTH-range+Main.WIDTH,y*Main.WIDTH-range+Main.WIDTH,range*2,range*2);
            g2.setColor(Color.black);
            g2.drawOval(x*Main.WIDTH-range+Main.WIDTH,y*Main.WIDTH-range+Main.WIDTH,range*2,range*2);
        }
        g2.setColor(new Color(153,93,51));
        g2.fillOval(x*Main.WIDTH+Main.QWIDTH,y*Main.WIDTH+Main.QWIDTH,
                Main.WIDTH*2-Main.HWIDTH,Main.WIDTH*2-Main.HWIDTH);
        g2.setColor(new Color(153,22,13));
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(x*Main.WIDTH+Main.QWIDTH,y*Main.WIDTH+Main.QWIDTH,
                Main.WIDTH*2-Main.HWIDTH,Main.WIDTH*2-Main.HWIDTH);
        g2.setStroke(new BasicStroke(1));
    }

    public int update (ArrayList<Enemy> enemies){
        if (timer<=0){
            int xLoc = (x+1)*Main.WIDTH;
            int yLoc = (y+1)*Main.WIDTH;
            for (int i = 0; i < enemies.size(); i++) {
                int xdist=(int)(enemies.get(i).getCenterPoint().getX()-xLoc);
                int ydist=(int)(enemies.get(i).getCenterPoint().getY()-yLoc);
                int dist=(int)(Math.sqrt(xdist*xdist+ydist*ydist));
                if (dist<=range){
                    timer=timerMax;
                    return i;
                }
            }
        }
        timer--;
        return -1;
    }

    public void upgrade (){
        dps+=2;
        range+=Main.QWIDTH;
        timerMax=timerMax/4*3;
        upgradeCost+=50;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getDps() {
        return dps;
    }
}
