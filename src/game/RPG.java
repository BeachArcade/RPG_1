package game;

import tiles.MapManager;

import javax.swing.*;

public class RPG {
  //TODO
  /* check TileManager Class    !!
   * title screen               !
   * menus
   * better sprites
   * better tiles
   *
   * Ideas:
   * Window manager (switch between title and game)
   * Types of keyhandlers (one for game one for menus)
   *
   */
  public static void main(String[] args) {
    // Window Creation
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Fuck ass chode dick cum fart anus wiener cock turd shit queef");

    // Adds the game panel
    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }
}
