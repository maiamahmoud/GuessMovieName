package com.example.guesswhat;

public class Movie {
    private String name;
    private String desc;
    private int letters;

    Movie(String name,int letters,String desc)
    {
        this.name =name;
        this.desc =desc;
        this.letters=letters;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLetters() {
        return letters;
    }

    public void setLetters(int letters) {
        this.letters = letters;
    }
}
