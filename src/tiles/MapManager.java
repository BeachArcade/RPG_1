package tiles;

import game.GamePanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapManager {
    public ArrayList<ArrayList<Tile>> makeMap(String mapName){
        ArrayList<ArrayList<Tile>> tileMap = new ArrayList<>();
        ArrayList<String[]> textMap = new ArrayList<>();
        int height = 0;
        InputStream is = getClass().getResourceAsStream("/maps/"+mapName+".txt");
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            ++height;
            //System.out.println(++height +":\t" + line);
            textMap.add(line.split(" "));
        }
        for(String[] line : textMap){
            ArrayList<Tile> mapRow = new ArrayList<>();
            for (String id : line) {
                mapRow.add(new Tile(Integer.parseInt(id)));
            }
            tileMap.add(mapRow);
        }
        return tileMap;
    }
    public ArrayList<ArrayList<Tile>> makeRandom(int x, int y){
        ArrayList<ArrayList<Tile>> map = new ArrayList<>();
        for(int i = 0; i < y; i++){
            ArrayList<Tile> row = new ArrayList<>();
            for(int j = 0; j < x; j++){
                int c = (int)(Math.random() * 5);
                System.out.print(j + ": " + c + " ");
                Tile tile = new Tile(c);
                row.add(tile);
            }
            System.out.println();
            map.add(row);
        }
        return map;
    }
}
