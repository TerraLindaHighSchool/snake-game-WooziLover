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
    mMillisDelay = 750;
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
    int x = mSnake.get(0).getXLoc() * mSpriteDim;
    int y = mSnake.get(0).getYLoc() * mSpriteDim;
    int degrees = mSnake.get(0).getDegrees();
   /* if(y < yTouched){
      degrees = 90;
    }else{
      degrees = 270;
    }
    mPivotPoints.add(new PivotPoint(x, y, degrees));*/

    if(degrees == 0){
      if(yTouched < y){
        mPivotPoints.add(new PivotPoint(x, y, degrees))
      }
    }
 /*   if(yTouched < y)
      if(xTouched < x){
      mPivotPoints.add(new PivotPoint(x, y, 270));
      }else{
    if(yTouched > y)
        if(xTouched > x){
        mPivotPoints.add(new PivotPoint(x, y, 90));
        }
      }
*/
   /* if(yTouched > y) {
      mPivotPoints.add(new PivotPoint(x / mSpriteDim, y / mSpriteDim, 270));
    }else{
      mPivotPoints.add(new PivotPoint(x / mSpriteDim, y / mSpriteDim,180));
    }

    if(xTouched > x) {
      mPivotPoints.add(new PivotPoint(x/ mSpriteDim, y / mSpriteDim, 0));
    }else{
      mPivotPoints.add(new PivotPoint(x / mSpriteDim, y / mSpriteDim, 90));
    }*/
  }

  protected void eatApple(){
  
  }
    
  protected boolean play() {
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
    if(mSnake.get(0).getXLoc() >= mXMax || mSnake.get(0).getYLoc() >= mYMax){
      return true;
    }
      return false;
    }

    private void setAppleCoord(){
      mAppleCoord[0] = (int) ((mXMax - 1) * Math.random() + 1) * mSpriteDim;
      mAppleCoord[1] = (int) ((mYMax - 1) * Math.random() + 1) * mSpriteDim;
    }
}
