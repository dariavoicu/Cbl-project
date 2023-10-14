package com.cbl.demo;

import java.io.*;

public class GameManager {
    public static void saveGame(Player player, Story currentStory, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println("Saving player...");
            out.writeObject(player);
            System.out.println("Saving story...");
            out.writeObject(currentStory);
            out.flush();  // Ensure all data is written
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save the game.");
            e.printStackTrace();
        }
    }

    public static Object[] loadGame(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("Loading player...");
            Player loadedPlayer = (Player) in.readObject();
            System.out.println("Loading story...");
            Story loadedStory = (Story) in.readObject();
            System.out.println("Game loaded successfully!");
            return new Object[]{loadedPlayer, loadedStory};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while trying to load the game.");
            e.printStackTrace();
            return null;
        }
    }

}
