package com.example.expandablerecyclerview;

public class NameModel {
    private String title;
    private String subTitle;
    private boolean expanded;

    public NameModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
