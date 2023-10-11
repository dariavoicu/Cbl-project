# Choose Your Adventure: Text Edition

## Overview
"Choose Your Adventure: Text Edition" is a simple, interactive text-based game where players navigate through a series of stories by making choices. Each story presents a scenario and a set of choices, leading the player through different paths until they reach an ending.

## Table of Contents
- [System Requirements](#system-requirements)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Code Structure](#code-structure)
- [Classes Overview](#classes-overview)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## System Requirements
- Java Development Kit (JDK) 8 or later

## Installation
1. Clone or download the repository to your local machine.
2. Open a terminal and navigate to the project directory.
3. Compile the Java files using the command: javac *.java
4. Run the game using the command: java Main

## How to Play
1. Launch the game.
2. Read the presented story text.
3. Choose an option by clicking the corresponding button.
4. Navigate through the story by making choices until you reach an ending.

## Code Structure
- Main.java: Entry point of the application. Initializes the game and sets up the user interface.
- Story.java: Represents a part of the story, containing text and available choices.
- Choice.java: Represents a choice available to the player, containing text and the next story.
- GameInitializer.java: Initializes the game by creating Story and Choice objects.

## Classes Overview
### Main
- currentStory: Holds the current Story object.
- storyTextArea: Displays the current story text.
- buttonPanel: Contains buttons for each available choice.

### Story
- text: The text of the story part.
- choices: A list of Choice objects available at this part of the story.

### Choice
- text: The text of the choice.
- nextStory: The Story object that follows this choice.

### GameInitializer
- initializeGame(): Initializes the game by creating and linking Story and Choice objects.

## Future Enhancements
- Implement save and load functionality to allow players to resume their game.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
