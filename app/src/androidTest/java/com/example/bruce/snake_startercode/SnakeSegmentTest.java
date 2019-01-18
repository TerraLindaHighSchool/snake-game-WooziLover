package com.example.bruce.snake_startercode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeSegmentTest {

    SnakeSegment[] snakeSegments = {
            new SnakeSegment (SnakeSegment.BodyParts.HEAD, 0,1,1),
            new SnakeSegment (SnakeSegment.BodyParts.BODY,90,2,2),
            new SnakeSegment (SnakeSegment.BodyParts.TAIL,180,3,3),
            new SnakeSegment (SnakeSegment.BodyParts.HEAD,270,4,4)};


    @Test
    public void getBodyParts() {
        SnakeSegment.BodyParts[] actualValue = {SnakeSegment.BodyParts.values()[0],SnakeSegment.BodyParts.values()[1], SnakeSegment.BodyParts.values()[2]};
        SnakeSegment.BodyParts[] expectedValue = new SnakeSegment.BodyParts[3];
        for(int i = 0; i < snakeSegments.length - 1;i++){
            expectedValue[i] = snakeSegments[i].getBodyParts();
        }
        assertArrayEquals(expectedValue,actualValue);
    }

    @Test
    public void setDegrees() {
        snakeSegments[0].setDegrees(270);
        assertTrue(snakeSegments[0].getDegrees() == 270);
        snakeSegments[1].setDegrees(180);
        assertTrue(snakeSegments[1].getDegrees() == 180);
        snakeSegments[2].setDegrees(90);
        assertTrue(snakeSegments[2].getDegrees() == 90);
        snakeSegments[3].setDegrees(0);
        assertTrue(snakeSegments[3].getDegrees() == 0);
    }

    @Test
    public void getDegrees() {
        int[] actualValue = {0, 90, 180, 270};
        int[] expectedValue = new int[4];
        for(int i = 0; i < snakeSegments.length;i++){
            expectedValue[i] = snakeSegments[i].getDegrees();
        }
        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void setXLoc() {
        snakeSegments[3].setXLoc(2);
        assertTrue(snakeSegments[3].getXLoc() == 2);
    }

    @Test
    public void getXLoc() {
        int[] actualValue = {1, 2, 3, 4};
        int[] expectedValue = new int[4];
        for(int i = 0; i < snakeSegments.length;i++){
            expectedValue[i] = snakeSegments[i].getXLoc();
        }
        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void setYLoc() {
        snakeSegments[1].setYLoc(1);
        assertTrue(snakeSegments[1].getYLoc() == 1);
    }

    @Test
    public void getYLoc() {
        int[] actualValue = {1, 2, 3, 4};
        int[] expectedValue = new int[4];
        for(int i = 0; i < snakeSegments.length;i++){
            expectedValue[i] = snakeSegments[i].getYLoc();
        }
        assertArrayEquals(expectedValue, actualValue);
    }
}