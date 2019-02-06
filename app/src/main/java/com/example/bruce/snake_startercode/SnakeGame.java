package com.example.bruce.snake_startercode;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.POWER_SERVICE;

public class SnakeGame {

  private int mMillisDelay, mSpriteDim, mScore, mLevel, mCountdown, mBOARD_WIDTH, mBOARD_HEIGHT, mXMax, mYMax, mRandomXCoordinate, mRandomYCoordinate;;
  protected int[] mAppleCoord;
  protected ArrayList<SnakeSegment> mSnake = new ArrayList();
  private SnakeSegment mBodyParts;
  private boolean mGameOver;
  protected ArrayList<PivotPoint> mPivotPoints;

  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height){
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 200;//750
    mXMax = width / beginningSpriteDim;
    mYMax = height / beginningSpriteDim;
    mPivotPoints = new ArrayList();
    mAppleCoord = new int[2];
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.HEAD, beginningDirection, beginningX, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.BODY, beginningDirection, beginningX - 1, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.TAIL, beginningDirection, beginningX - 2, beginningY));
    setAppleCoord();

  }

  protected int getMillisDelay(){
    return mMillisDelay;
  }

  protected int getSpriteDim(){
    return mSpriteDim;
  }

  protected int[] getAppleCoord(){
    return mAppleCoord;
  }

  protected boolean getGameOver(){
    return mGameOver;
  }

  protected int getScore(){
    return mScore;
  }

  protected int getLevel(){
    return mLevel;
  }

  protected int getCountdown(){
    return mCountdown;
  }

  protected ArrayList<SnakeSegment> getSnake(){
      return mSnake;
  }

  protected void touched(float xTouched, float yTouched) {
    int x = mSnake.get(0).getXLoc();
    int y = mSnake.get(0).getYLoc();
    int degrees = mSnake.get(0).getDegrees();
    if (degrees == 180 || degrees == 0) {
      if (yTouched > y * mSpriteDim)
        mPivotPoints.add(new PivotPoint(x, y, 90));
      else
        mPivotPoints.add(new PivotPoint(x, y, 270));
    }

    if (degrees == 90 || degrees == 270){
      if (xTouched > x * mSpriteDim)
        mPivotPoints.add(new PivotPoint(x, y, 0));
      else
        mPivotPoints.add(new PivotPoint(x, y, 180));
    }
  }

  protected void eatApple(){
    if(mSnake.get(0).getXLoc()* mSpriteDim == mAppleCoord[0] && mSnake.get(0).getYLoc() * mSpriteDim == mAppleCoord[1]){
      setAppleCoord();
      growSnake();
    }
  }

  private void growSnake(){
    SnakeSegment newBodyPart = mSnake.get(mSnake.size() - 1);
    mSnake.add(mSnake.size() - 2, new SnakeSegment(SnakeSegment.BodyParts.BODY, newBodyPart.getDegrees(), newBodyPart.getXLoc(), newBodyPart.getYLoc()));//mSnake.size() -2
    switch(newBodyPart.getDegrees()){
      case 0:
        newBodyPart.setXLoc(newBodyPart.getXLoc() + 1);//+1
        break;
      case 180:
        newBodyPart.setXLoc(newBodyPart.getXLoc() - 1);//-1
        break;
      case 90:
        newBodyPart.setYLoc(newBodyPart.getYLoc() - 1);//-1
        break;
      case 270:
        newBodyPart.setYLoc(newBodyPart.getYLoc() - 1);//+1
    }
  }

  protected boolean play() {
    eatApple();
    SnakeSegment mType;
    int x, y;

    for(int i = 0; i < mSnake.size(); i++){
      int degrees = mSnake.get(i).getDegrees();
      mType = mSnake.get(i);
      x = mType.getXLoc();
      y = mType.getYLoc();

    for(int s = 0; s < mPivotPoints.size(); s++) {
      PivotPoint pivotPoint = mPivotPoints.get(s);
      if (x == pivotPoint.getXCoordinate() && y == pivotPoint.getYCoordinate()) {
        mType.setDegrees(pivotPoint.getDegrees());
        if (mType.getBodyParts() == SnakeSegment.BodyParts.TAIL)
          mPivotPoints.remove(s);
      }
    }
      /*
      for (int i = 0; i < mSnake.size(); i++) {
        SnakeSegment.BodyParts bp = mSnake.get(i).getBodyParts();
        int degrees = mSnake.get(i).getDegrees();
        int x = mSnake.get(i).getXLoc();
        int y = mSnake.get(i).getYLoc();

        for(int s = 0; s < mPivotPoints.size();s++){
          if(mSnake.get(0).getXLoc() == mPivotPoints.get(s).mXCoordinate){
            if(mSnake.get(0).getYLoc() == mPivotPoints.get(s).mYCoordinate){
              mSnake.get(degrees).setDegrees(mPivotPoints.get(s).mDegrees);
            }
          }
          if(bp == SnakeSegment.BodyParts.TAIL){
          mPivotPoints.remove(0);
          }
        }
      */
        switch(degrees){
          case 0:
            mSnake.get(i).setXLoc(++x);
            break;

          case 90:
            mSnake.get(i).setYLoc(++y);
            break;

          case 180:
            mSnake.get(i).setXLoc(--x);
            break;

          case 270:
            mSnake.get(i).setYLoc(--y);
            break;
        }
      }

    if(mSnake.get(0).getXLoc() >= mXMax + 1 || mSnake.get(0).getYLoc() >= mYMax + 1 || mSnake.get(0).getXLoc() <= 0 || mSnake.get(0).getYLoc() <= 0){
      return true;
    }
      return false;
    }

    private void setAppleCoord(){
      mAppleCoord[0] = (int) ((mXMax - 1) * Math.random() + 1) * mSpriteDim;
      mAppleCoord[1] = (int) ((mYMax - 1) * Math.random() + 1) * mSpriteDim;
      if(mAppleCoord[0] == mSnake.get(0).getXLoc() && mAppleCoord[1] == mSnake.get(0).getYLoc()){
        mAppleCoord[0] += 1;
        mAppleCoord[1] += 1;
      }
    }
}
