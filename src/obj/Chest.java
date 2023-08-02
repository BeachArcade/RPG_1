package obj;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest extends SuperObject{
    public Chest(){
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}