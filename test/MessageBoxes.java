import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageBoxes extends JFrame implements ActionListener {
    private ArrayList<String> rappers = new ArrayList<>();
    private int currentIndex = 0;
    private Label text;
    private Button next, previous;
    public MessageBoxes(){
        addRappers();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("why does it hurt when i pee?");
        next = new Button("next");
        previous = new Button("previous");
        previous.setBounds(30,100,80,30);
        next.setBounds(120,100,80,30);
        setSize(1920/2,1080/2);
        setLayout(null);
        setVisible(true);
        text = new Label("fart");
        text.setBounds(30,60,200,40);

        next.addActionListener(this);
        previous.addActionListener(this);
        add(next);
        add(previous);
        add(text);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals( next ))
            nextMessage();
        else
            previousMessage();
        text.setText(rappers.get(currentIndex));

    }
    private void nextMessage(){
        if(currentIndex >= rappers.size() - 1)
            currentIndex = 0;
        else
            currentIndex++;
        System.out.println("NEXT");
    }
    private void previousMessage(){
        if(currentIndex == 0)
            currentIndex = rappers.size() - 1;
        else
            currentIndex--;
        System.out.println("PREV");
    }
    private void addRappers(){
        InputStream is = getClass().getResourceAsStream("/not_for_github/rappers.txt");
        Scanner in = new Scanner(is);
        while (in.hasNextLine()){
            rappers.add(in.nextLine());
        }
    }
}
