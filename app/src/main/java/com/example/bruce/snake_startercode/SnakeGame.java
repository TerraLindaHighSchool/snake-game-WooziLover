package com.example.bruce.snake_startercode;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SnakeGame {

  private int mMillisDelay, mSpriteDim, mScore, mLevel, mCountdown;
  protected int[] mAppleCoord;
  protected List<SnakeSegment> mSnake;
  protected SnakeSegment mBodyPart;

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
    return false;
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

    public SnakeSegment getBodyPart() {
        return mBodyPart;
    }

  protected List<SnakeSegment> getSnake(){
      return mSnake;
  }

  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height){
  
  }
  
  protected void touched(float xTouched, float yTouched){
  
  }
    
  protected void eatApple(){
  
  }
    
  protected boolean play(){
        return false;
  }
}
