package com.example.homework4_2_1;

public class SamplesList {
    private String name;
    private String exampleName;
    private int drawableId;

    public SamplesList(String name, String exampleName, int drawableId) {
        this.name = name;
        this.exampleName = exampleName;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
