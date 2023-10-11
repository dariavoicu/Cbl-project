package com.cbl.demo;

import java.util.List;

public class Story {
    private String text;
    private List<Choice> choices;

    public Story(String text, List<Choice> choices) {
        this.text = text;
        this.choices = choices;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}
