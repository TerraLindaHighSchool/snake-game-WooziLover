package com.example.bruce.snake_startercode;

public class PivotPoint {
    int mXCoordinate, mYCoordinate, mDegrees;

    public PivotPoint (int xCoordinate, int yCoordinate, int degrees){
        mXCoordinate = xCoordinate;
        mYCoordinate = yCoordinate;
        mDegrees = degrees;
    }

    protected int getXCoordinate(){
        return mXCoordinate;
    }

    protected int getYCoordinate(){
        return mYCoordinate;
    }

    protected int getDegrees(){
        return mDegrees;
    }
}
