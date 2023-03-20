package game;

import java.awt.*;

public class TitleGenerator {
    public TitleGenerator(GamePanel gamePanel){
        Rectangle startBox = new Rectangle(7*64,7*64,2*64,64);
        TextArea startText = new TextArea("start");
        startText.setBounds(startBox);
        startText.setBackground(Color.GRAY);


    }
}
