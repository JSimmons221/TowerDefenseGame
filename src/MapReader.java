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
                        map[a/21][a%21]=new Tile(a%21,a/21,false);
                        a++;
                    }
                    if (c.equals("P")){
                        map[a/21][a%21]=new Tile(a%21,a/21,true);
                        a++;
                    }
                }
                line = reader.readLine();
            }

        } catch (Exception e){ e.printStackTrace(); }

        return map;

    }


}