import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MapReader {


    public static Tile[][] main() {

        Tile[][] map = new Tile[20][21];
        int a=0;

        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(new File("./res/TileMap")));
            String line = reader.readLine();
            while(line != null){
                String[] chars = line.split("");
                for(String c : chars){
                    if (c.equals("T")){
                        map[a/21][a%21]=new TowerTile(a%21*Main.WIDTH, a/21*Main.WIDTH);
                        a++;
                    }
                    if (c.equals("P")){
                        map[a/21][a%21]=new Path(a%21*Main.WIDTH, a/21*Main.WIDTH);
                        a++;
                    }
                }
                line = reader.readLine();
            }

        } catch (Exception e){ e.printStackTrace(); }

        return map;

    }


}