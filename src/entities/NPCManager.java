package entities;

import game.GamePanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Holds all the npcs needed for a place
 */
public class NPCManager {
    private GamePanel gamePanel;
    private ArrayList<NPC> npcList = new ArrayList<>();
    public NPCManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void addNpc(NPC npc){
        npcList.add(npc);
    }
    public ArrayList<NPC> getNpcList(){
        return this.npcList;
    }
    public void setNpcList(ArrayList<NPC> npcList){
        this.npcList = npcList;
    }
    // Draw all npcs in the list
    public void draw(Graphics2D g){
        for(NPC npc : npcList){
            npc.draw(g);
        }
    }

}
