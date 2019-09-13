import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Main extends JPanel{

    public static final int WIDTH=40;
    int hWIDTH, qWIDTH;
    private Timer timer;
    Tile[][] map;
    ArrayList<Sprite> enemies = new ArrayList<Sprite>();
    ArrayList<Sprite> decor = new ArrayList<Sprite>();
    private int gold, health;



    public Main(){
        timer = new Timer(1000 / 60, e -> update());
        timer.start();
        hWIDTH=WIDTH/2;
        qWIDTH=WIDTH/4;
        setKeyListener();
        setMouseListener();
        enemies.add(new Enemy(WIDTH*3+qWIDTH, 0));
        map = MapReader.main();
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
        directionChange();
        repaint();
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

