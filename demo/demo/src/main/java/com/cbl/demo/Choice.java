package com.cbl.demo;

import java.io.Serializable;

public class Choice implements Serializable {
    private String text;
    private Story nextStory;

    public Choice(String text, Story nextStory){
        this.text = text;
        this.nextStory = nextStory;
        
    }
    public String getText(){
        return text;
    }
    public void  setText(String text){
        this.text = text;
    }
    public Story getNextStory(){
        return nextStory;
    }
    public void setNextStory(Story nextStory){
        this.nextStory = nextStory;
    }
}
