package com.cbl.demo;

import java.util.List;

public class GameInitializer {
    public static Story initializeGameStory(){
        // Endings
        Story end1 = new Story("You live happily ever after.", null);
        Story end2 = new Story("Unfortunately, it was all just a dream.", null);
        Story end3 = new Story("You become the ruler of a mighty kingdom.", null);
        Story end4 = new Story("You decide to lead a quiet life in the countryside.", null);

        // Choices leading to endings
        Choice choiceEnd1 = new Choice("Choose a happy life.", end1);
        Choice choiceEnd2 = new Choice("Wake up from the dream.", end2);
        Choice choiceEnd3 = new Choice("Ascend the throne.", end3);
        Choice choiceEnd4 = new Choice("Retire to a farm.", end4);

        // Intermediate story nodes
        Story story4 = new Story("You are offered a crown. What do you do?", List.of(choiceEnd3, choiceEnd4));
        Story story3 = new Story("You come across a village. Do you decide to settle or continue exploring?", List.of(choiceEnd4, choiceEnd1));
        Story story2 = new Story("You have found a treasure chest. What do you do?", List.of(choiceEnd1, choiceEnd2));

        // Choices leading to intermediate story nodes
        Choice choiceToStory4 = new Choice("Approach the castle.", story4);
        Choice choiceToStory3 = new Choice("Enter the village.", story3);
        Choice choiceToStory2 = new Choice("Explore the cave.", story2);

        // Starting story node
        Story start = new Story("You are in a dark cave. You see two paths ahead.", List.of(choiceToStory2, choiceToStory3, choiceToStory4));

        return start;
}
}