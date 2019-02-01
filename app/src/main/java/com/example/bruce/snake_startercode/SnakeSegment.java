package com.example.bruce.snake_startercode;

public class SnakeSegment {

    private BodyParts mBodyParts;
    int mDegrees, mXLoc, mYLoc;

    public SnakeSegment ( BodyParts bodyParts, int degrees, int xLoc, int yLoc){
        mBodyParts = bodyParts;
        mDegrees = degrees;
        mXLoc = xLoc;
        mYLoc = yLoc;
    }

    /*************************************
     * Enum
     ************************************/

    public enum BodyParts {
        HEAD, BODY, TAIL
    }

    /************************************
     * Getters and Setters
     ***********************************/

    public BodyParts getBodyParts(){
        return mBodyParts;
    }

    public void setDegrees(int d){
        mDegrees = d;
    }

    public int getDegrees(){
        return mDegrees;
    }

    public void setXLoc(int x){
        mXLoc = x;
    }

    public int getXLoc(){
        return mXLoc;
    }

    public void setYLoc(int y){
        mYLoc = y;
    }

    public int getYLoc(){
        return mYLoc;
    }
}
