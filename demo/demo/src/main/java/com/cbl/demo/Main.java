package com.cbl.demo;

		import javax.swing.*;
		import java.awt.*;
		import java.util.List;

public class Main {
	private static Story currentStory;
	private static Player player;
	private static JTextArea storyTextArea;
	private static JPanel buttonPanel;

	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		JFrame frame = new JFrame("Choose Your Adventure: Text Edition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		storyTextArea = new JTextArea();
		storyTextArea.setEditable(false);
		storyTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
		storyTextArea.setForeground(new Color(51, 51, 51));
		storyTextArea.setBackground(new Color(245, 245, 245));
		storyTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JScrollPane scrollPane = new JScrollPane(storyTextArea);
		frame.add(scrollPane);

		buttonPanel = new JPanel();
		frame.add(buttonPanel);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem loadItem = new JMenuItem("Load");

		saveItem.addActionListener(e -> saveGame());
		loadItem.addActionListener(e -> loadGame());

		menu.add(saveItem);
		menu.add(loadItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 12));
		String playerName = JOptionPane.showInputDialog(frame, "Enter your name:", "Player name", JOptionPane.PLAIN_MESSAGE);
		player = new Player(playerName != null ? playerName : "Default Player");

		List<Story> startingStories = GameInitializer.initializeGameStories();

		currentStory = (Story) JOptionPane.showInputDialog(
				null,
				"Choose your adventure:",
				"Story Selection",
				JOptionPane.QUESTION_MESSAGE,
				null,
				startingStories.toArray(),
				startingStories.get(0)
		);

		if (currentStory == null) {
			System.exit(0);
		}

		updateUI();
		frame.setVisible(true);
	}

	private static void saveGame(){
		GameManager.saveGame(player,currentStory,"game_save.ser");
	}

	private static void loadGame(){
		Object[] loadedObjects = GameManager.loadGame("game_save.ser");
		if(loadedObjects != null){
			player = (Player) loadedObjects[0];
			currentStory = (Story) loadedObjects[1];
			String welcomeMessage = "Welcome back, " + player.getName() + "!\nHere's where you left off...";
			JOptionPane.showMessageDialog(null, welcomeMessage, "Welcome Back!", JOptionPane.INFORMATION_MESSAGE);

			updateUI();
		}
	}

	private static void updateUI() {
		storyTextArea.setText(currentStory.getText());

		buttonPanel.removeAll();

		List<Choice> choices = currentStory.getChoices();
		if (choices != null) {
			for (Choice choice : choices) {
				JButton choiceButton = new JButton(choice.getText());
				choiceButton.setFont(new Font("SansSerif", Font.BOLD, 16));
				choiceButton.setBackground(new Color(70, 130, 180));
				choiceButton.setForeground(Color.WHITE);
				choiceButton.setBorderPainted(false);
				choiceButton.setFocusPainted(false);
				choiceButton.setMargin(new Insets(10, 20, 10, 20));
				choiceButton.addActionListener(e -> handleChoice(choice));
				buttonPanel.add(choiceButton);
			}
		}

		buttonPanel.revalidate();
		buttonPanel.repaint();
	}

	private static void handleChoice(Choice choice) {
		currentStory = choice.getNextStory();

		if (currentStory.getChoices() == null || currentStory.getChoices().isEmpty()) {
			String endingText = currentStory.getText();

			if (endingText.contains("happily ever after")) {
				JOptionPane.showMessageDialog(null, "Your heart swells with joy as you embrace a future of happiness and love.", "A Blissful Future", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("just a dream")) {
				JOptionPane.showMessageDialog(null, "You blink, the fantastical world dissolving around you, leaving behind the tendrils of a fading dream.", "A Surreal Awakening", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("mighty kingdom")) {
				JOptionPane.showMessageDialog(null, "The cheers of the kingdom echo in your ears as you ascend to the throne, a legacy of power before you.", "A Royal Coronation", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("quiet life")) {
				JOptionPane.showMessageDialog(null, "You find solace in the gentle hum of nature, your days passing in tranquil harmony.", "Serenity Found", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("hidden world")) {
				JOptionPane.showMessageDialog(null, "Curiosity gleams in your eyes as you step into a realm of mystery and unknown adventures.", "A Mystical Journey", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("group of explorers")) {
				JOptionPane.showMessageDialog(null, "With a heart full of excitement, you embark on countless adventures, the world an endless map to explore.", "Endless Horizons", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("forgotten civilization")) {
				JOptionPane.showMessageDialog(null, "You gaze upon the ancient city, its secrets now yours to discover, as the forgotten civilization welcomes their new leader.", "Lost Legacy", JOptionPane.INFORMATION_MESSAGE);
			} else if (endingText.contains("mystical woods")) {
				JOptionPane.showMessageDialog(null, "The woods envelop you, a mystical path unwinding in all directions, your fate intertwined with its enchanted depths.", "Enchanted Eternity", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Your journey concludes, the tales of your adventures to be whispered through the ages.", "Tales Concluded", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		updateUI();
	}


}
