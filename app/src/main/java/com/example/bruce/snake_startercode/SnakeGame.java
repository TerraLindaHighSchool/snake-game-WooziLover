package com.example.bruce.snake_startercode;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.POWER_SERVICE;

public class SnakeGame {

  private int mMillisDelay, mSpriteDim, mScore, mLevel, mCountdown, mBOARD_WIDTH, mBOARD_HEIGHT, mXValue,mYValue,mDegrees, mXMax, mYMax, mRandomXCoordinate, mRandomYCoordinate;;
  protected int[] mAppleCoord;
  protected ArrayList<SnakeSegment> mSnake = new ArrayList();
  private SnakeSegment mBodyParts;
  private boolean mGameOver;


  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height){
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 750;//400
    mXMax = 10;
    mYMax = 10;
    mAppleCoord = new int[2];
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.TAIL, beginningDirection, beginningX - 2, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.BODY, beginningDirection, beginningX - 1, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.HEAD, beginningDirection, beginningX, beginningY));
    setAppleCoord();
    play();

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

  protected void touched(float xTouched, float yTouched){
  
  }
    
  protected void eatApple(){
  
  }
    
  protected boolean play() {
    SnakeSegment mType;
    //
      for (int i = 0; i < mSnake.size(); i++) {
        switch(mDegrees){
          case 0:
            //This is the start of experimenting.
            //This is the end
            mSnake.get(i).setXLoc(mXValue++);
            break;

          case 1:
            mSnake.get(i).setYLoc(mYValue++);
            break;

          case 2:
            mSnake.get(i).setXLoc(mXValue++);
            mSnake.get(i).setYLoc(mYValue++);

          case 3:
            mSnake.get(i).setYLoc(mYValue++);
        }
      }
    if(mSnake.get(1).getXLoc() >= mXMax){
      return true;
    }
      return false;
    }

    //This has something to do with the GameActivity.java the //Draw Apple section.
    private void setAppleCoord(){
      mRandomXCoordinate = (int) (11 * Math.random() + 1);
      mRandomYCoordinate = (int) (11 * Math.random() + 1);
      if(mRandomXCoordinate >= mXMax || mRandomYCoordinate >= mYMax){
        mRandomXCoordinate -= 1;
        mRandomYCoordinate -= 1;
      }
    }
}
