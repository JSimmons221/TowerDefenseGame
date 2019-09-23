import apple.laf.JRSUIConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Main extends JPanel{

    public static final int WIDTH=40;
    int hWIDTH, qWIDTH;
    private Timer timer;
    private int countBasic, countFast, countThicc, countBoss;
    Tile[][] map;
    ArrayList<Sprite> enemies = new ArrayList<Sprite>();
    ArrayList<Sprite> decor = new ArrayList<Sprite>();
    private int gold, health;
    ArrayList<Tower> towers = new ArrayList<Tower>();



    public Main(){
        countBasic = 0; countFast = 0; countThicc = 0; countBoss = 0;
        timer = new Timer(1000 / 60, e -> update());
        timer.start();
        hWIDTH=WIDTH/2;
        qWIDTH=WIDTH/4;
        setKeyListener();
        setMouseListener();
        enemies.add(new Enemy(WIDTH*3+qWIDTH, 0));
        map = MapReader.main();
        towers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int x=(int)(Math.random()*(Main.WIDTH/2+Main.WIDTH*20));
            int y=(int)(Math.random()*(Main.WIDTH/2+Main.WIDTH*20));
            decor.add(new Rock1(x,y,decor));
        }

    }

    public void update() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
        }
        for (int i = 0; i < towers.size(); i++) {
            towers.get(i).update(enemies);
        }
        enemySpawn();
        directionChange();
        repaint();
    }

    public void enemySpawn(){
        countBasic += (int)(Math.random()*5);
        countFast += (int)(Math.random()*5);
        countThicc += (int)(Math.random()*5);
        countBoss ++;

        if(countBasic == 50){
            enemies.add(new Enemy(WIDTH*3+qWIDTH,-WIDTH));
            countBasic = 0;
        }

        if(countFast == 225){
            enemies.add(new Fast_Enemy(WIDTH*3+qWIDTH,-WIDTH));
            countFast = 0;
        }

        if(countThicc == 600){
            enemies.add(new Thicc_Enemy(WIDTH*3+qWIDTH,-WIDTH));
            countThicc = 0;
        }

        if(countBoss == 900){
            enemies.add(new Boss_Enemy(WIDTH*3+qWIDTH,-WIDTH));
            countBoss = 0;
        }


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j].draw(g2);
            }
        }
        //tile lines
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(1));
        for (int i = 1; i < 840; i+=40) {
            for (int j = 1; j < 822; j+=40) {
                g2.drawLine(i,0,i,822);
                g2.drawLine(0,j,840,j);
            }
        }

        for (int i = 0; i < decor.size(); i++) {
            decor.get(i).draw(g2);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g2);
        }



    }

    public void setActionListener(){

    }

    public void setKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void setMouseListener(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) { //****************
                int x = e.getX()/WIDTH;
                int y = e.getY()/WIDTH;
                System.out.println(x + " " + y);

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        map[i][j].setFilled(false);
                    }
                }
                if (x<21 && y<21){
                    if (map[x][y].getClass().getSimpleName()=="TowerTile"
                            && map[x+1][y].getClass().getSimpleName()== "TowerTile"
                            && map[x][y+1].getClass().getSimpleName()=="TowerTile"
                            && map[x+1][y+1].getClass().getSimpleName()=="TowerTile"){
                        System.out.println(1);

                    }
                }

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

    public void directionChange (){
        for (int i = 0; i < enemies.size(); i++) {
            int x = (int)(enemies.get(i).getCenterPoint().getX());
            int y = (int)(enemies.get(i).getCenterPoint().getY());
            if (WIDTH*3<x && x<WIDTH*4 && WIDTH*12<y && y<WIDTH*13){
                enemies.get(i).setDir(Sprite.EAST);
            }
            if (WIDTH*10<x && x<WIDTH*11 && WIDTH*12<y && y<WIDTH*13){
                enemies.get(i).setDir(Sprite.NORTH);
            }

            if (WIDTH*10<x && x<WIDTH*11 && WIDTH*3<y && y<WIDTH*4){
                enemies.get(i).setDir(Sprite.EAST);
            }

            if (WIDTH*17<x && x<WIDTH*18 && WIDTH*3<y && y<WIDTH*4){
                enemies.get(i).setDir(Sprite.SOUTH);
            }

            if (WIDTH*17<x && x<WIDTH*18 && WIDTH*17<y && y<WIDTH*18){
                enemies.get(i).setDir(Sprite.WEST);
            }
        }
    }

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setBounds(0, 0, WIDTH*21, WIDTH*20 + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }

}

