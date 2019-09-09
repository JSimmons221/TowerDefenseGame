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
        setPic("blank.png", NORTH);  //Assumes pic is oriented NORTH by default
        speed = this.speed;

        id = nextID;
        nextID++;
    }

    /**
     * Changes the image file that this Sprite uses to draw.
     * Assumes the file is in the res folder.
     * @param fileName    the case-sensitive file name
     * @param orientation the direction that the image file is facing
     */
    public void setPic(String fileName, int orientation) {
        try {
            pic = ImageIO.read(new File("res/" + fileName));
            picOrientation = orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This draws the image pic at the Point loc, rotated to face dir.
     */
    public void draw(Graphics2D g2) {
        double rotationRequired = Math.toRadians(picOrientation - dir);
        double halfWidth = pic.getWidth() / 2;
        double halfHeight = pic.getHeight() / 2;
        g2.rotate(rotationRequired, loc.x + halfWidth, loc.y + halfHeight);
        g2.drawImage(pic, loc.x, loc.y, null);
        g2.rotate(-rotationRequired, loc.x + halfWidth, loc.y + halfHeight);
    }

    /**
     * Moves the pic in the direction the Sprite is facing (dir).
     */
    public void update() {
        int dx = (int) (Math.cos(Math.toRadians(dir)) * speed);
        int dy = -(int) (Math.sin(Math.toRadians(dir)) * speed);
        loc.translate(dx, dy);
    }

    /**
     * Changes the direction the Sprite is facing by the given angle.
     *
     * @param delta change in angle measured in degrees
     */
    public void rotateBy(int delta) {
        setDir(dir + delta);
    }

    /**
     * Changes the direction the Sprite is facing to the given angle.
     *
     * @param newDir the new direction measured in degrees
     */
    public void setDir(int newDir) {
        dir = newDir;
    }

    public void setPic(BufferedImage pic) {
        this.pic = pic;
    }

    /**
     * Returns the center of this Sprite
     */
    public Point getCenterPoint() {
        return new Point(loc.x + pic.getWidth() / 2, loc.y + pic.getHeight() / 2);
    }

    /**
     * Changes the speed of this Sprite
     */
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
}
