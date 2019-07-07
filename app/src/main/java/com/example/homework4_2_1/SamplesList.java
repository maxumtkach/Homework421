package com.example.homework4_2_1;

import android.widget.Button;

public class SamplesList {
    private String name;
    private String exampleName;
    private int drawableId;
    private Button addItem;
    private int deleteImg;

    public SamplesList(String name, String exampleName, int drawableId, Button addItem, int deleteImg) {
        this.name = name;
        this.exampleName = exampleName;
        this.drawableId = drawableId;
        this.addItem = addItem;
        this.deleteImg = deleteImg;
    }

    public Button getAddItem() {
        return addItem;
    }

    public void setAddItem(Button addItem) {
        this.addItem = addItem;
    }

    public int getDeleteImg() {
        return deleteImg;
    }

    public void setDeleteImg(int deleteImg) {
        this.deleteImg = deleteImg;
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
