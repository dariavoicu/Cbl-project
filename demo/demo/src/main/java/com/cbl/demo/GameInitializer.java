package com.cbl.demo;

import java.util.List;

public class GameInitializer {
    public static List<Story> initializeGameStories() {
        // Endings
        Story end1 = new Story("You live happily ever after.", null);
        Story end2 = new Story("It was all just a dream.", null);
        Story end3 = new Story("You become the ruler of a mighty kingdom.", null);
        Story end4 = new Story("You decide to lead a quiet life in the countryside.", null);
        Story end5 = new Story("You find a hidden world and decide to explore it.", null);
        Story end6 = new Story("You join a group of explorers on their next adventure.", null);

        // Choices leading to endings
        Choice choiceEnd1 = new Choice("Choose happiness.", end1);
        Choice choiceEnd2 = new Choice("Wake up.", end2);
        Choice choiceEnd3 = new Choice("Accept the crown.", end3);
        Choice choiceEnd4 = new Choice("Retire quietly.", end4);
        Choice choiceEnd5 = new Choice("Explore the hidden world.", end5);
        Choice choiceEnd6 = new Choice("Join the explorers.", end6);

        // Intermediate story nodes
        Story story2A = new Story("You meet an enchanting sorcerer. What do you do?", List.of(choiceEnd1, choiceEnd2));
        Story story2B = new Story("A dragon offers to share his hoard with you. What do you do?", List.of(choiceEnd3, choiceEnd4));
        Story story2C = new Story("The shrouded figure reveals a secret passage. What do you do?", List.of(choiceEnd5, choiceEnd6));

        // Choices leading to intermediate story nodes
        Choice choiceTo2A = new Choice("Follow the sorcerer.", story2A);
        Choice choiceTo2B = new Choice("Negotiate with the dragon.", story2B);
        Choice choiceTo2C = new Choice("Enter the passage.", story2C);

        // More Intermediate story nodes
        Story loveStoryNode = new Story("You find a mysterious rose. What do you do?", List.of(choiceTo2A, choiceTo2B));
        Story adventureStoryNode = new Story("You discover a map leading to a hidden treasure. What do you do?", List.of(choiceTo2B, choiceTo2C));
        Story mysteryStoryNode = new Story("A shrouded figure offers you a quest. What do you do?", List.of(choiceTo2C, choiceTo2A));

        // Choices leading to intermediate story nodes
        Choice choiceToLoveStory = new Choice("Follow the path of love.", loveStoryNode);
        Choice choiceToAdventureStory = new Choice("Embark on the adventure.", adventureStoryNode);
        Choice choiceToMysteryStory = new Choice("Dive into the mystery.", mysteryStoryNode);
        // Additional Endings
        Story end7 = new Story("You discover a forgotten civilization and become their leader.", null);
        Story end8 = new Story("You get lost in the mystical woods, never to be found again.", null);

// Choices leading to new endings
        Choice choiceEnd7 = new Choice("Lead the civilization.", end7);
        Choice choiceEnd8 = new Choice("Venture deeper into the woods.", end8);

// Additional Intermediate story nodes
        Story story3A = new Story("You find an ancient relic that glows with mysterious energy. What do you do?", List.of(choiceEnd7, choiceEnd8));
        Story story3B = new Story("A mystical creature asks you to follow it into the depths of the forest. What do you do?", List.of(choiceEnd8, choiceEnd7));

// Choices leading to additional intermediate story nodes
        Choice choiceTo3A = new Choice("Investigate the relic.", story3A);
        Choice choiceTo3B = new Choice("Follow the creature.", story3B);


        // Starting story node
        Story loveStoryStart = new Story("You are at a romantic place, surrounded by beautiful roses...", List.of(choiceToLoveStory, choiceToAdventureStory));
        Story adventureStoryStart = new Story("You find yourself at the entrance of an ancient, unexplored cave...", List.of(choiceToAdventureStory, choiceToMysteryStory));
        Story mysteryStoryStart = new Story("You wake up in a strange room with walls covered in cryptic messages...", List.of(choiceToMysteryStory, choiceToLoveStory));
        Story thrillerStoryStart = new Story("You hear a loud noise and find a hidden door in your room...", List.of(choiceToLoveStory, choiceToAdventureStory));

        return List.of(loveStoryStart, adventureStoryStart, mysteryStoryStart, thrillerStoryStart);
    }
}

