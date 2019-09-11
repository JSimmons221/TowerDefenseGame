import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;


public class Main extends JPanel{

    public static final int WIDTH=20;
    private Timer timer;
    Tile[][] map;
    private int gold, health;



    public Main(){
        timer = new Timer(1000 / 60, e -> update());
        timer.start();
        setKeyListener();
        map = new Tile[21][21];
        for (int i = 2; i < 5; i++) {

        }

    }

    public void update() {


        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;




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

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setBounds(0, 0, WIDTH*21, WIDTH*21 + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }

}

