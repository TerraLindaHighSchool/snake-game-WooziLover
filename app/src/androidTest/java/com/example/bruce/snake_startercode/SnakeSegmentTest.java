package com.example.bruce.snake_startercode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeSegmentTest {

    SnakeSegment[] snakeSegments = {
        new SnakeSegment(SnakeSegment.BodyParts.HEAD, 0,1,1),
        new SnakeSegment(SnakeSegment.BodyParts.BODY, 90,1,1),
        new SnakeSegment(SnakeSegment.BodyParts.TAIL,180,1,1),
        new SnakeSegment(SnakeSegment.BodyParts.HEAD, 270,1,1)};


    @Test
    public void getBody() {
    SnakeSegment.BodyParts[] actualValue = {SnakeSegment.BodyParts.values()[0],SnakeSegment.BodyParts.values()[1], SnakeSegment.BodyParts.values()[2]};
    SnakeSegment.BodyParts[] expectedValue = new SnakeSegment.BodyParts[3];
    for(int i = 0; i < snakeSegments.length; i++) {
        expectedValue[i] = snakeSegments[i].getBody();
    }
    assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void setDegrees() {
    /*int expected = snakeSegments.setDegrees(90);
    assertTrue(expected, );*/
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

    }

    @Test
    public void getXLoc() {
        int[] actualValue = {}
    }


    @Test
    public void setYLoc() {
    }

    @Test
    public void getYLoc() {
    }
}
