package com.cbl.demo;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {
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

    @Override
    public String toString() {
        return text.length() <= 30 ? text : text.substring(0, 30) + "...";
    }
}
