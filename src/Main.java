import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JPanel{

    public static final int WIDTH=40, HWIDTH=WIDTH/2, QWIDTH=WIDTH/4;
    private Timer timer;
    private Tile[][] map;
    private int level, levelCounter, enemySpawn, spawnb, spawnf, spawnt, spawnB;
    private ArrayList<Enemy> enemies;
    private ArrayList<Tower> towers;
    private int selectedTower;
    private Point selectedTile;
    private int money,health;



    public Main(){

        selectedTower=-1;
        selectedTile = new Point();
        selectedTile.setLocation(-1,-1);

        timer = new Timer(1000 / 30, e -> update());
        timer.start();
        setKeyListener();
        setMouseListener();

        map = MapReader.main();

        level=1;
        levelCounter=0;
        spawnb=90;
        spawnf=180;
        spawnt=270;
        spawnB=50;

        enemies = new ArrayList<>();
        towers = new ArrayList<>();

        money=1000;
        health=200;
    }

    public void update() {
        for (Enemy e:enemies) {
            e.update();
        }
        for (Tower t:towers){
            t.update(enemies);
        }
        damageEnemies();
        reachEnd();
        directionChange();
        spawnEnemies();
        repaint();
    }

    public void spawnEnemies(){
        enemySpawn++;
        if (enemySpawn%spawnb==0){
            enemies.add(new BasicEnemy(level));
        }
        if (enemySpawn%spawnf==0){
            enemies.add(new FastEnemy(level));
        }
        if (enemySpawn%spawnt==0){
            enemies.add(new ThickEnemy(level));
        }
        if (levelCounter>=spawnB){
            enemies.add(new BossEnemy(level));
            enemySpawn=0;
            spawnb=spawnb*7/8;
            spawnf=spawnf*7/8;
            spawnt=spawnt*7/8;
            spawnB=level*level*50;
            level++;
        }
    }

    public void reachEnd(){
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getCenterPoint().getX()<-WIDTH){
                if (enemies.get(i).getName()=="BasicEnemy"){
                    health--;
                }
                if (enemies.get(i).getName()=="FastEnemy"){
                    health-=2;
                }
                if (enemies.get(i).getName()=="ThickEnemy"){
                    health-=10;
                }
                if (enemies.get(i).getName()=="BossEnemy")
                    health-=20;
                enemies.remove(i);
                i--;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                map[y][x].draw(g2);
            }
        }
        for (int i = 1; i < 21; i++) {
            g2.setColor(new Color(20,20,20));
            g2.drawLine(i*WIDTH,0,i*WIDTH,WIDTH*21);
            g2.drawLine(0,i*WIDTH,WIDTH*20,i*WIDTH);
        }
        for (Enemy e:enemies) {
            e.draw(g2);
        }
        for (Tower t:towers){
            t.draw(g2);
        }
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.setColor(Color.yellow);
        g2.drawString("$" + money, WIDTH*18-QWIDTH,22);
        g2.setColor(Color.red);
        g2.drawString("Health:" + health,WIDTH*17-HWIDTH-2,44);
        g2.setColor(Color.black);
        g2.drawString("Boss Counter:" + levelCounter + "/" + spawnB,WIDTH*10,22);
        if (health==0){
            g2.drawString("GAME OVER", WIDTH*10, WIDTH*10);
        }

    }

    public void setKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (selectedTile.getX()!=-1 && e.getKeyCode()==49 && money>=200){

                    map[(int)selectedTile.getY()][(int)selectedTile.getX()].setSelected(false);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()].setSelected(false);
                    map[(int)selectedTile.getY()][(int)selectedTile.getX()+1].setSelected(false);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()+1].setSelected(false);

                    map[(int)selectedTile.getY()][(int)selectedTile.getX()].setFilled(true);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()].setFilled(true);
                    map[(int)selectedTile.getY()][(int)selectedTile.getX()+1].setFilled(true);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()+1].setFilled(true);

                    towers.add(new Tower((int)selectedTile.getX(),(int)selectedTile.getY()));

                    map[(int)selectedTile.getY()][(int)selectedTile.getX()].setTowerNum(towers.size()-1);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()].setTowerNum(towers.size()-1);
                    map[(int)selectedTile.getY()][(int)selectedTile.getX()+1].setTowerNum(towers.size()-1);
                    map[(int)selectedTile.getY()+1][(int)selectedTile.getX()+1].setTowerNum(towers.size()-1);

                    selectedTile.setLocation(-1,-1);
                    money-=200;
                }
                if (selectedTower!=-1 && e.getKeyCode()==49 && money>=towers.get(selectedTower).getUpgradeCost()){

                    money-=towers.get(selectedTower).getUpgradeCost();
                    towers.get(selectedTower).upgrade();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void setMouseListener(){
        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {

                for (Tile[] ta:map){
                    for (Tile t:ta){
                        t.setSelected(false);
                    }
                }
                for (Tower t: towers){
                    t.setSelected(false);
                }

                int x = e.getX()/WIDTH;
                int y = e.getY()/WIDTH;

                if (map[y][x].isFilled()){
                    selectedTower=map[y][x].getTowerNum();
                    towers.get(map[y][x].getTowerNum()).setSelected(true);
                }

                else if (!map[y][x].isPath()){
                    if (!map[y+1][x].isPath() && !map[y+1][x].isFilled()){
                        if (!map[y][x+1].isPath() && !map[y][x+1].isFilled()){
                            if (!map[y+1][x+1].isPath() && !map[y+1][x+1].isFilled()) {
                                map[y][x].setSelected(true);
                                map[y + 1][x].setSelected(true);
                                map[y][x + 1].setSelected(true);
                                map[y + 1][x + 1].setSelected(true);
                                selectedTile.setLocation(x,y);
                            }
                        }
                    }
                }

            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void directionChange(){
        for (Enemy e:enemies) {
            if (e.getCenterPoint().getY()>=WIDTH*11+HWIDTH && e.getCenterPoint().getY()<=WIDTH*12
                    && e.getCenterPoint().getX()<=WIDTH*4){
                e.setDir(Sprite.EAST);
            }
            if (e.getCenterPoint().getY()>=WIDTH*11 && e.getCenterPoint().getY()<=WIDTH*12
                    && e.getCenterPoint().getX()>=WIDTH*10+HWIDTH && e.getCenterPoint().getX()<=WIDTH*12){
                e.setDir(Sprite.NORTH);
            }
            if (e.getCenterPoint().getY()>=WIDTH*3 && e.getCenterPoint().getY()<=WIDTH*3+HWIDTH
                    && e.getCenterPoint().getX()>=WIDTH*10 && e.getCenterPoint().getX()<=WIDTH*11){
                e.setDir(Sprite.EAST);
            }
            if (e.getCenterPoint().getY()>=WIDTH*3 && e.getCenterPoint().getY()<=WIDTH*4
                    && e.getCenterPoint().getX()>=WIDTH*17+HWIDTH && e.getCenterPoint().getX()<=WIDTH*18){
                e.setDir(Sprite.SOUTH);
            }
            if (e.getCenterPoint().getY()>=WIDTH*16+HWIDTH && e.getCenterPoint().getY()<=WIDTH*17
                    && e.getCenterPoint().getX()>=WIDTH*17 && e.getCenterPoint().getX()<=WIDTH*18){
                e.setDir(Sprite.WEST);
            }
        }
    }

    public void damageEnemies(){
        for (Tower t:towers) {
            int e = t.update(enemies);
            if (e!=-1){
                enemies.get(e).looseHealth(t.getDps());
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).isDead()){
                if (enemies.get(i).getName()=="BasicEnemy"){
                    levelCounter++;
                    money+=level*5;
                }
                if (enemies.get(i).getName()=="FastEnemy"){
                    levelCounter+=2;
                    money+=level*10;
                }
                if (enemies.get(i).getName()=="ThickEnemy"){
                    levelCounter+=2;
                    money+=level*10;
                }
                if (enemies.get(i).getName()=="BossEnemy")
                    money+=100*level;
                enemies.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setBounds(0, 0, WIDTH*20, WIDTH*21 + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }

}

