import java.util.ArrayList;

public class Rock1 extends Sprite {


    public Rock1(int x, int y, ArrayList<Sprite> obstacles){
        super(x,y,NORTH,0);
        setPic("PixelRock.png",Sprite.NORTH);
    }


}
