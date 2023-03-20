package tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {
    public int id;
    public BufferedImage image;
    public boolean collison = false;

    public Tile(){}
    public Tile(String id){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tile/"+id+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Tile(int id){
        this.id = id;
        collison = (id == 1 || id == 2 || id == 6);
        String strId = switch (id){
            case 0 -> getRand("grass");
            case 1 -> getRand("water");
            case 2 -> getRand("wall");
            case 3 -> getRand("sand");
            case 4 -> getRand("dirt");
            case 5 -> getRand("tree");
            default -> null;

        };
        //System.out.println("/tile/"+strId+".png");
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tile/NewTileset/" +strId+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private String getRand(String s){
        String str = switch (s){
            case "grass" ->  s + "n" + ((int)(Math.random() * 5 + 1));
            case "dirt" ->  s + ((int)(Math.random() * 3 + 1));
            case "sand" -> s + ((int)(Math.random() * 2 + 1));
            default -> s + 1;
        };
        return str;
    }

    @Override
    public String toString() {
        return id + " ";
    }
}
