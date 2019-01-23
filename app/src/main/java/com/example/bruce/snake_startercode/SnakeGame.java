package com.example.bruce.snake_startercode;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SnakeGame {

  private int mMillisDelay, mSpriteDim, mScore, mLevel, mCountdown, mBOARD_WIDTH, mBOARD_HEIGHT;
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
    mMillisDelay = 400;
    mAppleCoord = new int[2];
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.HEAD, beginningDirection, beginningX, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.BODY, beginningDirection, beginningX - 1, beginningY));
    mSnake.add(new SnakeSegment(SnakeSegment.BodyParts.TAIL, beginningDirection, beginningX - 2, beginningY));
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
    
  protected boolean play(){
        return false;
  }
}
