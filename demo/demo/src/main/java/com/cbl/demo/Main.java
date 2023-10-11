package com.cbl.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
	private static Story currentStory;
	private static JTextArea storyTextArea;
	private static JPanel buttonPanel;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Choose Your Adventure: Text Edition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		// Corrected line: removed JTextArea type declaration
		storyTextArea = new JTextArea();
		storyTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(storyTextArea);
		frame.add(scrollPane);
		buttonPanel = new JPanel();
		frame.add(buttonPanel);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		currentStory = GameInitializer.initializeGameStory();
		updateUI();
		frame.setVisible(true);
	}

	private static void updateUI() {
		storyTextArea.setText(currentStory.getText());

		buttonPanel.removeAll();

		List<Choice> choices = currentStory.getChoices();
		if (choices != null) {
			for (Choice choice : choices) {
				JButton choiceButton = new JButton(choice.getText());
				choiceButton.addActionListener(e -> handleChoice(choice));
				buttonPanel.add(choiceButton);
			}
		}

		buttonPanel.revalidate();
		buttonPanel.repaint();
	}

	private static void handleChoice(Choice choice) {
		currentStory = choice.getNextStory();
		updateUI();
	}

}
