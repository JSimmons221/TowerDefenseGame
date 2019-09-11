import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MapReader {


    public static void main() {

        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader(new File("./res/TileMap")));
            String line = reader.readLine();
            while(line != null){
                String[] chars = line.split("");
                for(String c : chars){
                    System.out.print(c);
                }
                line = reader.readLine();
                System.out.println();
            }

        } catch (Exception e){ e.printStackTrace(); }


    }


}