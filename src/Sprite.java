import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sprite {

    public static final int NORTH = 90, SOUTH = 270, WEST = 180, EAST = 0, NE = 45, NW = 135, SW = 225, SE = 315;
    private static int nextID = 1; //static instance fields- there is ONE shared variable for all objects of this class.
    private Point loc; //top left corner of this Sprite. Note loc.x and loc.y are the easy way to access the point.
    private int dir, picOrientation; //dir is the current direction in degrees.  See the constants below.
    private BufferedImage pic; //put the file in the res folder.
    private int speed; //Number of pixels moved each frame.
    private int id;

    public Sprite(int x, int y, int dir, int speed) {
        this.loc = new Point(x, y);
        this.dir = dir;
        setPic("Blank.png", NORTH);  //Assumes pic is oriented NORTH by default
        this.speed=speed;

        id = nextID;
        nextID++;
    }

    public void setPic(String fileName, int orientation) {
        try {
            pic = ImageIO.read(new File("res/" + fileName));
            picOrientation = orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean intersects(Sprite other) {
        return getBoundingRectangle().intersects(other.getBoundingRectangle());
    }

    public Rectangle getBoundingRectangle() {
        Rectangle box = null;
        if (picOrientation % 180 != 0)
            if (facingEast() || facingWest())
                box = new Rectangle(loc.x, loc.y, pic.getHeight(), pic.getWidth());
            else
                box = new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
        else if (facingEast() || facingWest())
            box = new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
        else
            box = new Rectangle(loc.x, loc.y, pic.getHeight(), pic.getWidth());

        return box;

    }
    public boolean facingEast() {
        return dir % 360 < 90 || dir % 360 > 270;
    }

    public boolean facingWest() {
        return dir % 360 > 90 && dir % 360 < 270;
    }


    public void draw(Graphics2D g2) {
        double rotationRequired = Math.toRadians(picOrientation - dir);
        double halfWidth = pic.getWidth() / 2;
        double halfHeight = pic.getHeight() / 2;
        g2.rotate(rotationRequired, loc.x + halfWidth, loc.y + halfHeight);
        g2.drawImage(pic, loc.x, loc.y, null);
        g2.rotate(-rotationRequired, loc.x + halfWidth, loc.y + halfHeight);
    }

    public void update() {
        int dx = (int) (Math.cos(Math.toRadians(dir)) * speed);
        int dy = -(int) (Math.sin(Math.toRadians(dir)) * speed);
        System.out.println(dx + " " + dy);
        loc.translate(dx, dy);
    }

    public void rotateBy(int delta) {
        setDir(dir + delta);
    }

    public void setDir(int newDir) {
        dir = newDir;
    }

    public void setPic(BufferedImage pic) {
        this.pic = pic;
    }

    public void setLoc(Point loc) {
        this.loc = loc;
    }

    public Point getCenterPoint() {
        return new Point(loc.x + pic.getWidth() / 2, loc.y + pic.getHeight() / 2);
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
}
